package org.zerock.controller.p01Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.p01Controller.bean.Bean01;
import org.zerock.controller.p01Controller.bean.Bean02;
import org.zerock.controller.p01Controller.bean.Bean03;
import org.zerock.controller.p01Controller.bean.Bean04;
import org.zerock.controller.p01Controller.bean.Bean05;
import org.zerock.controller.p01Controller.bean.Bean06;
import org.zerock.controller.p01Controller.bean.Bean07;
import org.zerock.controller.p01Controller.bean.Bean08;

@Controller
@RequestMapping("/cont04")
public class Controller04 {
	
	@RequestMapping("/met01")
	public void method01(String name, String city) {
		System.out.println(name);
		System.out.println(city);
	}
	
	@RequestMapping("/met02")
	public void method02(HttpServletRequest request) {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		Bean01 bean = new Bean01();
		bean.setName(name);
		bean.setCity(city);
		
		System.out.println(bean); //잘 들어왔는지 확인
	}
	
	@RequestMapping("/met03")
	public void method03(Bean01 bean) {
		System.out.println(bean); //잘 들어왔는지 확인
	}
	
	@RequestMapping("/met04")
	public void method04(Bean02 bean) {
		System.out.println(bean); //잘 들어왔는지 확인
	}
	
	@RequestMapping("/met05")
	public void method05(Bean03 bean) {
		System.out.println(bean); //잘 들어왔는지 확인
	}
	
	// /cont04/met06?id=99&score=99.99
	@RequestMapping("/met06")
	public void method06(Bean04 bean) {
		System.out.println(bean);
	}
	
	
	//controller배열
	// /cont04/met07?tel=010&tel=011&tel=012
	@RequestMapping("/met07")
	public void method07(@RequestParam("tel") ArrayList<String> tel) {
		System.out.println(tel);
	}
	
	// /cont04/met08?name=john&tel=010&tel=011&tel=012
	@RequestMapping("/met08")
	public void method08(Bean05 bean) {
		System.out.println(bean); //모든 프로퍼티에 값이 들어가도록 요청
	}
	
	// ?name=john&id=99&address=seoul&address=jeju&address=ny
	@RequestMapping("/met09")
	public void method09(Bean06 bean) {
		System.out.println(bean);//모든 프로퍼티에 값이 들어가도록 요청
	}
	
	
	//시간 - localData
	@RequestMapping("/met10")
	public void method10(@RequestParam("date")
//		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		System.out.println(date);
	}
	
	@RequestMapping("/met11")
	public void method11(@RequestParam("dateTime") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime dateTime) {
		System.out.println(dateTime);
	}
	
	@RequestMapping("/met12")
	public void method12(Bean07 bean) {
		System.out.println(bean);
	}
	
	@RequestMapping("/met13")
	public void method13(Bean08 bean) {
		System.out.println(bean); //모든 프로퍼티가 request param으로 부터 채워져서 출력되도록
	}
	
	@RequestMapping("/met14")
	public void method14(@RequestParam String name, @RequestParam int age, HttpServletRequest request) {
		System.out.println(name);
		System.out.println(age);
		
		System.out.println(request);
	}
}
