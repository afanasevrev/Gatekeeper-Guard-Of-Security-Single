module com.alrosa.staa.gatekeeper_client_single {
    requires javafx.controls;
    requires javafx.fxml;
    requires log4j;
    requires spring.web;
    requires static lombok;
    requires java.logging;
    requires spring.core;
    opens com.alrosa.staa.gatekeeper_client_single to javafx.fxml;
    exports com.alrosa.staa.gatekeeper_client_single;
    exports com.alrosa.staa.gatekeeper_client_single.controller;
}