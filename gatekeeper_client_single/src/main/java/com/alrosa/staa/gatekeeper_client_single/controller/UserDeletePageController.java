package com.alrosa.staa.gatekeeper_client_single.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserDeletePageController {
    @FXML
    private Button buttonDelete = new Button();
    @FXML
    private Button buttonCancel = new Button();
    @FXML
    private void setButtonDelete() {

    }
    @FXML
    private void setButtonCancel() {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
}
