<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>Insert title here</title>



<%@ include file="../homeParts/HeaderBenef.jsp" %>
 <section class="shop spad">
        <div class="container " style=" margin-left: 0px">
            <div class="row ">
                <div class="col-lg-3 col-md-3">
                </div>
              
               
                
 <div class="col-lg-9 col-md-9">

                <form action="../beneficiaireAdd" method="POST"  class="checkout__form">
				<div class="col-lg-8">
                        <h5>Inscrire un beneficiaire</h5>
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>nomBenefi<span>*</span></p>
                                    <input type="text" name="nomBenefi" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>prenomBenefi <span>*</span></p>
                                    <input type="text" name="prenomBenefi"class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p> login <span>*</span></p>
                                    <input type="text" name="login" class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>password <span>*</span></p>
                                    <input type="text" name="password"class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>numTel <span>*</span></p>
                                    <input type="number" name="numTel"class="form-control">
                                </div>
                                
                               
                                <div class="checkout__form__input">
                                    <p>adresse <span>*</span></p>
                                    <input type="text" name="adresse"class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>genre <span>*</span></p>
                                    <ul>
                                    <li>
                                         <input type="radio"  id="reponse-1" name="genre" value="male" class="form-control" >
                                         <label for="reponse-1"> Male</label>
									</li>
									 <li>
                                         <input type="radio"  id="reponse-2"name="genre" value="female" class="form-control"> 
							             <label for="reponse-2">Female</label>
								    </li>
								    </ul>
                                </div>
                                
                                <div class="checkout__form__input">
                                    <p>dateNaissance <span>*</span></p>
                                    
                                    <input type="date" name="dateNaissance"  class="form-control">
                                </div>
                                
                                <div class="checkout__form__input">
                                   
                            
                          
                                
                                <button type="submit" class="site-btn">Ajouter</button> 
                               </div> <!--  //row -->
                            
                           </div> 
                       </div> 
               </div> 
                           
                    
                   
            </form>
            </div>
      
</body>
</html>