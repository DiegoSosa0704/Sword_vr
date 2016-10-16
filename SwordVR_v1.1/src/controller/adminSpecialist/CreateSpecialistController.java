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

public class CreateSpecialistController extends Stage implements Initializable {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtLastName;
	@FXML
	private PasswordField txtPasswordSpecialist;
	@FXML
	private TextField txtPosition;
	@FXML
	private TextField txtEmail;
	@FXML
	private Button btnCreate;
	@FXML
	private Button btnCancel;
	private ConnectionTableAdmin tableAdmin;
	private AdminSpecialistController adminSpecialistController;

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

	@FXML
	public void cancelCreateSpecialist(ActionEvent event) {
		this.close();
	}

	public void initialize(URL location, ResourceBundle resources) {
	}

}
