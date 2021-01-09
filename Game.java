import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Game {
	
	private Question[] easyQuestions;
	private Question[] medQuestions;
	private Question[] hardQuestions;
	private Question[] doneQuestions;
	
	private int numQuestions;
	private int numEasy;
	private int numMed;
	private int numHard;
	private int position;
	
	// Constructor for game class
	// Read from file and create question objects
	// Read from save file to determine current position
	public Game(String readFile, String saveFile) {
		String nextLine;
		String fileName; 
		try {
			fileName = readFile;
			BufferedReader brRead = new BufferedReader(new FileReader(fileName));
			
			String newStatement;
			int newId; 
			int newDifficulty;
			String[] newAnswers;
			
			int nextAns = 0;
			int questNum = 0;
			
			int easyNum = 0;
			int medNum = 0;
			int hardNum = 0;
			
			numEasy = Integer.parseInt(brRead.readLine());
			numMed = Integer.parseInt(brRead.readLine());
			numHard = Integer.parseInt(brRead.readLine());
			
			easyQuestions = new Question[numEasy];
			medQuestions = new Question[numMed];
			hardQuestions = new Question[numHard];
			
			nextLine = brRead.readLine();
			while (nextLine != null) {
				newStatement = nextLine.substring(1);
				newDifficulty = Integer.parseInt(brRead.readLine());
				newId = questNum;
				nextLine = brRead.readLine();
				while (nextLine != null && nextLine.charAt(0) != '~') {
					newAnswers[nextAns] = nextLine;
					nextAns++;
					nextLine = brRead.readLine();
				}
				nextAns = 0;
				if (newDifficulty == 1) {
					easyQuestions[easyNum] = new Question(newStatement, newAnswers, newDifficulty, newId);
					easyNum++;
				} else if (newDifficulty == 2) {
					medQuestions[medNum] = new Question(newStatement, newAnswers, newDifficulty, newId);
					medNum++;
				} else {
					hardQuestions[hardNum] = new Question(newStatement, newAnswers, newDifficulty, newId);
					hardNum++;
				}
				questNum++;
			}
			numQuestions = questNum;
			brRead.close();
			
			fileName = saveFile;
			BufferedReader brSave = new BufferedReader(new FileReader(fileName));
			brSave.readLine();
			
			brSave.close();
		
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " could not be found.");
		}
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
	
	// add the recently completed question to the end of the doneQuestion array
	private void modifyDoneQuestions(Question newDone) {
		//make array of one size bigger
		Question[] newDoneQuestions = new Question [doneQuestions.length + 1];

		//iterate through to copy data from newDoneQuestions to newDoneQuestions
		for (int i = 0; i<doneQuestions.length; i++)
		{
		    newDoneQuestions[i] = doneQuestions[i];
		}

		//tack newDone to end of newDoneQuestions
		newDoneQuestions[newDoneQuestions.length - 1] = newDone;
		}
	
	}
	
	// Check whether the selected answer is correct
	public boolean checkAnswer(Question question, String answer) {
		boolean outcome;
		if (question.getCorrect().equals(answer)) {
			outcome = true;
			modifyDoneQuestions(question);
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
			bw = new BufferedWriter(new FileWriter("saveFile.txt"));
			
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
