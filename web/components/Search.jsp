<%-- 
    Document   : Search
    Created on : Jan 15, 2024, 11:36:25 PM
    Author     : DELL
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- HOME -->
        <section class="home-section section-hero overlay bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">

            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-12">
                        <div class="mb-5 text-center">
                            <h1 class="text-white font-weight-bold">The Easiest Way To Get Your Dream Job</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate est, consequuntur perferendis.</p>
                        </div>
                        <form id="searchForm" class="search-jobs-form">
                            <div class="row mb-5">
                                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                                    <input 
                                        type="text" 
                                        class="form-control form-control-lg" 
                                        placeholder="Job title, Company..."
                                        id="search"   
                                        >
                                </div>
                                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                                    <select class="selectpicker" data-style="btn-white btn-lg" data-width="100%" id="star">
                                        <option value="0" selected>Select Star</option>
                                        <option value="3">3+</option>
                                        <option value="4">4+</option>
                                        <option value="5">5+</option>
                                    </select>
                                </div>
                                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                                    <select class="selectpicker" data-style="btn-white btn-lg" data-width="100%" id="price">
                                        <option value="0" selected>Select Price</option>
                                        <option value="1000">0 - 1000</option>
                                        <option value="2000">1000 - 2000</option>
                                        <option value="2001">2000+</option>
                                    </select>
                                </div>

                                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                                    <button type="button" class="btn btn-primary btn-lg btn-block text-white btn-search" onclick="submitData()"><span class="icon-search icon mr-2"></span>Search Job</button>
                                </div>
                            </div>
                        </form>

                        <script>
                            var searchData = {};
                            function submitData() {
                                var searchValue = document.getElementById('search').value;
                                var starValue = document.getElementById('star').value;
                                var priceValue = document.getElementById('price').value;

                                searchData.search = searchValue;
                                searchData.star = starValue;
                                searchData.price = priceValue;
                                $.ajax({
                                    type: 'POST',
                                    url: 'loadSearch',
                                    data: {
                                        search: searchValue,
                                        star: starValue,
                                        price: priceValue
                                    },
                                    success: function (data) {
                                        document.getElementById("container-list-talent").innerHTML = data;
                                        updatePagination();
                                    }
                                });
                            }

                            function updatePagination() {
                                var endPage = document.getElementById("endPage").value;
                                console.log(endPage);
                                // Thêm mã HTML mới cho phần tử có id "page" với vòng lặp forEach mới
                                var paginationHTML = '<div class="row pagination-wrap">';
                                paginationHTML += '<div class="col-md-6 text-center text-md-left mb-4 mb-md-0">';
                                paginationHTML += '<span>Showing 1-7 Of 43,167 Jobs</span>';
                                paginationHTML += '</div>';
                                paginationHTML += '<div class="col-md-6 text-center text-md-right">';
                                paginationHTML += '<div class="custom-pagination ml-auto">';
                                paginationHTML += '<a href="#" class="prev">Prev</a>';
                                paginationHTML += '<div class="d-inline-block">';

                                for (var i = 1; i <= endPage; i++) {
                                    paginationHTML += '<a href="javascript:void(0);" onclick="PaginationSearchClick(' + i + ')" class="active">' + i + '</a>';
                                }
                                
                                paginationHTML += '</div>';
                                paginationHTML += '<a href="#" class="next">Next</a>';
                                paginationHTML += '</div>';
                                paginationHTML += '</div>';
                                paginationHTML += '</div>';

                                // Thêm mã HTML mới vào phần tử có id "page"
                                document.getElementById("paging").innerHTML = paginationHTML;
                            }

                            function PaginationSearchClick(index) {
                                // Sử dụng dữ liệu từ biến toàn cục
                                 console.log(searchData);
                                var searchValue = searchData.search;
                                var starValue = searchData.star;
                                var priceValue = searchData.price;
                               
                                $.ajax({
                                    type: 'POST',
                                    url: 'loadSearch',
                                    data: {
                                        search: searchValue,
                                        star: starValue,
                                        price: priceValue,
                                        index:index
                                    },
                                    success: function (data) {
                                        console.log(data);
                                        document.getElementById("container-list-talent").innerHTML = data;
                                        
                                    }
                                });

                            }
                        </script>

                        <div class="row">
                            <div class="col-md-12 popular-keywords">
                                <h3>Trending Keywords:</h3>
                                <ul class="keywords list-unstyled m-0 p-0">
                                    <li><a href="#" class="">UI Designer</a></li>
                                    <li><a href="#" class="">Python</a></li>
                                    <li><a href="#" class="">Developer</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <a href="#next" class="scroll-button smoothscroll">
                <span class=" icon-keyboard_arrow_down"></span>
            </a>

        </section>

    </body>
</html>

