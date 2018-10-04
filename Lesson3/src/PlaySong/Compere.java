package PlaySong;

import java.io.*;
import java.util.ArrayList;

public class Compere extends Thread{
	public static ArrayList<Song> songLi = new ArrayList<Song>();	//歌单
	public static ArrayList<Song> preSongLi = new ArrayList<Song>();	//备用和已播放
	
	public Compere() {
		preSongLi.add(new Song("彩虹", "zjl", 23000));
	}
	 
   // 由此进入点个线程
   public void run(Customer c) throws IOException {
      try {
    	  
         for(int i = 10; i > 0; i--) {
        	 this.addSong(c);
            //每20秒确认一次
            Thread.sleep(20000);
         }
      } catch (InterruptedException e) {
         System.out.println("等候点歌出错");
      }
      System.out.println("退出等候点歌");
   }
   
	//确认是否有人点歌
	public void addSong(Customer c) throws IOException {
		System.out.println("是否有人点歌：1.是  2.否");
		String inputLine = null;
		try {
			BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
			new InputStreamReader(System.in);
			inputLine = is.readLine();
		}catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		if(Integer.parseInt(inputLine) == 1)
		{
			songLi.add(c.selectSong());
		}
	}
	
	//播放歌曲
	public Song play(Song s) {
		preSongLi.add(s);
		songLi.remove(s);
		return s;
	}
	
	//随机播放
	public Song randomPlay() {
		return preSongLi.get((int) (Math.random() *preSongLi.size()));
	}

}
