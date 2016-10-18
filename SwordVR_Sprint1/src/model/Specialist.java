package model;

/**
 * Clase con atributos del Especialista
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:11 p. m.
 */
public class Specialist {

	private int id;
	private String name;
	private String lastName;
	private String position;
	private String email;

	/**
	 * @param id
	 * @param name
	 * @param lastName
	 * @param position
	 * @param email
	 */
	public Specialist(int id, String name, String lastName, String position, String email) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}// end Specialist