package com.alrosa.staa.gatekeeper_client_single.controller;

import com.alrosa.staa.gatekeeper_client_single.Variables;
import com.alrosa.staa.gatekeeper_client_single.request.UserRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
/**
 * Контроллер для работы с формой добавить пользователя
 */
public class UserAddPageController {
    private final Logger logger = Logger.getLogger(UserAddPageController.class);
    private final String url = "http://" + Variables.server_ip + ":" + Variables.server_port;
    private final RestTemplate restTemplate = new RestTemplate();
    private final FileChooser fileChooser = new FileChooser();
    private File file;
    private byte[] userPhoto = null;
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
            if (userPhoto != null) {
                userRequest.setUserPhoto(userPhoto);
            }
            HttpEntity<UserRequest> request = new HttpEntity<UserRequest>(userRequest, headers);
            ResponseEntity<UserRequest> response = restTemplate.exchange(url + "/setUser", HttpMethod.POST, request, UserRequest.class);
            logger.info(response.getBody().getStatus());
            Stage stage = (Stage) buttonAddUser.getScene().getWindow();
            stage.close();
        } else {
            logger.info("Заполните все поля");
        }
    }
    @FXML
    private Button buttonLoadPhoto = new Button();
    /**
     * При нажатии кнопки, выбираем и загружаем фото на ImageView
     */
    @FXML
    private void setButtonLoadPhoto() {
        fileChooser.setTitle("Выберите файл");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG Files", "*.jpg", "*.jpeg", "*.png"));
        file = fileChooser.showOpenDialog(new Stage());
        try {
            //Image image = new Image(String.valueOf(file));
            Image image = new Image(file.toURI().toString());
            imageViewUserPhoto.setPreserveRatio(true);
            imageViewUserPhoto.setImage(image);
            userPhoto = imageByteToArray(file);
        } catch (IllegalArgumentException e) {
            logger.info(e);
            userPhoto = null;
        }
    }
    /**
     * Метод проверяет, все ли поля заполнены
     * @return boolean
     */
    private boolean isEmptyFields() {
        return textFieldFirstName.getText().isEmpty() ||
                textFieldMiddleName.getText().isEmpty() ||
                textFieldLastName.getText().isEmpty() ||
                textFieldCompany.getText().isEmpty() ||
                textFieldCardId.getText().isEmpty();
    }
    /**
     * Метод превращает File в массив байт
     * @return byte[]
     */
    private byte[] imageByteToArray(File file) {
        try {
            // Чтение всего содержимого файла в массив байтов
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            logger.error(e);
            return null;
        }
    }
}
