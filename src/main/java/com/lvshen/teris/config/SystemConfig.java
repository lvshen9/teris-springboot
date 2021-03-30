package com.lvshen.teris.config;

import lombok.Data;
import org.dom4j.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SystemConfig {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    private int levelUp;
    private List<Point[]> typeConfig;
    private List<Boolean> typeRound;
    private Map<Integer, Integer> plusPoint;

    public SystemConfig(Element system) {
        this.minX = Integer.parseInt(system.attributeValue("minX"));
        this.maxX = Integer.parseInt(system.attributeValue("maxX"));
        this.minY = Integer.parseInt(system.attributeValue("minY"));
        this.maxY = Integer.parseInt(system.attributeValue("maxY"));
        this.levelUp = Integer.parseInt(system.attributeValue("levelUp"));

        @SuppressWarnings("unchecked")
        List<Element> rects = system.elements("rect");
        typeConfig = new ArrayList<>(rects.size());
        typeRound = new ArrayList<>(rects.size());
        for (Element rect : rects) {
            //是否旋转
            this.typeRound.add(Boolean.parseBoolean(rect.attributeValue("round")));

            //获得坐标对象
            @SuppressWarnings("unchecked")
            List<Element> pointConfig = rect.elements("point");
            //创建Point对象数组
            Point[] points = new Point[pointConfig.size()];
            //初始化对象数组
            for (int i = 0; i < points.length; i++) {
                int x = Integer.parseInt(pointConfig.get(i).attributeValue("x"));
                int y = Integer.parseInt(pointConfig.get(i).attributeValue("y"));
                points[i] = new Point(x, y);
            }
            //把Point对象数组放到typeConfig中
            typeConfig.add(points);
        }
        //获得连消行加分配置
        this.plusPoint = new HashMap<>();
        List<Element> plusPointCfg = system.elements("plusPoint");
        for (Element cfg : plusPointCfg) {
            int rm = Integer.parseInt(cfg.attributeValue("rm"));
            int point = Integer.parseInt(cfg.attributeValue("point"));
            this.plusPoint.put(rm, point);
        }
    }

}
