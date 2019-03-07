<html>
	<head>
		<meta charset="UTF-8" />
	</head>
	
	<body>
		<h1 style="fontsize:64px;color:red;">USER</h1>
		
			<#list userList as user>
				<tr>
					<td>ID: ${user.id}</td>
					<td>NAME: ${user.name}</td> 
					<td>AGE: ${user.age}</td>
					<td>SEX: ${user.sex}</td>
				</tr>	
			</#list>
	
	</body>
</html>