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

@WebServlet("/update.do")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정폼 페이지로 넘어가는 메서드
		String mem_id = request.getParameter("memId");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO cont = dao.contMember(mem_id);
		
		request.setAttribute("Cont", cont);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/member_edit.jsp");
		rd.forward(request, response);
		
	}

}
