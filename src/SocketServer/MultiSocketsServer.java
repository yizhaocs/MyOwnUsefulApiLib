package SocketServer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by yizhao on 12/17/14.
 */
public class MultiSocketsServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4444;

        try {
            boolean listening = true;
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (listening) {
                new MultiSocketsServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}