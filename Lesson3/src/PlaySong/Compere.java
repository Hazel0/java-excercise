package PlaySong;

import java.io.*;
import java.util.ArrayList;

public class Compere extends Thread{
	public static ArrayList<Song> songLi = new ArrayList<Song>();	//�赥
	public static ArrayList<Song> preSongLi = new ArrayList<Song>();	//���ú��Ѳ���
	
	public Compere() {
		preSongLi.add(new Song("�ʺ�", "zjl", 23000));
	}
	 
   // �ɴ˽������߳�
   public void run(Customer c) throws IOException {
      try {
    	  
         for(int i = 10; i > 0; i--) {
        	 this.addSong(c);
            //ÿ20��ȷ��һ��
            Thread.sleep(20000);
         }
      } catch (InterruptedException e) {
         System.out.println("�Ⱥ������");
      }
      System.out.println("�˳��Ⱥ���");
   }
   
	//ȷ���Ƿ����˵��
	public void addSong(Customer c) throws IOException {
		System.out.println("�Ƿ����˵�裺1.��  2.��");
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
	
	//���Ÿ���
	public Song play(Song s) {
		preSongLi.add(s);
		songLi.remove(s);
		return s;
	}
	
	//�������
	public Song randomPlay() {
		return preSongLi.get((int) (Math.random() *preSongLi.size()));
	}

}
