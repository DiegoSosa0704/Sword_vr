package model;

/**
 * Created by SOSA-PC on 1/10/2016.
 */
public class Specialist {

	private int id;
	private String name;
	private String lastName;
	private String position;
	private String email;

	public Specialist(int id, String name, String lastName, String position, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.email = email;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
