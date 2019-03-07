<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href = "/css/Stile.css" rel = "stylesheet" media = "screen">
		<title>Inserimento Scheduling</title>
	</head>
	
	<body>
	
		<%@ include file="menu_user.html" %>
	
		<h1 class="title">Inserimento Scheduling</h1>
		
		<div style="padding-left: 20%; padding-right: 20%;">
		
			<form action="/Scheduling/insertScheduling" method="post">
		
				<div class="form-group">
					<label class="col-form-label">Nome</label>
					<input type="text" class="form-control" name="name">				
				</div>
				
				<div class="form-group">
					<label class="col-form-label">Data Inizio</label>
					<input type="datetime-local" class="form-control" name="dataInizio">				
				</div>
				
				<div class="form-group">
					<label class="col-form-label">Data Fine</label>
					<input type="datetime-local" class="form-control" name="dataFine">				
				</div>
				
				<button style="margin-top:2%" type="submit" class="btn btn-primary" name="action" value="insertScheduling" >Inserisci</button>	
			
			</form>
			
		</div>	
	
	</body>
</html>