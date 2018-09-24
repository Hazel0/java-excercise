package numberGuess;

public class GuessGame {
	private int[] numbers;			//��Ϸ�����������
	public int rNum; 				//�洢��ǰ���е�����
	
	public GuessGame() {
		this.numbers = new int[3];
		this.rNum = -1;
	}	
	
	public void giveNum() {					//���������
		for(int i = 0; i < 3; i++) {
			this.numbers[i] = randNum(i);		
		}
	}
	
	public int randNum(int se) {			//�������ظ������
		int randnumber = (int)(Math.random() * 10);
		for(int i = 0; i < se; i++) {
			if(randnumber == this.numbers[i]) {
				return randNum(se);
			}
		}
		return randnumber;
	}
	
	public boolean checkNum(int n) {		//��������Ƿ�¶�
		for(int i = 0; i < 3; i++) {
			if(n == this.numbers[i]) {
				this.rNum = n;
				return true;
			}
		}
		return false;
	}	
	
	public boolean checkGame() {		//�����Ϸ�Ƿ����
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
