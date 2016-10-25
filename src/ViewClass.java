import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;

public class ViewClass implements ActionListener {
	
	PlayerMethods playerMethods = new PlayerMethods();
	

	private JFrame frame;
	private JButton btnPlay = new JButton("play");
	private JButton btnStop = new JButton("stop");
	private JButton btnPause = new JButton("pause");
	private JButton btnOpen = new JButton("open");
	
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ViewClass window = new ViewClass();
		window.frame.setVisible(true);

	}

	/**
	 * Create the application.
	 */

	public ViewClass() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void createGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnPlay.setBounds(41, 68, 107, 22);
		btnStop.setBounds(321, 67, 117, 25);
		btnPause.setBounds(180, 67, 117, 25);
		btnOpen.setBounds(170, 23, 117, 25);
	
	}

	public void addComponentsToFrame() {
		frame.getContentPane().add(btnPlay);
		frame.getContentPane().add(btnStop);
		frame.getContentPane().add(btnPause);
		frame.getContentPane().add(btnOpen);

	}

	public void addActionListeners() {

		btnPlay.addActionListener(this);
		btnStop.addActionListener(this);
		btnPause.addActionListener(this);
		btnOpen.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPlay) {
			//new MP3Player(new File("/home/lisabromark/workspace/Firstmp3player-project/FooFightersEverlong.mp3")).play();
			playerMethods.play("/home/lisabromark/workspace/Firstmp3player-project/FooFightersEverlong.mp3");
		}
		if (e.getSource() == btnStop) {
			playerMethods.stop();
		}
		if (e.getSource() == btnPause) {
			playerMethods.pause();
		}
		if (e.getSource() == btnOpen) {
			playerMethods.open();
		}

	}
}
