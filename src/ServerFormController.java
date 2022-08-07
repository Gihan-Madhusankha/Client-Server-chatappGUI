import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Gihan Madhusankha
 * 2022-08-06 11:03 PM
 **/

public class ServerFormController {

    final int PORT = 8000;
    ServerSocket serverSocket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        String reply = textField.getText();
        dataOutputStream.writeUTF(reply);
        textArea.appendText("You : " + reply + "\n");
        dataOutputStream.flush();
    }

    public void initialize() {

        new Thread(() -> {

            try {
                textArea.setEditable(false);

                serverSocket = new ServerSocket(PORT);
                textArea.appendText("Server is running...\n");
                Socket localSocket = serverSocket.accept();
                textArea.appendText("Accepted the client\n\n");

                dataInputStream = new DataInputStream(localSocket.getInputStream());
                dataOutputStream = new DataOutputStream(localSocket.getOutputStream());

                bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                String message = "";

                while (!message.equals("exit")) {
                    message = dataInputStream.readUTF();
                    textArea.appendText("Client : " + message + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();

    }

}
