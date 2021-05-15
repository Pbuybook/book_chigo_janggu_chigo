package com.bookchigo.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookchigo.domain.SellItem;
import com.bookchigo.domain.Wishlist;
import com.bookchigo.domain.BuyFin;

@Mapper
public interface SellMapper {
	List<SellItem> getSellList();
	SellItem getSellByItemId(int itemId);
	int getMemberIdbyItemId(int itemId);
	List<SellItem> getSellListByItemName(String itemName);
	List<SellItem> getSellListByMemberId(int memberId);
	
	String getAccountByMemberId(int memberId);
	int getDealStatus(int itemId);
	int getMemberIdBySell(int itemId);
	int getMemberIdbyId(String id);
	String getNamebyId(int memberId);
	int getCountbyId(int memberId);
	void updateName(SellItem item);
	
	List<Wishlist> selectWishlist(int memberId);
	List<BuyFin> selectBuyFin(int memberId);
	
	void insertSellItem(SellItem item);
	void updateCountPlus(int memberId);
	void updateSellItem(SellItem item);
	void deleteSellItem(int itemId);
	void updateCountMinus(int memberId);
	void updateDealStatus(SellItem item);
	
	void insertWishlist(Wishlist wish);
	void deleteWishlist(int wishId);
	void insertBuyFin(BuyFin buy);
}