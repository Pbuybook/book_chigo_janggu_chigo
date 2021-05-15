package com.bookchigo.domain;

import java.io.Serializable;

public class BuyFin implements Serializable {
	private int sellfin_id; //완료 ID
	private int memberId; //구매자의 아이디
	private int sell_itemId;
	private String sell_itemName;
	private int sell_price;
	private String sell_image; 
	private String deal_method;
	private String account;
	
	public int getSellfin_id() {
		return sellfin_id;
	}
	public void setSellfin_id(int sellfin_id) {
		this.sellfin_id = sellfin_id;
	}
	public int getmemberId() {
		return memberId;
	}
	public void setmemberId(int memberId) {
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
	public String getDeal_method() {
		return deal_method;
	}
	public void setDeal_method(String deal_method) {
		this.deal_method = deal_method;
	}
	public int getSell_itemId() {
		return sell_itemId;
	}
	public void setSell_itemId(int sell_itemId) {
		this.sell_itemId = sell_itemId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "BuyFin [sellfin_id=" + sellfin_id + ", memberId=" + memberId + ", sell_itemId=" + sell_itemId
				+ ", sell_itemName=" + sell_itemName + ", sell_price=" + sell_price + ", sell_image=" + sell_image
				+ ", deal_method=" + deal_method + ", account=" + account + "]";
	}
}
