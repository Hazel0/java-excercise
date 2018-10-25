package Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

//���й�˾����
public class person {
	public String name;	    //����
	public String position; //���
	public Calendar inauguationDate = Calendar.getInstance(); //��ְ����/�������
	public Calendar birth = Calendar.getInstance(); 	//����
	public int benefit; //Ա������������¹��ʣ� �ɶ������ɷ�
	
	public person createPerson() {
		boolean flag = false;
		while(!flag) {
			System.out.print("��������˵������Ϣ��1����ͨԱ��  2������  3���ɶ�\n");
			BufferedReader is =  new BufferedReader(new InputStreamReader(System.in));
			new InputStreamReader(System.in);
			try {
				String inputLine = is.readLine();
				int pos = Integer.parseInt(inputLine);
				//�ж������Ƿ����Ҫ��
				if(pos <= 0) {
					//������Ҫ�� ���ؿն���
					return null;
				}else if(pos < 2) {
					this.position = "��ͨԱ��";
				}else if(pos < 3) {
					this.position = "����";
				}else if(pos < 4) {
					this.position = "�ɶ�";
				}else {
					return null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.print("���������ڸ�ʽ�����Ա��/����/�ɶ��������Ϣ��������ְ/�����ڡ����ա��¹��ʻ�ɷ�(���� ��-��-�� ��-��-�� �¹���/�ɷݣ�\n");
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
				System.out.print("�����ʽ���󣡣���");
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
