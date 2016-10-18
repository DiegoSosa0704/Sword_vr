package controller.adminSpecialist;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Specialist;
import model.db.ConnectionTableAdmin;

/**
 * Clase encargada de administrar datos de especialistas e instanciar las clases
 * EditSpecialistController y CreateSpecialistController. Controlador de la
 * vista AdminSpecialist.fxml
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:10 p. m.
 */
public class AdminSpecialistController implements Initializable {

	@FXML
	private Button btnCreateSpecialist;
	@FXML
	private Button btnDeleteSpecialist;
	@FXML
	private Button btnEditSpecialist;
	@FXML
	private TableColumn<Specialist, String> clmnEmail;
	@FXML
	private TableColumn<Specialist, Integer> clmnId;
	@FXML
	private TableColumn<Specialist, String> clmnLastName;
	@FXML
	private TableColumn<Specialist, String> clmnName;
	@FXML
	private TableColumn<Specialist, String> clmnPosition;
	@FXML
	private TableView<Specialist> tblViewSpecialist;
	private ObservableList<Specialist> listaSpecialist;
	private Specialist specialist;
	private ConnectionTableAdmin tableAdmin;

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
		listaSpecialist = FXCollections.observableArrayList();
		tableAdmin.getQuerySpecialists(listaSpecialist);

		tblViewSpecialist.setItems(listaSpecialist);
		clmnId.setCellValueFactory(new PropertyValueFactory<Specialist, Integer>("id"));
		clmnName.setCellValueFactory(new PropertyValueFactory<Specialist, String>("name"));
		clmnLastName.setCellValueFactory(new PropertyValueFactory<Specialist, String>("lastName"));
		clmnPosition.setCellValueFactory(new PropertyValueFactory<Specialist, String>("position"));
		clmnEmail.setCellValueFactory(new PropertyValueFactory<Specialist, String>("email"));
		gestionEventos();
	}

	/**
	 * Metodo que elimina el especialista seleccionado del TableView y la base
	 * de datos.
	 */
	@FXML
	public void deleteSpecialist() {
		if (specialist != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar Especialista");
			alert.setHeaderText("Confirmar accion: ");
			alert.setContentText("¿Desea eliminar al usuario " + specialist.getName() + "?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				tableAdmin.deleteSpecialist(specialist.getId());
				tableAdmin.getQuerySpecialists(listaSpecialist);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error al borrar. ");
			alert.setContentText("Ningun especialista fue seleccionado.");
			alert.setHeaderText("Error: ");
			alert.show();
		}
	}

	/**
	 * Metodo que retorna el especialista seleccionado en el TableView.
	 */
	public Specialist gestionEventos() {
		tblViewSpecialist.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
		return specialist;
	}

	/**
	 * Metodo que iguala la variable global specialist con la variable que llega
	 * por par�metro.
	 * 
	 * @param specialist
	 */
	public void selecionarItemTableViewClientes(Specialist specialist) {
		this.specialist = specialist;
	}

	/**
	 * Metodo que instancia la clase CreateSpecialistController y la hace
	 * visible.
	 * 
	 * @param event
	 * @exception Exception
	 */
	@FXML
	public void showCreateSpecialist(ActionEvent event) throws Exception {
		CreateSpecialistController controller = new CreateSpecialistController(tableAdmin, this);
		controller.showAndWait();
	}

	/**
	 * Metodo que instancia la clase EditSpecialistController y la hace visible.
	 * 
	 * @param event
	 * @exception Exception
	 */
	@FXML
	public void showEditSpecialist(ActionEvent event) throws Exception {
		if (specialist == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error al borrar. ");
			alert.setContentText("Ningun especialista fue seleccionado.");
			alert.setHeaderText("Error: ");
			alert.show();
		} else {
			EditSpecialistController controller = new EditSpecialistController(specialist, tableAdmin, this);
			controller.showAndWait();
		}
	}

	/**
	 * @return the btnCreateSpecialist
	 */
	public Button getBtnCreateSpecialist() {
		return btnCreateSpecialist;
	}

	/**
	 * @param btnCreateSpecialist
	 *            the btnCreateSpecialist to set
	 */
	public void setBtnCreateSpecialist(Button btnCreateSpecialist) {
		this.btnCreateSpecialist = btnCreateSpecialist;
	}

	/**
	 * @return the btnDeleteSpecialist
	 */
	public Button getBtnDeleteSpecialist() {
		return btnDeleteSpecialist;
	}

	/**
	 * @param btnDeleteSpecialist
	 *            the btnDeleteSpecialist to set
	 */
	public void setBtnDeleteSpecialist(Button btnDeleteSpecialist) {
		this.btnDeleteSpecialist = btnDeleteSpecialist;
	}

	/**
	 * @return the btnEditSpecialist
	 */
	public Button getBtnEditSpecialist() {
		return btnEditSpecialist;
	}

	/**
	 * @param btnEditSpecialist
	 *            the btnEditSpecialist to set
	 */
	public void setBtnEditSpecialist(Button btnEditSpecialist) {
		this.btnEditSpecialist = btnEditSpecialist;
	}

	/**
	 * @return the clmnEmail
	 */
	public TableColumn<Specialist, String> getClmnEmail() {
		return clmnEmail;
	}

	/**
	 * @param clmnEmail
	 *            the clmnEmail to set
	 */
	public void setClmnEmail(TableColumn<Specialist, String> clmnEmail) {
		this.clmnEmail = clmnEmail;
	}

	/**
	 * @return the clmnId
	 */
	public TableColumn<Specialist, Integer> getClmnId() {
		return clmnId;
	}

	/**
	 * @param clmnId
	 *            the clmnId to set
	 */
	public void setClmnId(TableColumn<Specialist, Integer> clmnId) {
		this.clmnId = clmnId;
	}

	/**
	 * @return the clmnLastName
	 */
	public TableColumn<Specialist, String> getClmnLastName() {
		return clmnLastName;
	}

	/**
	 * @param clmnLastName
	 *            the clmnLastName to set
	 */
	public void setClmnLastName(TableColumn<Specialist, String> clmnLastName) {
		this.clmnLastName = clmnLastName;
	}

	/**
	 * @return the clmnName
	 */
	public TableColumn<Specialist, String> getClmnName() {
		return clmnName;
	}

	/**
	 * @param clmnName
	 *            the clmnName to set
	 */
	public void setClmnName(TableColumn<Specialist, String> clmnName) {
		this.clmnName = clmnName;
	}

	/**
	 * @return the clmnPosition
	 */
	public TableColumn<Specialist, String> getClmnPosition() {
		return clmnPosition;
	}

	/**
	 * @param clmnPosition
	 *            the clmnPosition to set
	 */
	public void setClmnPosition(TableColumn<Specialist, String> clmnPosition) {
		this.clmnPosition = clmnPosition;
	}

	/**
	 * @return the listaSpecialist
	 */
	public ObservableList<Specialist> getListaSpecialist() {
		return listaSpecialist;
	}

	/**
	 * @param listaSpecialist
	 *            the listaSpecialist to set
	 */
	public void setListaSpecialist(ObservableList<Specialist> listaSpecialist) {
		this.listaSpecialist = listaSpecialist;
	}

	/**
	 * @return the specialist
	 */
	public Specialist getSpecialist() {
		return specialist;
	}

	/**
	 * @param specialist
	 *            the specialist to set
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
	 * @param tableAdmin
	 *            the tableAdmin to set
	 */
	public void setTableAdmin(ConnectionTableAdmin tableAdmin) {
		this.tableAdmin = tableAdmin;
	}

	/**
	 * @return the tblViewSpecialist
	 */
	public TableView<Specialist> getTblViewSpecialist() {
		return tblViewSpecialist;
	}

	/**
	 * @param tblViewSpecialist
	 *            the tblViewSpecialist to set
	 */
	public void setTblViewSpecialist(TableView<Specialist> tblViewSpecialist) {
		this.tblViewSpecialist = tblViewSpecialist;
	}

}// end AdminSpecialistController