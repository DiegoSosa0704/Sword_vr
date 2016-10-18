package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal
 * 
 * @author SOSA-PC
 * @version 1.0
 * @created 17-oct.-2016 9:32:11 p. m.
 */
public class MainApp extends Application {

	/**
	 * Metodo principal. Punto de entrada para aplicaciones JavaFX.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Inicia aplicacin mediante el paso de argumentos.
	 * 
	 * @param primaryStage
	 * @exception Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SwordVR");
		Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}// end MainApp