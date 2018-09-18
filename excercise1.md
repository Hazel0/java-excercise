# 第一次作业


## 1.数瓶子

```java
package Lesson1;

public class countBottles {
	int bottlesNum;
	int stopNum;
	
	public countBottles(int bonum, int stopnum) {
		this.bottlesNum = bonum;
		this.stopNum = stopnum;
	}
	
	public void count(){
		for(int i = bottlesNum; i > stopNum; i--) {
			if(i > 1) {
				System.out.printf("%d bottles of beer on the wall. %d bottles of beer. %nTakes one down. %nPass it around.%n", i, i);
				if(i > 2) {
					System.out.printf("%d bottles of beer on the wall.%n%n",i-1);
				}else{
					System.out.printf("%d bottle of beer on the wall.%n%n",i-1);
				}
			}else{
				System.out.printf("%d bottle of beer on the wall. %d bottle of beer.%nTakes one down.%nPass it around.%nNo more bottles of beer on the wall.", i, i);
			}
		}
	}
	
	public static void main(String[] args) {
		countBottles myco = new countBottles(99, 3);
		myco.count();		
	}
}
```

##  2.String变量相关问题

```java
String s1 = "s1";
String s2 = s1;
System.out.println(s1 == s2);	//true

String s2 = "s1";
System.out.println(s1 == s2);	//true

s2 = "s2";
System.out.println(s1 == s2);	//false
```
我的理解：在java中String是一个对象类型，因此使用String创建一个对象时，如：String s1 = "s1"， jvm会在堆内存中查找是否有数据为“s1”的对象，没有则创建对象，并把对象的引用经过哈希计算将其交给s1保存，当初创建String s2 = s1时，也是将s1中保存的对象引用给s2copy了一份，当s2 = "s2"，并不是将s2引用的对象修改，而是jvm又在内存中查看有没有这样的对象，结果没有于是重新创建一个对象，并将对象的引用交给s2.


## 3.如何获取变量的内存地址
	System.out.println(obj.hashcode())输出的时对象的哈希码，
	 而非内存地址。在Java中是不可能得到对象真正的内存地址的，因为Java中堆是由JVM管理的不能直接操作。 
	 只能说此时打印出的Hash码表示了该对象在JAVA虚拟机中的内存位置，Java虚拟机会根据该hash码最终在真正的的堆空间中给该对象分配一个地址. 
	 
  参考地址：https://blog.csdn.net/id19870510/article/details/4877537
