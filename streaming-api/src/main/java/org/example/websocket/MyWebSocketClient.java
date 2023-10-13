package org.example.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MyWebSocketClient extends WebSocketClient {
    private String apiKey;

    public MyWebSocketClient(URI serverUri, String apiKey) {
        super(serverUri);
        this.apiKey = apiKey;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connected to the WebSocket server.");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received a message: " + message);
        // Process the received data here
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connection closed.");
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void connect() {
        if (apiKey != null) {
            String authHeader = "Basic " + Base64.getEncoder().encodeToString((apiKey + ":").getBytes(StandardCharsets.UTF_8));
            this.addHeader("Authorization", authHeader);
        }
        super.connect();
    }
}
