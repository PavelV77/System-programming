module com.example.sispro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.compiler;
    requires BusLogic;
    requires LowFunction;
    requires java.naming;
    requires org.hibernate.commons.annotations;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires mysql.connector.j;


    opens mainpackage to javafx.fxml;
    exports mainpackage;

    opens models to javafx.fxml;
    exports models;

    exports hibernatepackage;
    opens hibernatepackage to java.logging;

    exports recordspackage;
    opens recordspackage to javafx.fxml;
}