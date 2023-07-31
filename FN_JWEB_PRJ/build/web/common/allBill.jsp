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
        
        <form method="post" action="allBill">
            
            <table border ="2" style="margin-left: auto; margin-right: auto; margin-top: 50px">
                <tr>
                    <td>BookingID </td>
                    <td>Location </td>
                    <td>Film Booking </td>
                    <td>Movie ID </td>
                    <td>Movie Title </td>
                    <td>Date Booking </td>

                </tr>

                <c:forEach items="${bookings1}" var="bookings1">
                    <tr>
                        <td>${bookings1.getBooking_id()}</td>
                        <td>${bookings1.getAcc_id()}</td>
                        <td>${bookings1.getLocation_id()}</td>
                        <td>${bookings1.getMovie_id()}</td>
                        <td>${bookings1.getTitle()}</td>
                        <td>${bookings1.getBooking_date()}</td>
                    </tr>
                    
                </c:forEach>


            </table>
<!--                ${message}
                <input type="submit" value="submit">
            -->
        </form>

    </body>
</html>
