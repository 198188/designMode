package com.tj.mode4.Article29;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.tj.mode4.Article29.constant.DateUtils;
import com.tj.mode4.Article29.constant.STATUS;

import javax.transaction.InvalidTransactionException;

public class Transaction {
  private String id;
  private Long buyerId;
  private Long sellerId;
  private Long productId;
  private String orderId;
  private Long createTimestamp;
  private Double amount;
  private STATUS status;
  private String walletTransactionId;


  private WalletRpcService walletRpcService;
  private TransactionLock lock;

  public void setTransactionLock(TransactionLock lock) {
    this.lock = lock;
  }

  public void setWalletRpcService(WalletRpcService walletRpcService) {
    this.walletRpcService = walletRpcService;
  }
  
  // ...get() methods...
  
  public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
    this.fillTransactionId(preAssignedId);
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.orderId = orderId;
    this.status = STATUS.TO_BE_EXECUTD;
    this.createTimestamp = System.currentTimeMillis();

  }
  
  public boolean execute() throws InvalidTransactionException {
    if ((buyerId == null || (sellerId == null || amount < 0.0))) {
      throw new InvalidTransactionException("...");
    }
    if (status == STATUS.EXECUTED) return true;
    boolean isLocked = false;
    try {
      isLocked = lock.lock(id);
      if (!isLocked) {
        return false; // 锁定未成功，返回 false，job 兜底执行
      }
      if (status == STATUS.EXECUTED) return true; // double check
      if (isExpired()) {
        this.status = STATUS.EXPIRED;
        return false;
      }
      // WalletRpcService walletRpcService = new WalletRpcService();
      String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
      if (walletTransactionId != null) {
        this.walletTransactionId = walletTransactionId;
        this.status = STATUS.EXECUTED;
        return true;
      } else {
        this.status = STATUS.FAILED;
        return false;
      }
    } finally {
      if (isLocked) {
       lock.unlock(id);
      }
    }
  }


  protected void fillTransactionId(String preAssignedId) {
    if (preAssignedId != null && !preAssignedId.isEmpty()) {
      this.id = preAssignedId;
    } else {
      // this.id = IdGenerator.generateTransactionId();
      this.id = IdUtil.simpleUUID();
    }
    if (!this.id.startsWith("t_")) {
      this.id = "t_" + preAssignedId;
    }
  }

  protected boolean isExpired() {
    long executionInvokedTimestamp = System.currentTimeMillis();
    return executionInvokedTimestamp - createTimestamp > DateUtils.day14;
  }

  private void assertTrue(boolean executedResult) throws Exception {
    if (!executedResult) {
      throw new Exception();
    }
  }


  // 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
  public void testExecute() throws Exception{
    Long buyerId = 123L;
    Long sellerId = 234L;
    Long productId = 345L;
    String orderId = "1234";

    TransactionLock mockLock = new TransactionLock() {
      public boolean lock(String id) {
        return true;
      }

      public void unlock(String id) {}
    };

    // 测试日期是否过期
    Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId) {
      @Override
      protected boolean isExpired() {
        return true;
      }
    };
    // 使用 mock 对象来替代真正的 RPC 服务
    transaction.setWalletRpcService(new MockWalletRpcServiceOne());
    // 替换redis锁
    transaction.setTransactionLock(mockLock);
    boolean executedResult = transaction.execute();
    assertTrue(executedResult);
  }
}