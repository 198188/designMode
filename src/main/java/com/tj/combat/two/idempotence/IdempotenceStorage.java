package com.tj.combat.two.idempotence;

/**
 * 幂等号生成类
 */
public interface IdempotenceStorage {

    boolean saveIfAbsent(String idempotenceId);

    void delete(String idempotenceId);
}