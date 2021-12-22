package org.zerock.controller.p06Controller_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cont14")
public class Controller14 {

	@RequestMapping("/met01")
	@ResponseBody
	public String method01(@RequestParam("name") String name) {
		System.out.println("/cont14/met01 실행");
		System.out.println(name);
		
		return "hello";
	}
	
	@RequestMapping("/met02")
	@ResponseBody
	public String method2(@RequestParam("city") String city) {
		System.out.println("/cont14/met02 실행");
		System.out.println(city);
		return "city";
	}
	
	@RequestMapping("/met03")
	@ResponseBody
	public String method03(@RequestParam("city") String city, @RequestParam("name") String name) {
		System.out.println(city);
		System.out.println(name);
		return "city, name";
	}
	
	@RequestMapping("/met04")
	@ResponseBody
	public String method04(String data1) {
		System.out.println(data1);
		return "Hello";
	}
	
	@RequestMapping("/met05")
	public void method05(String name, String address) {
		System.out.println(name);
		System.out.println(address);
	}
	
}
