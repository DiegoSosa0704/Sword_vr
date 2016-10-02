package logic;

/**
 * Created by SOSA-PC on 1/10/2016.
 */
public class Specialist {

    private String id;
    private String name;
    private String lastName;
    private String position;
    private String email;

    public Specialist(String id, String name, String lastName, String position, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
