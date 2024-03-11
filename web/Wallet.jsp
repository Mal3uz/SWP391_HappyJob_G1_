<%-- 
    Document   : Wallet
    Created on : March 8, 2024, 1:38:24 AM
    Author     : Mal3uz
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%@include file="components/Header.jsp" %>
<style>



.container {
  display: flex;
  justify-content: center;
}

.iphone {
  background-color: #F7F7F7;
  margin: 10px;
  height: 812px;
 width: 100%; /* 375px voi dien thoai*/
  box-shadow: 0 1px 5px -1px rgba(0, 0, 0, 0.3), inset 0 0 0 1px rgba(0, 0, 0, 0.15);
  overflow: hidden;
  position: relative;
  transform: scale(0.9);
  transform-origin: top center;
}

.header {
  height: 30%;
  background-color: #44B0A0;
  border-bottom-right-radius: 40px;
    border-bottom-left-radius: 40px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  position: relative;
  z-index: 1;
   overflow: hidden;
}


.header-summary {
  display: flex;
  flex-direction: column;
font-family: 'Montserrat', sans-serif;
  color: white;
  z-index: 3;
}

.summary-text {
  font-size: 1.2rem;
  font-weight: 300;
  margin-bottom: 1.5rem;
}

.summary-balance {
  font-size: 2rem;
  letter-spacing: 1.5px;
  margin-bottom: 0.8rem;
  
}

.summary-text-2 {
  font-size: 0.8rem;
  letter-spacing: 1px;
}

.user-profile {
  margin-top: 4rem;
  height: 70px;
  width: 70px;
  align-self: flex-start;
}

.user-photo {
  height: 100%;
  width: 100%;
  border-radius: 50%;
  border: 1px solid white;
  box-shadow: 5px 5px 25px 0px rgba(0,0,0,0.2);
}

.content {
  z-index: 4;
  position: absolute;
  top: 210px;
  margin-left:30px;
  display:flex;
  flex-direction:column;
  width:85%;
}

.card {
  
font-family: 'Montserrat', sans-serif;
  align-self: stretch;
  background-color: white;
  border-radius: 12px;
  display: flex;
  flex-direction:column;
   box-shadow: 0 14px 28px rgba(0,0,0,0.02), 0 10px 10px rgba(0,0,0,0.0);
}

.upper-row {
  display: flex;
  justify-content: space-evenly;
  padding-bottom: 25px;
  padding-top: 10px
}

.card-item {
  margin: 20px;
  display: flex;
  flex-direction: column;
}

.card-item span:first-child {
  font-size: 0.7rem;
  font-weight: bold;
  margin-bottom:10px;
}

.card-item span:last-child {
  font-size: 1.2rem;
  font-weight: 300;
}

.dollar {
  color: #FFC168;
}

.lower-row {
  display: flex;
  justify-content: space-evenly;
  margin-bottom: 20px;
}

.lower-row::before {
    content: '';
    display: block;
    position: absolute;
    top: 110px;
    width: 50%;
    left: 25%;
    border-top: 1px solid #E1E1E1;
}

.icon-item {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.icon {
  color: #FFC168;
  padding: 10px;
  background-color: #FBFBFB;
  border-radius: 5px;
  margin-bottom: 5px;
}

.icon-text {
  font-size: 0.6em;
  color: #939393;
}

.transactions {
  font-family: 'Montserrat', sans-serif;
  display: flex;
  position: relative;
  margin-top: 1.5rem;
  flex-direction: column;
}

.t-desc {
  font-size: 0.8rem;
  font-weight: bold;
  padding-bottom: 10px;
}

.transaction {
  cursor: default;
  padding: 10px 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color:white;
  box-shadow: 0 14px 28px rgba(0,0,0,0.02), 0 10px 10px rgba(0,0,0,0.0);
  border-radius: 12px;
  margin-bottom:20px;
}

.t-details {
  width: 55%;
}

.t-icon-container {
  width: 45px;
  align-self: flex-start;
}

.t-icon {
  width: 100%;
  border-radius: 50%;
  box-shadow: 5px 5px 25px 0px rgba(0,0,0,0.2);
}

.t-title {
  text-align: left;
  flex-grow: 1;
  font-size: 0.8rem;
  font-weight: bold;
  margin-bottom: 5px;
}

.t-time {
  font-size: 0.6rem;
  opacity: 0.6;
  font-weight: 300;
  letter-spacing: 1px;
}

.t-amount {
  font-size: 0.6rem;
  letter-spacing: 1px;
  font-weight: 400;
  color: #06D778;
}

.red {
  color: #F4532D;
}

.drawer {
  display:flex;
  background-color: white;
  height:80px;
  position:absolute;
  bottom: 0px;
  width: 100%;
  border-top-left-radius: 50px;
  border-top-right-radius: 50px;
  z-index: 5;
  justify-content: space-evenly;
  align-items: center;
}


.drawer span {
  display: inline-block;
  font-size: 1.5rem;
  color: #FFC168;
  transition: all 0.4s;
  cursor: pointer;
}

.drawer span i:hover {
  transform: scale(1.2);
  border-bottom: 2px solid orange;
}

.drawer span i {
  transition: all 0.3s ease;
  padding-bottom: 8px;
}


.transaction:hover {
    box-shadow: 0 1px 5px -1px rgba(0, 0, 0, 0.3), inset 0 0 0 1px rgba(0, 0, 0, 0.15);
}
</style>

<!-- HOME -->
<section class="section-hero overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">
    <body>
        <div class="container">
            <div class="iphone">
                <div class="header">
                    <div class="header-summary">
                        <div class="summary-text">
                            My Balance
                        </div>
                        <div class="summary-balance">
                           $${w.getBalance()}
                        </div>
                       
                    </div>
                    <div class="user-profile">
                        <img src="${sessionScope.user.getImg() != null ? sessionScope.user.getImg() : 'https://bootdey.com/img/Content/avatar/avatar7.png'}" class="user-photo" >
                        <p class="text-light">${sessionScope.user.getName()}</p>
                    </div>
                </div>
                <div class="content">
                    <div class="card">
                        <div class="upper-row">
                           
                            <div class="icon-item">
                                <div class="btn btn-info">Withdraw <i class="icon-account_balance_wallet"></i></div>
                            </div>
                            <div class="icon-item">
                                <div class="btn btn-info">Add money <i class="icon-money"></i></div>
                            </div>
                        </div>
                    </div>
                    <div class="transactions"><span class="t-desc">Recent Transactions</span>
                        <c:forEach items="${trans}" var="trs" >
                       <c:set value="${dao.getTalentByTransactionId(trs.getTransactionID())}" var="t"></c:set>    
                        <div class="transaction">
                          
                            <div class="t-details">
                                <div class="t-title">${t.getTitle()}</div>
                                <div class="t-time">${trs.getTransactionDate()}
                                </div>
                            </div>
                            <div class="t-amount">${trs.getStatus()}</div>
                            <div class=" t-desc text-primary">+ $${trs.getTotalPrice()}
                            </div>
                        </div>
                        
                        </c:forEach>

                        <div class="transaction">
                            <div class="t-icon-container"><img src="https://www.paypalobjects.com/webstatic/icon/pp144.png" class="t-icon"></div>
                            <div class="t-details">
                                <div class="t-title">Paypal </div>
                                <div class="t-time">03.45 AM
                                </div>
                            </div>
                            <div class="t-amount">+&nbsp;200&#8377;
                            </div>
                        </div>

                        <div class="transaction">
                            <div class="t-icon-container"><img src="https://cdn.dribbble.com/assets/dribbble-ball-192-ec064e49e6f63d9a5fa911518781bee0c90688d052a038f8876ef0824f65eaf2.png" class="t-icon"></div>
                            <div class="t-details">
                                <div class="t-title">99 designs</div>
                                <div class="t-time">08.00PM
                                </div>
                            </div>
                            <div class="t-amount red">-&nbsp;120&#8377;
                            </div>
                        </div>
                    </div>
                </div>
                <div class="drawer">
                    <span><i class="fal fa-home"></i></span>
                    <span><i class="fal fa-chart-bar"></i></span>
                    <div class="menu-btn"><i class="fal fa-plus"></i></div>
                    <span><!---to evenly space icons---></span>
                    <span><i class="fal fa-sticky-note"></i> </span>
                    <span><i class="fal fa-user"></i> </span>
                </div>

            </div>
        </div>
            </body>
</section>

<%@include file="components/Footer.jsp" %>
