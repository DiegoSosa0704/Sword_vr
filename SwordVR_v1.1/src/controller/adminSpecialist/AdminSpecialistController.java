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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Specialist;
import model.db.ConnectionTableAdmin;

public class AdminSpecialistController implements Initializable {
	@FXML
	private Button btnCreateSpecialist;
	@FXML
	private Button btnDeleteSpecialist;
	@FXML
	private Button btnEditSpecialist;
	@FXML
	private TableColumn<Specialist, Integer> clmnId;
	@FXML
	private TableColumn<Specialist, String> clmnName;
	@FXML
	private TableColumn<Specialist, String> clmnLastName;
	@FXML
	private TableColumn<Specialist, String> clmnPosition;
	@FXML
	private TableColumn<Specialist, String> clmnEmail;
	@FXML
	private TableView<Specialist> tblViewSpecialist;
	private ConnectionTableAdmin tableAdmin;
	private ObservableList<Specialist> listaSpecialist;
	private Specialist specialist;

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

	@FXML
	public void showCreateSpecialist(ActionEvent event) throws Exception {
		CreateSpecialistController controller = new CreateSpecialistController(tableAdmin, this);
		controller.showAndWait();
	}

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

	@FXML
	public void deleteSpecialist() {
		if (specialist != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Borrar Especialista");
			alert.setHeaderText("Confirmar accion: ");
			alert.setContentText("¿Desea eliminar al usuario " + specialist.getName() + "?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
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

	public Specialist gestionEventos() {
		tblViewSpecialist.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
		return specialist;
	}

	public void selecionarItemTableViewClientes(Specialist specialist) {
		this.specialist = specialist;
	}

	public TableView<Specialist> getTblViewSpecialist() {
		return tblViewSpecialist;
	}

	public void setTblViewSpecialist(TableView<Specialist> tblViewSpecialist) {
		this.tblViewSpecialist = tblViewSpecialist;
	}

	public ConnectionTableAdmin getTableAdmin() {
		return tableAdmin;
	}

	public void setTableAdmin(ConnectionTableAdmin tableAdmin) {
		this.tableAdmin = tableAdmin;
	}

	public ObservableList<Specialist> getListaSpecialist() {
		return listaSpecialist;
	}

	public void setListaSpecialist(ObservableList<Specialist> listaSpecialist) {
		this.listaSpecialist = listaSpecialist;
	}

}
