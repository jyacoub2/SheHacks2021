import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnswerGUI implements ActionListener {
	
	private JFrame qFrame;
	private JPanel qPanel;
	private JLabel qStatement;
	private JLabel[] qAnswers;
	private JButton[] qButtons;
	private String selected;
	
	public AnswerGUI(String statement, String[] answers) {
		
		qPanel = new JPanel();
		qPanel.setLayout(null);
		
		qAnswers = new JLabel[answers.length];
		qButtons = new JButton[answers.length];
		
		qStatement = new JLabel(statement);
		qStatement.setBounds(10,20,400,25);
		
		qPanel.add(qStatement);
		
		int numAns = answers.length;
		int yPos = 50;
		
		for (int i=0; i<numAns; i++) {
			
			qAnswers[i] = new JLabel(answers[i]);
			qAnswers[i].setBounds(70,yPos,300,25);
			
			qButtons[i] = new JButton(Integer.toString(i+1));
			qButtons[i].setBounds(10,yPos,50,25);
			qButtons[i].addActionListener(new ActionListener()
					
					{
				@Override
				public void actionPerformed(ActionEvent e) {
					Object source = e.getSource();
					if (source instanceof JButton) {
						for (int i=0; i<numAns; i++) {
							if (qButtons[i] == source) {
								selected = answers[i];
								qFrame.dispose();
							}
						}
					}
				}
					}
					
					);
			
			qPanel.add(qAnswers[i]);
			qPanel.add(qButtons[i]);
			
			yPos += 30;
			
		}
		
		qFrame = new JFrame();
		qFrame.setSize(800,yPos+100);
		qFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		qFrame.add(qPanel);
		qFrame.setVisible(true);
		
	}
	
	public String getSelected() {
		return selected;
	}
}
