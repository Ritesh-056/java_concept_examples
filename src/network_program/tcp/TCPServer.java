package network_program.tcp;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started.");

            while (true) {
                // wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // create an input stream to read data from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // create an output stream to write data to the client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // read the request from the client
                String request = in.readLine();
                System.out.println("Client request: " + request);

                // send a response back to the client
                out.println("Hello, client!");

                // close the client socket and streams
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
