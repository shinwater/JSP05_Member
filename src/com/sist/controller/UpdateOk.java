package com.sist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.model.MemberDAO;
import com.sist.model.MemberVO;


@WebServlet("/updateOk.do")
public class UpdateOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//수정포맟ㅇ엑서넘어온 데이터를 DB에 저장.
		String mem_id = request.getParameter("mem_id").trim();
		String mem_name = request.getParameter("mem_name").trim();
		String mem_pwd = request.getParameter("mem_pwd").trim();
		String mem_tel = request.getParameter("mem_tel").trim();
		String mem_addr = request.getParameter("mem_addr").trim();
		String mem_email = request.getParameter("mem_email").trim();
		int mem_age = Integer.parseInt(request.getParameter("mem_age").trim());
		
		MemberVO vo = new MemberVO();
		
		vo.setId(mem_id);
		vo.setName(mem_name);
		vo.setPwd(mem_pwd);
		vo.setTel(mem_tel);
		vo.setAddr(mem_addr);
		vo.setEmail(mem_email);
		vo.setAge(mem_age);
		
		MemberDAO dao = MemberDAO.getInstance();
		int res = dao.updateMember(vo);
		
		PrintWriter out = response.getWriter();
		if(res == 1) {
			out.println("<script>");
			out.println("alert('수정성공')");
			out.println("location.href='cont.do?memId="+mem_id+"'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		
	}

}
