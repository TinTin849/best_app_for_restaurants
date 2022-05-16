<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Main Fix Page</h2>

<input type="button" value="New Item" onclick="window.location.href = 'allOrders'"/>
<br><br>

<input type="button" value="New Supplier" onclick="window.location.href = 'allOrders'"/>
<br><br>

<form:form action="editSupplier" methodParam="supplier">
    <form:select path="id">
        <form:option value="-1">--SELECT--</form:option>
        <c:forEach var="supplier" items="${allSuppliers}">
            <form:option value="${supplier.id}" name="supplierId">${supplier.name}</form:option>
        </c:forEach>
    </form:select>
    <input type="submit" value="OK">
</form:form>

</body>

</html>