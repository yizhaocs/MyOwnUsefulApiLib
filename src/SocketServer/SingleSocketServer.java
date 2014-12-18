package SocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yizhao on 12/17/14.
 */
public class SingleSocketServer {
    public static void main(String[] args) throws IOException {
        int portNumber = 4444;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            out.println("connection is setup between server and client");

            while ((inputLine = in.readLine()) != null) {
                out.println("echo " + inputLine);
                if (inputLine.equals("Bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
