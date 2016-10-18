package controller.adminSpecialist;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Specialist;
import model.db.ConnectionTableAdmin;

/**
 * Clase que crea un Dialog para editar especialistas de la base de datos.
 * Controlador de la vista EditSpecialist.fxml
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:11 p. m.
 */
public class EditSpecialistController extends Stage implements Initializable {

	private AdminSpecialistController adminSpecialistController;
	private Specialist specialist;
	private ConnectionTableAdmin tableAdmin;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtName;
	@FXML
	private PasswordField txtPasswordSpecialist;
	@FXML
	private TextField txtPosition;

	/**
	 * Constructor de la clase.
	 * 
	 * @param specialist
	 * @param tableAdmin
	 * @param adminSpecialistController
	 * @exception Exception
	 */
	public EditSpecialistController(Specialist specialist, ConnectionTableAdmin tableAdmin,
			AdminSpecialistController adminSpecialistController) throws Exception {
		this.adminSpecialistController = adminSpecialistController;
		this.specialist = specialist;
		this.tableAdmin = tableAdmin;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/loginAdmin/EditSpecialist.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		this.setTitle("Edición de especialistas");
		this.setResizable(false);
		this.initModality(Modality.APPLICATION_MODAL); // Evista cambiar de
		this.setScene(scene);
	}

	/**
	 * Metodo que cierra el Dialog generado por la clase.
	 * 
	 * @param event
	 */
	@FXML
	public void cancelEditSpecialist(ActionEvent event) {
		this.close();
	}

	/**
	 * Metodo que realiza la funci�n del bot�n Editar. Edita datos del
	 * especialista seleccionado.
	 * 
	 * @param event
	 */
	@FXML
	public void editSpecialist(ActionEvent event) {
		tableAdmin.updateSpecialist(specialist.getId(), txtName.getText(), txtLastName.getText(), txtPosition.getText(),
				txtPasswordSpecialist.getText(), txtEmail.getText());
		tableAdmin.getQuerySpecialists(adminSpecialistController.getListaSpecialist());
		this.close();
	}

	/**
	 * Inicializa el controlador despu�s de que su elemento ra�z ha sido
	 * completamente procesado.
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtName.setText(specialist.getName());
		txtLastName.setText(specialist.getLastName());
		txtPosition.setText(specialist.getPosition());
		txtEmail.setText(specialist.getEmail());
	}

	/**
	 * @return the adminSpecialistController
	 */
	public AdminSpecialistController getAdminSpecialistController() {
		return adminSpecialistController;
	}

	/**
	 * @param adminSpecialistController the adminSpecialistController to set
	 */
	public void setAdminSpecialistController(AdminSpecialistController adminSpecialistController) {
		this.adminSpecialistController = adminSpecialistController;
	}

	/**
	 * @return the specialist
	 */
	public Specialist getSpecialist() {
		return specialist;
	}

	/**
	 * @param specialist the specialist to set
	 */
	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	/**
	 * @return the tableAdmin
	 */
	public ConnectionTableAdmin getTableAdmin() {
		return tableAdmin;
	}

	/**
	 * @param tableAdmin the tableAdmin to set
	 */
	public void setTableAdmin(ConnectionTableAdmin tableAdmin) {
		this.tableAdmin = tableAdmin;
	}

	/**
	 * @return the txtEmail
	 */
	public TextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail the txtEmail to set
	 */
	public void setTxtEmail(TextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**
	 * @return the txtLastName
	 */
	public TextField getTxtLastName() {
		return txtLastName;
	}

	/**
	 * @param txtLastName the txtLastName to set
	 */
	public void setTxtLastName(TextField txtLastName) {
		this.txtLastName = txtLastName;
	}

	/**
	 * @return the txtName
	 */
	public TextField getTxtName() {
		return txtName;
	}

	/**
	 * @param txtName the txtName to set
	 */
	public void setTxtName(TextField txtName) {
		this.txtName = txtName;
	}

	/**
	 * @return the txtPasswordSpecialist
	 */
	public PasswordField getTxtPasswordSpecialist() {
		return txtPasswordSpecialist;
	}

	/**
	 * @param txtPasswordSpecialist the txtPasswordSpecialist to set
	 */
	public void setTxtPasswordSpecialist(PasswordField txtPasswordSpecialist) {
		this.txtPasswordSpecialist = txtPasswordSpecialist;
	}

	/**
	 * @return the txtPosition
	 */
	public TextField getTxtPosition() {
		return txtPosition;
	}

	/**
	 * @param txtPosition the txtPosition to set
	 */
	public void setTxtPosition(TextField txtPosition) {
		this.txtPosition = txtPosition;
	}
	
	
}// end EditSpecialistController