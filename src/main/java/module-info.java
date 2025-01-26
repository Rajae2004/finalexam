module com.example.testfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.testfinal to javafx.fxml;
    exports com.example.testfinal;
}