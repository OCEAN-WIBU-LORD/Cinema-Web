
<nav class="site-nav">
            <div class="container">
                <div class="menu-bg-wrap">
                    <div class="site-navigation">
                        <a href="home" class="logo m-0 float-start"><img src="images/logo.png" width="50px" alt="alt" /><span style="font-family: fantasy">CGV</span></a>

                        <ul
                            class="js-clone-nav d-none d-lg-inline-block text-start site-menu float-end"
                            >
                            <li class="has-children">
                                <a href="#">Movie</a>
                                <ul class="dropdown">
                                    <li><a href="#">ON THE GO FILMS</a></li>
                                    <li><a href="#">FILM COMING SOON</a></li>

                                </ul>
                            </li>
                            <li class="has-children">
                                <a href="properties.html">CGV THREATRE</a>
                                <ul class="dropdown">
                                    <li><a href="#">ALL KINDS OF CINEMA</a></li>
                                    <li><a href="#">SPECIAL CINEMA</a></li>
                                    <li><a href="#">3D CINEMA</a></li>
                                    <li class="has-children">
                                        <a href="#">MORE</a>
                                        <ul class="dropdown">
                                            <li><a href="#">ACCOUNT CGV</a></li>
                                            <li><a href="#">BENEFITS</a></li>

                                        </ul>
                                    </li>
                                </ul>
                            </li>

                            <li class="has-children">
                                <a href="properties.html">MEMBER</a>
                                <ul class="dropdown">
                                    <li><a href="allBill">HISTORY BOOKING</a></li>
                                    <li><a href="#">BENEFITS</a></li>
                                </ul>
                            </li>

                            <c:if test="${usercurrent ne null}">
                                <li class="has-children">
                                <a href="#">${usercurrent.firstname} ${usercurrent.lastname}</a>
                                <ul class="dropdown">
                                    <li><a href="profile?acc_id=${usercurrent.acc_id}">PROFILE</a></li>
                                    <li><a href="logout">LOGOUT</a></li>
                                </ul></li>
                            </c:if>
                            <c:if test="${usercurrent eq null}">
                                <li class="">
                                    <a href="login">LOGIN</a></li>
                                <li class="">
                                    <a href="register">REGISTER</a></li>
                            </c:if>
                        </ul>

                        <a
                            href="#"
                            class="burger light me-auto float-end mt-1 site-menu-toggle js-menu-toggle d-inline-block d-lg-none"
                            data-toggle="collapse"
                            data-target="#main-navbar"
                            >
                            <span></span>
                        </a>
                    </div>
                </div>
            </div>
        </nav>