package com.cube.pumpkin.xml;

import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;


public class Cell {
	private static Logger logger = Logger.getRootLogger();
	// 标致数据类型
	private String type;
	private Element data;
	private static final QName QNAMEType = new QName("Type", new Namespace("ss", "urn:schemas-microsoft-com:office:spreadsheet"));
	
	public Cell(Element cell) throws Exception{
		data = cell.element("Data");
		if (data == null) {
			throw new Exception("null data");
		}
		type = data.attributeValue(QNAMEType);
	}
	
	public double getNumericCellValue(){
		if (!type.equals("Number")) {
			logger.warn("cell type is error.type is not number.value="+data.getTextTrim());
			return 0;
		}
		return Double.parseDouble(data.getText());
	}
	
	public String getStringCellValue(){
		if (!type.equals("String")) {
			logger.warn("cell type is error.type is not string.value="+data.getTextTrim());
		}
		String res = data.getText();
		if (res == null || res.length() == 0) {
			@SuppressWarnings("unchecked")
			List<Element> list = data.elements();
			for (Element tmp : list) {
				res = tmp.getText();
				if (res != null && res.length()> 0) {
					break;
				}
			}
		}
		return res;
	}
	
	public String getCellType() {
		return type;
	}
}
