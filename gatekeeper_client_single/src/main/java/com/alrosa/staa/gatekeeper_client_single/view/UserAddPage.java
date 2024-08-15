package com.alrosa.staa.gatekeeper_client_single.view;

import com.alrosa.staa.gatekeeper_client_single.GatekeeperClientApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Класс - открывает форму для добавления пользователя
 */
public class UserAddPage {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GatekeeperClientApplication.class.getResource("user_add_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        stage.setTitle("Добавить пользователя");
        stage.setScene(scene);
        stage.show();
    }
}
