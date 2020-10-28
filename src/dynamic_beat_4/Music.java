package dynamic_beat_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{

	
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			//음악파일 재생하기 위한 세트
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		if(player == null)
			return 0;
		//오디오 샘플의 위피를 밀리 초 단위로 검색함
		return player.getPosition();
	}
	
	//종료
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	
	//Subclasses of Thread should override this method.
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
