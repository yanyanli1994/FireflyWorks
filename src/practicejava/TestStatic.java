package practicejava;

public class TestStatic {

	static String staticvar = "a";
	static int c =0;
	
	
	static{
	   System.out.println("1)��ʼ����̬�飺TestStatic");
	}
	
	{
	 
		 System.out.println("2)��ʼ���Ǿ�̬�飺TestStatic");
	}
	
	
	public TestStatic(){
		
	}
	public static void testStaticMethod(){
		System.out.println(staticvar);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]){
		TestStatic s1 = new TestStatic();

		
		TestStatic s2 = new TestStatic();	
		
		
		
		
		/*String a = "abc";
		a = "bcd";*/
		
		/*StringBuffer b = new StringBuffer("abc");
		b.delete(0, b.length());
		b.append("aaa");
		System.out.println(b.toString());*/
		
	}
}
