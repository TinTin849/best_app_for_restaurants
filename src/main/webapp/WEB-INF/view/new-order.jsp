<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<h2>New order panel</h2>
<br>

<form action="/newOrder">
<select>
    <c:forEach var="item" items="${allGoods}">
        <option value="${item.id}" name="itemId">${item.name}</option>
    </c:forEach>
</select>
</form>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="item" items="${suitableSuppliers}">
        <tr>
            <td>${item.key.name}</td>
            <td>${item.value}</td>
            <td>
                <form action="writeOffOfGoods">
                    <input type="number" min="1" name="numberToOrder"/>
                    <input type="hidden" value="${item.id}" name="itemId">
                    <input type="submit" name="Write-Off" value="Write-Off"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>





</body>

</html>