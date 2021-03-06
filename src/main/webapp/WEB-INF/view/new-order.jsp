<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>New order panel</h2>

<form:form action="new-order" modelAttribute="item">
    <form:select path="id">
        <form:option value="-1">--SELECT--</form:option>
        <c:forEach var="item" items="${allGoods}">
            <form:option value="${item.id}" name="itemId">${item.name}</form:option>
        </c:forEach>
    </form:select>
    <input type="submit" value="OK">
</form:form>
<br><br>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="chosenSaP" items="${chosenSuppliersAndPrices}">
        <tr>
            <td>${chosenSaP.supplier.name}</td>
            <td>${chosenSaP.price}</td>
            <td>
                <form action="new-order/add-order">
                    <input type="number" min="1" name="numberToOrder"/>
                    <input type="hidden" value="${chosenSaP.supplier.id}" name="supplierName">
                    <input type="hidden" value="${chosenSaP.item.id}" name="itemName">
                    <input type="submit" name="order" value="Order"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>

<input type="button" value="Show all orders" onclick="window.location.href = 'all-orders'"/>
<br><br>
<input type="button" value="Fix Suppliers and Items" onclick="window.location.href = 'fix-suppliers-and-items'"/>

</body>

</html>