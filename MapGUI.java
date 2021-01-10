import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public class MapGUI extends JFrame implements MouseListener {
	
	private Game play;
	private int delayMiliseconds;
	private int delayMiliseconds2;
	
	private String imgMap = "Map.jpg";
	private String imgSucc = "Succ.jpg";
	private String imgFail = "Fail.jpg";
	private String selected;
	
	private ImageIcon map;
	private ImageIcon succ;
	private ImageIcon fail;
	
	private JLabel mapLabel;
	private JLabel succLabel;
	private JLabel failLabel;
	
	private JPanel panel;
	private JPanel success;
	private JPanel failure;
	
	public MapGUI(Game play) {
			
		delayMiliseconds = 5000;
		delayMiliseconds2 = 2000;
		this.play = play;
		
		map = new ImageIcon(imgMap);
		mapLabel = new JLabel(map);
		mapLabel.setBounds(0, 0, 935, 700);
		
		succ = new ImageIcon(imgSucc);
		succLabel = new JLabel(succ);
		succLabel.setBounds(0, 0, 935, 700);
		
		fail = new ImageIcon(imgFail);
		failLabel = new JLabel(fail);
		failLabel.setBounds(0, 0, 935, 700);
		
		panel = new JPanel();
		panel.add(mapLabel);
		panel.addMouseListener(this);
		
		success = new JPanel();
		success.add(succLabel);
		
		failure = new JPanel();
		failure.add(failLabel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("EduPal");
		this.setSize(935, 740);
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Not required
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Not required
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		AnswerGUI ansGUI;
		Question nextQuestion;
		int[] ansRandomize;
		String[] answers;
		
		nextQuestion = play.questionRandomizer(1);
		answers = new String[nextQuestion.getAnswers().length];
		ansRandomize = nextQuestion.answerRandomizer(nextQuestion.getAnswers().length);
		for (int j=0; j<answers.length; j++) {
			answers[j] = nextQuestion.getAnswers()[ansRandomize[j]];
		}
		ansGUI = new AnswerGUI(nextQuestion.getStatement(), answers);
		Timer timer = new Timer(delayMiliseconds, new AbstractAction() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	boolean result;
		    	selected = ansGUI.getSelected();
		    	result = play.checkAnswer(nextQuestion, selected);
		    	if (result == true) {
		    		System.out.println("Correct");
		    		/*panel.add(success);
		    		revalidate();
		    		repaint();
		    		Timer timer2 = new Timer(delayMiliseconds2, new AbstractAction() {
		    		    @Override
		    		    public void actionPerformed(ActionEvent e) {
				    		revalidate();
				    		repaint();
		    			}
		    		});
		    		timer2.setRepeats(false);
		    		timer2.start();*/
		    	} else {
		    		System.out.println("Incorrect");
		    		/*panel.add(failure);
		    		revalidate();
		    		repaint();
		    		Timer timer2 = new Timer(delayMiliseconds2, new AbstractAction() {
		    		    @Override
		    		    public void actionPerformed(ActionEvent e) {
				    		revalidate();
				    		repaint();
		    			}
		    		});
		    		timer2.setRepeats(false);
		    		timer2.start();*/
		    	}
		    	
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Not required
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Not required
		
	}
	
	public String getSelected() {
		return selected;
		
	}

}
