module com.alrosa.staa.gatekeeper_client_single {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires spring.web;
    requires static lombok;
    requires spring.core;
    requires java.logging;
    requires java.desktop;
    opens com.alrosa.staa.gatekeeper_client_single to javafx.fxml;
    opens com.alrosa.staa.gatekeeper_client_single.controller to javafx.fxml;
    opens com.alrosa.staa.gatekeeper_client_single.view to javafx.fxml;
    exports com.alrosa.staa.gatekeeper_client_single;
    exports com.alrosa.staa.gatekeeper_client_single.controller;
    exports com.alrosa.staa.gatekeeper_client_single.view;
    exports com.alrosa.staa.gatekeeper_client_single.request;
    exports com.alrosa.staa.gatekeeper_client_single.data;
}