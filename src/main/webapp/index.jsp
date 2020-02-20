<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="${pageContext.request.contextPath}/api/customers">Get customers</a>
<a href="${pageContext.request.contextPath}/api/customers/{customerId}">Get one customer</a>
</body>
</html>
