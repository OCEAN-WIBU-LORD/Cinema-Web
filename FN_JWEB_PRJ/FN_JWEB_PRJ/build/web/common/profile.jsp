<%-- 
    Document   : profile
    Created on : Mar 12, 2023, 1:41:16 PM
    Author     : Nguyen Van Ky
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <style>
        body{
            background-color: #8899a6;
        }
        .container{
            background-image: url("../login_atr/images/bg-01.jpg");

            height: content-box;
        }
        .twPc-div {
            background: #fff none repeat scroll 0 0;
            border: 1px solid #e1e8ed;
            border-radius: 6px;
            height: 200px;
            max-width: 340px;
            margin-left: 10px
        }
        .twPc-bg {
            background-image: url("https://pbs.twimg.com/profile_banners/50988711/1384539792/600x200");
            background-position: 0 50%;
            background-size: 100% auto;
            border-bottom: 1px solid #e1e8ed;
            border-radius: 4px 4px 0 0;
            height: 95px;
            width: 100%;
        }
        .twPc-block {
            display: block !important;
        }
        .twPc-button {
            margin: -35px -10px 0;
            text-align: right;
            width: 100%;
        }
        .twPc-avatarLink {
            background-color: #fff;
            border-radius: 6px;
            display: inline-block !important;
            float: left;
            margin: -30px 5px 0 8px;
            max-width: 100%;
            padding: 1px;
            vertical-align: bottom;
        }
        .twPc-avatarImg {
            border: 2px solid #fff;
            border-radius: 7px;
            box-sizing: border-box;
            color: #fff;
            height: 72px;
            width: 72px;
        }
        .twPc-divUser {
            margin: 5px 0 0;
        }
        .twPc-divName {
            font-size: 18px;
            font-weight: 700;
            line-height: 21px;
        }
        .twPc-divName a {
            color: inherit !important;
        }
        .twPc-divStats {
            margin-left: 11px;
            padding: 10px 0;
        }
        .twPc-Arrange {
            box-sizing: border-box;
            display: table;
            margin: 0;
            min-width: 100%;
            padding: 0;
            table-layout: auto;
        }
        ul.twPc-Arrange {
            list-style: outside none none;
            margin: 0;
            padding: 0;
        }
        .twPc-ArrangeSizeFit {
            display: table-cell;
            padding: 0;
            vertical-align: top;
        }
        .twPc-ArrangeSizeFit a:hover {
            text-decoration: none;
        }
        .twPc-StatValue {
            display: block;
            font-size: 18px;
            font-weight: 500;
            transition: color 0.15s ease-in-out 0s;
        }
        .twPc-StatLabel {
            color: #8899a6;
            font-size: 10px;
            letter-spacing: 0.02em;
            overflow: hidden;
            text-transform: uppercase;
            transition: color 0.15s ease-in-out 0s;
        }
        table tr td,.header{
            font-weight: bold;
            color: white
        }
        table tr td input{
            background-color: black;
            height: 50px;
            width: 90%;
            padding: 0 10px;
        }
    </style>

    <body>


        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <div class="container" style="background-image: url('https://cdn.pixabay.com/photo/2016/03/15/02/42/floor-1256804__340.jpg');">
            <div class="row" style="margin-left: 10px">
                <a href="home"><img src="images/logo.png" width="100px" alt="alt"/><h1 class="header">CVG Profile Card</h1></a>
                <p class="header">You can update to refresh your PROFILE</p>
                <!-- code start -->
                <div class="twPc-div col-md"> 
                    <a class="twPc-bg twPc-block"></a>

                    <div>
                        <div class="twPc-button">
                            <!-- Twitter Button | you can get from: https://about.twitter.com/tr/resources/buttons#follow -->
                            <a href="https://twitter.com/mertskaplan" class="twitter-follow-button" data-show-count="false" data-size="large" data-show-screen-name="false" data-dnt="true">Follow @mertskaplan</a>
                            <script>!function (d, s, id) {
                                    var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
                                    if (!d.getElementById(id)) {
                                        js = d.createElement(s);
                                        js.id = id;
                                        js.src = p + '://platform.twitter.com/widgets.js';
                                        fjs.parentNode.insertBefore(js, fjs);
                                    }
                                }(document, 'script', 'twitter-wjs');</script>
                            <!-- Twitter Button -->   
                        </div>

                        <a title="Mert S. Kaplan" href="#" class="twPc-avatarLink">
                            <c:if test="${sessionScope.usercurrent.gender eq 1}">
                                <img alt="Mert S. Kaplan" src="https://c8.alamy.com/comp/TC2FPE/young-man-avatar-cartoon-character-profile-picture-TC2FPE.jpg" class="twPc-avatarImg">
                            </c:if>
                            <c:if test="${sessionScope.usercurrent.gender ne 1}">
                                <img alt="Mert S. Kaplan" src="https://c8.alamy.com/comp/TC2GE7/young-woman-avatar-cartoon-character-profile-picture-TC2GE7.jpg" class="twPc-avatarImg">
                            </c:if>
                        </a>

                        <div class="twPc-divUser">
                            <div class="twPc-divName">
                                <a href="https://twitter.com/mertskaplan">${sessionScope.usercurrent.firstname} ${sessionScope.usercurrent.lastname}</a>
                            </div>
                            <span>
                                <a href="https://twitter.com/mertskaplan">@<span>${sessionScope.usercurrent.username} </span></a>
                            </span>
                        </div>

                        <div class="twPc-divStats">
                            <ul class="twPc-Arrange">
                                <li class="twPc-ArrangeSizeFit">
                                    <a href="https://twitter.com/mertskaplan" title="9.840 Tweet">
                                        <span class="twPc-StatLabel twPc-block">Type card</span>
                                        <c:if test="${sessionScope.usercurrent.account_type_id eq 1}"> COPPER</c:if>
                                        <c:if test="${sessionScope.usercurrent.account_type_id eq 2}"> <span class="twPc-StatValue"><i>SILVER</i></span></c:if>
                                        <c:if test="${sessionScope.usercurrent.account_type_id eq 3}"> <span class="twPc-StatValue"><i>GOLD</i></span></c:if>
                                        <c:if test="${sessionScope.usercurrent.account_type_id eq 4}"> <span class="twPc-StatValue"><i>DIAMOND</i></span></c:if>
                                        </a>
                                    </li>


                                    <script type="text/javascript">
                                        function showEditProfile() {

                                        }
                                    </script>
                                    <li class="twPc-ArrangeSizeFit">
                                        <a href="#" title="" onclick="showEditProfile()">
                                            <span class="twPc-StatLabel twPc-block">Update profile</span>
                                            <span class="twPc-StatValue"></span>
                                        </a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                

                <div style="float: right;width: 60%">
                    <c:if test="${messenger ne null}">
                    <i style="color: greenyellow">Update successfully</i>
                </c:if>
                
                    <form action="profile" method="POST" class="login100-form validate-form p-b-33 p-t-5">
                        <i style="color: red;text-align: center;font-size: 30px">${mess}</i>
                        <table class="table table-hover">

                            <tbody>
                                <tr>
                            <input name="acc_id" type="text" value="${sessionScope.usercurrent.acc_id}" hidden="true"/>
                            <td>username</td>
                            <td><input name="username" type="text" value="${sessionScope.usercurrent.username}"/>
                            </td>
                            </tr>
                            <tr>
                                <td>password</td>
                                <td><input name="password" type="password" value="${sessionScope.usercurrent.password}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>first name</td>
                                <td><input name="firstname" type="text" value="${sessionScope.usercurrent.firstname}"/></td>
                            </tr><tr>
                                <td>last name</td>
                                <td><input name="lastname" type="text" value="${sessionScope.usercurrent.lastname}"/></td>
                            </tr>

                            <tr>
                                <td>age</td>
                                <td><input name="age" type="number" value="${sessionScope.usercurrent.age}"/></td>
                            </tr>
                            <tr>
                                <td>email</td>
                                <td><input name="email" type="email" value="${sessionScope.usercurrent.email}"/></td>
                            </tr>
                            <tr>
                                <td>gender</td>
                                <td><input style="width: 5% ;height: max-content" name="gender" ${sessionScope.usercurrent.gender eq 1 ? 'checked="true"': ''}  type="checkbox"/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input class="btn btn-info" type="submit" value="submit" />
                                </td>

                            </tr>
                            </tbody>
                        </table>

                    </form>
                </div>
                <!-- code end -->
            </div>
        </div>
    </body>
</html>
