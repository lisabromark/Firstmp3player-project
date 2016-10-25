import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFileChooser;
import jaco.mp3.player.MP3Player;
import java.io.File;

public class PlayerMethods implements PlayerInterface {

	MP3Player player = new MP3Player();
	// FileInputStream fileInput;
	// BufferedInputStream bufferedInput;
	File file = new File("");
	String fileName;

	public PlayerMethods() {

	}

	public MP3Player getPlayer() {
		return player;
	}

	public void setPlayer(MP3Player player) {
		this.player = player;
	}

	public void open() {
		String track = null;
		String filePath = null;
		File fileToPlay;
		final JFileChooser fileChooser = new JFileChooser("/home/lisabromark/workspace/Firstmp3player-project/mp3");
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileToPlay = fileChooser.getSelectedFile();
			filePath = fileToPlay.getAbsolutePath();
			track = fileChooser.getSelectedFile().toURI().toString();
			// String song = file + "";
			// String name = fileChooser.getSelectedFile().getName();
		}
		MP3Player player = new MP3Player(new File(filePath));
		player.play();

	}

	public void play(String path) {
		// fileInput = new FileInputStream(path);
		// bufferedInput = new BufferedInputStream(fileInput);
		player = new MP3Player(new File(path));
		player.play();

	}

	public void stop() {
		if (player != null) {
			player.stop();
		}

	}

	public void pause() {
		if (player != null) {
			player.pause();
		}

	}

	

}
