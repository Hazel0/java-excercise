1. 
```java
        countBottles myco = new countBottles(99, 3);
	countBottles i = new countBottles(99, 3);
	System.out.println(i == myco); //false
	System.out.println(i.equals(myco));//false

	countBottles j = myco;
	System.out.println(j == myco);//true
	System.out.println(j.equals(myco));//true

	String a = "3524";
	String b = a;
	System.out.println(a == b);//true
	System.out.println(a.equals(b));//true

	String c = "3524";
	System.out.println(c == a); //true
	System.out.println(c.equals(a));//true

	int cc = 10;
	int dd = 10;
	System.out.println(cc == dd);

	Integer ccc = 10;
	Integer ddd = 10;
	System.out.println(ccc == ddd);//true
	System.out.println(ccc.equals(ddd));//true

	ddd = ccc;
	System.out.println(ccc == ddd);//true
	System.out.println(ccc.equals(ddd));//true

	ddd = 20;
	System.out.println(ccc);//10
	System.out.println(ddd);//20

2.      equals 和 == 的区别
 
     
java中的数据类型，可分为两类： 

1.基本数据类型，也称原始数据类型。byte,short,char,int,long,float,double,boolean 

  他们之间的比较，应用双等号（==）,比较的是他们的值。 
  
2.复合数据类型(类) 

  当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址，所以，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。  JAVA当中所有的类都是继承于Object这个基类的，在Object中的基类中定义了一个equals的方法，这个方法的初始行为是比较对象的内存地 址，但在一些类库当中这个方法被覆盖掉了，如String,Integer,Date在这些类当中equals有其自身的实现，而不再是比较类在堆内存中的存放地址了。
  
  对于复合数据类型之间进行equals比较，在没有覆写equals方法的情况下，他们之间的比较还是基于他们在内存中的存放位置的地址值的，因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）的结果相同。
