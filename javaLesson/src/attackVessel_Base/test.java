package attackVessel_Base;

public class test {
	public static void main(String[] args) {
		//记录玩家的猜测次数
		int numofGuesses = 0;
		//通过此类来去的玩家的输入
		GameHelper helper = new GameHelper();
		
		//创建dot com对象
		SimpleDotCom theDotCom = new SimpleDotCom();
		//利用随机数产生第一格的位置
		int randomNum = (int)(Math.random()*5);
		int[] locations = {randomNum, randomNum+1, randomNum+2};
		theDotCom.setLocationCells(locations);
		
		//创建出记录游戏是否继续进行的boolean变量
		boolean isAlive = true;
		
		while(isAlive == true) {
			//让玩家输入字符串
			String guess = helper.getUserInput("enter a number");
			//判断结果
			String result = theDotCom.checkYourself(guess);
			numofGuesses++;
			if(result.equals("kill")) {
				isAlive = false;
				System.out.println("You took" + numofGuesses + " 11guesses");
			}
		}
		
	}

}
