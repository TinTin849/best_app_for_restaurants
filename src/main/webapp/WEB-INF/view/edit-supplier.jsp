<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Edit Supplier</h2>

<h3>${realSupplier.name}</h3>

<table border="1">
    <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <c:forEach var="currentNote" items="${chosenItemsAndPrices}">
        <tr>
            <td>${currentNote.item.name}</td>
            <td>${currentNote.price}</td>
            <td>
                <form:form action="edit-supplier/delete-item" modelAttribute="itemAndPrice">
                    <form:input path="id" type="hidden" value="${currentNote.id}"/>
                    <input type="submit" name="Delete"/>
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<%--<input type="button" value="Add Item" onclick="window.location.href = '/add-item-to-supplier'"/>--%>

<%--<form:form action="add-item-to-supplier" method="post" modelAttribute="itemAndPrice">--%>

<%--    <form:select>--%>
<%--        <form:option value="-1">--SELECT--</form:option>--%>
<%--        <c:forEach var="currentNote" items="${unusedItems}">--%>
<%--            <form:option value="${currentNote}">${currentNote.name}</form:option>--%>
<%--        </c:forEach>--%>
<%--    </form:select>--%>
<%--    <form:input type="number" path="price"/>--%>
<%--    <input type="submit" value="Add">--%>
<%--</form:form>--%>

</body>

</html>