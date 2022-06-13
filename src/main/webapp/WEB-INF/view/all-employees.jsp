<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>

<table>
	<tr>
		<th>Name</th> <!-- th - table head шапка таблицы -->
		<th>Surname</th>
		<th>Department</th>
		<th>Salary</th>
	</tr>
	
	<c:forEach var="emp" items="${allEmps}">
	
		<tr> <!-- th - table row строки таблицы, проходим циклом по записям и добавляем строки -->
			<td>${emp.name} </td>
			<td>${emp.surname} </td>
			<td>${emp.department} </td>
			<td>${emp.salary} </td>	
		</tr>		
	
	</c:forEach>



</table>




</body>






</html>