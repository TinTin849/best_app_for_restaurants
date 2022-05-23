<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Edit Supplier</h2>
<br>

<form:form action="saveSupplier" modelAttribute="supplier">

    <form:hidden path="id"/>
    <h1>${supplier.name}</h1>
    <br><br>

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
                        <%--                    <form action="deleteItem">--%>
                        <%--                        <input type="hidden" value="${item.id}" name="itemId"/>--%>
                        <%--                        <input type="submit" name="Delete" value="Delete"/>--%>
                        <%--                    </form>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="OK">
</form:form>

<form:form action="/addItemToSupplier" modelAttribute="itemAndPrice">
    <form:select path="item">
        <option value="-1">--SELECT--</option>
        <c:forEach var="currentNote" items="${unusedItems}">
            <option value="${currentNote.id}" name="supplierId">${currentNote.name}</option>
        </c:forEach>
    </form:select>
    <form:input type="number" path="price" title="цена"/>
    <br>
    <input type="submit" value="Add">
</form:form>

</body>

</html>