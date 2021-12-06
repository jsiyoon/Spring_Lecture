package org.zerock.controller.p03Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p03Controller.bean.Bean01;
import org.zerock.controller.p03Controller.bean.Bean02;

@Controller
@RequestMapping("/cont06")
public class Controller06 {
	
	@RequestMapping("/met01")
	public void method01(HttpServletRequest request) {
		request.setAttribute("myattr12", "hello world");
	}
	
	@RequestMapping("/met02")
	public void method02(Model model) {
		//4. add attribute
		model.addAttribute("myattr1", "myvalue1");
	}
	
	//요청경로 : /cont06/met03
	//view name : /cont06/met03
	//view에서 사용하는 attribute명 : "myattr2"
	//myattr2 값 : "myvalue2"
	//view작성해 myattr2가 myvalue2를 출력하는지 확인
	@RequestMapping("/met03")
	public void method03(Model model) {
		model.addAttribute("myattr2", "myvalue2");
	}
	
	@RequestMapping("/met04")
	public void method04(Model model) {
		Bean01 bean = new Bean01();
		bean.setAge(99);
		bean.setName("trump");
		
		model.addAttribute("myBean", bean);
	}
	
	@RequestMapping("/met05")
	public void method05(Model model) {
		Bean01 bean = new Bean01();
		bean.setAge(38);
		bean.setName("donald");
		
		model.addAttribute(bean); //attribute의 이름이 클래스(type)의 이름과 같은 경우 생략 가능
	}

	@RequestMapping("/met06")
	public void method06(Model model) {
		model.addAttribute("attr1", "val1");
		model.addAttribute("attr2", "val2");
	}
	
	@RequestMapping("/met07")
	public void method07(String name, String city, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("city", city);
	}
	
	@RequestMapping("/met08")
	public String method08(@ModelAttribute("name") String name, @ModelAttribute("city") String city) {
		return "/cont06/met07";
	}
	
	@RequestMapping("/met09")
	public void method09(Bean01 bean, Model model) {
		model.addAttribute("bean", bean);
	}
	
	@RequestMapping("/met10")
	public String method10(@ModelAttribute("bean") Bean01 bean) {
		return "/cont06/met09";
	}
	
	@RequestMapping("/met11")
	public void method11(@ModelAttribute Bean01 bean) {
		
	}
	
	@RequestMapping("/met12")
	public String method12(Bean01 bean) {
		return "/cont06/met11";
	}
	
	// /cont06/met13?city=seoul&address=gangnam
	@RequestMapping("/met13")
	public void method13(@ModelAttribute Bean02 bean) {//생략되어있는 bean02 --> met13에서 호출 시 사용
		
	}
}
