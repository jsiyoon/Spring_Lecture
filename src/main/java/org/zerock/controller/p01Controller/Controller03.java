package org.zerock.controller.p01Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cont03")
public class Controller03 {
	
	@RequestMapping("/met01")
	public void method01(HttpServletRequest request) {
		System.out.println("메소드 01 일함");
		
		//2.request 분석/가공
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);
		
		//3.
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("/met02")
	public void method02(String name, Integer age) {
		System.out.println("메소드 02 실행");
		System.out.println(name);
		System.out.println(age);
	}
	
	// /cont03/met03 : request 파라미터, address(String)와 id(Integer)를 받도록 메소드 작성
	@RequestMapping("/met03")
	public void method03(String address, Integer id) {
		System.out.println("메소드 03 실행");
		System.out.println(address);
		System.out.println(id);
	}
	
	@RequestMapping("/met04")
	public void method04(@RequestParam("name") String contactName) {
		System.out.println(contactName);
	}
	
	// url:/cont03/met05?country=korea&height=200
	@RequestMapping("/met05")
	public void method05(@RequestParam("country") String country, @RequestParam("height") Integer height) {
		System.out.println("메소드 05 실행");
		System.out.println(country);
		System.out.println(height);
	}
}
