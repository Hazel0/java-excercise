package Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//
//����¼��Ա����Ϣ����ĳ�¹��ʼ�¼����ѯ����ĳ�˹��ʷ��ż�¼
//Ҳ���������д����ѯ�����˵Ĺ��ʼ�¼
//���Ҫ��ÿ�δ򿪳���Ҫ���½����Ա���ԭ����¼����Ҫ�Ķ�
//Ҳ����չ�򿪱�ʱ��ӵĹ��ʼ�¼�Ǳ��·ݵ�Ա�����ʷ��ż�¼

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
				System.out.print("�Ƿ�Ҫ���Ա����Ϣ: 1�� ��  2����\n");
				BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
				new InputStreamReader(System.in);
				try {
					//��ȡ�û�ѡ��
					String inputLine = is.readLine();
					int input = Integer.parseInt(inputLine);
					//�ж�ѡ���Ƿ����
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
				System.out.print("�Ƿ�Ҫ��ӹ�����Ϣ: 1�� ��  2����\n");
				BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
				new InputStreamReader(System.in);
				try {
					//��ȡ�û�ѡ��
					String inputLine = is.readLine();
					int input = Integer.parseInt(inputLine);
					//�ж�ѡ���Ƿ����
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
				System.out.print("�Ƿ�Ҫ����Ա��������Ϣ: 1�� ��  2����\n");
				BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
				new InputStreamReader(System.in);
				try {
					//��ȡ�û�ѡ��
					String inputLine = is.readLine();
					int input = Integer.parseInt(inputLine);
					//�ж�ѡ���Ƿ����
					if(input <= 0) {
						addWageflag = true;
					}else if(input < 2){
						System.out.print("������Ա������:\n");
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
