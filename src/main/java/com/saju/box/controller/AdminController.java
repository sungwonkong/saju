package com.saju.box.controller;

import java.util.List;
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

import com.saju.box.model.LoginDto;
import com.saju.box.model.OrderDto;
import com.saju.box.service.AdminService;

@Controller
public class AdminController {
	@Inject
	private AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * 로그인
	 * @param request
	 * @param loginDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/getLogin.json", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView getLoginInfo(HttpServletRequest request, LoginDto loginDto) throws Exception{
		//logger.info("ksw:::::::getLogin "+ loginDto.getTeacherId());
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		//로그인 정보 받아오기
		try {
			LoginDto loginDtoResult = adminService.getLoginInfo(loginDto);
			
			if(loginDtoResult == null){
				//맞는 정보가 없는경우			
				mv.addObject("code","1");
				mv.addObject("msg","맞는 정보가 없습니다.");
				//mv.setViewName("/login");
			}else {
				//로그인 세션 구현				
				session.setAttribute("compNo", loginDtoResult.getCompNo());		
				session.setAttribute("compName", loginDtoResult.getCompName());
				session.setAttribute("teacherNo", loginDtoResult.getTeacherNo());
				session.setAttribute("teacherNm", loginDtoResult.getTeacherNm());
				session.setAttribute("teacherId", loginDtoResult.getTeacherId());
				session.setAttribute("reprYn", loginDtoResult.getReprYn());
				
				mv.addObject("code","0");
				mv.addObject("msg","로그인 성공");

			}	
		}catch(Exception e) {
			logger.error(e.toString());
		}

		return mv;
	}
	
	@RequestMapping(value = "/admin/consult", method = RequestMethod.GET)
	public ModelAndView consult(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("jsonView");
		
		//세션값 확인
		if((String) session.getAttribute("teacherId") == null) {
			mv.setViewName("redirect:/admin/login");
			return mv;
		}	
		
		mv.setViewName("admin/consult");
		return mv;
	}
	/**
	 * 상담관리 > 검색
	 * @param companyInfoDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/getOrderList.json", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView  getOrderList(HttpServletRequest request, Model model, OrderDto orderDto) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		logger.info(orderDto.getCompNo());
		List<OrderDto> result = adminService.getOrderList(orderDto);
		
		
		mv.addObject("code", "0");
		mv.addObject("totalCnt", result.size());
		mv.addObject("list", result);	//오더리스트
		
		return mv;	  
	}
	
	@RequestMapping(value = "/admin/getOrderDetail.json", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView  getOrderDetail(HttpServletRequest request, Model model, OrderDto orderDto) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		//logger.info(orderDto.getCompNo());
		OrderDto result = adminService.getOrderDetail(orderDto);
		
		
		mv.addObject("code", "0");		
		mv.addObject("list", result);	//오더디테일
		
		return mv;	  
	}
}
