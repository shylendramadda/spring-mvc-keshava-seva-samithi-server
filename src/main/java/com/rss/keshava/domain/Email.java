package com.rss.keshava.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Email {
	
	private String from;
	private String subject;
	private String body;
	private String toWhome;

	private List<String> to;
	private List<String> cc;

	private boolean isHtml;
 
	public Email() {
		this.to = new ArrayList<>();
		this.cc = new ArrayList<>();
	}
 
	public Email(String from, String toList, String subject, String body) {
		this();
		this.from = from;
		this.subject = subject;
		this.body = body;
		this.to.addAll(Arrays.asList(splitByComma(toList)));
	}
 
	public Email(String from, String toList, String ccList, String subject, String body) {
		this();
		this.from = from;
		this.subject = subject;
		this.body = body;
		this.to.addAll(Arrays.asList(splitByComma(toList)));
		this.cc.addAll(Arrays.asList(splitByComma(ccList)));
	}
 
	
        //getters and setters not mentioned for brevity
 
	private String[] splitByComma(String toMultiple) {
		String[] toSplit = toMultiple.split(",");
		return toSplit;
	}
 
//	public String getToAsList() {
//		return AppUtil.concatenate(this.to, ",");
//	}


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean html) {
		isHtml = html;
	}

    public String getToWhome() {
        return toWhome;
    }

    public void setToWhome(String toWhome) {
        this.toWhome = toWhome;
    }
}