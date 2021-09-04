package com.saju.box.controller;

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
import com.saju.box.service.AdminService;

@Controller
public class AdminController {
	@Inject
	private AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin/getLogin.json", method = RequestMethod.POST)
	@ResponseBody 
	public ModelAndView getLoginInfo(HttpServletRequest request, LoginDto loginDto) throws Exception{
		//logger.info("ksw:::::::getLogin "+ loginDto.getTeacherId());
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		//�α��� ���� �޾ƿ���
		try {
			LoginDto loginDtoResult = adminService.getLoginInfo(loginDto);
			
			if(loginDtoResult == null){
				//�´� ������ ���°��			
				mv.addObject("code","1");
				mv.addObject("msg","�´� ������ �����ϴ�.");
				//mv.setViewName("/login");
			}else {
				//�α��� ���� ����				
				session.setAttribute("compNo", loginDtoResult.getCompNo());		
				session.setAttribute("compName", loginDtoResult.getCompName());
				session.setAttribute("teacherNo", loginDtoResult.getTeacherNo());
				session.setAttribute("teacherNm", loginDtoResult.getTeacherNm());
				session.setAttribute("teacherId", loginDtoResult.getTeacherId());
				session.setAttribute("reprYn", loginDtoResult.getReprYn());
				
				mv.addObject("code","0");
				mv.addObject("msg","�α��� ����");

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
		
		//���ǰ� Ȯ��
		if((String) session.getAttribute("teacherId") == null) {
			mv.setViewName("redirect:/admin/login");
			return mv;
		}	
		
		mv.setViewName("admin/consult");
		return mv;
	}
	
}
