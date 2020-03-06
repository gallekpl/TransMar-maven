module pl.transmar {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.transmar to javafx.fxml;
    exports pl.transmar;
}