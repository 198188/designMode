package com.tj.combat.three.darklaunch.feature.Impl;

import com.tj.combat.three.darklaunch.feature.IDarkFeature;

public class UserPromotionDarkRule implements IDarkFeature {
    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean dark(long darkTarget) {
        // 灰度规则自己想怎么写就怎么写
        return false;
    }

    @Override
    public boolean dark(String darkTarget) {
        // 灰度规则自己想怎么写就怎么写
        return false;
    }
}