
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

        <title>
            CGV &mdash; Cinemas
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

        <div class="hero">
            <div class="hero-slide">
                <div
                    class="img overlay"
                    style="background-image: url('https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/s/u/suzume_980wx448h.jpg')"
                    ></div>
                <div
                    class="img overlay"
                    style="background-image: url('https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/t/o/tom_jerry_980wx448h.jpg')"
                    ></div>
                <div
                    class="img overlay"
                    style="background-image: url('https://www.cgv.vn/media/banner/cache/1/b58515f018eb873dafa430b6f9ae0c1e/9/8/980x448_78.png')"
                    ></div>
            </div>

            <div class="container">
                <div class="row justify-content-center align-items-center">
                    <div class="col-lg-9 text-center">
                        <h1 class="heading" data-aos="fade-up">
                            Easiest way to find your FAVORITE MOVIE
                        </h1>
                        <form
                            action="SearchServlet"
                            class="narrow-w form-search d-flex align-items-stretch mb-3"
                            data-aos="fade-up"
                            data-aos-delay="200" method="post"
                            >
                            <input
                                type="text"
                                class="form-control px-4"
                                placeholder="thể loại, tên phim, diễn viên, ..."
                                name="searchInput"/>
                            <button type="submit" class="btn btn-primary">Search</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="section">
            <div class="container">
                <div class="row mb-5 align-items-center">
                    <div class="col-lg-6">
                        <h2 class="font-weight-bold text-primary heading">
                            Popular Movie
                        </h2>
                    </div>
                    <div class="col-lg-6 text-lg-end">
                        <p>
                            <a
                                href="allmovie"
                                target="_blank"
                                class="btn btn-primary text-white py-3 px-4"
                                >View all</a
                            >
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="property-slider-wrap">
                            <div class="property-slider">

                                <c:forEach items="${movieList}" var = "o">
                                    <!--//-->
                                    <div class="property-item">
                                        <a href="moviedetail?movie_id=${o.movie_id}" class="img">
                                            <img src="${o.poster}" alt="Image" class="img-fluid" />
                                        </a>

                                        <div class="property-content" style="height: 300px">
                                            <div class="price mb-2"><span>${o.title}</span></div>
                                            <div style="height:90%">
                                                <span class="d-block mb-2 text-black-50"
                                                      >



                                                    <c:forEach items="${mcList}" var="p" >

                                                        <c:if test="${p.movie_id eq o.movie_id}">
                                                            <c:forEach items="${cateList}" var="v" >
                                                                <c:if test="${v.cate_id eq p.cate_id}">
                                                                    ${v.cate_name}, 
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:if>
                                                    </c:forEach>

                                                </span>


                                                <div class="specs d-flex mb-4">
                                                    <span class="d-block d-flex align-items-center me-3">

                                                        <span class="caption">${o.request}</span>
                                                    </span>

                                                </div>

                                                <a
                                                    href="moviedetail?movie_id=${o.movie_id}"
                                                    class="btn btn-primary py-2 px-3"
                                                    >See details</a
                                                >
                                            </div>
                                        </div>
                                    </div>
                                    <!-- .item -->
                                </c:forEach>



                            </div>

                            <div
                                id="property-nav"
                                class="controls"
                                tabindex="0"
                                aria-label="Carousel Navigation"
                                >
                                <span
                                    class="prev"
                                    data-controls="prev"
                                    aria-controls="property"
                                    tabindex="-1"
                                    >Prev</span
                                >
                                <span
                                    class="next"
                                    data-controls="next"
                                    aria-controls="property"
                                    tabindex="-1"
                                    >Next</span
                                >
                            </div>
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
                            <c:forEach items="${actorList}" var = "o">${o.actor_id}</c:forEach>
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

