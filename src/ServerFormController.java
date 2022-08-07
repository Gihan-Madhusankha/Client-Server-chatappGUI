import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Gihan Madhusankha
 * 2022-08-06 11:03 PM
 **/

public class ServerFormController {

    final int PORT = 8000;
    ServerSocket serverSocket;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    void btnSendOnAction(ActionEvent event) {

    }

    public void initialize(){

        new Thread(()->{

            try {
                serverSocket = new ServerSocket(PORT);


            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }

}
