package com.alrosa.staa.gatekeeper_client_single.view;

import com.alrosa.staa.gatekeeper_client_single.GatekeeperClientApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class UserDeletePage {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GatekeeperClientApplication.class.getResource("user_delete_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 200);
        stage.setTitle("Удалить пользователя");
        stage.setScene(scene);
        stage.show();
    }
}
