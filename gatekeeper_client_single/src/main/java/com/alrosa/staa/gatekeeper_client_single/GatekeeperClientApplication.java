package com.alrosa.staa.gatekeeper_client_single;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import java.io.IOException;
/**
 * Точка входа в приложение
 */
public class GatekeeperClientApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GatekeeperClientApplication.class.getResource("main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        stage.setTitle("Главная страница");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        BasicConfigurator.configure();
        launch();
    }
}