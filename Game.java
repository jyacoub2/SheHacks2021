
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
		
	}
	
	// Check whether the selected answer is correct
	public boolean checkAnswer(Question question, String answer) {
		
	}
	
	// Write current game state to file 
	public void saveGame() {
		
	}

}
