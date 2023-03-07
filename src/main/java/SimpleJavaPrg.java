
public class SimpleJavaPrg {
	static String ename;
	static int esalary;
	public void set(String name,int salary) {
		ename=name;
		esalary=salary;
	}
	public void get() {
	System.out.println( "Employee Name is" +ename);
	System.out.println("Salary is" +esalary);	
}
	public static void main(String[] args) {
		SimpleJavaPrg aa=new SimpleJavaPrg();
        aa.set("Arun",15000);
        aa.get();
	}

}
