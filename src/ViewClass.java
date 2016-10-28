import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;

import jaco.mp3.player.MP3Player;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;

public class ViewClass implements ActionListener {

	// Class object = new constructor. Necessary to initialize new object.

	PlayerMethods playerMethods = new PlayerMethods();

	// Defining attributes

	public JFrame frame;
	private JButton btnPlay = new JButton("play");
	private JButton btnStop = new JButton("stop");
	private JButton btnPause = new JButton("pause");
	private JButton btnOpen = new JButton("open");
	private JLabel lblMyMusic = new JLabel("my music");

	/**
	 * Create the application. Constructor for this class.
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
		frame.setTitle("My first player");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.PINK);
		btnPlay.setFont(new Font("FreeSerif", Font.BOLD, 16));
		btnPlay.setBounds(27, 80, 107, 22);
		btnPlay.setEnabled(false);
		btnStop.setFont(new Font("FreeSerif", Font.BOLD, 16));
		btnStop.setBounds(321, 79, 117, 25);
		btnStop.setEnabled(false);
		btnPause.setFont(new Font("FreeSerif", Font.BOLD, 16));
		btnPause.setBounds(170, 79, 117, 25);
		btnPause.setEnabled(false);
		btnOpen.setFont(new Font("FreeSerif", Font.BOLD, 16));
		btnOpen.setBounds(113, 43, 249, 25);
		lblMyMusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyMusic.setForeground(new Color(51, 51, 51));
		lblMyMusic.setFont(new Font("FreeSerif", Font.BOLD, 20));
		lblMyMusic.setBounds(101, 174, 261, 57);

	}

	public void addComponentsToFrame() {
		frame.getContentPane().add(btnPlay);
		frame.getContentPane().add(btnStop);
		frame.getContentPane().add(btnPause);
		frame.getContentPane().add(btnOpen);
		frame.getContentPane().add(lblMyMusic);

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
			playerMethods.play();

		}

		if (e.getSource() == btnStop) {
			playerMethods.stop();
		}

		if (e.getSource() == btnPause) {
			playerMethods.pause();

		}

		if (e.getSource() == btnOpen) {

			JFileChooser fileChooser = new JFileChooser("/home/lisabromark/workspace/Firstmp3player-project");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 file", "mp3");
			fileChooser.setFileFilter(filter);
			int returnVal = fileChooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				playerMethods.stop();
				
				btnPlay.setEnabled(true);
				btnStop.setEnabled(true);
				btnPause.setEnabled(true);
				File songToPlay = fileChooser.getSelectedFile();
				playerMethods.setPlayer(new MP3Player(songToPlay));
				String nameOfSong = fileChooser.getSelectedFile().getName();
				lblMyMusic.setText(nameOfSong);

				playerMethods.open();

			}
		}

	}

}
