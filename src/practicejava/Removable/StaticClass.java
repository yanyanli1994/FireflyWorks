package practicejava.Removable;

public class StaticClass {
	//��̬����
	public static int i = 0;
	
	public StaticClass(){
		i = 15;
	}
	
	public StaticClass(int n){
		i = n;
	}
	

	
	//��̬����
	public static void inc(String str){
		System.out.println(str);		
	}

	public static void inc(){
		i++;
	}
}
