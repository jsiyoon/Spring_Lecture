package org.zerock.controller.p08restController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@requestMapping이 있으면 @responseBody가 붙어있다고 하는것 - @restController
@RestController
@RequestMapping("/cont17")
public class Controller17 {

	@RequestMapping("/met01")
	public String method01() {
		return "hello";
	}
	
	@RequestMapping("/met02/{id}")
	public String method02(@PathVariable("id") Integer id) {
		System.out.println(id);
		return "hello2";
	}
	
	@RequestMapping("/met03/{number}")
	public String method03(@PathVariable("number") Integer number) {
		System.out.println(number);
		return "hello3";
	}
	
	@RequestMapping("/met04/{str}")
	public String method04(@PathVariable String str) {
		return str;
	}
	
	@RequestMapping("/met05/{id}/{city}")
	public String method05(@PathVariable Integer id, @PathVariable String city) {
		System.out.println("id : " + id);
		System.out.println("city : " + city);
		return "hello";
	}
	
	@RequestMapping("/met06/id/{id}/city/{city}")
	public String method06(@PathVariable Integer id, @PathVariable String city) {
		System.out.println("id : " + id);
		System.out.println("city : " + city);
		return "hello";
	}
}
