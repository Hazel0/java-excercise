package PlaySong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Customer {
	public Customer() {}
	
	//点歌
	public Song selectSong() throws IOException {
		Song song = null;
		String input1 = null,input2 = null;
		int input3 = 0;
			
		Scanner in1 =  new Scanner(System.in);
		System.out.println("请输入歌名,歌手，时长");
		input1 = in1.nextLine();
		input2 = in1.nextLine();
		input3 = Integer.parseInt(in1.nextLine());
		in1.close();
		
		song = new Song(input1, input2, input3);
		return song;
	}
}
