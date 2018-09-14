# 第一次作业


## 1.数瓶子

```java
package Lesson1;

public class countBottles {
	public static int bottlesNum = 99;
	public static void main(String[] args) {
		for(int i = bottlesNum; i > 0; i--) {
			if(i > 1) {
				System.out.printf("%d bottles of beer on the wall. %d bottles of beer. %nTakes one down. %nPass it around.%n", i, i);
				if(i > 2) {
					System.out.printf("%d bottles of beer on the wall.%n%n",i-1);
				}else{
					System.out.printf("%d bottle of beer on the wall.%n%n",i-1);
				}
			}else {
					System.out.printf("%d bottle of beer on the wall. %d bottle of beer.%nTakes one down.%nPass it around.%nNo more bottles of beer on the wall.", i, i);
			}
		}
	}
}
```

##  2.String变量相关问题

```java
String s1 = "s1";
String s2 = s1;
System.out.printf(s1+"%n");		//s1
System.out.printf(s2+"%n");		//s1
System.out.println(s1 == s2);	//true
String s2 = "s1";
System.out.printf(s1+"%n");		//s1
System.out.printf(s2+"%n");		//s1
System.out.println(s1 == s2);	//true
s2 = "s2";
System.out.printf(s1+"%n");		//s1
System.out.printf(s2+"%n");		//s2
System.out.println(s1 == s2);	//false
```

如上：定义s1后，会在常量池中查找是否有对“s1”对象的引用，没有就会将创建对象，并将对象的引用放在常量池中，再将此引用返回给s1，
     s2 = "s1"时，同样会在会在常量池中查找是否有对“s1”对象的引用，于是直接将此引用返回给s2，
     s2 = "s2"时，会在常量池中查找是否有对“s1”对象的引用，没有就会将创建对象，并将对象的引用放在常量池中，再将此引用返回给s2，而不是去修改引用的对象的数据
     

```java
String s8 = "ja";
		String s9 = "va";
		String s10 = "java";
		String s11 = s8 + s9;
		System.out.println(s10 == s11);		//false  ???
		System.out.println(s10 == s12);         //true
```

 参考文章：https://my.oschina.net/xiaohui249/blog/170013
       
            https://blog.csdn.net/uyninger/article/details/77621183
	    
	    https://www.cnblogs.com/luankun0214/p/4433720.html


## 3.如何获取变量的内存地址
	System.out.println(obj.hashcode())输出的时对象的哈希码，
	 而非内存地址。在Java中是不可能得到对象真正的内存地址的，因为Java中堆是由JVM管理的不能直接操作。 
	 只能说此时打印出的Hash码表示了该对象在JAVA虚拟机中的内存位置，Java虚拟机会根据该hash码最终在真正的的堆空间中给该对象分配一个地址. 
	 
	 参考地址：
	 https://blog.csdn.net/id19870510/article/details/4877537
