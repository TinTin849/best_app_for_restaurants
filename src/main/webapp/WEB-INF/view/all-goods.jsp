<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>All available goods</h2>

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
                <form action="writeOffOfGoods">
                    <input type="number" max="${item.numberOfItems}" min="0" name="numberToWriteOff"/>
                    <input type="hidden" value="${item.id}" name="itemId">
                    <input type="submit" name="Write-Off" value="Write-Off"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>

<input type="button" value="New Order" onclick="window.location.href = 'newOrder'"/>
<br><br>
<input type="button" value="Fix Warehouse" onclick="window.location.href = 'fixGoods'"/>

</body>

</html>