package org.zerock.controller.p07Controller_ajax;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cont15")
public class Controller15 {
	
	@RequestMapping("met01")
	@ResponseBody
	public String method01() {
		System.out.println("cont15 met01 실행!");
		return "hello";
	}
	
	@RequestMapping("/met02")
	public ResponseEntity<String> method02(){
		System.out.println("cont15 met02 일함");
		
		//응답 코드 조작 - 200 OK
		ResponseEntity<String> result = new ResponseEntity<String>(HttpStatus.OK);
		
		return result;
	}
	
	@RequestMapping("/met03")
	public ResponseEntity<String> method03(){
		System.out.println("cont15 met03 일함");
		
		//응답 코드 조작 - 403 FORBIDDEN
		ResponseEntity<String> result = new ResponseEntity<String>(HttpStatus.FORBIDDEN); 
		
		return result;
	}
	
	@RequestMapping("/met04")
	@ResponseBody
	public ResponseEntity<String> method04(){
		System.out.println("cont15 met04 일함");
		
		ResponseEntity<String> result = null;
		
		if(Math.random() > 0.5) {
			result = ResponseEntity.status(HttpStatus.OK).body("hello data is ok");
		}else {
			result = ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
		return result;
	}
}
