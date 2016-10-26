import javax.swing.JOptionPane;

import jaco.mp3.player.MP3Player;

public class PlayerMethods implements PlayerInterface {

	MP3Player player = new MP3Player();

	public PlayerMethods() {

	}

	public MP3Player getPlayer() {
		return player;
	}

	public void setPlayer(MP3Player player) {
		this.player = player;
	}

	@Override
	public void open() {
		player.play();

	}

	@Override
	public void play() {
				player.play();
		
	}

	@Override
	public void stop() {
				if (player != null){
				player.stop();
						
		}else if (player == null){
			JOptionPane.showMessageDialog(null,"Please open a file first!");
		}
	}
	
	@Override
	public void pause() {
		player.pause();
	
	}


}
