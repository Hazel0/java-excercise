package Lesson1;

public class countBottles {
	int bottlesNum;
	int stopNum;
	
	public countBottles(int bonum, int stopnum) {
		this.bottlesNum = bonum;
		this.stopNum = stopnum;
	}
	
	public void count(){
		for(int i = bottlesNum; i > stopNum; i--) {
			if(i > 1) {
				System.out.printf("%d bottles of beer on the wall. %d bottles of beer. %nTakes one down. %nPass it around.%n", i, i);
				if(i > 2) {
					System.out.printf("%d bottles of beer on the wall.%n%n",i-1);
				}else{
					System.out.printf("%d bottle of beer on the wall.%n%n",i-1);
				}
			}else{
				System.out.printf("%d bottle of beer on the wall. %d bottle of beer.%nTakes one down.%nPass it around.%nNo more bottles of beer on the wall.", i, i);
			}
		}
	}
	
	public static void main(String[] args) {
		countBottles myco = new countBottles(99, 3);
		myco.count();		
	}
}
