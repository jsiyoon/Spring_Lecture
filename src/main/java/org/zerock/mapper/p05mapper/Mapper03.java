package org.zerock.mapper.p05mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.controller.p05Controller.bean.Bean03;
import org.zerock.controller.p05Controller.bean.Bean04;

public interface Mapper03 {
	
	public int insertCustomer(@Param("customerName") String customerName, @Param("contactName") String contactName);

	public int insertSupplier(@Param("supplierName")String supplierName, @Param("contactName")String contactName);

	public int insertCustomer2(Bean03 bean);

	public int insertSupplier2(Bean04 bean);

	public int insertCustomer3(Bean03 bean);

	public int insertSupplier3(Bean04 bean);

	public int updateCustomer(Bean03 bean);

	public int updateSupplier(Bean04 bean);
	
	public int deleteCustomer(Integer id);

	public int deleteSupplier(Integer id);
}
