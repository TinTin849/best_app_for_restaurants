<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>Edit Supplier</h2>
<br>

<form:form action="saveSupplier" modelAttribute="supplier">

    <form:hidden path="id"/>
    <h1>${chosenItemsAndPrices[0].supplier.name}</h1>
    <br><br>

    <table border="1">
        <tr>
            <th>Item</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="item" items="${chosenItemsAndPrices}">
            <tr>
                <td>${item.item.name}</td>
                <td>${item.price}</td>
                <td>
                    <form action="deleteItem">
                        <input type="hidden" value="${item.id}" name="itemId"/>
                        <input type="submit" name="Delete" value="Delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <form:form action="addItemToSupplier" modelAttribute="itemToAdd">
                    <form:select path="id">
                        <form:option value="-1">--SELECT--</form:option>
                        <c:forEach var="item" items="${unusedItems}">
                            <form:option value="${item.id}" name="supplierId">${item.name}</form:option>
                        </c:forEach>
                    </form:select>
                    <input type="submit" value="ADD">
                </form:form>
            </td>
        </tr>
    </table>
    <input type="submit" value="OK">

</form:form>

</body>

</html>