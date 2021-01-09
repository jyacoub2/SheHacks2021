import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Input {
	
	public static void main(String[] args) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("questionFile.txt"));
			
			int numEasy = 0;
			int numMed = 0;
			int numHard = 0;
			
			String statement = "";
			int difficulty = 0;
			String answer = "";
			
			boolean nextA = true;
			boolean nextQ = true;
			
			// Read past the first 3 lines
			bw.newLine();
			bw.newLine();
			bw.newLine();
			
			// Read questions from GUI until "done" selected
			while (nextQ == true) {
				// Read statement from GUI
				/**/
				bw.write("~" + statement);
				bw.newLine();
				
				// Read difficulty from GUI
				/**/
				bw.write(difficulty);
				bw.newLine();
				
				// Read answers from GUI until "next question" button selected
				// Display "add answer"
				while (nextA == true) {
					// Read answer from GUI
					/**/
					bw.write(answer);
					bw.newLine();
				}
				nextA = true;
			}
			
			bw.close();
					
		} catch (IOException e) {
			System.out.println("Invalid IO");
		}
		
	}
	
}
