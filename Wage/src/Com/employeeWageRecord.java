package Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class employeeWageRecord {
	public String name;
	public int wage;
	public int sendWageDate; 
	
	public employeeWageRecord createEmployeeWageRecord() {
		System.out.print("请以括号内格式输入此员工/经理的相关信息姓名、此月工资、工资发放日期(姓名 工资 日）");
		BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
		new InputStreamReader(System.in);
		try {
			String inputLine = is.readLine();
			String arr[] = inputLine.split(" ");
			this.name = arr[0];
			this.wage = Integer.parseInt(arr[1]);
			this.sendWageDate = Integer.parseInt(arr[2]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getWage() {
		return this.wage + "";
	}
	
	public String getSendWageDate() {
		return this.sendWageDate + "";
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setWage(String w) {
		this.wage = Integer.parseInt(w);
	}
	
	public void setSendWageDate(String date) {
		this.sendWageDate = Integer.parseInt(date);
	}
	
	public String getInfo(){
		return this.name + " " + this.wage + "." + this.sendWageDate;
	}
	
	public void printInfo(){
		System.out.print(this.name + " " + this.wage + " " + this.sendWageDate);
	}
	
	public void setInfo(String s) {
		String arr[] = s.split(" ");
		this.name = arr[0];
		this.wage = Integer.parseInt(arr[1]);
		this.sendWageDate = Integer.parseInt(arr[2]);
	}
}
