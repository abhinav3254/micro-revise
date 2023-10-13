package org.example;


import org.example.websocket.MyWebSocketClient;

import java.net.URI;


public class Main {
    public static void main(String[] args) {
        String serverURI = "wss://stream.companieshouse.gov.uk/charges";
        String apiKey = "api-key";
        MyWebSocketClient client = new MyWebSocketClient(URI.create(serverURI), apiKey);

        try {
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
