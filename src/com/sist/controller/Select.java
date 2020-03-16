package com.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;

@WebServlet("/select.do")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Select() {
        super();
    
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB상의 member1 테이블의 전체 리스트를 가져오는 메서드
		MemberDAO dao = MemberDAO.getInstance();//MemberDVO 타입 ㅌ반환
		List<MemberVO> member = dao.getMemberList();	//전체 리스트를 가져오는 메서드
			
		//뷰 페이지로 해당 데이터를 이동
		//1단계 : setAttribute() 메서드로 저장을 하자.
		//2단계 : 뷰페이지로 실제 이동시키자.
		
		request.setAttribute("List", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/member_list.jsp");
		rd.forward(request, response);
	}

}
