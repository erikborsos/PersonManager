
package at.htlwels4ahit.personmanager.model;

import at.htlwels4ahit.personmanager.Main;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class representing a catalog for storing information about people.
 */
public class PersonCatalog {

    private static PersonCatalog instance;

    /**
     * A list property to store a list of Person objects.
     */
    public ListProperty<Person> personList = new SimpleListProperty<>(FXCollections.observableArrayList(new ArrayList<>()));

    private PersonCatalog() {
    }

    /**
     * Returns the single instance of the class.
     *
     * @return The single instance of the class.
     */
    public static PersonCatalog getInstance() {
        if(instance == null) instance = new PersonCatalog();
        return instance;
    }

    /**
     * Adds a person to the database.
     *
     * @param id The ID of the person.
     * @param name The name of the person.
     * @param address The address of the person.
     * @throws SQLException If an SQL error occurs.
     */
    public void addPerson(int id, String name, String address) throws SQLException {
        PreparedStatement addPerson = Main.dbUtils.getConnection().prepareStatement("INSERT INTO PERSON (id, name) VALUES (?, ?)");
        addPerson.setInt(1, id);
        addPerson.setString(2, name);
        addPerson.executeUpdate();
        addPerson.close();

        PreparedStatement addAddress = Main.dbUtils.getConnection().prepareStatement("INSERT INTO ADRESSE (id, wohnort) VALUES (?, ?)");
        addAddress.setInt(1, id);
        addAddress.setString(2, address);
        addAddress.executeUpdate();
        addAddress.close();
    }

    /**
     * Retrieves all the persons from the database and adds them to the personList property.
     *
     * @throws SQLException If an SQL error occurs.
     */
    public void getPersons() throws SQLException {
        personList.removeIf(person -> true);
        PreparedStatement getPersons = Main.dbUtils.getConnection().prepareStatement("SELECT ID, NAME, WOHNORT FROM PERSON JOIN ADRESSE USING(ID) ORDER BY ID");
        ResultSet rs = getPersons.executeQuery();

        while(rs.next()) {
            Person person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("wohnort"));
            personList.add(person);
        }

        getPersons.close();
    }
}
