<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RegistrationForm</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="RegisterForm/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="RegisterForm/css/style.css">
	</head>

	<body>

		<div class="wrapper" style="background-image: url('RegisterForm/images/bg-registration-form-2.jpg');">
			<div class="inner">
				<form action="/AssociationMarket/associationAdd" method="POST">
					<h3>Registration Form</h3>
					<div class="form-group">
						<div class="form-wrapper">
							<label for=""> Nom de l'association</label>
							<input type="text" name="nomAsso" class="form-control">
						</div>
						<div class="form-wrapper">
							<label for="">Secteur</label>
							<input type="text" name="secteur" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<div class="form-wrapper">
							<label for=""> Nom du responsable</label>
							<input type="text" name="nomRespo" class="form-control">
						</div>
						<div class="form-wrapper">
							<label for="">Prenom du responsable</label>
							<input type="text" name="prenomRespo" class="form-control">
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Email</label>
						<input type="text" name="email" class="form-control">
					</div>
					<div class="form-wrapper">
						<label for="">Password</label>
						<input type="password" name="password" class="form-control">
					</div>
					<div class="form-wrapper">
						<label for="">Telephone</label>
						<input type="number" name="telephoneAsso" class="form-control">
					</div>
					<div class="form-group">
						<div class="form-wrapper">
							<label for="">Ville</label>
							<input type="text" name="ville" class="form-control">
						</div>
						<div class="form-wrapper">
							<label for="">Localisation</label>
							<input type="text" name="localisation" class="form-control">
						</div>
					</div>					
					<div class="form-wrapper">
						<label for="">Nombre de jour limite pour recuperer produit</label>
						<input type="number" name="nbrJourRecuProd" class="form-control">
					</div>
					<div class="checkbox">
						<label>
							<input type="checkbox" required> I caccept the Terms of Use & Privacy Policy.
							<span class="checkmark"></span>
						</label>
					</div>
					<button>Ajouter Association</button>
				</form>
			</div>
		</div>
		
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>