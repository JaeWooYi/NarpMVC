<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 메서드 만들땐 느낌표 -->
<%! 
public int hap(int s, int e) {
	int sum = 0;
	for(int i = s; i <= e; i++){
		sum += i;
	}
	return sum;
}
%>

<!-- 일반 자바코드 -->
<%
int sum = 0;
for(int i = 0; i < 101; i++){
	sum += i;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border='1'>

<tr>
<td>
<p>Ex01) 1부터 100까지의 총합은?</p>
</td>
<td>
<p><%=sum %></p>
</td>
</tr>

<tr>
<td>
<p>Ex02) 55부터 350까지의 총합은?</p>
</td>
<td>
<p><%=hap(55, 350)%></p>
</td>

</tr> 
</table>

</body>
</html>