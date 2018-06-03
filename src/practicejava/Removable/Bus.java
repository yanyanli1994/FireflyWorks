package practicejava.Removable;

public class Bus extends Car{

	int p;
	
	public Bus(){		
	}
	
	public Bus(int p){
		this.p = p;
	}
	
	
	public Bus(int p,int v,String name){
		this(p);
		this.v = v;
	}
	
	void drive(){
		System.out.println("Bus�ٶȣ� "+v);
	}
	
	void carry(){
		System.out.println(name+"Bus���ˣ� "+this.p);
	}
	
	void sum(){
		System.out.println(name+"Bus�ٶȣ� "+super.v);
		System.out.println(name+"Bus���ˣ� "+p);
	}
}
