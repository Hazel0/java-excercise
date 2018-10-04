package PlaySong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SongDrive extends Thread{
	public Compere master = new Compere();	//������
	public Customer player = new Customer();	//������
	
	public SongDrive() throws IOException {
		start();
		master.run(player);
	}
	
	public void run(){
		try {
			int dur = 3000; //��ʱ�����ʼ�ȴ����1ʱ��
	    	  //��ʼ����˴λ������5�׸�
	         for(int i = 5; i >0; i--) {
	        	 Song song = null;
	            if(Compere.songLi.isEmpty())
	            {
	            	//����赥Ϊ�գ���������ű��ø赥
	            	song = this.master.randomPlay();
	            	dur = song.duration;
	            }else{
	            	//������������ָ���赥�е�һ�׸貥�ţ����߲�����һ��
	      			System.out.println("��������ѡ��1.������һ�� 2.ָ���赥�е�һ�׸�");
	      			String inputLine = null;
	      		
	      			Scanner is =  new Scanner(System.in);
	      			inputLine = is.nextLine();
	      			is.close();
	      			      			
	      			//������һ��
	      			if(Integer.parseInt(inputLine) == 1 || inputLine.length() == 0)
	      			{
	      				song = Compere.songLi.get(0);
						this.master.play(song);
	      			}
      			
	      			//������ָ��
	      			if(Integer.parseInt(inputLine) == 2)
	      			{
	      				boolean flag = false;	//�����˵���Ƿ�ɹ�
	      				while(!flag) {
	      					System.out.println("�赥��");
	          				//��ӡ�赥
	          				for(Song a:Compere.songLi) {
	          					System.out.println(Compere.songLi.indexOf(a) + ':' + a.songName);
	          				}
	          				System.out.println("��ѡ��");
	          				BufferedReader inpu =  new BufferedReader(new InputStreamReader(System.in));
	          				new InputStreamReader(System.in);
						    inputLine = inpu.readLine();
	          				int index = Integer.parseInt(inputLine);	//��������
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
	            System.out.println("���ڲ���" + song.songName + "  " + song.singer);
      			dur = song.duration;
	            Thread.sleep(dur);   //��������ʱ��
	         }
	      }catch (InterruptedException | IOException e) {
	         System.out.println("�������ֹͣ." + e);
	      }
	      System.out.println("Main thread exiting.");
	}
	public static void main(String[] args) throws IOException {
		  SongDrive driver = new SongDrive(); 
	   }
}
