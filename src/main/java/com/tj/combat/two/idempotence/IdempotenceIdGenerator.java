package com.tj.combat.two.idempotence;

import java.util.UUID;

/**
 * 幂等号生成类
 */
public class IdempotenceIdGenerator {

    public String generateId() {
        return UUID.randomUUID().toString();
    }

}