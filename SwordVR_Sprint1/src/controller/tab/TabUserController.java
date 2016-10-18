package controller.tab;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Clase controladora de la vista TabUser.fxml. Realiza el login de
 * especialistas.
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:12 p. m.
 */
public class TabUserController {

	@FXML
	private Button btnSubmit;
	@FXML
	private Label lblPass;
	@FXML
	private Label lblUser;
	@FXML
	private PasswordField txtPass;
	@FXML
	private TextField txtUser;
	private MainController mainController;

	/**
	 * Metodo que relaciona la clase MainController.
	 * 
	 * @param mainController
	 */
	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	/**
	 * @return the btnSubmit
	 */
	public Button getBtnSubmit() {
		return btnSubmit;
	}

	/**
	 * @param btnSubmit
	 *            the btnSubmit to set
	 */
	public void setBtnSubmit(Button btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	/**
	 * @return the lblPass
	 */
	public Label getLblPass() {
		return lblPass;
	}

	/**
	 * @param lblPass
	 *            the lblPass to set
	 */
	public void setLblPass(Label lblPass) {
		this.lblPass = lblPass;
	}

	/**
	 * @return the lblUser
	 */
	public Label getLblUser() {
		return lblUser;
	}

	/**
	 * @param lblUser
	 *            the lblUser to set
	 */
	public void setLblUser(Label lblUser) {
		this.lblUser = lblUser;
	}

	/**
	 * @return the mainController
	 */
	public MainController getMainController() {
		return mainController;
	}

	/**
	 * @param mainController
	 *            the mainController to set
	 */
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	/**
	 * @return the txtPass
	 */
	public PasswordField getTxtPass() {
		return txtPass;
	}

	/**
	 * @param txtPass
	 *            the txtPass to set
	 */
	public void setTxtPass(PasswordField txtPass) {
		this.txtPass = txtPass;
	}

	/**
	 * @return the txtUser
	 */
	public TextField getTxtUser() {
		return txtUser;
	}

	/**
	 * @param txtUser
	 *            the txtUser to set
	 */
	public void setTxtUser(TextField txtUser) {
		this.txtUser = txtUser;
	}

}// end TabUserController