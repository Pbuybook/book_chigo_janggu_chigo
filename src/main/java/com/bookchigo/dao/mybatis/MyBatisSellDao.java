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

	public List<SellItem> getSellByItemId(int itemId) throws DataAccessException {
		return sellMapper.getSellByItemId(itemId);
	}

	public List<SellItem> getSellListByItemName(String itemName) throws DataAccessException {
		return sellMapper.getSellListByItemName(itemName);
	}

	public List<SellItem> getSellListByMemberId(int memberId) throws DataAccessException {
		return sellMapper.getSellListByMemberId(memberId);
	}

	public void insertSellItem(SellItem item) throws DataAccessException {
		sellMapper.insertSellItem(item);
		sellMapper.updateCountPlus(item.getMemberId());
	}

	public void updateSellItem(SellItem item) throws DataAccessException {
		sellMapper.updateSellItem(item);
	}

	public void deleteSellItem(int itemId) throws DataAccessException {
		int memId = sellMapper.getMemberIdBySell(itemId);
		sellMapper.deleteSellItem(itemId);
		sellMapper.updateCountMinus(memId);
	}

	public void updateDealStatus(SellItem item) throws DataAccessException {
		sellMapper.updateDealStatus(item);
	}

	public int getDealStatus(int itemId) throws DataAccessException {
		return sellMapper.getDealStatus(itemId);
	}

	public void insertWishlist(Wishlist wish) throws DataAccessException {
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
		sellMapper.insertBuyFin(buy);
	}

	public List<BuyFin> selectBuyFin(int memberId) throws DataAccessException {
		return sellMapper.selectBuyFin(memberId);
	}

}