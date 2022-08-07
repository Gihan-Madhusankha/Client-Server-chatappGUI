import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author : Gihan Madhusankha
 * 2022-08-06 11:03 PM
 **/

public class ServerApp {
    public static void main(String[] args) {

        final int PORT = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
