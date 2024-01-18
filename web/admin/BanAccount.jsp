<%-- 
    Document   : BanAccount
    Created on : Jan 17, 2024, 9:36:52 PM
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
                                    <li class="breadcrumb-item text-light">Agents</li>
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
                                        <div class="table-responsive">
                                            <div class="search-container d-sm-block d-none">
                                                <input type="text" class="form-control" placeholder="Search" />
                                                <i class="icon-search"></i>
                                            </div>
                                            <table class="table table-bordered table-striped align-middle m-0">
                                                <thead>
                                                    <tr>
                                                        <th></th>
                                                        <th></th>
                                                        <th>Name</th>
                                                        <th>Email</th>
                                                        <th>Tickets Resolved</th>
                                                        <th>Status</th>
                                                        <th>Country</th>
                                                        <th>Email Sent</th>
                                                        <th>Calls</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option1" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user2.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Araceli Zhang
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>248</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>United States</td>
                                                        <td>98</td>
                                                        <td>86</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option2" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user1.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Carmen Mccall
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>230</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>India</td>
                                                        <td>65</td>
                                                        <td>39</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option3" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user.png" class="me-2 img-3x rounded-3" alt="Bootstrap Gallery" />
                                                            Gino Watson
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>200</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-light fs-5"></i>
                                                                Offline
                                                            </div>
                                                        </td>
                                                        <td>Turkey</td>
                                                        <td>76</td>
                                                        <td>44</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>4</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option4" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user3.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Edwardo Manning
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>198</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>Indonesia</td>
                                                        <td>72</td>
                                                        <td>39</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>5</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option5" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user4.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Rolf Weeks
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>187</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>Brazil</td>
                                                        <td>44</td>
                                                        <td>12</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>6</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option6" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user5.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Maria Oliver
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>181</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>Saudi Arabia</td>
                                                        <td>73</td>
                                                        <td>33</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>7</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option2" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user2.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Mitzi Stark
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>176</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>France</td>
                                                        <td>65</td>
                                                        <td>39</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>8</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option3" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user1.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Nina Frye
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>174</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-light fs-5"></i>
                                                                Offline
                                                            </div>
                                                        </td>
                                                        <td>Netherlands</td>
                                                        <td>31</td>
                                                        <td>12</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>9</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option4" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user3.png" class="me-2 img-3x rounded-3"
                                                                 alt="Bootstrap Gallery" />
                                                            Lloyd Carlson
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>169</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>Indonesia</td>
                                                        <td>89</td>
                                                        <td>43</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>10</td>
                                                        <th>
                                                            <input class="form-check-input" type="checkbox" value="option5" />
                                                        </th>
                                                        <td>
                                                            <img src="assets/images/user.png" class="me-2 img-3x rounded-3" alt="Bootstrap Gallery" />
                                                            Michael Gould
                                                        </td>
                                                        <td>info@example.com</td>
                                                        <td>165</td>
                                                        <td>
                                                            <div class="d-flex align-items-center">
                                                                <i class="icon-circle1 me-2 text-success fs-5"></i>
                                                                Online
                                                            </div>
                                                        </td>
                                                        <td>Germany</td>
                                                        <td>73</td>
                                                        <td>22</td>
                                                        <td>
                                                            <button class="btn btn-outline-primary btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-primary"
                                                                    data-bs-title="Edit">
                                                                <i class="icon-edit"></i>
                                                            </button>
                                                            <button class="btn btn-outline-danger btn-sm" data-bs-toggle="tooltip"
                                                                    data-bs-placement="top" data-bs-custom-class="custom-tooltip-danger"
                                                                    data-bs-title="Delete">
                                                                <i class="icon-trash"></i>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
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
<%@include file="Footer.jsp" %>
