package studentmanagementsystem;

/**
 * Abstract class representing a general Person in the system.
 * This class applies Abstract Classes and Encapsulation concepts.
 */
public abstract class Person {
    // Attributes encapsulated using private access modifier
    private int id;
    private String name;
    private String email;

    // Constructor to initialize properties
    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters for Encapsulation
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}