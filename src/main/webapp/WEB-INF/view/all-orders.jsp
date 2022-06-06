<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Orders</h2>

<table border="1">
    <tr>
        <th>Item</th>
        <th>Supplier</th>
        <th>Number</th>
        <th>Price</th>
        <th>Date</th>
    </tr>
    <c:forEach var="order" items="${allOrders}">
        <tr>
            <td>${order.orderItem.name}</td>
            <td>${order.orderSupplier.name}</td>
            <td>${order.quantityOfGoods}</td>
            <td>${order.price}</td>
            <td>${order.creationDate}</td>
            <td>
                <form action="all-orders/delete-order">
                    <input type="hidden" value="${order.id}" name="orderId"/>
                    <input type="submit" name="Delete" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>

<input type="button" value="Home" onclick="window.location.href = '/best_app_for_restaurants/'"/>

</body>

</html>