package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;

import controller.tab.TabAdminController;
import controller.tab.TabUserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.db.ConnectionTableAdmin;

public class MainController implements Initializable {
	@FXML
	TabAdminController tabAdminController;
	@FXML
	TabUserController tabUserController;
	@FXML
	JFXTabPane jfxTabPane;
	private ConnectionTableAdmin tableAdmin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableAdmin = new ConnectionTableAdmin();
		System.out.println("Aplicacion iniciada");
		tabAdminController.init(this, tableAdmin);
		tabUserController.init(this);
	}

}
