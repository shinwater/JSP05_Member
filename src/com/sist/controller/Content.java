package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

@WebServlet("/cont.do")
public class Content extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Content() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시물의 상세내역을 조회하는 메서드
		String mem_id = request.getParameter("memId");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO cont =dao.contMember(mem_id);
		
		request.setAttribute("Cont", cont);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/member_cont.jsp");
		rd.forward(request, response);
	}

}
