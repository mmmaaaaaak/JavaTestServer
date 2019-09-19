/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatestserver;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Mark Masone
 */
public class JavaTestServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while(true) {
            try(ServerSocket serverSocket = new ServerSocket(12345)) {
                System.out.println("listening for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected.");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("waiting for messages...");
                while(true) {
                    System.out.println("message: " + in.readLine());
                }
            } catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
}
