package com.alrosa.staa.gatekeeper_client_single.controller;

import com.alrosa.staa.gatekeeper_client_single.Variables;
import com.alrosa.staa.gatekeeper_client_single.request.UserRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;
/**
 * Контроллер для работы с формой добавить пользователя
 */
public class UserAddPageController {
    private final Logger logger = Logger.getLogger(UserAddPageController.class);
    private final String url = "http://" + Variables.server_ip + ":" + Variables.server_port;
    private final RestTemplate restTemplate = new RestTemplate();
    @FXML
    private ImageView imageViewUserPhoto = new ImageView();
    @FXML
    private TextField textFieldFirstName = new TextField();
    @FXML
    private TextField textFieldMiddleName = new TextField();
    @FXML
    private TextField textFieldLastName = new TextField();
    @FXML
    private TextField textFieldCompany = new TextField();
    @FXML
    private TextField textFieldCardId = new TextField();
    @FXML
    private Button buttonAddUser = new Button();
    /**
     * При нажатии кнопки отправляем на сервер
     * POST - запрос о добавлении пользователя в систему
     */
    @FXML
    private void setButtonAddUser() {
        if (!isEmptyFields()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            UserRequest userRequest = new UserRequest(textFieldFirstName.getText(), textFieldMiddleName.getText(), textFieldLastName.getText(), textFieldCompany.getText(), textFieldCardId.getText());
            HttpEntity<UserRequest> request = new HttpEntity<UserRequest>(userRequest, headers);
            ResponseEntity<UserRequest> response = restTemplate.exchange(url + "/setUser", HttpMethod.POST, request, UserRequest.class);
            logger.info(response.getBody());
        } else {
            logger.info("Заполните все поля");
        }
    }
    @FXML
    private Button buttonLoadPhoto = new Button();
    /**
     * Метод проверяет, все ли поля заполнены
     * @return boolean
     */
    private boolean isEmptyFields() {
        if (textFieldFirstName.getText().isEmpty()      ||
                textFieldMiddleName.getText().isEmpty() ||
                textFieldLastName.getText().isEmpty()   ||
                textFieldCompany.getText().isEmpty()    ||
                textFieldCardId.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
