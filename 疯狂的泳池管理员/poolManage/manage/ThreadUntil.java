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
	
	/**
     * 线程池管理工具
     * 传入一组带有返回值的线程，然后由工具类统一管理，并把最终的线程运行集合返回
     * @param list       线程集合
     * @param isBlock    是否阻塞标示位，如果为false，则线程启动后立即返回，否则等待所有线程均有结果后返回（推荐使用true）
     * @return           线程运行结果集合，仅返回已运行结束的线程集合，如都未结束，则返回尺寸为0的list
     * @throws ExecutionException
     * @throws InterruptedException
     */
	public static List<Object> runCheckCallable(List<Callable<Object>> list, boolean isBlock) throws InterruptedException, ExecutionException {
		int taskSize = list.size();
        // 创建一个线程池
		ThreadPoolExecutor execute = (ThreadPoolExecutor) Executors.newFixedThreadPool(taskSize);
        
		if (!isBlock){
            return new ArrayList<>();
        }
		
		// 创建多个有返回值的任务
        List<Future<Object>> li = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            // 执行任务并获取Future对象
            Future<Object> f = execute.submit(list.get(i));
            li.add(f);
        }
 
        List<Object> reli = new ArrayList<>();
		for(Future<Object> fus : li) {
			reli.add(fus.get());
		}
		return reli;
	}
}
