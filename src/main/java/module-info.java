module pl.transmar {
    requires javafx.controls;
    requires javafx.fxml;
    requires jpro.webapi;

    opens pl.transmar to javafx.fxml;
    exports pl.transmar;
}