<%-- 
    Document   : login
    Created on : Mar 11, 2023, 8:52:50 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login V16</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="login_atr/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="login_atr/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="login_atr/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login_atr/css/util.css">
        <link rel="stylesheet" type="text/css" href="login_atr/css/main.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <style>
            .mess{
                transition: ease-in;
                width: 200px; height: 100px;background: white;position: absolute;z-index: 2;right: 44%;
                border-bottom-left-radius: 10px;border-bottom-right-radius: 10px;
            }
            .mess:hover{
                cursor: pointer
            }
            .fa-angle-up{
                font-size: 24px;
                position: absolute;
                right: 5%
            }
            .content{
                text-align: center;padding-top: 15%
            }
            .close{
                height: 0px;
                
            }
        </style>
        <script>
            
            
        </script>
    </head>
    <body>
        
        <div class="limiter">
            <div class="container-login100" style="background-image: url('login_atr/images/bg-01.jpg');">
                <div class="wrap-login100 p-t-30 p-b-50">
                    <span class="login100-form-title p-b-41">
                        Register to CGV
                    </span>
                    <form action="register" method="post" class="login100-form validate-form p-b-33 p-t-5">
                        <p style="text-align: center;color: red" >${mess}</p>
                        <div class="wrap-input100 validate-input " data-validate = "Enter username">
                            <input  id="username" class="input100" type="text" name="username" value="${username eq null ? "" : username}" placeholder="User name">
                            <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input id="password" class="input100" type="password" name="pass" value="${password eq null ? "" : password}" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter re-password">
                            <input id="repassword" class="input100" type="password" name="repass" value="${password eq null ? "" : password}" placeholder="Re-Password">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter re-password">
                            <input id="repassword" class="input100" type="text" name="firstname" value="${firstname eq null ? "" : firstname}" placeholder="First Name">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter re-password">
                            <input id="repassword" class="input100" type="text" name="lastname" value="${lastname eq null ? "" : lastname}" placeholder="Last Name">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter re-password">
                            <input id="repassword" class="input100" type="text" name="age" value="${age eq null ? "" : age}" placeholder="Age">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>
                        <div class="" data-validate="Enter re-password">Gender:
                            <input id="repassword" style="margin-left: 50px" class="input50" type="radio" name="gender" value="Male" placeholder="Gender">Male
                            <input id="repassword" class="input50" type="radio" name="gender" value="Female" placeholder="Gender">Female
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Enter re-password">
                            <input id="repassword" class="input100" type="text" name="email" value="${email eq null ? "" : email}" placeholder="Email">
                            <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                        </div>
                        <div class="container-login100-form-btn m-t-32">
                            <button class="login100-form-btn" onclick="checkValid()">
                                Register
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="login_atr/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="login_atr/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="login_atr/vendor/bootstrap/js/popper.js"></script>
        <script src="login_atr/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="login_atr/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="login_atr/vendor/daterangepicker/moment.min.js"></script>
        <script src="login_atr/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="login_atr/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="login_atr/js/main.js"></script>

    </body>
</html>