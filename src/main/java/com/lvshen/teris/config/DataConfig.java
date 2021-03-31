package com.lvshen.teris.config;

import lombok.Data;
import org.dom4j.Element;

@Data
public class DataConfig {

    private final int maxRow;

    private final DataInterfaceConfig dataA;
    private final DataInterfaceConfig dataB;

    public DataConfig(Element data) {
        this.maxRow = Integer.parseInt(data.attributeValue("maxRow"));
        this.dataA = new DataInterfaceConfig(data.element("dataA"));
        this.dataB = new DataInterfaceConfig(data.element("dataB"));

    }

}
