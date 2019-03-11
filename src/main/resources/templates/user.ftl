<!DOC html>
<html>
	<head>
		<meta charset="UTF-8" />
	</head>
	
	<body>
		<h1 style="fontsize:64px;color:red;">USERINFO</h1>
		
			<#list userList as user>
				<div>
				<tr>
					<td>ID: ${user.id}</td>
					<td>NAME: ${user.name}</td> 
					<td>AGE: ${user.age}</td>
					<td>SEX: ${user.sex}</td>
				</tr>	
				</div>
			</#list>
	
	</body>
	
</html>