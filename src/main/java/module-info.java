module com.example.projectsoftware {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires java.desktop;
    requires postgresql;
    requires javafx.swing;
    requires jasperreports;

    opens com.example.projectsoftware to javafx.fxml;
    exports com.example.projectsoftware;
}