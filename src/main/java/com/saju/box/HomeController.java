package com.saju.box;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.saju.box.model.companyInfoDto;
import com.saju.box.service.companyInfoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private companyInfoService companyInfoService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ModelAndView mv = new ModelAndView("jsonView");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		mv.addObject("serverTime", formattedDate );
		mv.setViewName("home");
		
		//return "home";
		return mv;
	}
	
	
	
	@RequestMapping(value = "/guest", method = RequestMethod.GET)
	public ModelAndView guest(Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		mv.setViewName("guest/guestMain");
		//return "guest/guestMain";
		return mv;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin(HttpServletRequest request, Locale locale, Model model) {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("jsonView");
		logger.info("ksw::::" + (String) session.getAttribute("teacherId"));
		//세션값 확인
		if((String) session.getAttribute("teacherId") == null) {
			mv.setViewName("admin/login");
			return mv;
		}		
		//세션값 셋팅
		mv.addObject("compNo", (String) session.getAttribute("compNo"));
		mv.addObject("compName", (String) session.getAttribute("compName"));
		mv.addObject("teacherNo", (String) session.getAttribute("teacherNo"));
		mv.addObject("teacherNm", (String) session.getAttribute("teacherNm"));
		mv.addObject("teacherId", (String) session.getAttribute("teacherId"));
		mv.addObject("reprYn", (String) session.getAttribute("reprYn"));
		
		
		mv.setViewName("admin/home");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.setViewName("admin/login");
		return mv;		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, Locale locale, Model model) {
		ModelAndView mv = new ModelAndView("jsonView");
		//세션 삭제
		HttpSession session = request.getSession();
        session.invalidate();

		mv.setViewName("redirect:login");
		return mv;		
	}
	
	@RequestMapping(value = "/getCompInfo.json", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView  getCompInfo(companyInfoDto companyInfoDto) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		mv.addObject("code", "0000");
		mv.addObject("data", companyInfoService.getCompInfo());	//사주카페 정보 확인
		
		return mv;	  
	  }
	 
	
}
