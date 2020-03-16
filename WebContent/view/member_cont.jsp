<%@page import="com.sist.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO cont =(MemberVO)request.getAttribute("Cont");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1" cellspacing="0" width="400">
			<%
				if(cont != null) {//검색된 ㅎ레코드가 있는 경웋
			%>
				<tr>
					<th colspan="2" align="center">
						<h3><%=cont.getName()%>님 회원정보</h3>
					</th>
				</tr>
				<tr>
					<th>아이디</th>
					<td><%=cont.getId()%></td>
				</tr>
				<tr>
					<th>회원명</th>
					<td><%=cont.getName() %></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<%
						if(cont.getPwd().length() > 0){
							for(int i=1; i<=cont.getPwd().length(); i++){
								%>*<%
							}
						}
						%>
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<%
						if(cont.getTel() == null) { %>
						<td></td>
						<%}else{ %>
						<td><%=cont.getTel() %></td>
						<% } %>
				</tr>
				<tr>
					<th>주쏘</th>
					<%
						if(cont.getAddr() == null) { %>
						<td></td>
						<%}else{ %>
						<td><%=cont.getAddr() %></td>
						<% } %>
				</tr>
				<tr>
					<th>ㅇ메일</th>
					<%
						if(cont.getEmail() == null) { %>
						<td></td>
						<%}else{ %>
						<td><%=cont.getEmail() %></td>
						<% } %>
				</tr>
				<tr>
					<th>나이</th>
					<%
						if(cont.getAge() == 0) { %>
						<td></td>
						<%}else{ %>
						<td><%=cont.getAge() %></td>
						<% } %>
				</tr>
				<tr>
					<th>가입날짜</th>
					<td><%=cont.getReg_date() %></td>
				</tr>
			<% } else { %>
			 		<tr>
					<td colspan="2" align="center">
						<h3>검색된 레코드가 없습니다.</h3>
					</td>
					</tr>
			<% } %>
			<tr>
				<td colspan="2" align="center">
					<a href="<%=request.getContextPath() %>/update.do?">[수정]</a><!--  -->
					<!-- 뭐 데이터가 많이 넘어오는게 아니라 글번호만 받으면되니까 그냥 jsp페이지로 넘겨버려야징.. 
						다른것도 넘겨줘도 되는데 ! 유지보수엔 좋지않앗 -->
					<a href="board_delete.jsp?">[삭제]</a>
					<a href="select.do">[전체목록]</a>
				</td>
			</tr>
		
		</table>
	</div>
</body>
</html>