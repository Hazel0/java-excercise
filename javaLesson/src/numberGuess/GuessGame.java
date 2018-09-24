package numberGuess;

public class GuessGame {
	private int[] numbers;			//游戏产生的随机数
	public int rNum; 				//存储当前猜中的数字
	
	public GuessGame() {
		this.numbers = new int[3];
		this.rNum = -1;
	}	
	
	public void giveNum() {					//产生随机数
		for(int i = 0; i < 3; i++) {
			this.numbers[i] = randNum(i);		
		}
	}
	
	public int randNum(int se) {			//产生非重复随机数
		int randnumber = (int)(Math.random() * 10);
		for(int i = 0; i < se; i++) {
			if(randnumber == this.numbers[i]) {
				return randNum(se);
			}
		}
		return randnumber;
	}
	
	public boolean checkNum(int n) {		//检查数字是否猜对
		for(int i = 0; i < 3; i++) {
			if(n == this.numbers[i]) {
				this.rNum = n;
				return true;
			}
		}
		return false;
	}	
	
	public boolean checkGame() {		//检查游戏是否结束
		for(int i:this.numbers) {
			if(i == -1) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteNum() {
		for(int i = 0; i < 3; i++) {
			if(this.numbers[i] == this.rNum) {
				this.numbers[i] = -1;
			}
		}
	}
}
