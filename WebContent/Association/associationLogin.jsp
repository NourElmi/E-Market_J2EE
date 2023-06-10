<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
  <!--  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet"> -->   

 <!--  <link rel="stylesheet" href="../frontend/login-form-02/fonts/icomoon/style.css">  -->   

  <!--  <link rel="stylesheet" href="../frontend/login-form-02/css/owl.carousel.min.css"> 

    <!-- Bootstrap CSS -->
 <!--    <link rel="stylesheet" href="../frontend/login-form-02/css/bootstrap.min.css">   --> 
    
    <!-- Style -->
  	<link rel="stylesheet" href="../frontend/login-form-02/css/style.css">  

    <title>Login</title>
  </head>
  <body>
	<%@ include file="../homeParts/HeaderAssociation.jsp" %>	
	
  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('../frontend/login-form-02/images/authen.png');"></div>
    <div class="contents order-2 order-md-1">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3 style="text-align: center ">Login Association<strong>:</strong></h3>
            <p class="mb-4"></p>
            <form action="/AssociationMarket/login_Association" method="post">
              <div class="form-group first">
                <label for="username">Email</label>
                <input type="text" name="email" class="form-control" placeholder="your-email@gmail.com" id="username">
              </div>
              <div class="form-group last mb-3">
                <label for="password">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Your Password" id="password">
              </div>
              
        <!--       <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
              </div> -->

              <input type="submit" value="Log In" class="btn btn-block btn-primary" style=" background-color:#C91616; border-color:#C91616" >

            </form>
          </div>
        </div>
      </div>
    </div>

    
  </div>
    
    

    <script src="../frontend/login-form-02/js/jquery-3.3.1.min.js"></script>
    <script src="../frontend/login-form-02/js/popper.min.js"></script>
    <script src="../frontend/login-form-02/js/bootstrap.min.js"></script>
    <script src="../frontend/login-form-02/js/main.js"></script>
  </body>
</html>