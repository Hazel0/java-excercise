package numberGuess;

import java.util.ArrayList;

public class Player {
	public String name;					//玩家姓名
	public ArrayList<Integer> nums;
	public int grade;						//得分
	
	public Player(String n) {
		this.name = n;
		this.nums = new ArrayList<Integer>();
		this.grade = 0;
	}
	public int guessNum() {					//猜数
		return this.randNum();
	}
	public void addGrade() {				//加分
		this.grade++;
	}
	
	public int randNum() {			//产生非重复随机数
		int randnumber = (int)(Math.random() * 10);
		for(int i = 0; i < this.nums.size(); i++) {
			if(!this.nums.contains(randnumber)) {
				return randNum();
			}
		}
		return randnumber;
	}
}
