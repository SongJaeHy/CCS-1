package com.sjh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sjh.service.IMemberService;
import com.sjh.service.MemberLoginService;



/**
 * Servlet implementation class PattenServlet
 */
@WebServlet("*.do")
public class PattenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PattenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMemberService sv = null;
		
		// 해당 로직을 실핸 뒤에 넘어갈 .jsp 파일 지정
		String ui = null;
		
		// 세션 쓰는 법
		HttpSession session = null;
		session = request.getSession();
		
		// doget에 있던 모든 코드를 가져옵나다.
		// 확장자 패턴에서 확장자를 포함한 주소값을 가져오기 위해서
		// 아래 코드를 사용합니다.
		String uri = request.getRequestURI();	
		System.out.println("uri 패턴:" + uri);
		
		// 콘솔이 아닌 사용자가 확인할 수 있도록 .jsp 화면에
		// 변수에 담긴 자료를 찍는 out.print(); 사용을 위한
		// 사전 준비
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// jsp페이지가 html형싣으로 이뤄져 있음을 알려주는 코드
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		if(uri.equals("/ccs/join.do")) {
			sv = new MemberLoginService();
			sv.execute(request, response);
			ui = "member/member_login_form.jsp";
	}else {
		System.out.println("잘못된 패턴입니다.");
		}
	}
}
