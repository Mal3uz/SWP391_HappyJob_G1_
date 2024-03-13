<%-- 
    Document   : EvaluationForm
    Created on : Mar 9, 2024, 12:54:09 PM
    Author     : DELL
--%>




<%@include file="components/Header.jsp" %>
<style>
    .rating {
        display: inline-block;
        position: relative;
        height: 50px;
        line-height: 50px;
        font-size: 50px;
    }

    .rating label {
        position: absolute;
        top: 0;
        left: 0;
        height: 100%;
        cursor: pointer;
    }

    .rating label:last-child {
        position: static;
    }

    .rating label:nth-child(1) {
        z-index: 5;
    }

    .rating label:nth-child(2) {
        z-index: 4;
    }

    .rating label:nth-child(3) {
        z-index: 3;
    }

    .rating label:nth-child(4) {
        z-index: 2;
    }

    .rating label:nth-child(5) {
        z-index: 1;
    }

    .rating label input {
        position: absolute;
        top: 0;
        left: 0;
        opacity: 0;
    }

    .rating label .icon {
        float: left;
        color: transparent;
    }

    .rating label:last-child .icon {
        color: #000;
    }

    .rating:not(:hover) label input:checked ~ .icon,
    .rating:hover label:hover input ~ .icon {
        color: #fcc603;
    }

    .rating label input:focus:not(:checked) ~ .icon:last-child {
        color: #000;
        text-shadow: 0 0 5px #09f;
    }
</style>
<script>
    
    let starValue = 0;
    /* for star rating */
    function starChange(value) {
        console.log('New star rating: ' + value);
        starValue = value;
    }

    /* for submit feedback */
    function submitFeedback() {
        document.getElementById('star-value').value = starValue;
        document.getElementById('submit-feedback').submit();
    }

</script>

<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h1 class="text-white font-weight-bold">Feedback and Rating</h1>
                <div class="custom-breadcrumbs">
                    <a href="#">Home</a> <span class="mx-2 slash">/</span>
                    <span class="text-white"><strong>Evaluation</strong></span>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="py-5 bg-image overlay-primary fixed overlay" id="next-section" style="background-image: url('images/hero_1.jpg');">

    <div class="container">

        <div class="row mt-3 bg-white">
            <div class="col-md-5">

                <a href="detailTalentServlet?tID=${t.getTalentID()}#nav-basic"><img class="talent-img" src="${t.getImg()}"></a>

                <div class="talent-person">
                    <img class="talent-person-avt" src="images/person_1.jpg">
                    <div class="talent-person-name"> ${a.getName()}</div>
                </div>
                <a href="detailTalentServlet?tID=${t.getTalentID()}#nav-basic"><div class="talent-title">${t.getTitle()}</div></a>
                <div class="talent-star">
                    <div class="black-color">
                        <div class="icon-star"></div>
                        <div>5.0</div>
                    </div>
                    <div>
                        (385)
                    </div>
                </div>
                <div class="black-color">From $${service.getPrice()}</div>

            </div>
            <div class="col-md-7">
                <div class="card">
                    <div class="feedback-form mt-5 mb-5 ml-5 mr-5">

                        <div class="header">
                            <h3 class="text-success">Add feedback for product</h3>
                        </div>

                        <div class="star-rating">
                            <form class="rating">
                                <label>
                                    <input type="radio" name="stars" value="1" ${star == 1 ? 'checked' : ''} onclick="starChange(this.value)"/>
                                    <span class="icon icon-star2"></span>
                                </label>
                                <label>
                                    <input type="radio" name="stars" value="2" ${star == 2 ? 'checked' : ''} onclick="starChange(this.value)"/>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                </label>
                                <label>
                                    <input type="radio" name="stars" value="3" ${star == 3 ? 'checked' : ''} onclick="starChange(this.value)"/>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>   
                                </label>
                                <label>
                                    <input type="radio" name="stars" value="4" ${star == 4 ? 'checked' : ''} onclick="starChange(this.value)"/>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                </label>
                                <label>
                                    <input type="radio" name="stars" value="5" ${star == 5 ? 'checked' : ''} onclick="starChange(this.value)"/>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                    <span class="icon icon-star2"></span>
                                </label>
                            </form>
                        </div>


                        <div class="feedback-text">
                            <form action="getFeedback?tid=${t.getTalentID()}" id="submit-feedback" method="POST" onsubmit="submitFeedback()" >                                    
                                <label for="feedback-text" class="form-label">Your Feedback: </label>
                                <textarea name="feedback-text" class="form-control" id="feedback-text"  rows="5" placeholder="Write your Feedback here" required>${text}</textarea>
                                <input type="hidden" id="star-value" name="star-value">
                                <input type="hidden" id="productId" name="productId" value="${requestScope.product.productID}">
                                <input type="hidden" id="orderId" name="orderId" value="${requestScope.orderId}">
                                <input type="submit" class="btn btn-success mt-5" value="Submit">                                   
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>

</section>

<script>
    window.onload = function () {
        formatCurrency();
    };
    function formatCurrency() {

        var listCurrency = document.getElementsByClassName("currency");
        for (let i = 0; i < listCurrency.length; i++) {
            listCurrency[i].innerHTML = formatter.format(listCurrency[i].innerHTML);
        }

    }

</script>

<%@include file="components/Footer.jsp" %>
