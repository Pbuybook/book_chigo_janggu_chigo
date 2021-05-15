package com.bookchigo.domain;

import java.io.Serializable;

public class Wishlist implements Serializable {
	private int wish_id; //즐겨찾기 ID
	private int memberId; //구매자 아이디
	private int sell_itemId;
	private String sell_itemName;
	private int sell_price;
	private String sell_image; 
	private int deal_status; 
	private String account;
	
	public int getWish_id() {
		return wish_id;
	}
	public void setWish_id(int wish_id) {
		this.wish_id = wish_id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
	public String getSell_image() {
		return sell_image;
	}
	public void setSell_image(String sell_image) {
		this.sell_image = sell_image;
	}
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
