import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputGUI implements ActionListener {
	
	private JFrame qInFrame;
	private JFrame aInFrame;
	
	private JPanel qInPanel;
	private JPanel aInPanel;
	
	private JLabel question;
	private JLabel correct;
	private JLabel incorrect;
	
	private JTextField qStatement;
	private JTextField corAns;
	private JTextField incorAns;
	
	private JButton 
		diffEasy, diffMed, diffHard;
	
	private JButton
		finish, nextQ, addAns;
	
	private String[] questions;
	private String[][] answers;
	private int[] difficulties;
	private int counter;
	private int incAnsCounter;
	
	public InputGUI() {
		
		counter = 0;
		incAnsCounter = 1;
		
		// question Frame
		difficulties = new int[50];
		questions = new String[50];
		answers = new String[50][10];
		
		question = new JLabel("Enter Question: ");
		question.setBounds(10,20,100,25);
		
		qStatement = new JTextField();
		qStatement.setBounds(10,50,400,25);
		
		correct = new JLabel("Enter Correct Answer: ");
		correct.setBounds(10,80,150,25);
		
		corAns = new JTextField();
		corAns.setBounds(10,110,400,25);
		
		diffEasy = new JButton("Easy");
		diffEasy.setBounds(10,160,80,25);
		diffEasy.addActionListener(this);
		
		diffMed = new JButton("Medium");
		diffMed.setBounds(100,160,80,25);
		diffMed.addActionListener(this);
		
		diffHard = new JButton("Hard");
		diffHard.setBounds(190,160,80,25);
		diffHard.addActionListener(this);
		
		
		qInPanel = new JPanel();
		qInPanel.setLayout(null);
		qInPanel.add(question);
		qInPanel.add(qStatement);
		qInPanel.add(correct);
		qInPanel.add(corAns);
		qInPanel.add(diffEasy);
		qInPanel.add(diffMed);
		qInPanel.add(diffHard);
		
		qInFrame = new JFrame();
		qInFrame.setSize(700,700);
		qInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		qInFrame.add(qInPanel);
		qInFrame.setVisible(true);
		
		
		// incorrect answer Frame
		incorrect = new JLabel("Enter Incorrect Answer: ");
		incorrect.setBounds(10,20,200,25);
		
		incorAns = new JTextField();
		incorAns.setBounds(10,50,400,25);
		
		addAns = new JButton("Add Answer");
		addAns.setBounds(10,100,120,25);
		addAns.addActionListener(this);
		
		nextQ = new JButton("Next Question");
		nextQ.setBounds(140,100,120,25);
		nextQ.addActionListener(this);
		
		finish = new JButton("Done");
		finish.setBounds(270,100,120,25);
		finish.addActionListener(this);
		
		aInPanel = new JPanel();
		aInPanel.setLayout(null);
		aInPanel.add(incorrect);
		aInPanel.add(incorAns);
		aInPanel.add(addAns);
		aInPanel.add(nextQ);
		aInPanel.add(finish);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JButton) {
			if (source == diffEasy || source == diffMed || source == diffHard) {
				if (source == diffEasy) {
					difficulties[counter] = 1;
				} else if (source == diffMed) {
					difficulties[counter] = 2;
				} else if (source == diffHard) {
					difficulties[counter] = 3;
				}
				
				questions[counter] = qStatement.getText();
				answers[counter][0] = corAns.getText();
				
				counter++;
				incAnsCounter = 1;
				
				aInFrame = new JFrame();
				aInFrame.setSize(500,200);
				aInFrame.setVisible(true);
				aInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				aInFrame.add(aInPanel);
				
				qStatement.setText("");
				corAns.setText("");
				qInFrame.dispose();
				
			} else if (source == addAns || source == nextQ || source == finish) {
				
				answers[counter-1][incAnsCounter] = incorAns.getText();
				incAnsCounter++;
				
				if (source == addAns) {
					incorAns.setText("");
				} else if (source == nextQ) {
					qInFrame = new JFrame();
					qInFrame.setSize(700,700);
					qInFrame.setVisible(true);
					qInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					qInFrame.add(qInPanel);
					
					incorAns.setText("");
					aInFrame.dispose();
				} else if (source == finish) {
					aInFrame.dispose();
					
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter("questionFile.txt"));
						
						int numEasy = 0;
						int numMed = 0;
						int numHard = 0;
						
						String statement = "";
						int difficulty = 0;
						String answer = "";
						
						// Count of each difficulty
						for (int i=0; i<difficulties.length; i++) {
							if (difficulties[i] == 1) {
								numEasy++;
							} else if (difficulties[i] == 2) {
								numMed++;
							} else if (difficulties[i] == 3) {
								numHard++;
							}
						}
						
						// Read past the first 3 lines
						bw.write(Integer.toString(numEasy));
						bw.newLine();
						bw.write(Integer.toString(numMed));
						bw.newLine();
						bw.write(Integer.toString(numHard));
						bw.newLine();
						
						// Read questions from GUI until "done" selected
						for (int i=0; i<questions.length; i++) {
							// Read statement from GUI
							statement = questions[i];
							if (statement != null) {
								bw.write("~" + statement);
								bw.newLine();
							}
							
							// Read difficulty from GUI
							difficulty = difficulties[i];
							if (difficulty != 0) {
								bw.write(Integer.toString(difficulty));
								bw.newLine();
							}
							
							// Read answers from GUI until "next question" button selected
							// Display "add answer"
							for (int j=0; j<answers[i].length; j++) {
								// Read answer from GUI
								answer = answers[i][j];
								if (answer != null) {
									bw.write(answer);
									bw.newLine();
								}
							}
						}
						
						bw.close();
								
					} catch (IOException f) {
						System.out.println("Invalid IO");
					}
				}
			}
		}
	}
	
	public String[] getQuestions() {
		return questions;
	}
	
	public String[][] getAnswers() {
		return answers;
	}
	
	public int[] getDifficulties() {
		return difficulties;
	}
	
	public static void main(String[] args) {
		new InputGUI();
	}
}
