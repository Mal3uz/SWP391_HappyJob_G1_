<%-- 
    Document   : Notifications
    Created on : Jan 17, 2024, 9:48:01 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
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
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user1.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Angelica Ramos</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "Great work. Keep on developing great themes"
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">12:20PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user2.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Brenden Wagner</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "Great theme."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">12:30PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user3.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Cedric Kelly</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "For dedication and hard work."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">02:45PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user4.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Paul Byrd</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "For creativity and outstanding work."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">03:20PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user5.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Sonya Frost</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "For quality work and effort."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">03:20PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="bg-dark px-3 py-2 m-3 mb-1 rounded-2">
                          Yesterday
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user3.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Cedric Kelly</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "For dedication and hard work."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">02:45PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user2.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Paul Byrd</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "For creativity and outstanding work."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">03:20PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
                        <div class="px-3 py-2 d-flex align-items-center gap-3 notify-block">
                          <img src="assets/images/user5.png" alt="Admin Panel" class="img-3x rounded-circle" />
                          <div class="flex-1 flex flex-col">
                            <h6 class="fw-semibold mb-1">Sonya Frost</h6>
                            <p class="mb-1">
                              <small class="opacity-50">Appriciated the project.</small>
                              "For quality work and effort."
                            </p>
                            <p class="small mb-1">
                              <span class="fw-semibold">03:20PM</span>
                              <span class="opacity-50">March 25th, 2022</span>
                            </p>
                          </div>
                        </div>
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