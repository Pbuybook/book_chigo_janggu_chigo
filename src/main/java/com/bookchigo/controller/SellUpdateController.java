package com.bookchigo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

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

import com.bookchigo.domain.BuyFin;
import com.bookchigo.domain.SellItem;
import com.bookchigo.service.SellServiceFacade;

@Controller
@RequestMapping("/sell/update.do")
@SessionAttributes("UpdateForm")
public class SellUpdateController {
	
	private SellServiceFacade sellService;
	
	@Autowired
	public void setPetStore(SellServiceFacade sellService) {
		this.sellService = sellService;
	}

	@ModelAttribute("UpdateForm")
	public UpdateForm FormData(HttpServletRequest request) {
		UpdateForm uf = new UpdateForm();
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1;
		uf.setMemberId(memberId);
		return uf;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(@ModelAttribute("UpdateForm") UpdateForm updateForm, 
			@RequestParam("sell_itemId") int itemId) {
		ModelAndView mav = new ModelAndView();
		
		SellItem s = new SellItem();
		s = this.sellService.getSellByItemId(itemId);
		int c = this.sellService.getCountbyId(updateForm.getMemberId());
		s.setTradeCount(c);
		
		updateForm.setSell_itemId(s.getSell_itemId());
		updateForm.setSell_itemName(s.getSell_itemName());
		updateForm.setSell_price(s.getSell_price());
		updateForm.setDeal_method(s.getDeal_method());
		updateForm.setSell_author(s.getSell_author());
		updateForm.setSell_publisher(s.getSell_publisher());
		updateForm.setSell_info(s.getSell_info());
		
		int ds = this.sellService.getDealStatus(itemId);
		if (ds == 0) {
			mav.setViewName("sell/sell_update");
			mav.addObject("item", s);
		} else {
			mav.setViewName("sell/sell_seller");
			mav.addObject("item", s);
			mav.addObject("alert", "수정은 상품이 판매 중 상태일 때만 가능합니다.");
		}
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("UpdateForm") UpdateForm updateForm,
			SessionStatus status) {
		SellItem s1 = new SellItem();
		
		s1.setMemberId(updateForm.getMemberId());
		s1.setSell_itemId(updateForm.getSell_itemId());
		s1.setSell_itemName(updateForm.getSell_itemName());
		s1.setSell_price(updateForm.getSell_price());
		
		SellItem s = new SellItem();
		s = this.sellService.getSellByItemId(s1.getSell_itemId());
		String img = s.getSell_image();
		
		System.out.println(img);
		
		System.out.println(updateForm.getSell_image());
		if (updateForm.getSell_image() == null || updateForm.getSell_image().equals("")) {
			updateForm.setSell_image(img);
			System.out.println("test1");
		}
		
		if (updateForm.getSell_image().contains(",")) {
			updateForm.setSell_image(updateForm.getSell_image().replace(",", ""));
			System.out.println("test2");
		}
		
		System.out.println(updateForm.getSell_image());
		
		s1.setSell_image(updateForm.getSell_image());		
		
		s1.setDeal_method(updateForm.getDeal_method());
		s1.setSell_author(updateForm.getSell_author());
		s1.setSell_publisher(updateForm.getSell_publisher());
		s1.setSell_info(updateForm.getSell_info());
		
		System.out.println(updateForm.getSell_image());
		
		this.sellService.updateSellItem(s1);
		status.setComplete();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/sell/item.do?sell_itemId=" + s1.getSell_itemId());
		return mav;
	}
}
