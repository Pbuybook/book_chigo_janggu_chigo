package com.bookchigo.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookchigo.dao.mybatis.mapper.SellMapper;
import com.bookchigo.dao.SellDao;
import com.bookchigo.domain.SellItem;
import com.bookchigo.domain.Wishlist;
import com.bookchigo.domain.BuyFin;

@Repository
public class MyBatisSellDao implements SellDao {
	@Autowired
	private SellMapper sellMapper;
	
	public List<SellItem> getSellList() throws DataAccessException {
		return sellMapper.getSellList();
	}
	
	public SellItem getSellByItemId(int itemId) throws DataAccessException {
		return sellMapper.getSellByItemId(itemId);
	}
	
	public int getCountbyId(int memberId) throws DataAccessException {
		return sellMapper.getCountbyId(memberId);
	}
	
	public int getMemberIdbyItemId(int itemId) throws DataAccessException {
		return sellMapper.getMemberIdbyItemId(itemId);
	}
	
	public List<SellItem> getSellListByItemName(String itemName) throws DataAccessException {
		return sellMapper.getSellListByItemName(itemName);
	}
	
	public List<SellItem> getSellListByMemberId(int memberId) throws DataAccessException {
		return sellMapper.getSellListByMemberId(memberId);
	}
	
	public void insertSellItem(SellItem item) throws DataAccessException {
		String account = sellMapper.getAccountByMemberId(item.getMemberId());
		item.setAccount(account);
		sellMapper.insertSellItem(item);
		
		String name = sellMapper.getNamebyId(item.getMemberId());
		item.setName(name);
		sellMapper.updateName(item);
	}
	
	public void updateCountPlus(int memberId) throws DataAccessException {
		sellMapper.updateCountPlus(memberId);
	}
	
	public void updateSellItem(SellItem item) throws DataAccessException {
		sellMapper.updateSellItem(item);
	}
	
	public void deleteSellItem(int itemId) throws DataAccessException {
		int memId = sellMapper.getMemberIdBySell(itemId);
		sellMapper.deleteSellItem(itemId);
	}
	
	public void updateCountMinus(int memberId) throws DataAccessException {
		sellMapper.updateCountMinus(memberId);
	}
	
	public void updateDealStatus(SellItem item) throws DataAccessException { 
		sellMapper.updateDealStatus(item);
	}
	
	public int getDealStatus(int itemId) throws DataAccessException {
		return sellMapper.getDealStatus(itemId);
	}
	
	public void insertWishlist(Wishlist wish) throws DataAccessException {
		String account = sellMapper.getAccountByMemberId(wish.getMemberId());
		wish.setAccount(account);
		sellMapper.insertWishlist(wish);
	}
	
	public List<Wishlist> selectWishlist(int memberId) throws DataAccessException {
		return sellMapper.selectWishlist(memberId);
	}
	
	public void deleteWishlist(int wishId) throws DataAccessException {
		sellMapper.deleteWishlist(wishId);
	}
	
	public int getMemberIdbyId(String id) throws DataAccessException {
		return sellMapper.getMemberIdbyId(id);
	}
	
	public void insertBuyFin(BuyFin buy) throws DataAccessException {
		String account = sellMapper.getAccountByMemberId(buy.getmemberId());
		buy.setAccount(account);
		sellMapper.insertBuyFin(buy);
	}
	
	public List<BuyFin> selectBuyFin(int memberId) throws DataAccessException {
		return sellMapper.selectBuyFin(memberId);
	}
}
