package org.zerock.controller.p05Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.p05mapper.Mapper02;

import lombok.Setter;

@Controller
@RequestMapping("/cont11")
public class Controller11 {

	@Setter(onMethod_ = @Autowired)
	private Mapper02 mapper;
	
	//파라미터(id) 입력받아 출력
	@RequestMapping("/met01")
	public void method01(Integer id) {
		String name = mapper.getLastNameById(id);
		System.out.println(name);
	}
	
	@RequestMapping("/met02")
	public void method02(Integer id) {
		String customerName = mapper.getCustomerNameById(id);
		System.out.println(customerName);
	}
	
	// /cont11/met03?category=condiments - condiments에 해당하는 category
	@RequestMapping("/met03")
	public void method03(String category) {
		List<String> productNames = mapper.getProductNamesByCategory(category);
		for(String p : productNames) {
			System.out.println(p);
		}
	}
	
//	/cont11/met04?category=Beverages&price=10
	@RequestMapping("/met04")
	public void method04(String category, Double price) {
		List<String> productNames = mapper.getProductNamesByCategoryAndPrice(category, price);
		for(String p : productNames) {
			System.out.println(p);
		}
	}
	
//	/cont11/met05?city=Berlin&country=Germany
	@RequestMapping("/met05")
	public void method05(String city, String country) {
		List<String> supplierNames = mapper.getSupplierNamesCityAndCountry(city, country);
		for(String s : supplierNames) {
			System.out.println(s);
		}
	}
}
