package attackVessel_Complex;
import java.io.*;
import java.util.ArrayList;

public class GameHelper {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + "  ");
		try {
			BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
			new InputStreamReader(System.in);
			inputLine = is.readLine();
			if(inputLine.length() == 0) {
				return null;
			}
		}catch(IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine;
	}
	
	public ArrayList<String> placeDotCom(int comSize){
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphacoords = new String[comSize];			//保	存字符串
		String temp = null;									//临时字符串
		int[] coords = new int[comSize];					//现有字符串
		int attempts = 0;									//目前测试的字符串
		boolean success = false;							//是否找到合适的位置
		int location = 0; 									//目前起点
		
		comCount++;											//现在处理到第n个
		int incr = 1;										//水平增量
		if(comCount % 2 == 1) {
			incr = gridLength;								//垂直增量
		}
		
		while(!success & attempts++ < 200) {				//主要搜索循环			
			location = (int)(Math.random()*gridSize);       //随机起点
			int x = 0;
			success = true;
			while(success && x < comSize) {
				if(grid[location] == 0) {
					coords[x++] = location;					//存储位置
					location += incr;						//尝试下一个点
					if(location >= gridSize) {				//超出下边缘
						success = false;
					}
					if(x>0 && (location % gridLength == 0)) {
						success = false;
					}
				}else {
					success = false;
				}
			}
		}
		
		int x = 0;									//将位置转化为字符串格式
		int row = 0;
		int column = 0;
		while(x < comSize) {
			grid[coords[x]] = 1;					//表示格子已用
			row = (int)(coords[x]/gridLength);		//得到行的值
			column = coords[x]%gridLength;			//得到列的值
			temp = String.valueOf(alphabet.charAt(column));	//转换为字符串
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
		}
		
		return alphaCells;
	}
}
