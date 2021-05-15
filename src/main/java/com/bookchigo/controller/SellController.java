package com.bookchigo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.BuyFin;
import com.bookchigo.domain.SellItem;
import com.bookchigo.service.SellServiceFacade;

@Controller
//@RequestMapping("/sell")
public class SellController {
	
	private SellServiceFacade sellService;
	
	@Autowired
	public void setSellService(SellServiceFacade sellService) {
		this.sellService = sellService;
	}
	
	@RequestMapping("/sell/list.do")
	public ModelAndView getList() {
		List<SellItem> list = null;
		list = this.sellService.getSellList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_list");
		if (list != null)
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/sell/item.do")
	public ModelAndView getItem(HttpServletRequest request, 
			@RequestParam("sell_itemId") int itemId) {
		ModelAndView mav = new ModelAndView();
		
//		HttpSession session = request.getSession(true);
		
//		int sessionId = session.getAttribute("memberId"); //세션에서 얻음
//		int memberId = this.sellService.getMemberIdbyItemId(itemId);
//		
//		if (sessionId == memberId)
//			mav.setViewName("sell/sell_seller");
//		else
//			mav.setViewName("sell/sell_publisher");
		
		int memberId = this.sellService.getMemberIdbyItemId(itemId);
		mav.setViewName("sell/sell_publisher");
		
		SellItem s = new SellItem();
		s = this.sellService.getSellByItemId(itemId);
		int c = this.sellService.getCountbyId(s.getMemberId());
		s.setTradeCount(c);
		
		mav.addObject("item", s);
		mav.addObject("alert", "X"); //publisher 페이지 열기만 해도 경고창 뜨는 것 방지
		return mav;
	}
	
	@RequestMapping("/sell/search.do")
	public ModelAndView searchList(@RequestParam("sell_itemName") String itemName) {
		List<SellItem> list = null;
		list = this.sellService.getSellListByItemName(itemName);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_list");
		if (list != null)
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/sell/history.do")
	public ModelAndView getHistory(HttpServletRequest request) {
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1;
		
		List<SellItem> list = null;
		list = this.sellService.getSellListByMemberId(memberId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_history");
		if (list != null)
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/sell/upload.do")
	public ModelAndView upload(HttpServletRequest request, @RequestParam("sell_itemName") String itemName,
			@RequestParam("sell_price") int price,
			@RequestParam("sell_author") String author,
			@RequestParam("sell_publisher") String publisher,
			@RequestParam("sell_info") String info,
			@RequestParam("sell_image") String image,
			@RequestParam("deal_method") String method) {
		
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1; //세션에서 가져옴
		System.out.println("image" + image);
		
		SellItem s = new SellItem();
		s.setMemberId(memberId);
		s.setSell_itemName(itemName);
		s.setSell_price(price);
		s.setSell_author(author);
		s.setSell_publisher(publisher);
		s.setSell_info(info);
		s.setSell_image(image);
		s.setDeal_method(method);
		s.setDeal_status(0);
		
		this.sellService.insertSellItem(s);
		this.sellService.updateCountPlus(memberId);
		
		List<SellItem> list = null;
		list = this.sellService.getSellList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_list");
		if (list != null)
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/sell/delete.do")
	public ModelAndView delete(@RequestParam("sell_itemId") int itemId) {
		int memberId = this.sellService.getMemberIdbyItemId(itemId);
		this.sellService.deleteSellItem(itemId);
		this.sellService.updateCountMinus(memberId);
		
		List<SellItem> list = null;
		list = this.sellService.getSellList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_list");
		if (list != null)
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/sell/chat.do")
	public ModelAndView chat(@RequestParam("sell_itemId") int itemId) {
		ModelAndView mav = new ModelAndView();
		
		int ds = this.sellService.getDealStatus(itemId);
		if (ds != 0) {
			mav.setViewName("sell/sell_publisher");
			
			SellItem s = new SellItem();
			s = this.sellService.getSellByItemId(itemId);		
			int c = this.sellService.getCountbyId(s.getMemberId());
			s.setTradeCount(c);	
			
			mav.addObject("item", s);
			mav.addObject("alert", "채팅은 상품이 판매 중 상태일 때만 가능합니다.");
			return mav;
		} else {
			mav.setViewName("sell/sell_publisher"); //후에 채팅 페이지로 수정
			
			int sellerId = this.sellService.getMemberIdbyItemId(itemId);
			
			//sellerId와 itemId를 chatMessage 객체에 담아서 mav.addObject
		}
		return mav;
	}
	
	@RequestMapping("/sell/finish.do")
	public ModelAndView buyFin(HttpServletRequest request) {
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1;
				
		List<BuyFin> list = null;
		list = this.sellService.selectBuyFin(memberId);
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_finish");
		if (list != null)
			mav.addObject("list", list);
		return mav;	
	}
}
