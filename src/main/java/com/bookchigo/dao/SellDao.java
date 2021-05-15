package com.bookchigo.dao;

import com.bookchigo.domain.SellItem;
import com.bookchigo.domain.Wishlist;
import com.bookchigo.domain.BuyFin;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface SellDao {
	List<SellItem> getSellList() throws DataAccessException;
	SellItem getSellByItemId(int itemId) throws DataAccessException;
	int getCountbyId(int memberId) throws DataAccessException;
	int getMemberIdbyItemId(int itemId) throws DataAccessException;
	List<SellItem> getSellListByItemName(String itemName) throws DataAccessException;
	List<SellItem> getSellListByMemberId(int memberId) throws DataAccessException;
	void insertSellItem(SellItem item) throws DataAccessException;
	void updateCountMinus(int memberId) throws DataAccessException;
	void updateCountPlus(int memberId) throws DataAccessException;
	void updateSellItem(SellItem item) throws DataAccessException;
	void deleteSellItem(int itemId) throws DataAccessException;
	void updateDealStatus(SellItem item) throws DataAccessException;
	int getDealStatus(int itemId) throws DataAccessException;
	int getMemberIdbyId(String id) throws DataAccessException;
	void insertWishlist(Wishlist wish) throws DataAccessException;
	List<Wishlist> selectWishlist(int memberId) throws DataAccessException;
	void deleteWishlist(int wishId) throws DataAccessException;
	void insertBuyFin(BuyFin buy) throws DataAccessException;
	List<BuyFin> selectBuyFin(int memberId) throws DataAccessException;
}
