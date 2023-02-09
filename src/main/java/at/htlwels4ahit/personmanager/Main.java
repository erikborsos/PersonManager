package at.htlwels4ahit.personmanager;

import at.htlwels4ahit.personmanager.utils.DBUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static String error = "";
    @Override
    public void start(Stage stage) throws IOException {
        if(!error.isEmpty()) {
            error("Database Error.", error);
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/personManagerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PersonManager");
        stage.setScene(scene);
        stage.show();
    }

    public static DBUtils dbUtils;

    public static void main(String[] args) {
        dbUtils = new DBUtils("jdbc:derby://localhost:1527/B_Uebung", "B_Uebung", "B_Uebung");
        // Create connection
        try {
            dbUtils.open();

            // Check if tables exist
            if(!dbUtils.tableExists("PERSON") || !dbUtils.tableExists("ADRESSE")) {
                error = "The database is not set up correctly. Try running the setup script.";
            }

        } catch (Exception e) {
            error = "Could not connect to the database.";
        }
        launch();
    }

    /**
     * Shows an error dialog.
     * @param header The header text.
     * @param message The message text.
     */
    public static void error(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}