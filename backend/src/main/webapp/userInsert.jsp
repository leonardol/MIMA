<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href = "/css/Stile.css" rel = "stylesheet" media = "screen">
		<title>Inserisci utente</title>
	</head>
	
	<body>
	
		<ul>
			<li>
		  		<div class="dropdown">
					<a href="/User/openInsertUser" class="dropbtn">Inserisci utente</a>				
				</div>
	  		</li>
	  		
	  		<li>
		  		<div class="dropdown">
					<a href="/User/showUser?showUser=delete" class="dropbtn">Elimina utente</a>				
				</div>
	  		</li>
	  		
	  		<li>
		  		<div class="dropdown">
					<a href="/User/showUser?showUser=list" class="dropbtn">Lista utenti</a>				
				</div>
	  		</li>
	  		
	  		<li>
		  		<div class="dropdown">
					<a href="/User/logout" class="dropbtn">Logout</a>				
				</div>
	  		</li>
		</ul>
		
		<div class="main">
		
			<h1 class="title">Inserisci utente</h1>
			
			<div style="padding-left: 20%; padding-right: 20%;">
		
				<form action="/User/insertUser" method="post">
			
					<div class="form-group">
						<label class="col-form-label">Username</label>
						<input type="text" class="form-control" name="username">				
						
					</div>
					
					<div class="form-group">
						<label class="col-form-label">Password</label>
						<input type="password" class="form-control" name="password">				
						
					</div>
					
					<div class="form-group">
						<label class="col-form-label">Nome</label>
						<input type="text" class="form-control" name="nome">				
						
					</div>
					
					<div class="form-group">
						<label class="col-form-label">Congome</label>
						<input type="text" class="form-control" name="cognome">				
						
					</div>
					
					<div class="form-group">
						<label class="col-form-label">Email</label>
						<input type="email" class="form-control" name="email">				
						
					</div>
					
					<div class="form-group">
						<label class="col-form-label">Telefono</label>
						<input type="number" class="form-control" name="telefono">				
						
					</div>
					
					<div class="form-check" style="margin-top:2%;">
						
						<input class="form-check-input" type="radio" name="rank" value="0" checked="checked">					
						<label class="form-check-label">Utente</label>
						
					</div>
					
					<div class="form-check">
						
						<input class="form-check-input" type="radio" name="rank" value="1">					
						<label class="form-check-label">Admin</label>
						
					</div>
					
					<button style="margin-top:2%; margin-left:40%;" type="submit" class="btn btn-primary" name="action" value="insertUser" >Inserisci</button>	
				
				</form>
				
			</div>
			
		</div>
		
	</body>
</html>