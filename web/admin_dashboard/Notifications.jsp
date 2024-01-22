<%-- 
    Document   : Notifications
    Created on : Jan 17, 2024, 9:48:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
        <!-- App body starts -->
        <div class="app-body">

          <!-- Container starts -->
          <div class="container">

            <!-- Row start -->
            <div class="row">
              <div class="col-12 col-xl-6">

                <!-- Breadcrumb start -->
                <ol class="breadcrumb mb-3">
                  <li class="breadcrumb-item">
                    <i class="icon-home lh-1"></i>
                    <a href="index.html" class="text-decoration-none">Home</a>
                  </li>
                  <li class="breadcrumb-item">Pages</li>
                  <li class="breadcrumb-item text-light">Notifications</li>
                </ol>
                <!-- Breadcrumb end -->
              </div>
            </div>
            <!-- Row end -->

            <!-- Row start -->
            <div class="row">
              <div class="col-12">
                <div class="card mb-2">
                  <div class="card-body">
                    <!-- Search container start -->
                    <div class="search-container d-sm-block d-none">
                      <input type="text" class="form-control" placeholder="Search" />
                      <i class="icon-search"></i>
                    </div>
                    <!-- Search container end -->

                    <!-- Contacts Container Start -->
                    <div class="notification-container mt-3">
                      <div class="notification-list">
                        <div class="bg-dark px-3 py-2 m-3 mb-1 rounded-2">
                          Today
                        </div>
                        <c:forEach var="n" items="${listN}">
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="../admin_dashboard/assets/images/user1.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Angelica Ramos</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                               ${n.message}
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">${fn:substring(n.createdAt, 11, 19)}</span>
                              <span class="opacity-50">${fn:substring(n.createdAt, 0, 10)}</span>
                            </p>
                          </div>
                        </div>
                        </c:forEach>
                       
                      </div>
                    </div>
                    <!-- Contacts Container End -->
                  </div>
                </div>
              </div>
            </div>
            <!-- Row end -->

          </div>
          <!-- Container ends -->

        </div>
        <!-- App body ends -->

        <!-- App footer start -->
        <div class="app-footer">
          <div class="container">
            <span>© Bootstrap Gallery 2024</span>
          </div>
        </div>
        <!-- App footer end -->

      </div>
      <!-- App container ends -->

    </div>
    <!-- Page wrapper end -->

    <!-- *************
			************ JavaScript Files *************
		************* -->
    <!-- Required jQuery first, then Bootstrap Bundle JS -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.bundle.min.js"></script>

    <!-- *************
			************ Vendor Js Files *************
		************* -->

    <!-- Overlay Scroll JS -->
    <script src="assets/vendor/overlay-scroll/jquery.overlayScrollbars.min.js"></script>
    <script src="assets/vendor/overlay-scroll/custom-scrollbar.js"></script>

    <!-- Custom JS files -->
    <script src="assets/js/custom.js"></script>
  </body>

</html>