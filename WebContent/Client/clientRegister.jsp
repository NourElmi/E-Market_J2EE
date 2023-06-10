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



 <%@ include file="../homeParts/HeaderClient.jsp" %>	
 <section class="shop spad">
        <div class="container " style=" margin-left: 0px">
            <div class="row ">
                <div class="col-lg-3 col-md-3">
                </div>
              
       <div class="col-lg-9 col-md-9">
                <form action="../clientAdd" method="POST" class="checkout__form">
				<div class="col-lg-8">
                        <h5>client s'inscrire</h5>
                        <div class="row">
                             
                           
                            <div class="col-lg-6 col-md-6 col-sm-6">
                               <div class="checkout__form__input">
                                    <p>Nom  <span>*</span></p>
                                    <input type="text" name="nomClient"  class="form-control">
                                </div>
                              </div>
                              <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="checkout__form__input">
                                    <p>Prenom  <span>*</span></p>
                                    <input type="text" name="prenomRespo" class="form-control">
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="checkout__form__input">
                                    <p>email <span>*</span></p>
                                    <input type="text" name="login"   class="form-control">
                                </div>
                                 <div class="checkout__form__input">
                                      <p>password <span>*</span></p>
                                    <input type="text" name="password"  class="form-control">
                                </div>
                                <div class="checkout__form__input">
                                    <p>telephone  <span>*</span></p>
                                    <input type="text" name="numTel" class="form-control">
                                </div>
                                <div class="checkout__form__input">
                                    <p>adresse <span>*</span></p>
                                    <input type="text" name="adresse"class="form-control">
                                </div>
                                <div class="checkout__form__input">
                                    <p>genre <span>*</span></p>
                                    <input type="text" name="genre"class="form-control">
                                </div>
                                
                                  <div class="checkout__form__input">
                                    <p>dateNaissance <span>*</span></p>
                                    <input type="text" name="dateNaissance" class="form-control">
                                </div>
                                
                              </div>
                            </div>
                            
                            
                            
                                
                                
                                <button type="submit" class="site-btn">ajouter</button> 
                            </div> <!--  //row -->
                            
                       </div>     
                    
                   
            </form>
            </div>
      

  
             
</body>
</html>