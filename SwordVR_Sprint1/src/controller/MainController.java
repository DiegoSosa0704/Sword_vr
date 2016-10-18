package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;

import controller.tab.TabAdminController;
import controller.tab.TabUserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.db.ConnectionTableAdmin;

/**
 * Controlador de la vista Login.FXML.
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:11 p. m.
 */
public class MainController implements Initializable {

	@FXML
	JFXTabPane jfxTabPane;
	@FXML
	TabAdminController tabAdminController;
	private ConnectionTableAdmin tableAdmin;
	@FXML
	TabUserController tabUserController;

	/**
	 * Inicializa el controlador despu�s de que su elemento ra�z ha sido
	 * completamente procesado.
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableAdmin = new ConnectionTableAdmin();
		tabAdminController.init(this, tableAdmin);
		tabUserController.init(this);
	}

	/**
	 * @return the jfxTabPane
	 */
	public JFXTabPane getJfxTabPane() {
		return jfxTabPane;
	}

	/**
	 * @param jfxTabPane the jfxTabPane to set
	 */
	public void setJfxTabPane(JFXTabPane jfxTabPane) {
		this.jfxTabPane = jfxTabPane;
	}

	/**
	 * @return the tabAdminController
	 */
	public TabAdminController getTabAdminController() {
		return tabAdminController;
	}

	/**
	 * @param tabAdminController the tabAdminController to set
	 */
	public void setTabAdminController(TabAdminController tabAdminController) {
		this.tabAdminController = tabAdminController;
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
	 * @return the tabUserController
	 */
	public TabUserController getTabUserController() {
		return tabUserController;
	}

	/**
	 * @param tabUserController the tabUserController to set
	 */
	public void setTabUserController(TabUserController tabUserController) {
		this.tabUserController = tabUserController;
	}
	
	
}// end MainController