package controller.tab;

import java.io.IOException;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.db.ConnectionTableAdmin;

/**
 * Clase controladora de la vista TabAdmin.fxml. Realiza el login de
 * administradores.
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:12 p. m.
 */
public class TabAdminController {

	@FXML
	private Button btnSubmitAdmin;
	@FXML
	private Label lblAdmin;
	@FXML
	private Label lblPassAdmin;
	@FXML
	private TextField txtAdmin;
	@FXML
	private PasswordField txtPassAdmin;
	private MainController mainController;
	private ConnectionTableAdmin tableAdmin;

	/**
	 * Metodo que relaciona la clase MainController.
	 * 
	 * @param mainController
	 * @param tableAdmin
	 */
	public void init(MainController mainController, ConnectionTableAdmin tableAdmin) {
		this.mainController = mainController;
		this.tableAdmin = tableAdmin;
	}

	/**
	 * Metodo que realiza la funci�n del bot�n Ingresar para el administrador.
	 * 
	 * @param event
	 * @exception IOException
	 */
	@FXML
	public void loginAdmin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/loginAdmin/AdminSpecialist.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		if (validateLogin()) {
			stage.setTitle("Administrar Especialistas");
			stage.setScene(scene);
			stage.show();
		}
	}

	/**
	 * Metodo que valida los datos ingresado con los existentes en la base de
	 * datos para aceptar un usuario administrador.
	 */
	public boolean validateLogin() {
		boolean flag = false;
		if (tableAdmin.searchAdmin(txtAdmin.getText()) && tableAdmin.searchPass(txtPassAdmin.getText())) {
			flag = true;
		}
		return flag;
	}

	/**
	 * @return the btnSubmitAdmin
	 */
	public Button getBtnSubmitAdmin() {
		return btnSubmitAdmin;
	}

	/**
	 * @param btnSubmitAdmin
	 *            the btnSubmitAdmin to set
	 */
	public void setBtnSubmitAdmin(Button btnSubmitAdmin) {
		this.btnSubmitAdmin = btnSubmitAdmin;
	}

	/**
	 * @return the lblAdmin
	 */
	public Label getLblAdmin() {
		return lblAdmin;
	}

	/**
	 * @param lblAdmin
	 *            the lblAdmin to set
	 */
	public void setLblAdmin(Label lblAdmin) {
		this.lblAdmin = lblAdmin;
	}

	/**
	 * @return the lblPassAdmin
	 */
	public Label getLblPassAdmin() {
		return lblPassAdmin;
	}

	/**
	 * @param lblPassAdmin
	 *            the lblPassAdmin to set
	 */
	public void setLblPassAdmin(Label lblPassAdmin) {
		this.lblPassAdmin = lblPassAdmin;
	}

	/**
	 * @return the txtAdmin
	 */
	public TextField getTxtAdmin() {
		return txtAdmin;
	}

	/**
	 * @param txtAdmin
	 *            the txtAdmin to set
	 */
	public void setTxtAdmin(TextField txtAdmin) {
		this.txtAdmin = txtAdmin;
	}

	/**
	 * @return the txtPassAdmin
	 */
	public PasswordField getTxtPassAdmin() {
		return txtPassAdmin;
	}

	/**
	 * @param txtPassAdmin
	 *            the txtPassAdmin to set
	 */
	public void setTxtPassAdmin(PasswordField txtPassAdmin) {
		this.txtPassAdmin = txtPassAdmin;
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
	 * @return the tableAdmin
	 */
	public ConnectionTableAdmin getTableAdmin() {
		return tableAdmin;
	}

	/**
	 * @param tableAdmin
	 *            the tableAdmin to set
	 */
	public void setTableAdmin(ConnectionTableAdmin tableAdmin) {
		this.tableAdmin = tableAdmin;
	}

}// end TabAdminController