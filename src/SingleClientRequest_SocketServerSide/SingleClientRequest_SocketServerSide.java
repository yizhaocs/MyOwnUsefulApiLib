package SingleClientRequest_SocketServerSide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yizhao on 12/16/14.
 */
public class SingleClientRequest_SocketServerSide {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java KnockKnockServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try {
            /*
            * The server program begins by creating a new ServerSocket object to listen on a specific port (see the statement in bold in the following code segment).
            * When running this server, choose a port that is not already dedicated to some other service.
            * */
            ServerSocket serverSocket = new ServerSocket(portNumber);
            /*
            * If the server successfully binds to its port, then the ServerSocket object is successfully created and the server continues to the next step—accepting a connection from a client.
            * The accept method waits until a client starts up and requests a connection on the host and port of this server.
            *  In this example, the server is running on the port number specified by the first command-line argument.
            *  When a connection is requested and successfully established, the accept method returns a new Socket object which is bound to the same local port and has its remote address and remote port set to that of the client.
            *  The server can communicate with the client over this new Socket and continue to listen for client connection requests on the original ServerSocket.
            * */
            Socket clientSocket = serverSocket.accept();
            /* Gets the socket's input and output stream and opens readers and writers on them.*/
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;

            /* Initiates communication with the client by writing to the socket with simple conversation.*/
            SingleClientRequest_SocketServerProtocol kkp = new SingleClientRequest_SocketServerProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            /* Communicates with the client by reading from and writing to the socket (the while loop).*/
            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye.")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
