module com.project.periodental {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    //requires eu.hansolo.tilesfx;
    requires modelmapper;
    requires mysql.connector.java;
    requires io.activej.inject;
    requires io.activej.types;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.project.periodental to javafx.fxml;
    opens com.project.periodental.adapter.di.activej to io.activej.inject;
    exports com.project.periodental;
}