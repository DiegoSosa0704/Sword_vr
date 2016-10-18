package controller.adminSpecialist;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.db.ConnectionTableAdmin;

/**
 * Tiene la funci�n de crear un Dialog, que facilite la inserci�n de
 * especialistas a la base de datos. Controlador de la vista
 * CreateSpecialist.fxml
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:11 p. m.
 */
public class CreateSpecialistController extends Stage implements Initializable {

	private AdminSpecialistController adminSpecialistController;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnCreate;
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
	private ConnectionTableAdmin tableAdmin;

	/**
	 * Constructor de la clase. Genera un Dialog son sus respectivos
	 * componentes.
	 * 
	 * @param tableAdmin
	 * @param adminSpecialistController
	 * @exception Exception
	 */
	public CreateSpecialistController(ConnectionTableAdmin tableAdmin,
			AdminSpecialistController adminSpecialistController) throws Exception {
		this.tableAdmin = tableAdmin;
		this.adminSpecialistController = adminSpecialistController;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/loginAdmin/CreateSpecialist.fxml"));
		fxmlLoader.setController(this);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		this.setTitle("Creación de especialistas");
		this.setResizable(false);
		this.initModality(Modality.APPLICATION_MODAL); // Evista cambiar de
		this.setScene(scene);
	}

	/**
	 * Metodo que cierra el Dialog generado por la el constructor. Realiza la
	 * funci�n del bot�n Cancelar.
	 * 
	 * @param event
	 */
	@FXML
	public void cancelCreateSpecialist(ActionEvent event) {
		this.close();
	}

	/**
	 * Metodo que inserta nuevo especialista. Realiza la funci�n del bot�n
	 * Crear.
	 * 
	 * @param event
	 */
	@FXML
	public void createSpecialist(ActionEvent event) {
		tableAdmin.addSpecialist(txtName.getText(), txtLastName.getText(), txtPasswordSpecialist.getText(),
				txtPosition.getText(), txtEmail.getText());
		txtName.setText("");
		txtLastName.setText("");
		txtPasswordSpecialist.setText("");
		txtEmail.setText("");
		txtPosition.setText("");
		tableAdmin.getQuerySpecialists(adminSpecialistController.getListaSpecialist());
	}

	/**
	 * Inicializa el controlador despu�s de que su elemento ra�z ha sido
	 * completamente procesado.
	 * 
	 * @param location
	 * @param resources
	 */
	public void initialize(URL location, ResourceBundle resources) {

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
	 * @return the btnCancel
	 */
	public Button getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel the btnCancel to set
	 */
	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}

	/**
	 * @return the btnCreate
	 */
	public Button getBtnCreate() {
		return btnCreate;
	}

	/**
	 * @param btnCreate the btnCreate to set
	 */
	public void setBtnCreate(Button btnCreate) {
		this.btnCreate = btnCreate;
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
	
	
}// end CreateSpecialistController