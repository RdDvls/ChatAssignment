import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * Created by RdDvls on 8/25/16.
 */
public class AssignmentClient {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int messageCounter = 0;
        //String name = "Clay ";
        System.out.println("Running client...");
        //String testOutput ="Test string";
        try {
            Socket clientSocket = new Socket("10.0.0134", 8005);
            PrintWriter outFromServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Please enter your first name:");
            String name = inputScanner.nextLine();
            outFromServer.println("name = " + name);

            while(true){
                if(messageCounter == 0){
                    //System.out.println("Enter message:");
                    //String message = inputScanner.nextLine();
                   outFromServer.println("Thank you " + name + "!");
                   messageCounter++;
                }else{
                    System.out.println("Enter message:");
                    String message = inputScanner.nextLine();
                    outFromServer.println(name + " says: " + message);
                    String serverResponse = inputFromServer.readLine();
                    System.out.println("Would you like to send another message? y/n");
                    String userResponse = inputScanner.nextLine();
                    messageCounter++;
                    if(userResponse.equalsIgnoreCase("n")){
                        break;
                    }

                }
            }
//            out.println("name= " + name);// sent to server; read by server
//            String serverResponse = in.readLine();
            clientSocket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}

