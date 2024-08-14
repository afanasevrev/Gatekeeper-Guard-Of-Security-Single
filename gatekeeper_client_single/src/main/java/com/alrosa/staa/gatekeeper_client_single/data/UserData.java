package com.alrosa.staa.gatekeeper_client_single.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Потребуется для заполнения таблицы пользователей
 */
public class UserData {
    public StringProperty id;
    public StringProperty fullName;
    public UserData() {}
    public UserData(String id, String fullName) {
        this.id = new SimpleStringProperty(this, "id", id);
        this.fullName = new SimpleStringProperty(this, "fullName", fullName);
    }
    public String getId() {
        return id.get();
    }
    public StringProperty idProperty() {
        return id;
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public String getFullName() {
        return fullName.get();
    }
    public StringProperty fullNameProperty() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }
}
