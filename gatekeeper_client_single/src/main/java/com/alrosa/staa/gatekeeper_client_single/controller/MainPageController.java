package com.alrosa.staa.gatekeeper_client_single.controller;

import com.alrosa.staa.gatekeeper_client_single.data.UserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
public class MainPageController {
    @FXML
    private Button buttonUpdateUser = new Button();
    @FXML
    private Button buttonEditUser = new Button();
    @FXML
    private Button buttonAddUser = new Button();
    @FXML
    private Button buttonDeleteUser = new Button();
    @FXML
    private Button buttonOpenLogs = new Button();
    @FXML
    private TableView<UserData> tableViewUsers = new TableView<UserData>();
    private ObservableList<UserData> observableListUserData = FXCollections.<UserData>observableArrayList();
    @FXML
    private TableColumn<UserData, String> tableColumnUserId = new TableColumn<UserData, String>("ID");
    @FXML
    private TableColumn<UserData, String> tableColumnUserName = new TableColumn<UserData, String>("Полное имя");

}
