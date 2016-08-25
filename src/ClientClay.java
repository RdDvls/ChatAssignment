import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by RdDvls on 8/25/16.
 */
public class ClientClay {
    public static void main(String[] args) {
        System.out.println("Running client...");
        try{
            Socket clientSocket = new Socket("localhost", 8005);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Destroy all humans");
            String serverResponse = in.readLine();
            clientSocket.close();
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
