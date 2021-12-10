package com.tj.mode4.Article29;

import cn.hutool.core.util.IdUtil;

public class MockWalletRpcServiceOne extends WalletRpcService{

    @Override
    public String moveMoney(String id, Long buyerId, Long sellerId, Double amount) {
        return "123abc";
    }
}
