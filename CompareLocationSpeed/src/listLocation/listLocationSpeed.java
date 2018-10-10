package listLocation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class listLocationSpeed{
	public static void main(String[] args) throws IOException {
		//所有数据
		ArrayList<Integer> preli = new ArrayList<Integer>();
		
		//arrayList
		List<Integer> arrli = new ArrayList<Integer>();
		//hashSet
		Set<Integer> ihashset = new HashSet<Integer>();
		//linkedList
		List<Integer> linkli = new LinkedList<Integer>();
		//stack
		Stack<Integer> istack = new Stack<Integer>();
		//hashMap
		Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		//treeMap
		Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>();
		
		//用来导出数据到excel的封装
		List<Long> result = new ArrayList<>();
		
		//1000组数据，每添加1000个数据测一次
		for(int i = 1000000; i >= 10000;) {			
			for(int j = 0; j < i; j++) {
				preli.add(j);
			} 
			
			for(int j = 0; j > i; j--) {
				Integer num = preli.get((int)(Math.random()*preli.size()));
				arrli.add(num);
				ihashset.add(num);
				linkli.add(num);
				istack.add(num);
				hashmap.put(num, num);
				treemap.put(num, num);
				preli.remove(num);
			}
			
			Integer randomNum = new Integer((int)(Math.random()*i));	//产生一个随机数
			
			//arrList
			long startTime_arrli = System.nanoTime(); 				//程序开始记录时间
			arrli.indexOf(randomNum);											//查找
			long endTime_arrli = System.nanoTime(); 
			//程序结束记录时间
			long arrlitime = endTime_arrli - startTime_arrli;
			System.out.printf("在%d个数中查找%d需要：%d%n",i,randomNum,arrlitime);       				//总消耗时间
			
			//hashSet
			long startTime_hashset = System.nanoTime(); 				//程序开始记录时间
			ihashset.contains(randomNum);											//查找
			long endTime_hashset = System.nanoTime(); 
			long hashSettime = endTime_hashset - startTime_hashset;
			//程序结束记录时间
			System.out.printf("在%d个数中查找%d需要：%d%n",i,randomNum,hashSettime);       				//总消耗时间
			
			//linkedList
			long startTime_linkli = System.nanoTime(); 				//程序开始记录时间
			arrli.indexOf(randomNum);											//查找
			long endTime_linkli   = System.nanoTime(); 				//程序结束记录时间
			long linkedListtime = endTime_linkli - startTime_linkli;
			System.out.printf("在%d个数中查找%d需要：%d%n",i,randomNum, linkedListtime);       				//总消耗时间

			//stack
			long startTime_stack = System.nanoTime(); 				//程序开始记录时间
			istack.indexOf(randomNum);											//查找
			long endTime_stack   = System.nanoTime(); 				//程序结束记录时间
			long stacktime = endTime_stack - startTime_stack;
			System.out.printf("在%d个数中查找%d需要：%d%n",i,randomNum, stacktime);       				//总消耗时间
			
			//hashMap
			long startTime_hashmap = System.nanoTime(); 				//程序开始记录时间
			hashmap.containsValue(randomNum);											//查找
			long endTime_hashmap   = System.nanoTime(); 				//程序结束记录时间
			long hashmaptime = endTime_hashmap - startTime_hashmap;
			System.out.printf("在%d个数中查找%d需要：%d%n",i,randomNum,hashmaptime);       				//总消耗时间
			
			//treeMap
			long startTime_treemap = System.nanoTime(); 				//程序开始记录时间
			treemap.containsValue(randomNum);											//查找
			long endTime_treemap   = System.nanoTime(); 				//程序结束记录时间
			long treemaptime = endTime_treemap - startTime_treemap;
			System.out.printf("在%d个数中查找%d需要：%d%n",i,randomNum,treemaptime);       				//总消耗时间
			
			preli.clear();
			arrli.clear();
			ihashset.clear();
			
			result.add((long)i);
			result.add(arrlitime);
			result.add(hashSettime);
			result.add(linkedListtime);
			result.add(stacktime);
			result.add(hashmaptime);
			result.add(treemaptime);

			i = i - 10000;
		}
		
		String fileName = "location3.xls";        // 定义文件名
		//String headString = "查找速度统计表";          // 定义表格标题
		String sheetName = "工作表一";                  // 定义工作表表名
		String filePath = "G:\\";             // 文件本地保存路径
		String[] thead = {"","arrList","hashset","linkList","stack","hashmap","treemap"};                    // 定义表头内容
		int[] sheetWidth = {3500,3500,3500,3500,3500,3500,3500};   // 定义每一列宽度

		HSSFWorkbook wb = new HSSFWorkbook();           // 创建Excel文档对象
		HSSFSheet sheet = wb.createSheet(sheetName);    // 创建工作表
		// ①创建表格标题
		//ExcelUtil.createHeadTittle(wb, sheet, headString, result.get(0).size() - 1);

		// result.get(0).size() - 1为表格占用列数，从0开始1234

		// ②创建表头
		ExcelUtil.createThead(wb, sheet, thead, sheetWidth);

		// ③填入数据
		ExcelUtil.createTable(wb, sheet, result);
		
		FileOutputStream fos = new FileOutputStream(new File(filePath+fileName));
		// filePath,fileName是如上定义的文件保存路径及文件名
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fos.close();
		wb.close();
	}
}
