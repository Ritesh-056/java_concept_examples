package network_program.tcp;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // define the host and port to connect to
            String host = "localhost";
            int port = 8000;

            // create a socket
            Socket socket = new Socket(host, port);

            // create an input stream to read data from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // create an output stream to write data to the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // send a message to the server
            out.println("Hello, server!");

            // read the response from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // close the socket and streams
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
