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
		
		// �ش� ������ ���� �ڿ� �Ѿ .jsp ���� ����
		String ui = null;
		
		// ���� ���� ��
		HttpSession session = null;
		session = request.getSession();
		
		// doget�� �ִ� ��� �ڵ带 �����ɳ���.
		// Ȯ���� ���Ͽ��� Ȯ���ڸ� ������ �ּҰ��� �������� ���ؼ�
		// �Ʒ� �ڵ带 ����մϴ�.
		String uri = request.getRequestURI();	
		System.out.println("uri ����:" + uri);
		
		// �ܼ��� �ƴ� ����ڰ� Ȯ���� �� �ֵ��� .jsp ȭ�鿡
		// ������ ��� �ڷḦ ��� out.print(); ����� ����
		// ���� �غ�
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// jsp�������� html�������� �̷��� ������ �˷��ִ� �ڵ�
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		if(uri.equals("/ccs/join.do")) {
			sv = new MemberLoginService();
			sv.execute(request, response);
			ui = "member/member_login_form.jsp";
	}else {
		System.out.println("�߸��� �����Դϴ�.");
		}
	}
}
