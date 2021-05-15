package com.bookchigo.domain;

import java.io.Serializable;

public class SellItem implements Serializable {
	private int sell_itemId;
	private String sell_itemName;
	private int sell_price;
	private String sell_author;
	private String sell_publisher;
	private String sell_info;
	private String sell_image; 
	private String deal_method; 
	private int deal_status; 
	private String account;
	//Member 클래스 필드
	private int memberId; //판매자의 아이디
	private String name; //판매자 이름
	private int tradeCount; //판매자의 판매거래 횟수
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getSell_itemId() {
		return sell_itemId;
	}
	public void setSell_itemId(int sell_itemId) {
		this.sell_itemId = sell_itemId;
	}
	public String getSell_itemName() {
		return sell_itemName;
	}
	public void setSell_itemName(String sell_itemName) {
		this.sell_itemName = sell_itemName;
	}
	public int getSell_price() {
		return sell_price;
	}
	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}
	public String getSell_author() {
		return sell_author;
	}
	public void setSell_author(String sell_author) {
		this.sell_author = sell_author;
	}
	public String getSell_publisher() {
		return sell_publisher;
	}
	public void setSell_publisher(String sell_publisher) {
		this.sell_publisher = sell_publisher;
	}
	public String getSell_info() {
		return sell_info;
	}
	public void setSell_info(String sell_info) {
		this.sell_info = sell_info;
	}
	public String getSell_image() {
		return sell_image;
	}
	public void setSell_image(String sell_image) {
		this.sell_image = sell_image;
	}
	public String getDeal_method() {
		return deal_method;
	}
	public void setDeal_method(String deal_method) {
		this.deal_method = deal_method;
	}
	public int getDeal_status() {
		return deal_status;
	}
	public void setDeal_status(int deal_status) {
		this.deal_status = deal_status;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getTradeCount() {
		return tradeCount;
	}
	public void setTradeCount(int tradeCount) {
		this.tradeCount = tradeCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SellItem [sell_itemName=" + sell_itemName + ", sell_price=" + sell_price + ", sell_author="
				+ sell_author + ", sell_publisher=" + sell_publisher + ", sell_info=" + sell_info + ", sell_image="
				+ sell_image + ", deal_method=" + deal_method + ", memberId=" + memberId + "]";
	}

}
