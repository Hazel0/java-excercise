package numberGuess;

public class GuessLauncher{
	public static void main(String[] arg) {
		Player[] players = new Player[3];
		GuessGame game = new GuessGame();
		
		//初始化三个游戏对象
		players[0]= new Player("player1");
		players[1] = new Player("player1");
		players[2] = new Player("player3");
			
		//产生三个游戏数字
		game.giveNum();	
		
		while(game.checkGame()) {			//游戏是否结束？
			//游戏者分别给出各自猜的数字并进行检验
			for(int i = 0; i < 3; i++) {
				if(game.checkNum(players[i].guessNum())) {
					players[i].addGrade();
				}
			}
			if(game.rNum > -1) {
				game.deleteNum();
				System.out.printf("已猜中数字:%d" , game.rNum);
			}
		}
		

		Player winner = players[0].grade >= players[1].grade? players[0]:players[1];
		winner = winner.grade >= players[2].grade?winner:players[2];
		
		System.out.printf("the winner is:" +  winner.name);
 	}
}
