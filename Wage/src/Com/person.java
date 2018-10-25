package Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//所有公司人事
public class person {
	public String name;	    //姓名
	public String position; //身份
	public Calendar inauguationDate = Calendar.getInstance(); //入职日期/入股日期
	public Calendar birth = Calendar.getInstance(); 	//生日
	public int benefit; //员工或经理则代表月工资， 股东则代表股份
	
	public person createPerson() {
		boolean flag = false;
		while(!flag) {
			System.out.print("请输入此人的身份信息：1、普通员工  2、经理  3、股东\n");
			BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
			new InputStreamReader(System.in);
			try {
				String inputLine = is.readLine();
				int pos = Integer.parseInt(inputLine);
				//判断输入是否符合要求
				if(pos <= 0) {
					//不符合要求 返回空对象
					return null;
				}else if(pos < 2) {
					this.position = "普通员工";
				}else if(pos < 3) {
					this.position = "经理";
				}else if(pos < 4) {
					this.position = "股东";
				}else {
					return null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.print("请以括号内格式输入此员工/经理/股东的相关信息姓名、入职/入日期、生日、月工资或股份(姓名 年-月-日 年-月-日 月工资/股份）\n");
			is =  new BufferedReader(new InputStreamReader(System.in));
			new InputStreamReader(System.in);
			try {
				String inputLine = is.readLine();
				String arr[] = inputLine.split(" ");
				this.name = arr[0];
				this.benefit = Integer.parseInt(arr[3]);
				String[] date1 = arr[1].split("-");
				System.out.print(date1[0]);
				this.inauguationDate.set(Integer.parseInt(date1[0])-1, Integer.parseInt(date1[1])-1, Integer.parseInt(date1[2])-1);
				String[] date2 = arr[2].split("-");
				this.birth.set(Integer.parseInt(date2[0])-1, Integer.parseInt(date2[1])-1, Integer.parseInt(date2[2])-1);
				flag = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.print("输入格式有误！！！");
				flag = false;
			}
		}
		return this;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public String getInauguationDate() {
		return this.inauguationDate.get(this.inauguationDate.YEAR) + "." + this.inauguationDate.get(this.inauguationDate.MONTH) + "." + this.inauguationDate.get(this.inauguationDate.DATE);
	}
	
	public String getBirth() {
		return this.birth.get(this.birth.YEAR) + "." + this.birth.get(this.birth.MONTH) + "." + this.birth.get(this.birth.DATE);
	}
	
	public String getBenefit() {
		return this.benefit + "";
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public void setInauguationDate(String ina) {
		String[] arr = ina.split(".");
		this.inauguationDate.set(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
	}
	
	public void setBirth(String bir) {
		String[] arr = bir.split(".");
		this.birth.set(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
	}
	
	public void setBenefit(String ben) {
		this.benefit = Integer.parseInt(ben);
	}
		
	public String getInfo(){
		return this.name + " " + this.inauguationDate.YEAR + "." + this.inauguationDate.MONTH + "." + this.inauguationDate.DATE + " " + this.birth.YEAR + "." + this.birth.MONTH + "." + this.birth.DATE + " " + this.benefit;
	}
	
	public void setInfo(String s) {
		String arr[] = s.split(" ");
		this.name = arr[0];
		this.benefit = Integer.parseInt(arr[3]);
		String date1[] = arr[1].split(".");
		this.inauguationDate.set(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(date1[2]));
		String date2[] = arr[2].split(".");
		this.birth.set(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(date2[2]));
	}
}
