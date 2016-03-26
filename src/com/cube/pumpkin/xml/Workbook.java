package com.cube.pumpkin.xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;

public class Workbook {

	private Document document;
	private HashMap<String, Sheet> workSheets;
	private final QName QNAME = new QName("Name", new Namespace("ss", "urn:schemas-microsoft-com:office:spreadsheet"));
	private String TABNAME = "Table";
	private String ROWNAME = "Row";

	Workbook(InputStream ins) throws DocumentException {
		SAXReader reader = new SAXReader();
		document = reader.read(ins);
		Element root = document.getRootElement();
		workSheets = new HashMap<String, Sheet>();
		List<Element> temp= root.elements("Worksheet");
		for (Element obj : temp) {
			Element tab = obj.element(TABNAME);
			List<Element> rows = tab.elements(ROWNAME);
			
		}
	}
}
