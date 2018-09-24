package Lesson1;

public class testString {
	public static void main(String[] args){
		String s1 = "s1";
		String s2 = s1;
		System.out.println(s1 == s2);	//true
		System.out.printf("%n");
		
		s2 = "s2";
		System.out.println(s1 == s2);	//false
		System.out.printf("%n");
		
		String s4 = new String("s4");
		String s5 = s4;
		System.out.println(s4 == s5);
		System.out.printf("%n");
		
		s5 = "s5";
		System.out.println(s4 == s5);
		System.out.printf("%n");
		
		String s6 = new String( "s6");
		String s7 = new String( "s6");
		System.out.println(s6 == s7);
		System.out.printf("%n");
		
		String s8 = "ja";
		String s9 = "va";
		String s10 = "java";
		String s11 = s8 + s9;
		System.out.println(s10 == s11);
		String s12 = "ja" +"va";
		System.out.println(s10 == s12);
		
	}
}
