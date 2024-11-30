module ma.chat.tp5poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens ma.chat.tp5poo to javafx.fxml;
    exports ma.chat.tp5poo;
    exports ma.chat.tp5poo.model;
    opens ma.chat.tp5poo.model to javafx.fxml;
    exports ma.chat.tp5poo.dao;
    opens ma.chat.tp5poo.dao to javafx.fxml;
    exports ma.chat.tp5poo.controller;
    opens ma.chat.tp5poo.controller to javafx.fxml;
    exports ma.chat.tp5poo.metier;
    opens ma.chat.tp5poo.metier to javafx.fxml;


}