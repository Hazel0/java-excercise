package Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//
//功能录入员工信息、和某月工资记录、查询此月某人工资发放记录
//也可利用现有代码查询所有人的工资记录
//如果要想每次打开程序不要重新建表、以保存原来记录、需要改动
//也可扩展打开表时添加的工资记录是本月份的员工工资发放记录

public class manage {
	public ExcelManage ComExcel = new ExcelManage();
	public boolean flag = true;
	
	public manage() {
		this.ComExcel.fileExist("WageManage.xls");
		this.ComExcel.fileExist("WageManage.xls");
		String[] str1 = {"name", "position", "inauguationDate", "birth", "benefit"} ;
		String[] str2 = {"name", "wage", "sendWageDate"};
		this.ComExcel.createExcel("WageManage1.xls", "baseInfo", str1);
		this.ComExcel.createExcel("WageManage2.xls", "OctWage", str2);
	}
	
	public static void main(String[] args) {
		manage com = new manage();
		while(com.flag) {
			boolean addInfoflag = true;
			while(addInfoflag) {
				System.out.print("是否要添加员工信息: 1、 是  2、否\n");
				BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
				new InputStreamReader(System.in);
				try {
					//读取用户选择
					String inputLine = is.readLine();
					int input = Integer.parseInt(inputLine);
					//判断选择是否合理
					if(input <= 0) {
						addInfoflag = true;
					}else if(input < 2){
						person one = new person();
						one.createPerson();
						com.ComExcel.writeToExcel("G:\\WageManage1.xls", "baseInfo", one);
					}else if(input < 3) {
						addInfoflag = false;
					}else {
						addInfoflag = true;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					addInfoflag = true;
				}
			}
			boolean addWageflag = true;
			while(addWageflag) {
				System.out.print("是否要添加工资信息: 1、 是  2、否\n");
				BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
				new InputStreamReader(System.in);
				try {
					//读取用户选择
					String inputLine = is.readLine();
					int input = Integer.parseInt(inputLine);
					//判断选择是否合理
					if(input <= 0) {
						addWageflag = true;
					}else if(input < 2){
						employeeWageRecord one = new employeeWageRecord();
						one.createEmployeeWageRecord();
						com.ComExcel.writeToExcel("G:\\WageManage2.xls", "OctWage", one);
					}else if(input < 3) {
						addWageflag = false;
					}else {
						addWageflag = true;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					addInfoflag = true;
				}
			}
			boolean searchWageRecord = true;
			while(searchWageRecord) {
				System.out.print("是否要查找员工工资信息: 1、 是  2、否\n");
				BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
				new InputStreamReader(System.in);
				try {
					//读取用户选择
					String inputLine = is.readLine();
					int input = Integer.parseInt(inputLine);
					//判断选择是否合理
					if(input <= 0) {
						addWageflag = true;
					}else if(input < 2){
						System.out.print("请输入员工姓名:\n");
						is =  new BufferedReader(new InputStreamReader(System.in));
						new InputStreamReader(System.in);
						inputLine = is.readLine();
						employeeWageRecord one = new employeeWageRecord();
						String str = com.ComExcel.readFromExcel("G:\\WageManage2.xls", "OctWage", one, inputLine);
						if(str != null) {
							one.setInfo(str);
							one.printInfo();	
						}
					}else if(input < 3) {
						addWageflag = false;
					}else {
						addWageflag = true;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					searchWageRecord = true;
				}
			}
		}
	}
}
