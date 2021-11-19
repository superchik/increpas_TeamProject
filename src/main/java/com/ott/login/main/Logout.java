package com.ott.login.main;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex3_Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃은 로그인 시 session에 저장한 값을 삭제하는 것이다.
		
		HttpSession session = request.getSession();
		
		//로그인을 허용시 저장한 "tvo"를 삭제한다.
		session.removeAttribute("tvo");
		
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답을 위한 스트림 준비
		PrintWriter out = response.getWriter();
		
		//응답 시작
		out.println("<h2>로그아웃이 정상적으로 처리되었습니다.</h2>");
		out.println("<a href='login'>[메인]</a>");
		
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
