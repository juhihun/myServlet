package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.web.ABCControl;
import com.yedam.web.AddEmpControl;
import com.yedam.web.InfoControl;

public class FrontController extends HttpServlet {
	Map<String, Control> map;
	
	// 생성자
	public FrontController() {
		map = new HashMap<>();
	}

	// init
	@Override
	public void init() throws ServletException {
		//url패턴과 실행할  Control 구현클래스 정의
		map.put("/abc.do", new ABCControl());
		map.put("/info.do", new InfoControl());
		map.put("/addEmp.do",new AddEmpControl());
	}

	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8"); //요청정보의 한글처리

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		System.out.println("uri : " + uri + "  context : " + context);
		String path = uri.substring(context.length());
		System.out.println("path : " + path);
		
		Control control = map.get(path);
		control.exec(req,resp);
	}

	// destroy
	@Override
	public void destroy() {

	}
}
