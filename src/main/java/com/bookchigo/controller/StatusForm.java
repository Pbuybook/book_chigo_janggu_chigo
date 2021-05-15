package com.bookchigo.controller;

public class StatusForm {
	private int sell_itemId;
	private int deal_status; 
	private int memberId;
	private int tradeCount;
	private String id; //구매자의 아이디
	
	public int getSell_itemId() {
		return sell_itemId;
	}
	public void setSell_itemId(int sell_itemId) {
		this.sell_itemId = sell_itemId;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
