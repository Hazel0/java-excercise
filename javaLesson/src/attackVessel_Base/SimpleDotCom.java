package attackVessel_Base;

public class SimpleDotCom {
	int[] locationCells;
	//用来记录网站被攻击的次数
	int numofHits = 0;
	
	public void setLocationCells(int[] arr){
		this.locationCells = arr;
	}
	
	public String checkYourself(String userGue) {
		int guess = Integer.parseInt(userGue);
		String result = "miss";
		
		for(int cell:locationCells) {
			if(guess == cell) {
				result = "hit";
				numofHits++;
				break;
			}
		}
		if(numofHits == locationCells.length) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	
}
