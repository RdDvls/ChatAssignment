import com.tiy.networking.ConnectionHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by RdDvls on 8/25/16.
 */
public class Server {
    public void startServer(){
        try {
            System.out.println("Starting server...");


            ServerSocket serverListener = new ServerSocket(8005);
            System.out.println("Listener ready to accept connections");
            while (true) {
                Socket clientSocket = serverListener.accept();//accepts new connection
                System.out.println("Incoming message from: " + clientSocket.getInetAddress().getHostAddress());
                ConnectionHandler handler = new ConnectionHandler(clientSocket);
                Thread handlerThread = new Thread(handler);
                handlerThread.start();
            }
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }

}
//  while (true){
//          ConnectionHandler handler = new ConnectionHandler(clientSocket);
//          Thread handlerThread = new Thread(handler);
//          handlerThread.start();
////
//          }