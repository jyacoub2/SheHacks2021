import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

public class MapGUI extends JFrame implements MouseListener {
	
	private Game play;
	private int delaySeconds;
	
	private String imgMap = "Map.jpg";
	private String selected;
	
	private ImageIcon map;
	private JLabel mapLabel;
	private JPanel panel;
	
	public MapGUI(Game play) {
		
		
		delaySeconds = 5;
		this.play = play;
		
		map = new ImageIcon(imgMap);
		mapLabel = new JLabel(map);
		mapLabel.setBounds(0, 0, 935, 700);
		
		panel = new JPanel();
		panel.add(mapLabel);
		panel.addMouseListener(this);
		
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
		/*try {
			TimeUnit.SECONDS.sleep(delaySeconds);
		} catch (InterruptedException f) {
			System.out.println("System interrupted...");
		}*/
		/*while (ansGUI.status == false) {
			
		}*/
		selected = ansGUI.getSelected();
		System.out.println("From MapGUI: " + selected);
		
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
