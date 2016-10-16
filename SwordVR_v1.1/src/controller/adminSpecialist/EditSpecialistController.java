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

public class EditSpecialistController extends Stage implements Initializable{
	
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
	
	private Specialist specialist;
	private ConnectionTableAdmin tableAdmin;
	private AdminSpecialistController adminSpecialistController;
	
	public EditSpecialistController(Specialist specialist, ConnectionTableAdmin tableAdmin, AdminSpecialistController adminSpecialistController) throws Exception {
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

	@FXML public void editSpecialist(ActionEvent event) {
		tableAdmin.updateSpecialist(specialist.getId(), txtName.getText(), txtLastName.getText(), txtPosition.getText(), txtPasswordSpecialist.getText(), txtEmail.getText());
		tableAdmin.getQuerySpecialists(adminSpecialistController.getListaSpecialist());
		this.close();
	}

	@FXML public void cancelEditSpecialist(ActionEvent event) {
		this.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtName.setText(specialist.getName());
		txtLastName.setText(specialist.getLastName());
		txtPosition.setText(specialist.getPosition());
		txtEmail.setText(specialist.getEmail());
	}

}
