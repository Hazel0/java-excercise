package manage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUntil {
	
	public ThreadUntil() {	}
	
	public static List<Object> runCheckCallable(List<Callable<Object>> list, boolean b) throws InterruptedException, ExecutionException {
		int taskSize = list.size();
        // 创建一个线程池
		ThreadPoolExecutor execute = (ThreadPoolExecutor) Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future<Object>> li = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            // 执行任务并获取Future对象
            Future<Object> f = execute.submit(list.get(i));
            li.add(f);
        }
        
        do{
			TimeUnit.MILLISECONDS.sleep(10);
		}while(execute.getCompletedTaskCount() < list.size());
 
        List<Object> reli = new ArrayList<>();
		for(Future<Object> fus : li) {
			reli.add(fus.get());
		}
		return reli;
	}
}
