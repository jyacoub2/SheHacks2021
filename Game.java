import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Game {
	
	private Question[] easyQuestions;
	private Question[] medQuestions;
	private Question[] hardQuestions;
	private Question[] doneQuestions;
	
	private int numQuestions;
	private int position;
	
	// Constructor for game class
	// Read from file and create question objects
	// Read from save file to determine current position
	public Game(String fileName) {
		
	}

	// Pending interface...
	public static void main(String args[]) {
		
	}
	
	// Pending interface...
	public void progress() {
		
	}
	
	// Randomly select next question from appropriate array
	public Question questionRandomizer(int difficulty) {
		Question[] set;
		if (difficulty == 1) {
			set = easyQuestions;
		}
		else if (difficulty == 2) {
			set = medQuestions;
		}
		else {
			set = hardQuestions;
		}
		
		int counter = 0;
		
		for (int i=0; i<doneQuestions.length; i++) {
			for (int j=0; j<set.length; j++) {
				if (set[j].getId() == doneQuestions[i].getId()) {
					set[j] = null;
					counter++;
				}
			}
		}
		
		Question[] newSet = new Question[set.length - counter]; 
		int track = 0; 
		
		for (int i=0; i<set.length; i++) {
			if (set[i] != null) {
				newSet[track] = set[i];
				track++;
			}
		}
		
		Random rnd = new Random();
		int randomNum = rnd.nextInt(newSet.length);
		
		return newSet[randomNum];
		
	}
	
	// 
	private void modifyDoneQuestions(Question newDone) {
		
	}
	
	// Check whether the selected answer is correct
	public boolean checkAnswer(Question question, String answer) {
		boolean outcome;
		if (question.getCorrect().equals(answer)) {
			outcome = true;
		}
		else {
			outcome = false;
		}
		return outcome;
	}
	
	// Write current game state to file 
	public void saveGame() {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("saved.txt"));
			
			bw.write(doneQuestions.length);
			bw.newLine();
			
			for (int i=0; i<doneQuestions.length; i++) {
				bw.write(doneQuestions[i].getId());
				bw.newLine();
			}
			
			bw.close();
			
		} catch (IOException e) {
			System.out.println("Invalid IO");
		}
		
	}

}
