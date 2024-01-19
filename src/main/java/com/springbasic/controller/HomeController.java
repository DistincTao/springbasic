package com.springbasic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbasic.vo.StudentVo;


@Controller // 현재 클래스가 Controller 단임을 명시
public class HomeController {
	
	// logger : 로그를 남길 수 있도록 하는 객체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET) // GET 방식으 "/" 주소에 대한 요청을 받으면 아래에 있는 method(home)를 실행
	public String home(Locale locale, Model model) { // model 객체 : data를 바인딩 해주는 객체
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date(); // 현재 시간 객체를 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale); // java.text 의 날짜 포멧을 설정해주는 것 (Long 은 format type)
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // data 바인딩
		
		return "home"; // view Resolver에게 "home" 이라는 문자열을 반환
		// "/WEB-INF/views/home.jsp" 
		// => 경로에 있는 jsp가 객체화 되어 최종 DispatcherServlet에 의해 forwarding 방식으로 response 됨
	}
	
	@RequestMapping(value="/doAct1")
	public String doAction1 () {
		
		System.out.println("doAction1이 호출됨");
		
		return "doAction1"; // doAction1.jsp를 호출
	}
	
	@RequestMapping(value="/doAct2") // 반환을 안해주면 "doAct2.jsp"를 호출
	public void doAction2 () {
		
		System.out.println("doAction2가 호출됨");
		logger.info("doAction2가 호출됨");
		
	}
	
	@RequestMapping(value="doAct3", method = RequestMethod.GET)
	public String doAction3 (Model model) {
		
		logger.info("doAction3이 호출됨");
		
		String name = "distinctao";
		model.addAttribute("name", name);  // 바인딩
		
		return "doAction3";
	}
	
	@RequestMapping(value = "/doAct4")
	public ModelAndView doAction4() {
		
		logger.info("doAction4가 호출됨");
		
		String name = "distinctao";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name" , name); // 바인딩
		mav.setViewName("doAction4");
		
		return mav;
		
	}
	
	@RequestMapping(value = "doAct5")
	public void doAction5(Model model) {
		
		logger.info("doAction5가 호출됨");

		StudentVo stu = new StudentVo("240101", "dooly");
		StudentVo stu1 = new StudentVo("240102", "doolllly");
		
		model.addAttribute("student", stu);
		model.addAttribute("student1", stu1);
//		model.addAttribute(stu); // 바인딩하는 객체의 이름을 지정하지 않은 경우에는 자동으로 클래스명 (앞글자를 소문자로) 바인딩
//		model.addAttribute(stu1); // 같은 객체를 바인딩하게 될 경우 마지막 객체만 호출됨
		
	}
	
}
