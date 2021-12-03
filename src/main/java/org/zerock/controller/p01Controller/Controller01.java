package org.zerock.controller.p01Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//controller에 붙은 class bean이다.
@Controller

//모든 '/cont01'요청이 거쳐감.
@RequestMapping("/cont01")
public class Controller01 {
	
	// "/cont01"
	// requestMapping경로 겹치면 안됨.
	@RequestMapping("")
	public void method00() {
		System.out.println("메소드00 일함");
	}
	
	// "/cont01/met01"
	@RequestMapping("/met01")
	public void method01() {
		System.out.println("메소드 01 일함");
	}
	
	// "/cont01/met02"
	@RequestMapping("/met02")
	public void method02() {
		System.out.println("메소드 02 일함");
	}
	
	// "/cont01/met03", "/cont01/met04"로 요청왔을때 일하는 메소드
	//requestMapping 여러 경로로 작성하고 싶을때 배열처럼 작성.
	@RequestMapping({"/met03", "/met04"})
	public void method3() {
		System.out.println("메소드 03 일함");
	}
	
	// "/cont01/met05", "/cont01/met06"로 요청왔을때 일하는 메소드
	@RequestMapping({"/met05", "/met06"})
	public void method05() {
		System.out.println("메소드 05 일함");
	}
}
