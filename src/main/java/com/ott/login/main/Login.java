package com.ott.login.main;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ott.login.vo.ExVO;

/**
 * Servlet implementation class Ex3_Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 한글처리
		request.setCharacterEncoding("utf-8");
		
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답에 필요한 스트림 준비
		PrintWriter out = response.getWriter();
		
		// 아이디와 비밀번호를 받는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DB로부터 확인을 해야 함! (생략)
		// admin/1234인 경우만 로그인 허용하기로 해 보자!
		if(id.equals("admin") && pw.equalsIgnoreCase("1234") ) {// 대/소문자를 비교하지 않는다.
			ExVO vo = new ExVO(id, "어두일미", "admin@increpas.com");
			
			//세션 정보 얻기
			HttpSession session = request.getSession();
			
			//세션에 정보 저장하기
			session.setAttribute("tvo", vo);
			
			//out.println("<a href='Ex3_Main'>[메인]</a>");
			//response.sendRedirect("Ex3_Main");// 이동!
			out.println("1");
		}else {
			//로그인에 실패한 경우!!!
			//out.println("<h2>아이디 또는 비밀번호가 틀립니다.</h2>");
			//out.println("<a href='ex3_login.html'>[로그인]</a>");
			out.println("0");
		}
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
