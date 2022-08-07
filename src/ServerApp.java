import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Gihan Madhusankha
 * 2022-08-06 11:03 PM
 **/

public class ServerApp {
    public static void main(String[] args) {

        final int PORT = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket localSocket = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
