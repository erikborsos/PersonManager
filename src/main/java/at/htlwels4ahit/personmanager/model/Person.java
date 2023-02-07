package at.htlwels4ahit.personmanager.model;

/**
 * Represents a model of a person.
 */
public class Person {

    /**
     * The `id` of the person.
     */
    private int id;

    /**
     * The name of the person.
     */
    private String name;

    /**
     * The `Address` of the person.
     */
    private Address address;

    /**
     * Constructs a new `Person` object with the specified `id`, `name`, and `address`.
     *
     * @param id        The ID of the person.
     * @param name      The name of the person.
     * @param address The address of the person.
     */
    public Person(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = new Address(id, address);
    }

    /**
     * Returns the `id` of the person.
     *
     * @return The `id` of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the `id` of the person.
     *
     * @param id The `id` of the person.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the `address` of the person.
     *
     * @return The `address` of the person.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the `address` of the person.
     *
     * @param address The `address` of the person.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
