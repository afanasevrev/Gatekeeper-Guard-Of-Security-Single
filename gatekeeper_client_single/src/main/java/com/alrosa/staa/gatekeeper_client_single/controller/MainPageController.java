package com.alrosa.staa.gatekeeper_client_single.controller;

import com.alrosa.staa.gatekeeper_client_single.Variables;
import com.alrosa.staa.gatekeeper_client_single.data.UserFullName;
import com.alrosa.staa.gatekeeper_client_single.data.UserData;
import com.alrosa.staa.gatekeeper_client_single.view.UserAddPage;
import com.alrosa.staa.gatekeeper_client_single.view.UserDeletePage;
import com.alrosa.staa.gatekeeper_client_single.view.UserEditPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/**
 * Контроллер для главной страницы
 */
public class MainPageController implements Initializable {
    private final Logger logger = Logger.getLogger(MainPageController.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://" + Variables.server_ip + ":" + Variables.server_port;
    private final Stage stage = new Stage();
    private final UserAddPage userAddPage = new UserAddPage();
    private final UserDeletePage userDeletePage = new UserDeletePage();
    private final UserEditPage userEditPage = new UserEditPage();
    @FXML
    private Button buttonUpdateUser = new Button();
    @FXML
    private void setButtonUpdateUser() {
        observableListUserData.clear();
        ResponseEntity<List<UserFullName>> response = null;
        try {
            response = restTemplate.exchange(url + "/getUsers", HttpMethod.GET, null, new ParameterizedTypeReference<List<UserFullName>>(){});
            List<UserFullName> users = response.getBody();
            assert users != null;
            for(UserFullName user: users) {
                observableListUserData.add(new UserData(String.valueOf(user.getId()), user.getFullName()));
            }
        } catch (RuntimeException e) {
            logger.error(e);
        }
    }
    @FXML
    private Button buttonEditUser = new Button();
    @FXML
    private void setButtonEditUser() throws IOException {
        userEditPage.start(stage);
    }
    @FXML
    private Button buttonAddUser = new Button();
    @FXML
    private void setButtonAddUser() throws IOException {
        userAddPage.start(stage);
    }
    @FXML
    private Button buttonDeleteUser = new Button();
    @FXML
    private void setButtonDeleteUser() throws IOException {
        userDeletePage.start(stage);
    }
    @FXML
    private Button buttonOpenLogs = new Button();
    @FXML
    private TableView<UserData> tableViewUsers = new TableView<UserData>();
    private final ObservableList<UserData> observableListUserData = FXCollections.<UserData>observableArrayList();
    @FXML
    private TableColumn<UserData, String> tableColumnUserId = new TableColumn<UserData, String>("ID");
    @FXML
    private TableColumn<UserData, String> tableColumnUserName = new TableColumn<UserData, String>("Полное имя");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewUsers.setItems(observableListUserData);
        tableColumnUserId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        tableColumnUserName.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
    }
}
