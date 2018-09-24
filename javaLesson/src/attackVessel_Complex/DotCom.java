package attackVessel_Complex;

import java.util.*;

public class DotCom {
	private ArrayList<String> locationCells;
	//用来记录网站被攻击的次数
	private String name;
	
	public void setLocationCells(ArrayList<String> arr){
		this.locationCells = arr;
	}
	
	public void setName(String n) {
		name = n;
	}	
	
	public String checkYourself(String userGue) {
		String result = "miss";
		int index = locationCells.indexOf(userGue);
		
		if(index >= 0) {
			locationCells.remove(index);

			if(locationCells.isEmpty()) {
				result = "kill";
				System.out.println("You sunk " + name + " : (");
			}else {
				result = "hit";
			}
		}
		return result;
	}
	
}
