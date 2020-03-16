<%@page import="com.sist.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<MemberVO> member=(List<MemberVO>)request.getAttribute("List"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="tomato">
			<h3>Member1 테이블 전체 게시물 목록</h3>
		<hr width="50%" color="tomato">
		<br/><br/>
		<table border="1" cellspacing="0" width="800">
			<tr>
				<th> 회원ID</th><th> 회원명</th><th> 가입일자</th>
			</tr>
			
			<%
				if(member.size() != 0) { //검색된 레코드가 있는 경우
					//검색된 레코드 수 만큼 반복해서 웹 브라우저에 출력
					for(int i=0; i<member.size(); i++){
						MemberVO vo = member.get(i); // board.get(i):주소값 ->dto에 같은주소값 넣기~..
					%>
						<tr>
							<td><%= vo.getId() %></td>
							<td>
								<a href="cont.do?memId=<%= vo.getId() %>">
								<%= vo.getName() %></a>
							</td>
							<td><%= vo.getReg_date().substring(0,10) %></td>
						</tr>
				<% }//for문 end
				}else{ //검색된 레코드가 없는 경우
				%> 
					<tr>
						<td colspan="3" align="center">
							<h3>검색된 렡코드가 없습니당.</h3>
						</td>
					</tr>
			 <% } %>
		
		</table>
		<br/>
		<hr width="50%" color="tomato">
		<br/>
		<input type="button" value="회원 가입"
			onclick="location.href='view/member_write.jsp'"/>
		<br/>
		<form method="post" action="<%=request.getContextPath()%>/search.do">
			<select name="find_field">
				<option value="mem_id">아이디</option>
				<option value="mem_name">이름</option>
			</select>
			<input type="text" name="find_name" size="15" />
			<input type="submit" value="검색" />
			
		</form>
		
		
		
	</div>
</body>
</html>