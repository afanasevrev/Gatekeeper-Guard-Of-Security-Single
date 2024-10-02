package com.alrosa.staa.gatekeeper_client_single.view;

import com.alrosa.staa.gatekeeper_client_single.GatekeeperClientApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Класс открывает форму для изменения данных пользователя
 */
public class UserEditPage {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GatekeeperClientApplication.class.getResource("user_edit_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Изменить данные пользователя");
        stage.setScene(scene);
        stage.show();
    }
}
