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

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 가입폼 페이지에서 넘어온 데이터들을 DB에 저장시키는 메서드.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 가입폼 페이지에서 넘어오는 데이터를 처리해 주자.
		
		String mem_id = request.getParameter("mem_id").trim();
		String mem_name = request.getParameter("mem_name").trim();
		String mem_pwd = request.getParameter("mem_pwd").trim();
		String mem_tel = request.getParameter("mem_tel").trim();
		String mem_addr = request.getParameter("mem_addr").trim();
		String mem_email = request.getParameter("mem_email").trim();
		String mem_age = request.getParameter("mem_age").trim();
		
		int age=0;
		if(mem_age != "") {
			age=Integer.parseInt(mem_age);
		}
		
		MemberVO vo = new MemberVO();
		vo.setId(mem_id);
		vo.setName(mem_name);
		vo.setPwd(mem_pwd);
		vo.setTel(mem_tel);
		vo.setAddr(mem_addr);
		vo.setEmail(mem_email);
		vo.setAge(age);
		
		MemberDAO dao = MemberDAO.getInstance();
		int res = dao.insertMember(vo);
		
		PrintWriter out = response.getWriter();
		if(res == 1) {
			out.println("<script>");
			out.println("alert('회원가입 성공')");
			out.println("location.href='select.do'");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.go(-1)");//이전페이지로 이동
			out.println("</script>");
		}
	}

}
