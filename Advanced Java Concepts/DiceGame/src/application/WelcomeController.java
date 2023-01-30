package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WelcomeController {
	
	@FXML 
	public TextField nameText;
	
	@FXML
	public Button playBtn;
	
	@FXML 
	public Label errLabel;
	
	public void startGame(ActionEvent e) {
			try {
				Parent root1 =FXMLLoader.load(getClass().getResource("Game.fxml"));
				Stage stage = new Stage();
				stage.setTitle("Game of Pig");
				stage.setScene(new Scene(root1));
				stage.show();
				
			} catch (IOException e1) {
				errLabel.setText("Error Loading Game Window");
			}
		}
}
