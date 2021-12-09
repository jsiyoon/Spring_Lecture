package org.zerock.controller.p05Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.p05Controller.bean.Bean03;
import org.zerock.controller.p05Controller.bean.Bean04;
import org.zerock.mapper.p05mapper.Mapper03;

import lombok.Setter;

@Controller
@RequestMapping("/cont12")
public class Controller12 {
	
	@Setter(onMethod_ = @Autowired)
	private Mapper03 mapper;
	
	@RequestMapping("/met01")
	public void method01() {
		String customerName = "ironman";
		String contactName = "tony";
		
		int cnt = mapper.insertCustomer(customerName, contactName);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met02")
	public void method02() {
		String supplierName = "captain";
		String contactName = "steve";
		
		int cnt = mapper.insertSupplier(supplierName, contactName);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met03")
	public void method03() {
		//2.request분석 가공
		Bean03 bean = new Bean03();
		bean.setContactName("peter");
		bean.setCustomerName("spiderman");
		bean.setAddress("queens");
		bean.setCity("ny");
		bean.setPostalCode("2222");
		bean.setCountry("usa");
		
		int cnt = mapper.insertCustomer2(bean);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met04")
	public void method04() {
		Bean04 bean = new Bean04();
		bean.setSupplierName("sihyuk");
		bean.setContactName("singer");
		bean.setAddress("yeanNam");
		bean.setCity("seoul");
		bean.setPostalCode("111-111");
		bean.setCountry("korea");
		bean.setPhone("02-123-4567");
		
		int cnt = mapper.insertSupplier2(bean);
		System.out.println(cnt);
	}
	
	
	//INSERT하자마자 KEY값 얻어오는 방법
	@RequestMapping("/met05")
	public void method05() {
		Bean03 bean = new Bean03();
		bean.setAddress("gangnam");
		bean.setCity("seoul");
		bean.setContactName("marvel");
		bean.setCustomerName("danvers");
		bean.setCountry("france");
		bean.setPostalCode("99999");
		
		//3
		//insert하기전 id
		System.out.println(bean.getId()); //null or 0
		
		mapper.insertCustomer3(bean);
		
		System.out.println(bean.getId()); //key
	}
	
	@RequestMapping("/met06")
	public void method06() {
		Bean04 bean = new Bean04();
		bean.setSupplierName("hybe");
		bean.setContactName("actor");
		bean.setAddress("hanNam");
		bean.setCity("seoul");
		bean.setPostalCode("222-222");
		bean.setCountry("korea");
		bean.setPhone("02-987-6543");
		
		System.out.println(bean.getId());
		
		mapper.insertSupplier3(bean);
		
		System.out.println(bean.getId());
	}
	
	
	//update
	@RequestMapping("/met07")
	public void method07() {
		Bean03 bean = new Bean03();
		bean.setId(105);
		bean.setContactName("widow");
		bean.setCustomerName("nat");
		bean.setAddress("jongro");
		bean.setCity("dokdo");
		bean.setCountry("korea");
		bean.setPostalCode("777777");
		
		//3
		int cnt = mapper.updateCustomer(bean);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met08")
	public void method08() {
		Bean04 bean = new Bean04();
		bean.setId(37);
		bean.setSupplierName("widow");
		bean.setContactName("actor");
		bean.setAddress("jongro");
		bean.setCity("seoul");
		bean.setPostalCode("123-456");
		bean.setCountry("korea");
		bean.setPhone("02-789-4321");
		
		int cnt = mapper.updateSupplier(bean);
		System.out.println(cnt);
	}
	
	
	//delete
	@RequestMapping("/met09")
	public void method09(Integer id) {
		int cnt = mapper.deleteCustomer(id);
		System.out.println(cnt);
	}
	
	@RequestMapping("/met10")
	public void method10(Integer id) {
		int cnt = mapper.deleteSupplier(id);
		System.out.println(cnt);
	}
}
