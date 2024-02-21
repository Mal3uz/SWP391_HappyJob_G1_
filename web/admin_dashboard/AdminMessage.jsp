<%-- 
    Document   : AdminMessage
    Created on : Jan 30, 2024, 10:31:31 PM
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>

<div class="app-body" >


    <h1 class="h3 mb-3">Messages</h1>

    <div class="card">
        <div class="row g-0">
            <div class="col-12 col-lg-5 col-xl-3 border-right " id="container-list-friend">

                <div class="px-4  d-md-block">
                    <div class="d-flex align-items-center">
                        <div class="flex-grow-1">
                            <input type="text" class="form-control my-3" placeholder="Search...">
                        </div>
                    </div>
                </div>

                <ul class="px-4 list-unstyled chat-list mt-2 mb-0">

                    <c:forEach var="a" items="${receiver}">
                        <li class="clearfix d-flex align-items-center mb-2" id="li-${a.accountID}" onclick="show(${a.accountID},${sender.accountID})"> 


                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="avatar" class="rounded-circle" width="50">
                            <div class="about p-3">
                                <div class="name">${a.name}</div>
                                <div class="status"> 
                                    <i class="fa fa-circle offline"></i> left 7 mins ago
                                </div>
                            </div>
                        </li>
                    </c:forEach>


                </ul>


            </div>


            <div class="col-12 col-lg-7 col-xl-9 d-none" id="container-chat">
                <div class="py-2 px-4 border-bottom d-lg-block">
                    <div class="icon-arrow_back d-flex align-items-center py-1 account-receiver">
                        <!--                       img  amd name receiver-->
                    </div>
                </div>


                <div class="position-relative chat-messages" id="chat-messages">
                    <div class=" p-4">

                        <!--                       message chat-->

                    </div>
                </div>


                <div class="flex-grow-0 py-3 px-4 border-top">
                    <div class="input-group form-send">
                        <!--                         form send-->
                    </div>
                </div>

            </div>
        </div>
    </div>


</div>

<script>

    var userId = 0;
    function show(receiverID, senderID) {
        if (ws && ws.readyState === WebSocket.OPEN) {
            ws.close();
        }
        $.ajax({
            url: '../admin/messageDetail',
            type: 'GET',
            data: {receiver: receiverID},
            dataType: 'json',
            success: function (response) {
                var chatMessagesDiv = $('.chat-messages');
                var accountReceiverDiv = $('.account-receiver');
                var formSendDiv = $('.form-send');
                chatMessagesDiv.empty();
                accountReceiverDiv.empty();
                formSendDiv.empty();

                // add infomation account receiver
                var detailAcount = $(`<div class="position-relative">
 <img src="https://bootdey.com/img/Content/avatar/avatar3.png" class="rounded-circle mr-1" alt="Sharon Lessman" width="40" height="40"></div>
<div class="flex-grow-1 pl-3">
    <strong id="receiveId"></strong>
    <div class="text-muted small"><em class="m-2">` + response.receiver.name + `</em></div>
</div> <div><button class="btn btn-primary btn-lg mr-1 px-3"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-phone feather-lg"><path d="M22 16.92v3a2 2 0 0 1-2.18 2 19.79 19.79 0 0 1-8.63-3.07 19.5 19.5 0 0 1-6-6 19.79 19.79 0 0 1-3.07-8.67A2 2 0 0 1 4.11 2h3a2 2 0 0 1 2 1.72 12.84 12.84 0 0 0 .7 2.81 2 2 0 0 1-.45 2.11L8.09 9.91a16 16 0 0 0 6 6l1.27-1.27a2 2 0 0 1 2.11-.45 12.84 12.84 0 0 0 2.81.7A2 2 0 0 1 22 16.92z"></path></svg></button>
                            <button class="btn btn-info btn-lg mr-1 px-3 d-none d-md-inline-block"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-video feather-lg"><polygon points="23 7 16 12 23 17 23 7"></polygon><rect x="1" y="5" width="15" height="14" rx="2" ry="2"></rect></svg></button>
                            <button class="btn btn-light border btn-lg px-3"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-horizontal feather-lg"><circle cx="12" cy="12" r="1"></circle><circle cx="19" cy="12" r="1"></circle><circle cx="5" cy="12" r="1"></circle></svg></button>
                        </div>`);
                accountReceiverDiv.append(detailAcount);

                // add form input message
                var formMessage = $(` 
                         <input type="text" id="content" class="form-control" placeholder="Type your message" name="content" required>
                        <button id="button-value-sender" class="btn btn-primary" value="` + response.receiver.accountID + `" onclick="postMessage(` + response.receiver.accountID + `);">Send</button>
                         `);
                formSendDiv.append(formMessage);

                // Combine and sort the messages
                var allMessages = response.listMessSend.concat(response.listMessReceive);
                allMessages.sort(function (a, b) {
                    return new Date(a.timestamp) - new Date(b.timestamp);
                });

                var receiver = response.receiver.accountID;

                // Display the messages
                for (var i = 0; i < allMessages.length; i++) {
                    var mess = allMessages[i];
                    var timestamp = mess.timestamp; // giả sử "2024-02-02 02:00:28.417"
                    var hourAndMinute = (timestamp.split(" ")[1]).substring(0, 5); // lấy phần "02:00:28.417"
                    var date = timestamp.split(" ")[0];
                    if (receiver === mess.receiverid) {
                        var messageDiv = $('<div class="chat-message-right pb-4"></div>');
                        var imgDiv = $('<div><img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="You" width="40" height="40"><div class="text-muted small text-nowrap mt-2">' + hourAndMinute + '</div></div>');
                        var contentDiv = $('<div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3"><div class="fst-italic fs-6">' + date + '</div><div class=" mb-1 fw-bolder">You</div>' + mess.content + '</div>');
                    } else {
                        var messageDiv = $('<div class="chat-message-left pb-4"></div>');
                        var imgDiv = $('<div><img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="You" width="40" height="40"><div class="text-muted small text-nowrap mt-2">' + hourAndMinute + '</div></div>');
                        var contentDiv = $('<div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3"><div class="fst-italic fs-6">' + date + '</div><div class="fw-bolder mb-1">' + response.receiver.name + '</div>' + mess.content + '</div>');
                    }

                    messageDiv.append(imgDiv);
                    messageDiv.append(contentDiv);
                    chatMessagesDiv.append(messageDiv);
                }

                $('#container-chat').removeClass('d-none');
                if (window.innerWidth <= 768) {
                    if (!document.querySelector('#container-chat').classList.contains('d-none')) {
                        document.querySelector('#container-list-friend').classList.add('d-none');
                    }
                }


                if (receiverID < senderID) {
                    userId = receiverID + '' + senderID;
                } else {
                    userId = senderID + '' + receiverID;
                }

                ws = new WebSocket("ws://localhost:8080/SWP391_HappyJob_G1_/admin/message/" + userId);
                setupWebSocket();
                console.log("done");
                console.log(ws);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    }

    document.querySelector('.icon-arrow_back').addEventListener('click', function () {
        if (!document.querySelector('#container-chat').classList.contains('d-none')) {
            document.querySelector('#container-list-friend').classList.remove('d-none');
            document.querySelector('#container-chat').classList.add('d-none');
        }
    });



//    function postMessage(receiverId) {
//        var message = document.getElementById('content').value;
//        $.ajax({
//            url: "../admin/createMessage",
//            type: "GET",
//            data: {
//                message: message,
//                friendId: receiverId
//            }, dataType: 'json',
//            success: function (response) {
//                console.log(response.mess.content);
//                var chatMessagesDiv = $('.chat-messages');
//                   var timestamp = response.mess.timestamp; // giả sử "2024-02-02 02:00:28.417"
//                    var hourAndMinute = (timestamp.split(" ")[1]).substring(0, 5); // lấy phần "02:00:28.417"
//                    var date = timestamp.split(" ")[0];
//                var messageDiv;
//                if (response.mess.senderid === response.sender.accountID) {
//                    messageDiv = '<div class="chat-message-right pb-4">' +
//                            '<div><img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="You" width="40" height="40">' +
//                            '<div class="text-muted small text-nowrap mt-2">' + hourAndMinute + '</div></div>' +
//                            '<div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3">' +
//                            '<div class="fst-italic fs-6">' + date + '</div>' +
//                            '<div class="mb-1 fw-bolder">You</div>' + response.mess.content + '</div></div>';
//                } 
//                
//                if (response.mess.receiverid === response.sender.accountID) {
//                    messageDiv = '<div class="chat-message-left pb-4">' +
//                            '<div><img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="' + response.mess.nameFriend + '" width="40" height="40">' +
//                            '<div class="text-muted small text-nowrap mt-2">' + hourAndMinute + '</div></div>' +
//                            '<div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3">' +
//                            '<div class="fst-italic fs-6">' + date + '</div>' +
//                            '<div class="fw-bolder mb-1">' + response.mess.nameFriend + '</div>' + response.mess.content + '</div></div>';
//                }
//                chatMessagesDiv.append(messageDiv);
//                document.getElementById('content').value = ''; // Xóa nội dung tin nhắn đã gửi
//            },
//            error: function (jqXHR, textStatus, errorThrown) {
//                console.log(textStatus, errorThrown);
//            }
//        });
//    }



    var ws = new WebSocket("ws://localhost:8080/SWP391_HappyJob_G1_/admin/message/" + userId);

    ws.onopen = function () {
        // Connection is open

    };

    ws.onmessage = function (evt) {
        // Received a message from the server
        var chat = document.getElementById('chat-messages');
        console.log("onmessage");
        console.log(evt.data);

        chat.innerHTML += evt.data + '<br>';
    };

    ws.onclose = function () {
        // Connection is closed
    };

//    function postMessage() {
//        var msg = document.getElementById('content').value;
//        ws.send(msg);
//        document.getElementById('content').value = '';
//        return false;
//    }

    function postMessage(receiverId) {
        var message = document.getElementById('content').value;
        $.ajax({
            url: "../admin/createMessage",
            type: "GET",
            data: {
                message: message,
                friendId: receiverId
            }, dataType: 'json',
            success: function (response) {
                console.log(response.mess.content);
                var chatMessagesDiv = $('.chat-messages');
                var timestamp = response.mess.timestamp; // giả sử "2024-02-02 02:00:28.417"
                var hourAndMinute = (timestamp.split(" ")[1]).substring(0, 5); // lấy phần "02:00:28.417"
                var date = timestamp.split(" ")[0];
                var messageDiv;

                // Always append sent messages to 'chat-message-right'
                messageDiv = '<div class="chat-message-right pb-4">' +
                        '<div><img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="You" width="40" height="40">' +
                        '<div class="text-muted small text-nowrap mt-2">' + hourAndMinute + '</div></div>' +
                        '<div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3">' +
                        '<div class="fst-italic fs-6">' + date + '</div>' +
                        '<div class="mb-1 fw-bolder">You</div>' + response.mess.content + '</div></div>';
                chatMessagesDiv.append(messageDiv);

                // Prepare received messages but do not append to 'chat-message-left'
                messageDiv = '<div class="chat-message-left pb-4" id="left-mess-' + response.mess.id + '">' +
                        '<div><img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle mr-1" alt="' + response.mess.nameFriend + '" width="40" height="40">' +
                        '<div class="text-muted small text-nowrap mt-2">' + hourAndMinute + '</div></div>' +
                        '<div class="flex-shrink-1 bg-light rounded py-2 px-3 mr-3">' +
                        '<div class="fst-italic fs-6">' + date + '</div>' +
                        '<div class="fw-bolder mb-1">' + response.mess.nameFriend + '</div>' + response.mess.content + '</div></div>';
                ws.send(messageDiv);
                var check = 'left-mess-' + response.mess.id;

                document.getElementById('content').value = ''; // Xóa nội dung tin nhắn đã gửi
                document.getElementById(check).classList.add('d-none');
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus, errorThrown);
            }
        });
    }


    function setupWebSocket() {
        ws.onopen = function () {
            // Connection is open
        };

        ws.onmessage = function (evt) {
            // Received a message from the server
            var chat = document.getElementById('chat-messages');
            console.log(ws);
            console.log(evt.data);
            chat.innerHTML += evt.data + '<br>';
        };

        ws.onclose = function () {
            // Connection is closed
        };
    }



</script>
<%@include file="Footer.jsp" %>