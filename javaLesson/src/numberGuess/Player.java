package numberGuess;

import java.util.ArrayList;

public class Player {
	public String name;					//�������
	public ArrayList<Integer> nums;
	public int grade;						//�÷�
	
	public Player(String n) {
		this.name = n;
		this.nums = new ArrayList<Integer>();
		this.grade = 0;
	}
	public int guessNum() {					//����
		return this.randNum();
	}
	public void addGrade() {				//�ӷ�
		this.grade++;
	}
	
	public int randNum() {			//�������ظ������
		int randnumber = (int)(Math.random() * 10);
		for(int i = 0; i < this.nums.size(); i++) {
			if(!this.nums.contains(randnumber)) {
				return randNum();
			}
		}
		return randnumber;
	}
}
