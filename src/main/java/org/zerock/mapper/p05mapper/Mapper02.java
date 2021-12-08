package org.zerock.mapper.p05mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Mapper02 {

	String getLastNameById(Integer id);
	
	String getCustomerNameById(Integer id);

	List<String> getProductNamesByCategory(String category);

//	2개이상의 파라미터를 받을때는 오류가 발생하므로 @Param을 붙여준다.
	List<String> getProductNamesByCategoryAndPrice(@Param("category") String category, @Param("price")Double price);

	List<String> getSupplierNamesCityAndCountry(@Param("city") String city, @Param("country") String country);
}
