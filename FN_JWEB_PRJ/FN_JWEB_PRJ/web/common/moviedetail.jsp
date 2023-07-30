<%-- 
    Document   : moviedetail
    Created on : Mar 12, 2023, 5:08:19 PM
    Author     : Nguyen Van Ky
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- /*
* Template Name: Property
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="author" content="Untree.co" />
        <link rel="shortcut icon" href="favicon.png" />

        <meta name="description" content="" />
        <meta name="keywords" content="bootstrap, bootstrap5" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;500;600;700&display=swap"
            rel="stylesheet"
            />

        <link rel="stylesheet" href="fonts/icomoon/style.css" />
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css" />

        <link rel="stylesheet" href="css/tiny-slider.css" />
        <link rel="stylesheet" href="css/aos.css" />
        <link rel="stylesheet" href="css/style.css" />


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <title>
            Property &mdash; Free Bootstrap 5 Website Template by Untree.co
        </title>
    </head>
    <body>
        <div class="site-mobile-menu site-navbar-target">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close">
                    <span class="icofont-close js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>

        <%@include file="nav.jsp" %>

        <div
            class="hero page-inner overlay"
            style="background-image: url('images/hero_bg_3.jpg')"
            >

        </div>

        <div class="section">
            <div class="container">
                <div class="row justify-content-between">
                    <div class="col-lg-7">
                        <div class="img-property-slide-wrap">
                            <div class="img-property-slide">
                                <img src="${movie.poster}" alt="Image" class="img-fluid" />

                            </div>
                        </div>
                                <div style="width: 600px; height: 600px" >
                                    <!-- <c:if test="${bookingrs ne null}" >
                                        <%@include file="seat.jsp" %>
    
                                    </c:if>
                                    -->
                                    
                                </div>
                    </div>
                    <div class="col-lg-4">
                        <h2 class="heading text-primary">${movie.title}</h2>
                        <p class="meta"><b>Directed by:</b> ${movie.directed_by}</p>
                        <p class="text-black-50">
                            <b>Category: </b>${category.cate_name}
                        </p>
                        <p class="text-black-50">
                            <b>Time show: </b>${movie.time_show}
                        </p>
                        <p class="text-black-50">
                            <b>Request: </b>${movie.request}
                        </p>
                        <p class="text-black-50">
                            <b>Status: </b>
                            <c:if test="${movie.status_movie eq '1'}">
                                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="color: white">Can booking</button>
                            </c:if>
                            <c:if test="${movie.status_movie ne '1'} ">
                                <button class="btn btn-warning" ><a href="bookingmovie" style="color: white">Can't booking</a></button>
                            </c:if>
                        </p><c:if test="${bookingrs ne null}"><p style="color: greenyellow; font-size: 25px">booking successfull</p>                                  
                            <img style="width: 300px; width: 300px" src="images/sampleQR2.png">
                        </c:if>

                        <div class="d-block agent-box p-5">
                            <p>${movie.description}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog" >
            <div class="modal-dialog modal-lg" >
                <div class="modal-content"  >
                    <form action="bookingmovie" method="post">
                        <label for="sel1" class="form-label">Select list (select one):</label>

                        <br>
                        <input name="movie_id" type="text" value="${movie.movie_id}" hidden="true"/>

                        <select multiple class="form-select" id="sel2" name="location" >
                            <c:forEach items="${lpList}" var="o">

                                <option value="${o.location_id}" style="padding: 10px;font-size: 20px">${o.location_name}, ${o.position_name}, ${o.location_type},${o.time},${o.date}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-primary mt-3" style="margin:  0 0 0 43%">Submit</button>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!--end -->
        <div class="site-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Contact</h3>
                            <address>43 Raymouth Rd. Baltemoer, London 3910</address>
                            <ul class="list-unstyled links">
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li><a href="tel://11234567890">+1(123)-456-7890</a></li>
                                <li>
                                    <a href="mailto:info@mydomain.com">info@mydomain.com</a>
                                </li>
                            </ul>
                        </div>
                        <!-- /.widget -->
                    </div>
                    <!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Sources</h3>
                            <ul class="list-unstyled float-start links">
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Services</a></li>
                                <li><a href="#">Vision</a></li>
                                <li><a href="#">Mission</a></li>
                                <li><a href="#">Terms</a></li>
                                <li><a href="#">Privacy</a></li>
                            </ul>
                            <ul class="list-unstyled float-start links">
                                <li><a href="#">Partners</a></li>
                                <li><a href="#">Business</a></li>
                                <li><a href="#">Careers</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">FAQ</a></li>
                                <li><a href="#">Creative</a></li>
                            </ul>
                        </div>
                        <!-- /.widget -->
                    </div>
                    <!-- /.col-lg-4 -->
                    <div class="col-lg-4">
                        <div class="widget">
                            <h3>Links</h3>
                            <ul class="list-unstyled links">
                                <li><a href="#">Our Vision</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Contact us</a></li>
                            </ul>

                            <ul class="list-unstyled social">
                                <li>
                                    <a href="#"><span class="icon-instagram"></span></a>
                                </li>
                                <li>
                                    <a href="#"><span class="icon-twitter"></span></a>
                                </li>
                                <li>
                                    <a href="#"><span class="icon-facebook"></span></a>
                                </li>
                                <li>
                                    <a href="#"><span class="icon-linkedin"></span></a>
                                </li>
                                <li>
                                    <a href="#"><span class="icon-pinterest"></span></a>
                                </li>
                                <li>
                                    <a href="#"><span class="icon-dribbble"></span></a>
                                </li>
                            </ul>
                        </div>
                        <!-- /.widget -->
                    </div>
                    <!-- /.col-lg-4 -->
                </div>
                <!-- /.row -->

                <div class="row mt-5">
                    <div class="col-12 text-center">
                        <!-- 
                          **==========
                          NOTE: 
                          Please don't remove this copyright link unless you buy the license here https://untree.co/license/  
                          **==========
                        -->

                        <p>
                            Copyright &copy;
                            <script>
                                document.write(new Date().getFullYear());
                            </script>
                            . All Rights Reserved. &mdash; Designed with love by
                            <a href="https://untree.co">Untree.co</a>
                            <!-- License information: https://untree.co/license/ -->
                        </p>
                        <div>
                            Distributed by
                            <a href="https://themewagon.com/" target="_blank">themewagon</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container -->
        </div>
        <!-- /.site-footer -->

        <!-- Preloader -->
        <div id="overlayer"></div>
        <div class="loader">
            <div class="spinner-border" role="status">
                <span class="visually-hidden">Loading...</span>
            </div>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/tiny-slider.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/navbar.js"></script>
        <script src="js/counter.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
