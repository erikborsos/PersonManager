module at.htlwels4ahit.personmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens at.htlwels4ahit.personmanager to javafx.fxml;
    exports at.htlwels4ahit.personmanager;
    exports at.htlwels4ahit.personmanager.controller;
    opens at.htlwels4ahit.personmanager.controller to javafx.fxml;
}