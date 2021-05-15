package com.bookchigo.service;

import java.util.List;

import com.bookchigo.domain.BuyFin;
import com.bookchigo.domain.SellItem;
import com.bookchigo.domain.Wishlist;

public interface SellServiceFacade {
	public List<SellItem> getSellList();
	public SellItem getSellByItemId(int itemId);
	public int getCountbyId(int memberId);
	public int getMemberIdbyItemId(int itemId);
	public List<SellItem> getSellListByItemName(String itemName);
	public List<SellItem> getSellListByMemberId(int memberId);
	public void insertSellItem(SellItem item);
	public void updateCountMinus(int memberId);
	public void updateCountPlus(int memberId);
	public void updateSellItem(SellItem item);
	public void deleteSellItem(int itemId);
	public void updateDealStatus(SellItem item);
	public int getDealStatus(int itemId);
	public void insertWishlist(Wishlist wish);
	public List<Wishlist> selectWishlist(int memberId);
	public void deleteWishlist(int wishId);
	public int getMemberIdbyId(String id);
	public void insertBuyFin(BuyFin buy);
	public List<BuyFin> selectBuyFin(int memberId);
}