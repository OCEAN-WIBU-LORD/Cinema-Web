<%-- 
    Document   : moviedetail
    Created on : Mar 12, 2023, 5:08:19 PM
    Author     : Nguyen Van Ky
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="util.PageCount"%>

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
        
        <script >
            function changeCate(){
                 
            }
        </script>
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
     

        <%
	int pageindex = (int) request.getAttribute("pageindex");
	int totalNumberPage = (int) request.getAttribute("totalNumberPage");
	String cate_id = (String) request.getAttribute("cate_id");
	%>
        <div class="section container">
		<div class="row">
			<div class="col-lg-4 mb-2 order-0">
                            
                                <ul style="list-style-type: none">
					<li><h3>Genre</h3></li>
					<c:forEach items="${cateList }" var="g">
						<c:if test="${cate_id eq g.cate_id}">
							<li>
								<div class="form-check">
                                                                    <input onclick="changeCate()" checked="checked" type="radio" name="genreidn"
										id="inputgenreid" class="genre-class form-check-input"
										value="${g.cate_id }" /> ${g.cate_name }
								</div>
							</li>
						</c:if>
						<c:if test="${cate_id ne g.cate_id}">
							<li>
								<div class="form-check">
									<input onclick="changeCate()" type="radio" name="genreidn"
										class="genre-class form-check-input" value="${g.cate_id }" />
									${g.cate_name }
								</div>
							</li>
						</c:if>
					</c:forEach>
				</ul>
                           
			</div>

			<div class="col-lg-8 mb-4 order-0">
				<h1 id="genreh1">${genrename }</h1>
				



				<div class="row" id="divlistbook">

					<c:forEach items="${listCountPage}" var="b">


						<div class="col-xl-4 col-lg-6 mb-4">
							<div class="card" style="height: 420px">
								<div class="card-body">
									<div class="d-flex align-items-center">
										<a href="moviedetail?movie_id=${b.movie_id }"><img
											onMouseOver="this.style.width='235px'; this.style.height='355px'"
											onMouseOut="this.style.width='225px'; this.style.height='345px'"
											class="imgid" src="${b.poster }"
											style="box-shadow: 0 0 10px #c4cacc; width: 225px; height: 345px; z-index: 9999"
											alt="Image" /></a>

									</div>
									${b.title } - ${b.directed_by }
								</div>
							</div>
						</div>

					</c:forEach>

					<div class="link_page ">
						<button class="btn btn-default"><%=PageCount.previous(pageindex, cate_id)%></button><%=PageCount.pager(totalNumberPage, pageindex, totalNumberPage, cate_id)%><button
							class="btn btn-default"><%=PageCount.next(pageindex, totalNumberPage, cate_id)%></button>
					</div>
				</div>
			</div>
		</div>
	</div>


        
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
