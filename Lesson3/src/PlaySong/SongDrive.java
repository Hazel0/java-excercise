package PlaySong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SongDrive extends Thread{
	public Compere master = new Compere();	//主持人
	public Customer player = new Customer();	//点歌的人
	
	public SongDrive() throws IOException {
		start();
		master.run(player);
	}
	
	public void run(){
		try {
			int dur = 3000; //歌时长或最开始等待点歌1时长
	    	  //开始活动，此次活动共播放5首歌
	         for(int i = 5; i >0; i--) {
	        	 Song song = null;
	            if(Compere.songLi.isEmpty())
	            {
	            	//如果歌单为空，则随机播放备用歌单
	            	song = this.master.randomPlay();
	            	dur = song.duration;
	            }else{
	            	//否则，有主持人指定歌单中的一首歌播放，或者播放下一首
	      			System.out.println("请主持人选择：1.播放下一首 2.指定歌单中的一首歌");
	      			String inputLine = null;
	      		
	      			Scanner is =  new Scanner(System.in);
	      			inputLine = is.nextLine();
	      			is.close();
	      			      			
	      			//播放下一首
	      			if(Integer.parseInt(inputLine) == 1 || inputLine.length() == 0)
	      			{
	      				song = Compere.songLi.get(0);
						this.master.play(song);
	      			}
      			
	      			//主持人指定
	      			if(Integer.parseInt(inputLine) == 2)
	      			{
	      				boolean flag = false;	//主持人点歌是否成功
	      				while(!flag) {
	      					System.out.println("歌单：");
	          				//打印歌单
	          				for(Song a:Compere.songLi) {
	          					System.out.println(Compere.songLi.indexOf(a) + ':' + a.songName);
	          				}
	          				System.out.println("请选择：");
	          				BufferedReader inpu =  new BufferedReader(new InputStreamReader(System.in));
	          				new InputStreamReader(System.in);
						    inputLine = inpu.readLine();
	          				int index = Integer.parseInt(inputLine);	//歌曲索引
	   	          		    if(index > Compere.songLi.size() || index < 0)
	          				{
	          					flag = false;
	          				}else {
	          					song = Compere.songLi.get(index);
	          					this.master.play(song);
	          					flag = true;
	          				}
	      				}
	      			}
	            }
	            System.out.println("现在播放" + song.songName + "  " + song.singer);
      			dur = song.duration;
	            Thread.sleep(dur);   //歌曲播放时间
	         }
	      }catch (InterruptedException | IOException e) {
	         System.out.println("程序出错停止." + e);
	      }
	      System.out.println("Main thread exiting.");
	}
	public static void main(String[] args) throws IOException {
		  SongDrive driver = new SongDrive(); 
	   }
}
