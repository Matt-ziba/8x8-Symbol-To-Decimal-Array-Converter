module com.converter_8x8.arrayconverter_8x8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.converter_8x8.arrayconverter_8x8 to javafx.fxml;
    exports com.converter_8x8.arrayconverter_8x8;
}