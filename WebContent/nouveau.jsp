<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Résoudre des calculs</h3>

<!--  Calcul c = (Calcul) request.getAttribute("nouveauCalcul") -->
<c:set var="c" value="${requestScope['nouveauCalcul']}" />

<!--  response.getWriter().write(c.getOperandeGauche() + c.getOperation().getSigne() + c.getOperandeDroite())-->
<p><c:out value="${c.operandeGauche} ${c.operation.signe} ${c.operandeDroite }"/>
</p>

<%-- <p><c:out value="${pageContext.request.contextPath}/> </p> --%>
<form action="${pageContext.request.contextPath}/jouer.do" method="post">
		Votre solution : <input type= "text" name="proposition"/>
		<input type="submit" value="envoyer"/>
</form>
</body>
</html>