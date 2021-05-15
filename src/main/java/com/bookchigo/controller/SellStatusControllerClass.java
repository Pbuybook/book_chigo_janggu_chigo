package com.bookchigo.controller;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/sell/statusUpdate.do")
@SessionAttributes("StatusForm")
public class SellStatusControllerClass {
	
	private SellServiceFacade sellService;
	
	@Autowired
	public void setSellService(SellServiceFacade sellService) {
		this.sellService = sellService;
	}
	
	@ModelAttribute("StatusForm")
	public StatusForm FormData() {
		StatusForm sf = new StatusForm();
		sf.setId(null);
//		HttpSession session = request.getSession(true);
		
//		int memberId = session.getAttribute("memberId"); //세션에서 얻음
		int memberId = 1;
		sf.setMemberId(memberId);
		return sf;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(@ModelAttribute("StatusForm") StatusForm statusForm, 
			@RequestParam("sell_itemId") int itemId) {
		statusForm.setSell_itemId(itemId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_status");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("StatusForm") StatusForm statusForm,
			SessionStatus status) {
		SellItem s1 = new SellItem();
		System.out.println(statusForm.getDeal_status());
		int ds = statusForm.getDeal_status();
		int sid = statusForm.getSell_itemId();
		s1.setDeal_status(ds);
		s1.setSell_itemId(sid);
		
		this.sellService.updateDealStatus(s1);
		
		BuyFin bf = new BuyFin();
		SellItem s2 = new SellItem();
		String si = statusForm.getId();
		if (si != null && ds == 2) {
			int mi = -1;
			mi = this.sellService.getMemberIdbyId(si);
			if (mi != -1) {
				s2 = this.sellService.getSellByItemId(sid);
			
				bf.setmemberId(s2.getMemberId());
				bf.setSell_itemId(s2.getSell_itemId());
				bf.setSell_itemName(s2.getSell_itemName());
				bf.setSell_price(s2.getSell_price());
				bf.setSell_image(s2.getSell_image());
				bf.setDeal_method(s2.getDeal_method());
				bf.setAccount(s2.getAccount());
				
				System.out.println(bf);
				this.sellService.insertBuyFin(bf);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/sell/item.do?sell_itemId=" + sid);
		//getItem() 호출 후 객체 저장
		status.setComplete();
		return mav;
	}
}
