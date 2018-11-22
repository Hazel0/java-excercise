package com.captain.demo.threadNoSafe;

import java.util.List;

/**
 * 线程安全演示类
 * Created by captain on 2017/7/27.
 */
public class ThreadSafeDemo3 implements Runnable{

    private List<String> list;

    public ThreadSafeDemo3(List<String> list){
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            if(list.size()>0){
                list.remove(0);
                System.out.println("删除一个后尺寸："+list.size());
            }
        }
    }
}
