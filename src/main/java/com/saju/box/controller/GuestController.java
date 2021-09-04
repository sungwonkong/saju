package com.saju.box.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saju.box.model.OrderDto;
import com.saju.box.service.OrderService;

@Controller
public class GuestController {
	
	@Inject
	private OrderService orderService;
	
	private static final Logger logger = LoggerFactory.getLogger(GuestController.class);
	/**
	 * 게스트화면에서 오더 저장
	 * @param orderDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrder.json", method = RequestMethod.POST)
	public ModelAndView saveOrder(Model model, OrderDto orderDto) throws Exception{ 
		ModelAndView mv = new ModelAndView("jsonView");  
		//Map<String, Object> result = new HashMap<String, Object>();
		//List<companyInfoDto> companyInfo = companyInfoService.getCompInfo();
		
		//logger.info(orderDto.getOrderYear());
		
		try {
			orderService.saveOrder(orderDto);
			mv.addObject("code", "0");
		}catch(Exception e) {
			logger.error(e + "");
			mv.addObject("code", "1");
		}    
	      
		return mv;	  
	  }
}
