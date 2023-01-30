package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {

	
	@FXML 
	public Button rollBtn;
	
	@FXML
	public Button holdBtn;
	
	@FXML
	public Label plyrScore;
	
	@FXML
	public Label cpuScore;
	
	@FXML
	public Label whosTurn;
	
	@FXML 
	public Label currentRoll;
	
	@FXML
	public TextField nameText;
	
	@FXML 
	public Label nameLabel;
	
	@FXML
	public Button contBtn;
	
	@FXML
	public Button exitBtn;
	
	public int playerTurn=1;
	Random rand = new Random();
	public int pTotalScore;
	public int cTotalScore;
	public int pCurrentScore;
	public int cCurrentScore;
	public String winLoss;
	public int scoreCap = 100;
	
	public void roll(ActionEvent e){
		if(playerTurn ==2||pTotalScore>=scoreCap) {
			currentRoll.setText("It's not your turn");
		}else {
			int i = rand.nextInt(1, 6);
			if(i==1) {
			pCurrentScore=0;
			currentRoll.setText("Sorry, you rolled a 1. Turn score is zero.");
			playerTurn=2;
			contBtn.setVisible(true);
			}else {
				pCurrentScore+=i;
				currentRoll.setText("You rolled a "+i+". Your current score is "+pCurrentScore);
			}
		}		
	}
	public void hold(ActionEvent e) {
		currentRoll.setText("Current Score of "+pCurrentScore+" added to your total.");
		pTotalScore+=pCurrentScore;
		plyrScore.setText("Player Total Score: "+pTotalScore);
		playerTurn=2;
		pCurrentScore=0;
		if(pTotalScore>=scoreCap) {
			winTerms();
		}else
		contBtn.setVisible(true);
	}
	
	public void cpu() {
	if(playerTurn==2 &&pTotalScore<scoreCap&&cTotalScore<scoreCap) {
		whosTurn.setText("CPU Turn");
		int choice;
		if(cCurrentScore==0) {
			choice=1;
		}else {
		choice = rand.nextInt(1,3);
		}
		if(choice==1) {
			cpuRoll();
		}else
			cpuHold();
	}	
}
	public void cpuRoll(){
			int i = rand.nextInt(1, 6);
			if(i==1) {
			cCurrentScore=0;
			currentRoll.setText("CPU rolled a 1. Turn score is zero.");
			playerTurn=1;
			whosTurn.setText("Your Turn");
			}else {
				cCurrentScore+=i;
				currentRoll.setText("CPU rolled a "+i+". Your current score is "+cCurrentScore);
				cpu();
			}
		
	}
	public void cpuHold(){
		currentRoll.setText("Current Score of "+cCurrentScore+" added to cpu total.");
		cTotalScore+=cCurrentScore;
		cpuScore.setText("CPU Total Score: "+cTotalScore);
		playerTurn=1;
		cCurrentScore=0;
		whosTurn.setText("Your Turn");
		if(cTotalScore>=scoreCap) {
			winTerms();
		}
		}
	public void winTerms(){
		nameText.setVisible(true);
		nameLabel.setText("Enter Your Name:");
		if(pTotalScore>=scoreCap) {
			currentRoll.setText("You Win!");
			winLoss = "WIN";		
		}else {
			currentRoll.setText("You Lost :(");
			winLoss = "LOSS";
		}
		exitBtn.setVisible(true);
	}
	public void endGame(ActionEvent e) {
		if(nameText.getText()=="") {
			whosTurn.setText("Please enter name for records");
		}else {
			try {
			File histFile = new File("/Users/nickv/eclipse-workspace/FinalSkeleton/src/application/history.txt");
			FileWriter fw = new FileWriter(histFile, true);
			BufferedWriter writer = new BufferedWriter(fw);
			Date thisDate = new Date();
			SimpleDateFormat date = new SimpleDateFormat("MM/dd/Y H:m");
			writer.write(nameText.getText()+"\n"+date.format(thisDate)+"\n"+winLoss+"\n"+pTotalScore+"\n");
			writer.close();
			}catch(IOException ex) {
				currentRoll.setText("Error Writing Record");
			}
			Platform.exit();
		}
	}
	public void contButton(ActionEvent e) {
		if(playerTurn==2){
			cpu();
			contBtn.setVisible(false);
		}
		else {
			contBtn.setVisible(false);
		}
	}
	}