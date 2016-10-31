import jaco.mp3.player.MP3Player;

// inheriting abstract methods of the PlayerInterface 

public class PlayerMethods implements PlayerInterface {

// Class object = new constructor. Necessary to initialize new object.

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
		player.stop();
	}

	@Override
	public void pause() {
		player.pause();
	}
}
