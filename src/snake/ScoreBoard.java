package snake;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class ScoreBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreBoard frame = new ScoreBoard(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScoreBoard(int Winner) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayerWon = new JLabel("Player "+Winner+" Won");
		lblPlayerWon.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPlayerWon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerWon.setBounds(96, 198, 235, 48);
		contentPane.add(lblPlayerWon);
		
		JLabel lblPlayer = new JLabel();
		ImageIcon player=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/player-"+Winner+".png")).getImage().getScaledInstance(100, 180, Image.SCALE_DEFAULT));
		lblPlayer.setIcon(player);
		lblPlayer.setBounds(156, 7, 100, 180);
		contentPane.add(lblPlayer);
	}

}
