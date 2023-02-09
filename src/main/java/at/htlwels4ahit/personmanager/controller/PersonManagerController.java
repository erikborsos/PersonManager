package at.htlwels4ahit.personmanager.controller;

import at.htlwels4ahit.personmanager.Main;
import at.htlwels4ahit.personmanager.model.Person;
import at.htlwels4ahit.personmanager.model.PersonCatalog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class PersonManagerController {

    @FXML
    private TextField id, name, address;

    @FXML
    private Button insert;

    @FXML
    private TableView<Person> tv;

    @FXML
    private void initialize() {

        // id only Integer
        id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                id.setText(newValue.replaceAll("\\D", ""));
            }
        });

        // insert button only active if all fields are filled
        insert.disableProperty().bind(
                id.textProperty().isEmpty()
                        .or(name.textProperty().isEmpty())
                        .or(address.textProperty().isEmpty())
        );

        // set the columns of the tableview
        tv.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tv.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tv.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        // bind the tableview to the list of persons
        tv.itemsProperty().bindBidirectional(PersonCatalog.getInstance().personList);


        try {
            PersonCatalog.getInstance().getPersons();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a Person to the schema
     */
    @FXML
    private void add() {
        try {
            PersonCatalog.getInstance().addPerson(Integer.parseInt(id.getText()), name.getText(), address.getText());
            PersonCatalog.getInstance().getPersons();
        } catch (SQLException e) {
            Main.error("Database error", "An error occurred while trying to add a person to the database.");
        }
        id.clear();
        name.clear();
        address.clear();
    }

    /**
     * Refreshes the person catalog from the database
     */
    @FXML
    private void refresh() {
        try {
            PersonCatalog.getInstance().getPersons();
        } catch (SQLException e) {
            Main.error("Database error", "An error occurred while trying to refresh the table.");
        }
    }
}