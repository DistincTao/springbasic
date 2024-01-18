package com.springbasic.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbasic.vo.Student;

@Controller
@RequestMapping("/student/*") // 해당 폴더 아래의 모든 url에 대해서 mapping 처리
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("outputStudent")
	public void outputStudent(Model model) {
		logger.info("outputStudent가 호출 됨");
		
		Student stu = new Student("24001", "dooly");
		
		model.addAttribute("student", stu); // 바인딩
		
	}
	
	@RequestMapping(value="inputStudent", method = RequestMethod.GET)
	public void inputStudent(Model model) {
		logger.info("inputStudent GET이 호출 됨");
		
	}
	
//	@RequestMapping(value="saveStudent", method = RequestMethod.POST)
//	public void inputStudent(@RequestParam("stuNo") String stuNo,
//			@RequestParam("stuName") String stuName,
//			Model model) {
//		logger.info("saveStudent가 호출 됨");
//		
//		Student stu = new Student(stuNo, stuName);
//		
//		logger.info("학번 : " + stuNo);
//		logger.info("이름 : " + stuName);
//		logger.info("학생정보" + stu);
//		
//		model.addAttribute("inputStudent", stu); // 바인딩
//	}

//	@RequestMapping(value="saveStudent", method = RequestMethod.POST)
//	public void inputStudent(Student stu, Model model) {
//		logger.info("saveStudent가 호출 됨");
//		
//		model.addAttribute("inputStudent", stu); // 바인딩
//			
//	}
//	
	// redirect 시키는 경우
	// RedirectAttributes : redirect할 때 쿼리스트링으로 어떤 값을 넘기고자 할 때 사용하는 객체
	@RequestMapping (value="saveStudent", method = RequestMethod.POST)
	public String inputStudent(Student stu, Model model, RedirectAttributes rttr) {
		logger.info("saveStudent가 호출 됨");
		
		// redirect 
		rttr.addAttribute("status", "success");
		
		Map<String, String> map = new HashMap<>();
		map.put("name", stu.getStuName());
		map.put("stuNo", stu.getStuNo());
		
		rttr.addAllAttributes(map);
		rttr.addFlashAttribute("flashStatus", "flashStatus"); // flash가 붙으면 1회성 (휘발성)
		
		return "redirect:homeStudent";
		
	}
	
//	@RequestMapping (value="homeStudent", method = RequestMethod.GET)
//	public void homeStudent (@RequestParam(name="status") String status) {
//		logger.info("homeStudent가 GET 방식으로 요청됨");
//		
//		logger.info(status);
//		
//	}
	
	@RequestMapping (value="homeStudent", method = RequestMethod.GET)
	public void homeStudent (@ModelAttribute(name="status") String status,
							 @ModelAttribute(name="flashStatus") String flashStatus,
							 @RequestParam Map<String, String> map) {
		logger.info("homeStudent가 GET 방식으로 요청됨");
		logger.info(status);
		logger.info(flashStatus);
		
	}
	
	// jackson-databind 라이브러리 추가 -> json으로 response 보내기
	@RequestMapping("output")
	public @ResponseBody Student sampleStudent () {
		logger.info("sampleStudent가 호출 됨");
		Student tmp = new Student("24001", "doochi");
		
		return tmp;
	}
	
	
}
