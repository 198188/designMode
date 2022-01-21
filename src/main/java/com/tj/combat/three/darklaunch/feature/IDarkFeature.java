package com.tj.combat.three.darklaunch.feature;

/**
 * feature的灰度规则接口
 */
public interface IDarkFeature {
    boolean enabled();

    boolean dark(long darkTarget);

    boolean dark(String darkTarget);
}