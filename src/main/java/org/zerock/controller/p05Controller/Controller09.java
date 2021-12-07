package org.zerock.controller.p05Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.p05mapper.TimeMapper;

import lombok.Setter;

@Controller
@RequestMapping("/cont09")
public class Controller09 {

	@Setter(onMethod_ = @Autowired)
	private TimeMapper mapper;
	
	@RequestMapping("/met01")
	public void method01() {
		String time = mapper.getTime();
		
		System.out.println(time);
	}
	
	@RequestMapping("/met02")
	public void method02() {
		String name = mapper.getCustomerName();
		System.out.println(name);
	}
	
	@RequestMapping("/met03")
	public void method03(Model model) {
		String name = mapper.getCustomerName();
		model.addAttribute("name", name);
	}
	
	//요청경로 /met04
	//실행쿼리 : SELECT LastName FROM Employees WHERE EmployeeID = 1
	//view 통해 출력
	@RequestMapping("/met04")
	public void method04(Model model) {
		String lastName = mapper.getLastName();
		model.addAttribute("lastName", lastName);
	}
	
	@RequestMapping("/met05")
	public void method05() {
		String name = mapper.getCustomerNameById(2);
		
		System.out.println(name);
	}
	
	@RequestMapping("/met06")
	public void method06() {
		String name = mapper.getEmployeeNameById(3);
		System.out.println(name);
	}
	
	@RequestMapping("/met07")
	public void method07() {
		List<String> names = mapper.getCustomerNames();
		System.out.println(names);
	}
	
	//직원 테이블의 LastName들을 조회하는 쿼리를 실행하는 메소드
	@RequestMapping("/met08")
	public void method08() {
		List<String> names = mapper.getLastNames();
		System.out.println(names);
	}
}
