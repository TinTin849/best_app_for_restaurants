<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Main Fix Page</h2>

<input type="button" value="New Item" onclick="window.location.href = 'newItem'"/>
<input type="button" value="New Supplier" onclick="window.location.href = 'newSupplier'"/>
<br><br>

<form:form action="editSupplier" modelAttribute="supplier">
    <form:select path="id">
        <form:option value="-1">--SELECT--</form:option>
        <c:forEach var="supplier" items="${allSuppliers}">
            <form:option value="${supplier.id}" name="supplierId">${supplier.name}</form:option>
        </c:forEach>
    </form:select>
    <input type="submit" value="EDIT">
</form:form>
<br><br>

<input type="button" value="Delete Item or Supplier" onclick="window.location.href = 'deleteItemOrSupplier'"/>

</body>

</html>