<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Registration Form</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="addFormTemplate/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="addFormTemplate/css/style.css">
	</head>

	<body>

		<div class="wrapper" style="background-image: url('addFormTemplate/images/bg-registration-form-2.jpg');">
			<div class="inner">
				<form action="produitVenteAdd" method="POST"  >
					<h3>Formulaire d'ajout d'un Produit a donner</h3>
					<div class="form-group">
						<div class="form-wrapper">
							<label for="">lib_Prod</label>
							<input type="text" name="lib_Prod" class="form-control">
						</div>
						<div class="form-wrapper">
							<label for="">description Produit </label>
							<input type="text" name="descProd"class="form-control">
						</div>
					</div>
					<!-- <div class="form-wrapper">
						<label for="">image</label>
						<input type="text" name="image"class="form-control">
					</div> -->
					<div class="form-wrapper">
						<label for="">Date d'Ajout</label>
						<fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="yyyy/MM/dd HH:mm:ss"/> 
						<input type="text" name="dateAjout" value="${fmtDate}" placeholder="${fmtDate}" readonly class="form-control">
					</div>
					<div class="form-wrapper">
						<label for="">image</label>
						<input type="text" name="image" class="form-control">
						
					</div> 
					<div class="form-wrapper">
							<label for="">Prix Produit </label>
							<input type="text" name="prix"class="form-control">
				    </div>
				    <div class="form-wrapper">
							<label for="">couleur Produit </label>
							<input type="text" name="couleur"class="form-control">
					</div>
					<div class="form-wrapper">
							<label for="">taille Produit </label>
							<input type="text" name="taille"class="form-control">
					</div>
					<div class="form-wrapper">
							<label for="">Nombre Produit dans votre stock  </label>
							<input type="text" name="nbrprodstock"class="form-control">
					</div>
					
					
					<div>
					<input type="submit" value="Confirmer">
					<input type="reset" value="Annuler">
					</div>
				</form>
			</div>
		</div>
		
	</body>
</html>