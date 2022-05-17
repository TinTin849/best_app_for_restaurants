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
    </table>
    <input type="submit" value="OK">

</form:form>

</body>

</html>