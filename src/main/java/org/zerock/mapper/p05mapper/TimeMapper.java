package org.zerock.mapper.p05mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.controller.p05Controller.bean.Bean09;
import org.zerock.controller.p05Controller.bean.Bean10;
import org.zerock.controller.p05Controller.bean.Bean11;
import org.zerock.controller.p05Controller.bean.Bean12;
import org.zerock.controller.p05Controller.bean.Bean13;
import org.zerock.controller.p05Controller.bean.Bean14;
import org.zerock.controller.p05Controller.bean.Bean17;

public interface TimeMapper {
	
	@Select("SELECT NOW()")
	public String getTime();
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = 1")
	public String getCustomerName();

	@Select("SELECT LastName FROM Employees WHERE EmployeeID = 1")
	public String getLastName();
	
	//id 받기
	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = #{id}")
	public String getCustomerNameById(Integer id);

	@Select("SELECT LastName FROM Employees WHERE EmployeeID = #{id}")
	public String getEmployeeNameById(Integer id);
	
	//리스트 활용해 출력값 받기
	@Select("SELECT CustomerName FROM Customers")
	public List<String> getCustomerNames();
	
	@Select("SELECT LastName FROM Employees")
	public List<String> getLastNames();
	
	@Select("SELECT EmployeeID, LastName, FirstName FROM Employees WHERE EmployeeID = 1")
	public Bean09 getEmployeeName();
	
	@Select("SELECT CustomerName, ContactName FROM Customers WHERE CustomerID = 1")
	public Bean10 getCustomer();
	
	//ID 별칭을 붙이고, Bean11에서 별칭과 같은 프로퍼티 입력받아야 id 출력됨.
	@Select("SELECT customerID AS id, customerName FROM Customers WHERE CustomerID =  1")
	public Bean11 getCustomerInfo();
	
	@Select("SELECT EmployeeID id, LastName lname, FirstName fname FROM Employees WHERE EmployeeID = 2")
	public Bean12 getEmployeeInfo();
	
	@Select("SELECT EmployeeID, LastName, FirstName, BirthDate, Photo, Notes FROM Employees WHERE EmployeeID = #{id}")
	public Bean13 getEmployeeById(Integer id);

	@Select("SELECT CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country FROM Customers WHERE CustomerID = #{id}")
	public Bean14 getCustomerById(Integer id);
	
	@Select("SELECT CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country FROM Customers")
	public List<Bean14> getCustomers();
	
	@Select("SELECT EmployeeID, LastName, FirstName, BirthDate, Photo, Notes FROM Employees")
	public List<Bean13> getEmployees();
	
	@Select("SELECT p.ProductName, c.CategoryName, p.Unit, p.Price "
			+ " FROM Products p JOIN Categories c ON p.CategoryID = c.CategoryID")
	public List<Bean17> getProducts();
	
	public List<Bean17> getProductsInfo();
} 
