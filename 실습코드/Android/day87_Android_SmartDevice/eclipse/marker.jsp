<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
/* ���� �� ���� ��ġ�� ������ �浵 ���� ���� */
/* ������ �����͸� �ְ� ���� ��, ������ Ÿ���� 'String' 
�� ���� ������ ����Ϸ��� ������ Ÿ�� ��ȯ�� �ʿ�*/
double lat = Double.parseDouble(request.getParameter("lat"));
double lon = Double.parseDouble(request.getParameter("lon"));
%>

[
{"lat":<%=lat+0.01%>,"lon":<%=lon+0.01%>},
{"lat":<%=lat+0.02%>,"lon":<%=lon%>},
{"lat":<%=lat+0.01%>,"lon":<%=lon-0.01%>},
{"lat":<%=lat-0.01%>,"lon":<%=lon+0.01%>},
{"lat":<%=lat-0.009%>,"lon":<%=lon+0.03%>},
{"lat":<%=lat-0.001%>,"lon":<%=lon-0.01%>},
{"lat":<%=lat-0.01%>,"lon":<%=lon%>}
]