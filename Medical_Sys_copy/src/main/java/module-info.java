module com.example.amir {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.amir to javafx.fxml;
    exports com.example.amir;
}