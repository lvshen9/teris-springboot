package com.lvshen.teris.config;

import lombok.Data;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 数据配置
 */
@Data
public class DataInterfaceConfig {
    private final String className;

    private final Map<String, String> param;

    public DataInterfaceConfig(Element dataInterfaceConfig) {
        this.className = dataInterfaceConfig.attributeValue("className");

        this.param = new HashMap<>();

        @SuppressWarnings("unchecked")
        List<Element> params = dataInterfaceConfig.elements("param");

        for (Element e : params) {
            this.param.put(e.attributeValue("key"), e.attributeValue("value"));
        }
    }

}
