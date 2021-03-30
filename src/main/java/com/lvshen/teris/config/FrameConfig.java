package com.lvshen.teris.config;

import lombok.Data;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 框架配置
 */
@Data
public class FrameConfig {

	private final String title;
	private final int windowUp;
	private final int width;
	private final int height;
	private final int padding;
	private final int border;
	private final int sizeRol;
	private final int loseIdx;


	/**
	 * 图层属性
	 */
	private List<LayConfig> laysConfig;
	/**
	 * 按钮属性
	 */
	private final ButtonConfig buttonConfig;

	public FrameConfig(Element frame){
		//获取窗口宽度
		this.width=Integer.parseInt(frame.attributeValue("width"));
		//获取窗口高度
		this.height=Integer.parseInt(frame.attributeValue("height"));
		//获取边框粗细
		this.border=Integer.parseInt(frame.attributeValue("border"));
		//获取边框内边距
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		//获取标题
		this.title=frame.attributeValue("title");
		//图块尺寸获取窗口拔高
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
		//左位移偏移量
		this.sizeRol=Integer.parseInt(frame.attributeValue("sizeRol"));
		//游戏失败图片
		this.loseIdx=Integer.parseInt(frame.attributeValue("loseIdx"));

		//获取窗体属性
		@SuppressWarnings("unchecked")
		List<Element> lays=frame.elements("lay");
		laysConfig= new ArrayList<>();
		for (Element lay : lays){
			LayConfig lc=new LayConfig(
					lay.attributeValue("className"),
					Integer.parseInt(lay.attributeValue("x")),
					Integer.parseInt(lay.attributeValue("y")),
					Integer.parseInt(lay.attributeValue("w")),
					Integer.parseInt(lay.attributeValue("h"))
			);
			laysConfig.add(lc);
		}
		//初始化按钮属性
		buttonConfig=new ButtonConfig(frame.element("button"));
	}
}
