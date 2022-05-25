module BananeProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires org.apache.commons.io;
    requires com.github.oshi;
    requires json.simple;


    opens controllers;
}