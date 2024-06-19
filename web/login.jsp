<%-- 
    Document   : login
    Created on : May 7, 2024, 6:36:56 PM
    Author     : azhar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cleaning Service Management System</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <link rel="stylesheet" href="dist/css/adminlte.min.css?v=3.2.0">

        <script language="javascript">
            javascript:window.history.forward(1);
        </script>
        <style>
            .navbar-dark .navbar-nav .nav-link {
                font-size: 1em;
                margin-right: 15px;
                color: #ffffff;
            }
            .navbar-dark .navbar-nav .nav-link:hover {
                background-color: #00e6e6;
                color: white;
                border-radius: 5px;
            }
            .navbar-brand {
                font-weight: bold;
                font-size: 1.35em;
            }
            .btn-dark {
                background-color: #002633;
                border-color: #002633;
            }
            .custom-save {
                background-color: green;
                color: white;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-reset {
                background-color: yellow;
                color: black;
                padding: 2.5px 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            .custom-cancel {
                background-color: red;
                color: white;
                padding: 6px 10px;
                border-radius: 5px;
                text-decoration: none;
            }
        </style>
        <script nonce="eae1eff2-6388-4755-9ce6-86d15c332d33">try { (function (w, d) { !function (bS, bT, bU, bV) { bS[bU] = bS[bU] || {}; bS[bU].executed = []; bS.zaraz = { deferred: [], listeners: [] }; bS.zaraz._v = "5629"; bS.zaraz.q = []; bS.zaraz._f = function (bW) { return async function () { var bX = Array.prototype.slice.call(arguments); bS.zaraz.q.push({ m: bW, a: bX }) } }; for (const bY of ["track", "set", "debug"]) bS.zaraz[bY] = bS.zaraz._f(bY); bS.zaraz.init = () => { var bZ = bT.getElementsByTagName(bV)[0], b$ = bT.createElement(bV), ca = bT.getElementsByTagName("title")[0]; ca && (bS[bU].t = bT.getElementsByTagName("title")[0].text); bS[bU].x = Math.random(); bS[bU].w = bS.screen.width; bS[bU].h = bS.screen.height; bS[bU].j = bS.innerHeight; bS[bU].e = bS.innerWidth; bS[bU].l = bS.location.href; bS[bU].r = bT.referrer; bS[bU].k = bS.screen.colorDepth; bS[bU].n = bT.characterSet; bS[bU].o = (new Date).getTimezoneOffset(); if (bS.dataLayer) for (const ce of Object.entries(Object.entries(dataLayer).reduce(((cf, cg) => ({ ...cf[1], ...cg[1] })), {}))) zaraz.set(ce[0], ce[1], { scope: "page" }); bS[bU].q = []; for (; bS.zaraz.q.length; ) { const ch = bS.zaraz.q.shift(); bS[bU].q.push(ch) } b$.defer = !0; for (const ci of [localStorage, sessionStorage]) Object.keys(ci || {}).filter((ck => ck.startsWith("_zaraz_"))).forEach((cj => { try { bS[bU]["z_" + cj.slice(7)] = JSON.parse(ci.getItem(cj)) } catch { bS[bU]["z_" + cj.slice(7)] = ci.getItem(cj) } })); b$.referrerPolicy = "origin"; b$.src = "/cdn-cgi/zaraz/s.js?z=" + btoa(encodeURIComponent(JSON.stringify(bS[bU]))); bZ.parentNode.insertBefore(b$, bZ) }; ["complete", "interactive"].includes(bT.readyState) ? zaraz.init() : bS.addEventListener("DOMContentLoaded", zaraz.init) }(w, d, "zarazData", "script"); })(window, document) } catch (e) { throw fetch("/cdn-cgi/zaraz/t"), e; };</script>
    </head>

    <header>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #009999;">
            <a class="navbar-brand font-weight-bold" href="#">Cleaning Service Management System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">

                </ul>

            </div>
        </nav>
    </header>

    <body style="background-color: #e6ffff;">
        <div class="wrapper" style="margin-top: 30px;">
            <!-- Main content -->
            <div class="content full-height d-flex justify-content-center align-items-center">
                <div class="card card-primary" style="width: 30rem;">
                    <div class="card-header">
                        <h3 class="card-title">Sign In</h3>
                    </div>

                    <div class="card-body">
                        <% if (session.getAttribute("loginFailed") != null) {%>
                        <div class="alert alert-danger" role="alert">
                            <%= session.getAttribute("loginFailed")%>
                        </div>
                        <% session.removeAttribute("loginFailed"); // Remove the attribute after displaying %>
                        <% } %>
                        <form id="quickForm" action="loginuser" method="post">
                            <div class="form-group">
                                <label for="role">Role</label>
                                <select name="role" id="role" class="form-control" required>
                                    <option value="admin">Admin</option>
                                    <option value="cleaner">Cleaner</option>
                                </select>  
                            </div>

                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" required>
                            </div>

                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </div>

                    <div class="card-footer">
                        <span>
                            <a href="register">New Cleaner? Register Here</a>
                        </span>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <script src="plugins/jquery-validation/jquery.validate.min.js"></script>
        <script src="plugins/jquery-validation/additional-methods.min.js"></script>

        <script src="dist/js/adminlte.min.js?v=3.2.0"></script>

        <script>
            $(function () {
            $('#quickForm').validate({
            rules: {
            username: {
            required: true,
            },
                    password: {
                    required: true,
                            minlength: 8
                    },
                    terms: {
                    required: true
                    },
            },
                    messages: {
                    username: {
                    required: "Please enter username",
                    },
                            password: {
                            required: "Please provide a password",
                                    minlength: "Your password must be at least 8 characters long"
                            },
                    },
                    errorElement: 'span',
                    errorPlacement: function (error, element) {
                    error.addClass('invalid-feedback');
                    element.closest('.form-group').append(error);
                    },
                    highlight: function (element, errorClass, validClass) {
                    $(element).addClass('is-invalid');
                    },
            });
            });
        </script>
    </body>
</html>
