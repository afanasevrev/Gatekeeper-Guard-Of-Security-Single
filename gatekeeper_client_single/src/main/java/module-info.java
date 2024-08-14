module com.alrosa.staa.gatekeeper_client_single {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alrosa.staa.gatekeeper_client_single to javafx.fxml;
    exports com.alrosa.staa.gatekeeper_client_single;
}