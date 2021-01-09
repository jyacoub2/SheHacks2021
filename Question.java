
public class Question {
	
	// Question statement 
	private String statement;
	
	// Correct answer
	private String correct;
	
	// All question answers 
	private String[] answers;
	
	// Difficulty level of the question
	private int difficulty;
	
	// Integer identifier of the question
	private int id;
	
	// Create question object and set private variables
	public Question(String statement, String[] answers, int difficulty, int id) {
		this.statement = statement;
		this.answers = answers;
		correct = answers[0];
		this.difficulty = difficulty;
		this.id = id;
	}
	
	// Getters and setters for all private variables
	
	public String getStatement() {
		return statement;
	}
	
	public void setStatement(String newStatement) {
		statement = newStatement;
	}
	
	public String getCorrect() {
		return correct;
	}
	
	public void setCorrect(String newCorrect) {
		correct = newCorrect;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public void setAnswers(String[] newAnswers) {
		answers = newAnswers;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id = newId;
	}
	
	// Randomly select answer order for the answers
	public int[] answerRandomizer(int numAnswers) {
			
	}

}
