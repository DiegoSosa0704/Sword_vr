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

public class TabAdminController {

	private MainController mainController;
	private ConnectionTableAdmin tableAdmin;
	@FXML private Label lblAdmin;
	@FXML private Label lblPassAdmin;
	@FXML private TextField txtAdmin;
	@FXML private PasswordField txtPassAdmin;
	@FXML private Button btnSubmitAdmin;
	
	@FXML public void loginAdmin(ActionEvent event) throws IOException{
		System.out.println("pos hola");
		System.out.println("Entro");
		Parent root = FXMLLoader.load(getClass().getResource("/view/loginAdmin/AdminSpecialist.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		System.out.println(txtPassAdmin.getText());
		System.out.println(txtAdmin.getText());
		if(validateLogin()){
			stage.setTitle("Administrar Especialistas");
			stage.setScene(scene);
			stage.show();
		}
	}
	
	

	public void init(MainController mainController, ConnectionTableAdmin tableAdmin) {
		this.mainController = mainController;
		this.tableAdmin = tableAdmin;
	}
	
	public boolean validateLogin(){
        boolean flag = false;
        if(tableAdmin.searchAdmin(txtAdmin.getText()) && tableAdmin.searchPass(txtPassAdmin.getText())){
            flag = true;
        }
        return flag;
    }

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Label getLblAdmin() {
		return lblAdmin;
	}

	public void setLblAdmin(Label lblAdmin) {
		this.lblAdmin = lblAdmin;
	}

	public Label getLblPassAdmin() {
		return lblPassAdmin;
	}

	public void setLblPassAdmin(Label lblPassAdmin) {
		this.lblPassAdmin = lblPassAdmin;
	}

	public TextField getTxtAdmin() {
		return txtAdmin;
	}

	public PasswordField getTxtPassAdmin() {
		return txtPassAdmin;
	}

	public void setTxtPassAdmin(PasswordField txtPassAdmin) {
		this.txtPassAdmin = txtPassAdmin;
	}

	public Button getBtnSubmitAdmin() {
		return btnSubmitAdmin;
	}

	public void setBtnSubmitAdmin(Button btnSubmitAdmin) {
		this.btnSubmitAdmin = btnSubmitAdmin;
	}
	
	
	
}
