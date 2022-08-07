import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

/**
 * @author : Gihan Madhusankha
 * 2022-08-06 11:03 PM
 **/

public class ClientFormController {

    final int PORT = 8000;
    Socket socket;
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
        dataOutputStream.flush();
    }

    public void initialize() {

        new Thread(() -> {

            try {
                socket = new Socket("localhost", PORT);

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                String message = "";

                while (!message.equals("exit")) {
                    message = dataInputStream.readUTF();
                    textArea.appendText("Server : " + message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

}
