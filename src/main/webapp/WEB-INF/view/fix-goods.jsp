<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Warehouse editor</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Number</th>
    </tr>
    <c:forEach var="item" items="${allGoods}">
        <tr>
            <td>${item.name}</td>
            <td>${item.numberOfItems}</td>
            <td>
                <form action="updateWarehouse">
                    <input type="number" value="${item.numberOfItems}" name="numberToSet"/>
                    <input type="hidden" value="${item.id}" name="itemId">
                    <input type="submit" name="Update" value="Update"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>

<input type="button" value="Back" onclick="window.location.href = '/best_app_for_restaurants/'"/>

</body>

</html>