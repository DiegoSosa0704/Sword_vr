package controller.tab;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class TabUserController {
	
	private MainController mainController;
	@FXML private Label lblUser;
	@FXML private Label lblPass;
	@FXML private TextField txtUser;
	@FXML private PasswordField txtPass;
	@FXML private Button btnSubmit;
	
	public void init(MainController mainController) {
		this.mainController = mainController;
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Label getLblUser() {
		return lblUser;
	}

	public void setLblUser(Label lblUser) {
		this.lblUser = lblUser;
	}

	public Label getLblPass() {
		return lblPass;
	}

	public void setLblPass(Label lblPass) {
		this.lblPass = lblPass;
	}

	public TextField getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(TextField txtUser) {
		this.txtUser = txtUser;
	}

	public PasswordField getTxtPass() {
		return txtPass;
	}

	public void setTxtPass(PasswordField txtPass) {
		this.txtPass = txtPass;
	}

	public Button getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(Button btnSubmit) {
		this.btnSubmit = btnSubmit;
	}
	
	

}
