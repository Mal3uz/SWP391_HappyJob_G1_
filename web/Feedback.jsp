<%-- 
    Document   : Feedback
    Created on : Mar 2, 2024, 6:26:14 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Star Rating</title>
        <meta name="viewport"
              content="width=device-width, 
              initial-scale=1" />


        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                min-height: 50vh;
                display: flex;
                align-items: center;
                text-align: center;
                justify-content: center;
                background: hsl(137, 46%, 24%);
                font-family: "Poppins", sans-serif;
                background-image: url('images/hero_1.jpg');
                
            }

            .card {
                max-width: 50rem;
                background: #fff;
                margin: 0 1rem;
                padding: 1rem;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                width: 100%;
                border-radius: 0.5rem;
            }

            .card2 {
                max-width: 50rem;
                max-height: 33rem;
                background: #fff;
                margin: 0 1rem;
                padding: 1rem;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                width: 100%;
                height: 30%;
                border-radius: 0.5rem;
                margin-bottom: 50px;
                margin-top: 50px;
            }
            .card3 {
                max-width: 50rem;
                max-height: 33rem;
                background: #fff;
                margin: 0 1rem;
                padding: 1rem;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
                width: 100%;
                height: 30%;
                border-radius: 0.5rem;
                margin-bottom: 50px;
                margin-top: 50px;
            }
            img{
                width: 100%;
                height: 300px;
            }

            .star {
                font-size: 10vh;
                cursor: pointer;
            }

            .one {
                color: rgb(255, 0, 0);
            }

            .two {
                color: rgb(255, 106, 0);
            }

            .three {
                color: rgb(251, 255, 120);
            }

            .four {
                color: rgb(255, 255, 0);
            }

            .five {
                color: rgb(24, 159, 14);
            }

            button {
                display: block;
                margin-left: auto;
                margin-right: 20px;

                width:80px;
                height: 50px;

            }
            
            
        </style>
    </head>

    <body>


        <form action="./Feedback" method="POST">
            <input type="text" name="AccountID" id="accountId" value="${AccountID}" style="display:none" />  
            <input type="text" name="TalentID" id="talentId" value="${TalentID}" style="display:none" /> 
            <input type="text" name="Score" id="score"  style="display:none" /> 
            <div class="card2">
                <h1>Talent content ordered</h1>
                <br />
                <img src="${Img}" alt="alt"/>
                <br />

                <h3>
                    ${Title}
                </h3>
            </div>

            <div class="card">
                <h1>Rating for talent</h1>
                <br />
                <span onclick="gfg(1)"
                      class="star">★
                </span>
                <span onclick="gfg(2)"
                      class="star">★
                </span>
                <span onclick="gfg(3)"
                      class="star">★
                </span>
                <span onclick="gfg(4)"
                      class="star">★
                </span>
                <span onclick="gfg(5)"
                      class="star">★
                </span>
                <h3 id="output">
                    Rating is: 0/5
                </h3>
            </div>

            <div class="card3">
                <h1>Comment</h1>
                <br />
                <hr/>
                <br />
                <textarea name="Comment" rows="6" cols="70"></textarea>
                <br />
                <button type="submit">Save</button>
            </div>


        </form>
        <script>
            // To access the stars
            let stars =
                    document.getElementsByClassName("star");
            let output =
                    document.getElementById("output");

// Funtion to update rating
            function gfg(n) {
                remove();
                for (let i = 0; i < n; i++) {
                    if (n == 1) {
                        cls = "one";
                        document.getElementById("score").value = "1";
                    } else if (n == 2) {
                        cls = "two";
                        document.getElementById("score").value = "2";
                    } else if (n == 3) {
                        cls = "three";
                        document.getElementById("score").value = "3";
                    } else if (n == 4) {
                        cls = "four";
                        document.getElementById("score").value = "4";
                    } else if (n == 5) {
                        cls = "five";
                        document.getElementById("score").value = "5";
                        
                    }
                    stars[i].className = "star " + cls;
                }
                output.innerText = "Rating is: " + n + "/5";
            }

// To remove the pre-applied styling
            function remove() {
                let i = 0;
                while (i < 5) {
                    stars[i].className = "star";
                    i++;
                }
            }
        </script>
    </body>

</html>

