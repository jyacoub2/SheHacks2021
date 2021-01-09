import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LearnGUI implements ActionListener {
	
	private static int qCount = 0;
	private static JLabel label;
	private static JLabel password;
	private static JLabel success;
	private static JFrame frame;
	private static JPanel panel;
	private static JButton nextButton;
	private static JButton doneButton;
	private static JTextField text;
	private static JPasswordField passText;
	
	public LearnGUI() {
		
		label = new JLabel("Username");
		label.setBounds(10, 20, 80, 25);
		
		password = new JLabel("Password");
		password.setBounds(10, 50, 80, 25);
		
		success = new JLabel("");
		success.setBounds(10, 110, 30, 25);
		
		text = new JTextField(100);
		text.setBounds(100, 20, 165, 25);
		
		passText = new JPasswordField(100);
		passText.setBounds(100, 50, 165, 25);
		
		nextButton = new JButton("Login");
		nextButton.setBounds(10, 80, 80, 25);
		nextButton.addActionListener(this);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(label);
		panel.add(password);
		panel.add(text);
		panel.add(passText);
		panel.add(nextButton);
		panel.add(success);
		
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		
		/*
		// View window
		frame = new JFrame();
		
		// Buttons
		nextButton = new JButton("Next");
		nextButton.addActionListener(this);
		
		doneButton = new JButton("Done");
		
		// Labels
		label = new JLabel("Number of questions: " + qCount);
		
		// Window layout
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300, 500, 100, 100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(nextButton);
		panel.add(doneButton);
		panel.add(label);
		
		// Basic window setup
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add Question");
		frame.pack();
		frame.setVisible(true);
		*/
		
	}
	
	public static void main(String[] args) {
		new LearnGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = text.getText();
		String password = passText.getText();
		
		if (username.equals("Hello") && password.equals("World")) {
			success.setText("Login successful");
		}
	}
	
	/*
	public void actionPerformed(ActionEvent e) {
		qCount++;
		label.setText("Number of questions: " + qCount);
	}
	*/

}
