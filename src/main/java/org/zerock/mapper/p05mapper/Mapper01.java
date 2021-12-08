package org.zerock.mapper.p05mapper;

import java.util.List;

import org.zerock.controller.p05Controller.bean.Bean01;
import org.zerock.controller.p05Controller.bean.Bean09;

public interface Mapper01 {
	
	public Bean01 getSupplierOne();

	public Bean09 getEmployeeNameOne();
	
	public List<Bean09> getEmployeeNameList();

	public List<Bean01> getSupplierList();

	public String getEmployeeLastNameOne();

	public String getEmployeeFirstNameOne();

	public List<String> getEmployeeLastNameList();

}
