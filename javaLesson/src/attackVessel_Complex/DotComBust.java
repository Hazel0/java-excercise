package attackVessel_Complex;
import java.util.*;

public class DotComBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numofGuesses = 0;

	private void setUpGame() {
		//first make some dot coms and give them locations
		//创建3个DotCom对象并指派名称
		//声明并初始化变量
		DotCom one = new DotCom();
		one.setName("Pet.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		//列出简单的提示
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com., Go2.com");
		System.out.println("Try to sink time all in the fewest number of gusses");
		
		//要求DotCom的位置
		for(DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}		
	}
	
	//要求游戏对象启动
	private void startPlaying() {
		//判断DotComList是否为空
		while(!dotComsList.isEmpty()) {
			//取得为玩家输入
			String userGuess = helper.getUserInput("enter a guess");
			checkUserGuess(userGuess);
		}
		finshGame();
	}
	
	private void checkUserGuess(String userGuess) {
		//递增玩家猜测次数的计数
		numofGuesses++;
		String result = "miss";
		
		//对list中所有的dotCom重复
		for(DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	//这家伙被挂掉了
	private void finshGame() {
		System.out.println("All dot coms are dead!Your stock is now worthless.");
		if(numofGuesses <= 18) {
			System.out.println("It only took you" + numofGuesses + "guesses.");
			System.out.println("You got out before your options sank.");
		}else {
			System.out.println("Took you long enough." + numofGuesses+ "guesses");
			System.out.println("Fish are dancing with your optioins.");
		}
	}
	
	public static void main(String[] args) {
		//创建游戏对象
		DotComBust game = new DotComBust();
		//要求游戏对象启动
		game.setUpGame();
		//要求游戏启动游戏的主要循环
		game.startPlaying();
	}
}
