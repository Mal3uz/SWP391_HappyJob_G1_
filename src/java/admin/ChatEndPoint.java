/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

/**
 *
 * @author DELL
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.AdminDAO;
import entity.Account;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@ServerEndpoint(value = "/admin/message")
@ServerEndpoint(value = "/admin/message/{roomId}")
public class ChatEndPoint {
     private static final ConcurrentHashMap<String, Set<Session>> roomSessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId) {
        roomSessions.computeIfAbsent(roomId, k -> ConcurrentHashMap.newKeySet()).add(session);
    }

//    @OnMessage
//    public void onMessage(String message, @PathParam("roomId") String roomId) throws IOException {
//        Set<Session> sessions = roomSessions.get(roomId);
//        if (sessions != null) {
//            for (Session session : sessions) {
//                if (session.isOpen()) {
//                    session.getBasicRemote().sendText(message);
//                }
//            }
//        }
//    }
    @OnMessage
public void onMessage(String message, @PathParam("roomId") String roomId, Session clientSession) throws IOException {
    Set<Session> sessions = roomSessions.get(roomId);
    if (sessions != null) {
        for (Session session : sessions) {
            if (session.isOpen() && !session.equals(clientSession)) { // Kiểm tra xem session có phải là của người gửi hay không
                session.getBasicRemote().sendText(message);
            }
        }
    }
}

    @OnClose
    public void onClose(Session session, @PathParam("roomId") String roomId) {
        Set<Session> sessions = roomSessions.get(roomId);
        if (sessions != null) {
            sessions.remove(session);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Handle error
    }
}
