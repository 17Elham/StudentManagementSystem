package studentmanagementsystem;

/**
 * Abstract class representing a general Person in the system.
 * This class applies Abstract Classes and Encapsulation concepts.
 */
public abstract class Person {
    // Attributes encapsulated using private access modifier
    private int id;//Unique identifier for the person
    private String name; // Full name of the person
    private String email;
    
/**
 * Initializes a new Person object with the specified details.
 * 
 * @param id The unique identification number.
 * @param name The name of the person.
 * @param email The contact email address.
 */
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
    public abstract void displayDetails();
}