# 第一次作业


1. 数瓶子

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


