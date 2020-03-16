<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="skyblue">
			<h3>:::: 회 원 가 입 ::::</h3>
		<hr width="50%" color="skyblue">
		
		<form method="post" action="<%=request.getContextPath()%>/insert.do"><!-- 폼태그안의 데이터들도 같이넘어간돵 -->
			<table border="0" cellspacing="0" width="300">
				<tr>
					<th align="right">아이디 :&emsp;</th>
					<td><input type="text" name="mem_id" required/> </td>
				</tr>
				<tr>
					<th align="right">회원명:&emsp;</th>
					<td><input type="text" name="mem_name" required/> </td>
				</tr>
				<tr>
					<th align="right">비밀번호:&emsp;</th>
					<td><input type="password" name="mem_pwd" required/></td>
				</tr>
				<tr>
					<th align="right">연락처:&emsp;</th>
					<td><input type="text" name="mem_tel" /> </td>
				</tr>
				<tr>
					<th align="right">주 소:&emsp;</th>
					<td><input type="text" name="mem_addr" /> </td>
				</tr>
				<tr>
					<th align="right">이메일:&emsp;</th>
					<td><input type="text" name="mem_email" /> </td>
				</tr>
				<tr>
					<th align="right">나 이:&emsp;</th>
					<td><input type="text" name="mem_age" /> </td>
				</tr>
			
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="가입하기" /> &nbsp;&nbsp;
						<input type="reset" value="다시작성" /> &nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	
	</div>
</body>
</html>