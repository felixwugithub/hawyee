module com.example.friendbookver1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.friendbookver1 to javafx.fxml;
    exports com.example.friendbookver1;
}