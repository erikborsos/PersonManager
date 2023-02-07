package at.htlwels4ahit.personmanager.model;

/**
 * Represents a model of an address.
 */
public class Address {

    /**
     * The `id` of the address.
     */
    private int id;

    /**
     * The name of the address.
     */
    private String address;

    /**
     * Constructs a new `Address` object with the specified `id` and `address` name.
     *
     * @param id        The ID of the address.
     * @param address The name of the address.
     */
    public Address(int id, String address) {
        this.id = id;
        this.address = address;
    }

    /**
     * Returns the `id` of the address.
     *
     * @return The `id` of the address.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the `id` of the address.
     *
     * @param id The `id` of the address.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the address.
     *
     * @return The name of the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the name of the address.
     *
     * @param address The name of the address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a string representation of the address.
     *
     * @return A string representation of the address.
     */
    @Override
    public String toString() {
        return address;
    }
}
