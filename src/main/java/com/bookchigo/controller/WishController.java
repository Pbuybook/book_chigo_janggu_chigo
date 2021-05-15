package com.bookchigo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.Wishlist;
import com.bookchigo.domain.SellItem;
import com.bookchigo.service.SellServiceFacade;

@Controller
public class WishController {
	private SellServiceFacade sellService;
	
	@Autowired
	public void setPetStore(SellServiceFacade sellService) {
		this.sellService = sellService;
	}
	
	@RequestMapping("/sell/wish.do")
	public ModelAndView getList(HttpServletRequest request) {
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1; //세션에서 얻어옴
		
		List<Wishlist> w = null;
		w = this.sellService.selectWishlist(memberId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_wishlist");
		if (w != null)
			mav.addObject("list", w);
		return mav;
	}

	@RequestMapping("/sell/wish/upload.do")
	public ModelAndView upload(HttpServletRequest request, @RequestParam("sell_itemId") int itemId) {
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1; //세션에서 얻어옴
		SellItem s1 = new SellItem();
		s1 = this.sellService.getSellByItemId(itemId);
		
		Wishlist w = new Wishlist();
		w.setMemberId(memberId);
		w.setSell_itemId(itemId);
		w.setSell_itemName(s1.getSell_itemName());
		w.setSell_price(s1.getSell_price());
		w.setSell_image(s1.getSell_image());
		w.setDeal_status(s1.getDeal_status());
		w.setAccount(s1.getAccount());
		
		if (w != null)
			this.sellService.insertWishlist(w);
		
		SellItem s2 = new SellItem();
		s2 = this.sellService.getSellByItemId(itemId);
		int c = this.sellService.getCountbyId(memberId);
		s2.setTradeCount(c);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/sell/item.do?sell_itemId=" + itemId);
		return mav;
	}
	
	@RequestMapping("/sell/wish/delete.do")
	public ModelAndView delete(HttpServletRequest request, @RequestParam("wish_id") int wishId) {
		this.sellService.deleteWishlist(wishId);
		
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1; //세션에서 얻어옴
		
		List<Wishlist> w = null;
		w = this.sellService.selectWishlist(memberId);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/sell/wish.do?wish_id=" + wishId);
		return mav;
	}
}
