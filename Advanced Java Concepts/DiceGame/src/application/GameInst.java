package application;
import javafx.beans.property.SimpleStringProperty;


public class GameInst {
	public SimpleStringProperty name, date, win, score;
	
	public GameInst(String name, String date, String win, String score) {
		this.name = new SimpleStringProperty(name); 
		this.date = new SimpleStringProperty(date);
		this.win = new SimpleStringProperty(win);
		this.score =new SimpleStringProperty(score);
	}

	public SimpleStringProperty getName() {
		return name;
	}

	@Override
	public String toString() {
		return "GameInst [name=" + name + ", date=" + date + ", win=" + win + ", score=" + score + "]";
	}

	public void setName(SimpleStringProperty name) {
		this.name = name;
	}

	public SimpleStringProperty getDate() {
		return date;
	}

	public void setDate(SimpleStringProperty date) {
		this.date = date;
	}

	public SimpleStringProperty getWin() {
		return win;
	}

	public void setWin(SimpleStringProperty win) {
		this.win = win;
	}

	public SimpleStringProperty getScore() {
		return score;
	}

	public void setScore(SimpleStringProperty score) {
		this.score = score;
	}
	
	public SimpleStringProperty getStringName() {
		return name;
	}

}
