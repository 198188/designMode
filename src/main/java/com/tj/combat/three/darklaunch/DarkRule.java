package com.tj.combat.three.darklaunch;

import com.tj.combat.three.darklaunch.feature.IDarkFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 灰度规则
 */
public class DarkRule {
    // 从配置文件中加载的灰度规则
    private Map<String, IDarkFeature> darkFeatures = new HashMap<>();
    // 编程实现的灰度规则
    private ConcurrentHashMap<String, IDarkFeature> programmedDarkFeatures = new ConcurrentHashMap<>();

    public void setDarkFeatures(Map<String, IDarkFeature> newDarkFeatures) {
        this.darkFeatures = newDarkFeatures;
    }

    public IDarkFeature getDarkFeature(String featureKey) {
        IDarkFeature darkFeature = programmedDarkFeatures.get(featureKey);
        if (darkFeature != null) {
            return darkFeature;
        }
        return darkFeatures.get(featureKey);
    }
    public void addProgrammedDarkFeature(String featureKey, IDarkFeature darkFeature) {
        programmedDarkFeatures.put(featureKey, darkFeature);
    }

}
