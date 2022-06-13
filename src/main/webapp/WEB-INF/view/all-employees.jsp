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
		<th>Operations</th>
	</tr>
	
	<c:forEach var="emp" items="${allEmps}">
		
		<!-- Для изменения работника создаём ссылку c параметром на его id, чтобы далее знать с каким работником работать -->
		<c:url var="updateButton" value="/updateInfo">	
			<c:param name="empId" value="${emp.id}"/>
		</c:url>
		
		<!-- Также и для удаления. deleteButton лишь название переменной-->
		<c:url var="deleteButton" value="/deleteEmployee">	
			<c:param name="empId" value="${emp.id}"/>
		</c:url>
	
		<tr> <!-- th - table row строки таблицы, проходим циклом по записям и добавляем строки -->
			<td>${emp.name} </td> <!-- td - table data -->
			<td>${emp.surname} </td>
			<td>${emp.department} </td>
			<td>${emp.salary} </td>	
			<td>
				<input type="button" value="Update"
				onclick = "window.location.href = '${updateButton}'"/>

				<input type="button" value="Delete"
				onclick = "window.location.href = '${deleteButton}'"/>
			</td>	
		</tr>		
	
	</c:forEach>
</table>

<br>

<input type="button" value="Add"
	onclick="window.location.href = 'addNewEmployee'"/>
	
</body>
</html>