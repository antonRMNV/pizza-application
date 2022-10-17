module com.example.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.app to javafx.fxml;
    exports com.example.app;
    exports com.example.app.db;
    opens com.example.app.db to javafx.fxml;
    exports com.example.app.model;
    opens com.example.app.model to javafx.fxml;
}