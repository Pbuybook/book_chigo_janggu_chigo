package com.bookchigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookchigo.dao.SellDao;
import com.bookchigo.domain.SellItem;
import com.bookchigo.domain.Wishlist;
import com.bookchigo.domain.BuyFin;

@Service("sellServiceImpl")
public class SellServiceImpl implements SellService {
	@Autowired
	private SellDao sellDao;
	
	public List<SellItem> getSellList() {
		return sellDao.getSellList();
	}
	
	public List<SellItem> getSellByItemId(int itemId) {
		return sellDao.getSellByItemId(itemId);
	}
	
	public List<SellItem> getSellListByItemName(String itemName) {
		return sellDao.getSellListByItemName(itemName);
	}
	
	public List<SellItem> getSellListByMemberId(int memberId) {
		return sellDao.getSellListByMemberId(memberId);
	}
	
	public void insertSellItem(SellItem item) {
		sellDao.insertSellItem(item);
	}
	
	public void updateSellItem(SellItem item) {
		sellDao.updateSellItem(item);
	}
	
	public void deleteSellItem(int itemId) {
		sellDao.deleteSellItem(itemId);
	}
	
	public void updateDealStatus(SellItem item) {
		sellDao.updateDealStatus(item);
	}
	
	public int getDealStatus(int itemId) {
		return sellDao.getDealStatus(itemId);
	}
	
	public void insertWishlist(Wishlist wish) {
		sellDao.insertWishlist(wish);
	}
	
	public List<Wishlist> selectWishlist(int memberId) {
		return sellDao.selectWishlist(memberId);
	}
	
	public void deleteWishlist(int wishId) {
		sellDao.deleteWishlist(wishId);
	}
	
	public int getMemberIdbyId(String id) {
		return sellDao.getMemberIdbyId(id);
	}
	
	public void insertBuyFin(BuyFin buy) {
		sellDao.insertBuyFin(buy);
	}
	
	public List<BuyFin> selectBuyFin(int memberId) {
		return sellDao.selectBuyFin(memberId);
	}
	
}