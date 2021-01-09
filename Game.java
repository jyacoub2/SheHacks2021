
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
		else if (difficulty == 3) {
			set = hardQuestions;
		}
		
		
		for (int i=0; i<doneQuestions.length; i++) {
			
		}
	}
	
	// Check whether the selected answer is correct
	public boolean checkAnswer(Question question, String answer) {
		boolean outcome;
		if (question.correct.equals(answer)) {
			outcome = True;
		}
		else {
			outcome = False;
		}
		return outcome;
	}
	
	// Write current game state to file 
	public void saveGame() {
		
	}

}
