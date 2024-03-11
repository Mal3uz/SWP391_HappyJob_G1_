<%-- 
    Document   : PostJob
    Created on : Jan 15, 2024, 7:31:48 PM
    Author     : DELL
--%>
<%@page import="java.util.List"%>
<%@page import="dao.ProviderDAO"%>
<%@page import="dao.DBContext"%>
<%@page import="entity.Category"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@include file="components/Header.jsp" %>

<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1 class="text-white font-weight-bold">Post A Talent</h1>
                <div class="custom-breadcrumbs">
                    <a href="#">Home</a> <span class="mx-2 slash">/</span>
                    <a href="#">Job</a> <span class="mx-2 slash">/</span>
                    <span class="text-white"><strong>Post a Job</strong></span>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="site-section">
    <div class="container">

        <div class="row align-items-center mb-5">
            <div class="col-lg-8 mb-4 mb-lg-0">
                <div class="d-flex align-items-center">
                    <div>
                        <h2>Post A Job</h2>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="row">
                    <div class="col-6">
                        <a href="#" class="btn btn-block btn-light btn-md"><span class="icon-open_in_new mr-2"></span>Preview</a>
                    </div>
                    <div class="col-6">
                        <a href="AddTalentControl" class="btn btn-block btn-primary btn-md">Save Job</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mb-5">
            <div class="col-lg-12">
                <form action="AddTalentControl" class="p-4 p-md-5 border rounded" method="post" enctype="multipart/form-data" onsubmit="return validateServicePackageTypes();">
                    <h3 class="text-black mb-5 border-bottom pb-2">Job Details</h3>
                    <div class="form-group">
                        <label for="company-website-tw d-block">Upload Featured Image</label> <br>
                        <label class="btn btn-primary btn-md btn-file">
                            Browse File  <input type="file" name="ProductImgURL" class="form-control"></input>
                        </label>
                    </div>


                    <div class="form-group">
                        <label for="email">Title</label>
                        <input type="text" class="form-control" id="title" name="title" placeholder="I will do ...">
                    </div>
                    <!--
                    <div class="form-group">
                        <label for="job-title">Job Title</label>
                        <input type="text" class="form-control" id="job-title" placeholder="Product Designer">
                    </div>
                    <div class="form-group">
                        <label for="job-location">Location</label>
                        <input type="text" class="form-control" id="job-location" placeholder="e.g. New York">
                    </div>
                    -->
                    <div class="form-group">
                        <label for="job-region">Job Type</label>
                        <select
                            required="required" class="form-control" name="doctorNameSelect">
                            <option selected="selected" disabled="disabled">---Select---</option>

                            <%
                                DBContext dbContext = new DBContext();
                                ProviderDAO p = new ProviderDAO(dbContext.getConnection());
                                List<Category> listOfCategory = p.getAllCategory();
                                for (Category c : listOfCategory)
									
                            {%>
                            <!-- actually we take id of category from category table -->
                            <option value="<%= c.getId() %>"> <%= c.getName()%>  </option>

                            <%
                            }
                            %>


                        </select>
                    </div>


                    <div class="form-group">
                        <label for="job-description">Job Description</label>
                        <div class="editor" id="editor-1">
                            <p>Write Job Description!</p>
                            <textarea name="description" required="required" class="form-control" rows="3" cols=""></textarea>
                        </div>
                    </div>




                    <!--
                     <h3 class="text-black my-5 border-bottom pb-2">Company Details</h3>
                                        <div class="form-group">
                                            <label for="company-name">Company Name</label>
                                            <input type="text" class="form-control" id="company-name" placeholder="e.g. New York">
                                        </div>
                    
                                        <div class="form-group">
                                            <label for="company-tagline">Tagline (Optional)</label>
                                            <input type="text" class="form-control" id="company-tagline" placeholder="e.g. New York">
                                        </div>
                    
                                        <div class="form-group">
                                            <label for="job-description">Company Description (Optional)</label>
                                            <div class="editor" id="editor-2">
                                                <p>Description</p>
                                            </div>
                                        </div>
                    
                                        <div class="form-group">
                                            <label for="company-website">Website (Optional)</label>
                                            <input type="text" class="form-control" id="company-website" placeholder="https://">
                                        </div>
                    
                                        <div class="form-group">
                                            <label for="company-website-fb">Facebook Username (Optional)</label>
                                            <input type="text" class="form-control" id="company-website-fb" placeholder="companyname">
                                        </div>
                    
                                        <div class="form-group">
                                            <label for="company-website-tw">Twitter Username (Optional)</label>
                                            <input type="text" class="form-control" id="company-website-tw" placeholder="@companyname">
                                        </div>
                                        <div class="form-group">
                                            <label for="company-website-tw">Linkedin Username (Optional)</label>
                                            <input type="text" class="form-control" id="company-website-tw" placeholder="companyname">
                                        </div>
                    
                                        <div class="form-group">
                                            <label for="company-website-tw d-block">Upload Logo</label> <br>
                                            <label class="btn btn-primary btn-md btn-file">
                                                Browse File<input type="file" hidden>
                                            </label>
                                        </div>
                    
                                    </form>
                                </div>
                     </div>
                    -->
                     <h2>Service Packages</h2>
                    <!-- Service packages -->
                    <div class="row mb-3">
                       
                        <%-- Loop to create input fields for three service packages --%>
                        <c:forEach var="i" begin="1" end="3" varStatus="loop">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="servicePackageTitle${i}" class="form-label">Service Package Title ${i}</label>
                                    <input type="text" class="form-control" id="servicePackageTitle${i}" name="servicePackageTitle${i}" required>
                                </div>
                                <div class="form-group">
                                    <label for="servicePackageDescription${i}" class="form-label">Service Package Description ${i}</label>
                                    <textarea class="form-control" id="servicePackageDescription${i}" name="servicePackageDescription${i}" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="servicePackagePrice${i}" class="form-label">Service Package Price ${i}</label>
                                    <input type="number" class="form-control" id="servicePackagePrice${i}" name="servicePackagePrice${i}" required>
                                </div>
                                <div class="form-group">
                                    <label for="servicePackageType${i}" class="form-label">Service Package Type ${i}</label>
                                    <select class="form-select" id="servicePackageType${i}" name="servicePackageType${i}" required>
                                        <option value="Basic">Basic</option>
                                        <option value="Standard">Standard</option>
                                        <option value="Premium">Premium</option>
                                    </select>
                                </div>
                                 <div class="form-group">
                                    <label for="servicePackageRev${i}" class="form-label">Service Package Revisions ${i}</label>
                                    <input type="number" class="form-control" id="servicePackageRev${i}" name="servicePackageRev${i}" required>
                                </div>
                                 <div class="form-group">
                                    <label for="servicePackageDL${i}" class="form-label">Service Package Dealine ${i}</label>
                                    <input type="number" class="form-control" id="servicePackageDL${i}" name="servicePackageDL${i}" required>
                                </div>
                            </div>
                        </c:forEach>
                    </div>


                    <div class="row align-items-center mb-5">

                        <div class="col-lg-4 ml-auto">
                            <div class="row">
                                <div class="col-6">
                                    <a href="#" class="btn btn-block btn-light btn-md"><span class="icon-open_in_new mr-2"></span>Preview</a>
                                </div>
                                <div class="col-6">
                                    <input type="submit" value="Save Job" class="btn btn-block btn-primary btn-md">

                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <script>
                function updateServicePackageTypes(selectId) {
                    var selectedTypes = [];
                    var typeSelects = document.querySelectorAll('[id^="servicePackageType"]');

                    // Loop through each service package type select tag
                    typeSelects.forEach(function (select) {
                        if (select.id !== selectId) {
                            var selectedType = select.value;
                            selectedTypes.push(selectedType);
                        }
                    });

                    // Update options for each select tag
                    typeSelects.forEach(function (select) {
                        if (select.id !== selectId) {
                            var options = select.options;
                            for (var i = 0; i < options.length; i++) {
                                var option = options[i];
                                option.disabled = selectedTypes.includes(option.value);
                            }
                        }
                    });
                }

                function validateServicePackageTypes() {
                    var selectedTypes = new Set();
                    var errorMessage = "";

                    // Loop through each service package type select tag
                    for (var i = 1; i <= 3; i++) {
                        var typeSelect = document.getElementById("servicePackageType" + i);
                        var selectedType = typeSelect.value;

                        // Check if the selected type has already been chosen
                        if (selectedTypes.has(selectedType)) {
                            errorMessage = "Each type must be chosen only once.";
                            break;
                        } else {
                            selectedTypes.add(selectedType);
                        }
                    }

                    // Display error message if any
                    if (errorMessage !== "") {
                        alert(errorMessage);
                        return false;
                    }

                    return true;
                }
            </script>
            </section>



            <%@include file="components/Footer.jsp" %>


