package com.tj.combat.three.darklaunch;

import com.tj.combat.three.darklaunch.feature.IDarkFeature;
import com.tj.combat.three.darklaunch.feature.Impl.UserPromotionDarkRule;

public class DarkDemo {
    public static void main(String[] args) {
        DarkLaunch darkLaunch = new DarkLaunch(); // 默认加载classpath下dark-rule.yaml文件中的灰度规则
        darkLaunch.addProgrammedDarkFeature("user_promotion", new UserPromotionDarkRule()); // 添加编程实现的灰度规则
        // 获取灰度规则  优先编程实现的规则
        IDarkFeature darkFeature = darkLaunch.getDarkFeature("call_newapi_getUserById");

        System.out.println(darkFeature.enabled());
        System.out.println(darkFeature.dark(893));
    }
}