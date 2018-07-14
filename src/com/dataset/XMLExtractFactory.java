package com.dataset;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dataset.bean.DataSetBean;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLExtractFactory {

	public ArrayList<DataSetBean> Parse(int type, String fileName) {
		ArrayList<DataSetBean> reportList = new ArrayList<>();
		// public static void main (String args[]) {
		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName(DataSetConstatnts.REPORT);
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					DataSetBean bean = new DataSetBean();
					String sid = eElement.getAttribute("id");
					if (!sid.equals("") || !sid.equals(null)) {
						long id = Long.parseLong(eElement.getAttribute("id"));
						System.out.println("Report Id : " + id);
						bean.setId(id);
					} else {
						System.out.println("Report Id : null ");
						continue;
					}

					NodeList updateList = eElement.getElementsByTagName("update");
					for (int k = 0; k < updateList.getLength(); ++k) {
						Node update = (Node) updateList.item(k);
						Element updateElement = (Element) update;
						/*
						 * try { Thread.sleep(1000); } catch
						 * (InterruptedException e) { // TODO Auto-generated
						 * catch block e.printStackTrace(); }
						 */
						String swhen = updateElement.getElementsByTagName(DataSetConstatnts.WHEN).item(0)
								.getTextContent();
						System.out.println(" tyepe : " + type + " when : " + swhen);
						long when = Long.parseLong(swhen);
						String what = updateElement.getElementsByTagName(DataSetConstatnts.WHAT).item(0)
								.getTextContent();
						System.out.println(" tyepe : " + type + " what : " + what);
						System.out.println(" tyepe : " + type + " when : " + when);
						bean.setWhat(what);
						bean.setWhen(when);

					}
					reportList.add(bean);
					/*
					 * 
					 * System.out.println("First Name : " + eElement
					 * .getElementsByTagName("") .item(0) .getTextContent());
					 * 
					 */
				}
				System.out.println("Record Number: " + temp);
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportList;
	}

}
