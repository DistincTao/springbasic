package com.springbasic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value="saveStudent", method = RequestMethod.POST)
	public void inputStudent(Student stu, Model model) {
		logger.info("saveStudent가 호출 됨");
		
		model.addAttribute("inputStudent", stu); // 바인딩
			
	}
	
	// jackson-databind 라이브러리 추가 -> json으로 response 보내기
	@RequestMapping("output")
	public @ResponseBody Student sampleStudent () {
		logger.info("sampleStudent가 호출 됨");
		Student tmp = new Student("24001", "doochi");
		
		return tmp;
	}
	
	
}
