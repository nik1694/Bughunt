package com.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bean.ReportBean;
import com.dataset.bean.AssignTo;
import com.dataset.bean.Report;
import com.dataset.bean.Update;

public class BUGXmlHandler extends DefaultHandler {

	boolean update1;
	boolean update2;
	boolean updateTime1;
	boolean updateTime2;
	boolean reportID;

	private final Stack<String> tagsStack = new Stack<String>();
	private final StringBuilder tempVal = new StringBuilder();
	private Update update;
	private Report report;
	private List<Update> updates;
	private List<Report> reports;

	public BUGXmlHandler() {
		super();
		boolean update1 = false;
		boolean update2 = false;
		boolean updateTime1 = false;
		boolean updateTime2 = false;
		boolean reportID = false;
		updates = new ArrayList();

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		pushTag(qName);
		tempVal.setLength(0);
		if (DataSetConstatnts.REPORT.equalsIgnoreCase(qName)) {
			report = new Report();
		} else if (DataSetConstatnts.UPDATE.equalsIgnoreCase(qName)) {
			update = new Update();
		} /*
			 * else if (DataSehtConstatnts.equalsIgnoreCase(qName)) { student =
			 * new Student(); }
			 */
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String tag = peekTag();
		if (!qName.equals(tag)) {
			throw new InternalError();
		}

		if (DataSetConstatnts.WHEN.equalsIgnoreCase(tag)) {
			long time = Integer.valueOf(tempVal.toString().trim());
			update.setTime(time);
		} else if (DataSetConstatnts.WHAT.equalsIgnoreCase(tag)) {
			String what = tempVal.toString().trim();
			update.setString(what);
		} else if (DataSetConstatnts.UPDATE.equalsIgnoreCase(tag)) {
			updates.add(update);
		} else if (DataSetConstatnts.REPORT.equalsIgnoreCase(tag)) {
			report.setReport(updates);
			reports.add(report);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal.append(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {

	}

	public void startDocument() {
		pushTag("");
	}

	public List<Report> getReports() {
		List<Report> assignTo = null;
		return assignTo;
	}

	private void pushTag(String tag) {
		tagsStack.push(tag);
	}

	private String popTag() {
		return tagsStack.pop();
	}

	private String peekTag() {
		return tagsStack.peek();
	}
}
