package org.zerock.controller.p02Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cont05")
public class Controller05 {
	//request handler method return values
	
	@RequestMapping("/met01")
	public String method01(HttpServletRequest request) {
		//2. request 분석/가공
		
		//3. business로직
		
		//4. add attribute
		
		//5. forward / redirect
		
		/*Servlet / jsp사용할때*/
//		String path = "/WEB-INF/view/view01.jsp";
//		request.getRequestDispatcher(path).forward(request, response);
		
//		spring은 return으로 간단하게 연결.
		return "view01";
	}
	
//	/cont05/met02로 요청이 오면/WEB-INF/view02.jsp로 포워드 
	@RequestMapping("/met02")
	public String method02() {
		return "view02";
	}
	
//	/WEB-INF/views/
	@RequestMapping("/met03")
	public String method03() {
		return "cont05/view03";
	}
	
	@RequestMapping("/met04")
	public String method04() {
		return "/cont05/view04";
	}
	
	
	//redirect
	
	@RequestMapping("/met05")
	public String method05() {
		/*Servlet 사용  시*/
//		String location = request.getContextPath() + "/path";
//		response.sendRedirect(location);
		
		/*spring mvc 사용 시*/
		return "redirect:/cont05/met04";
	}
	
//  /cont5/met06으로 요청왔을 때 /cont05/met04로  redirect
	@RequestMapping("/met06")
	public String method06() {
		return "redirect:/cont05/met04";
	}
	
	// /cont05/met07
	@RequestMapping("/met07")
	public String method07() {
		return null; // view이름과 요청 경로가 같은 경우 null리턴 가능
	}
	
	@RequestMapping("/met08")
	public void method08() {
		//view이름과 요청 경로가 같은 경우 void return 타입으로 결정
	}
	
	// /cont05/met09로 요청이 왔을때 /WEB-INF/views/cont05/met09.jsp로 포워드 되도록 method09작성
	@RequestMapping("/met09")
	public void method09() {
		
	}
	
}
