package Music;

import javazoom.jl.player.MP3Player;

public class intro_BGM {
	public intro_BGM() {
		MP3Player mp3 = new MP3Player();
		
		if (mp3.isPlaying() == false) {
			mp3.play("C:\\Jo_java\\java\\BeggarGraw_GAME\\src\\Music\\lady-of-the-80x27s-128379.mp3");
		}
	}
}
