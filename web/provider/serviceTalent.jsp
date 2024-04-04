<%-- 
    Document   : serviceTalent
    Created on : Apr 5, 2024, 6:41:48 AM
    Author     : TGDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Hired Management | Provider Dashboard</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="provider/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="dashboard"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="images/person_5.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>${sessionScope.user.getName()}</b></p>
                    <p class="app-sidebar__user-designation">Welcome back</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="dashboard"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Dashboard</span></a></li>
                <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-user-voice'></i><span
                            class="app-menu__label">Customer Management</span></a></li>
                <li><a class="app-menu__item" href="talentmanager"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Talents Management</span></a>
                </li>
                <li><a class="app-menu__item" href="order"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Hired Management</span></a></li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="row">
                <div class="col-md-12">
                    <h5>Add More Service</h5>
                </div>
            </div>

            <c:if test="${empty servicepackage }">
                <form action="postServiceTalent" method="post" class="form-horizontal">
                </c:if>
                <c:if test="${not empty servicepackage }">
                    <form action="updateServiceTalent" method="post" class="form-horizontal">

                    </c:if>

                    <div class="row">
                        <c:if test="${not empty servicepackage }">
                            <div class="form-group col-md-12">
                                <label for="talentId" class="control-label">PacketID</label>
                                <input class="form-control" type="text" readonly id="talentId" name="packet_id" value="${pid}">
                            </div>
                        </c:if>
                        <div class="form-group col-md-12">
                            <label for="talentId" class="control-label">TalentID</label>
                            <input class="form-control" type="text" readonly id="talentId" name="talent_id" value="${tid}">
                        </div>
                        <div class="form-group col-md-12">
                            <label for="title" class="control-label">Title</label>
                            <input class="form-control" type="text" id="title" name="title" value="${servicepackage.title}" required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="description" class="control-label">Description</label>
                            <textarea class="form-control" id="description" name="description" required>${servicepackage.description}</textarea>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="price" class="control-label">Price</label>
                            <input class="form-control" type="number" id="price" name="price" value="${servicepackage.price}"  required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="revisions" class="control-label">Revisions</label>
                            <input class="form-control" type="number" id="revisions" name="revisions" value="${servicepackage.revisions}"  required>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="deadline" class="control-label">Deadline</label>
                            <input class="form-control" type="number" id="deadline" name="deadline" value="${servicepackage.deadline}"  required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <c:if test="${empty servicepackage }">
                                <button type="submit" class="btn btn-success btn-sm">
                                    Submit
                                </button>
                            </c:if>
                            <c:if test="${not empty servicepackage }">
                                <button type="submit" class="btn btn-info btn-sm">
                                    Update
                                </button>
                            </c:if>

                        </div>
                    </div>
                </form>

                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">TalentId</th>
                            <th scope="col">ServiceId</th>
                            <th scope="col">Title</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Revisions</th>
                            <th scope="col">Type</th>
                            <th scope="col">Deadline</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Dữ liệu của bảng modal -->
                        <c:forEach items="${service}" var="s">
                            <tr>
                                <td>${s.talentID}</td>
                                <td>${s.packageID}</td>
                                <td>${s.title}</td>
                                <td>${s.description}</td>
                                <td>${s.price}</td>
                                <td>${s.revisions}</td>
                                <td>${s.type}</td>
                                <td>${s.deadline}</td>
                                <td>
                                    <a href="updateServiceTalent?tid=${s.talentID}&&spid=${s.packageID}">
                                        <button type="submit" class="btn btn-info btn-sm">Edit</button>
                                    </a>
                                        <button type="reset" class="btn btn-danger btn-sm" onclick="showMess(${s.packageID},${s.talentID})">
                                            Delete
                                        </button>
                                    
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!--
              MODAL
    </main>
                <!-- Essential javascripts for application to work-->
                <script src="provider/js/jquery-3.2.1.min.js"></script>
                <script src="provider/js/popper.min.js"></script>
                <script src="provider/js/bootstrap.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
                <script src="provider/js/main.js"></script>
                <!-- The javascript plugin to display page loading on top-->
                <script src="provider/js/plugins/pace.min.js"></script>
                <!-- Page specific javascripts-->
                <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
                <!-- Data table plugin-->
                <script type="text/javascript" src="provider/js/plugins/jquery.dataTables.min.js"></script>
                <script type="text/javascript" src="provider/js/plugins/dataTables.bootstrap.min.js"></script>
                <script type="text/javascript">$('#sampleTable').DataTable();</script>
                <script>
                    function showMess(spid, tid) {
                        var option = confirm('Are you sure to delete service package id = ' + spid);
                        if (option === true) {
                            window.location.href = 'deleteServicePackage?spid=' + spid + '&&tid=' + tid;
                        }
                    }
                </script>



                </body>

                </html>
