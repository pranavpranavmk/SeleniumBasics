package seleneium;

public class Assadd1 extends Assmntadd{
	public void classB()
	{
		System.out.println("Print B");
	}
	public static void main(String[] args) {
		Assadd1 assadd1 =new Assadd1();
		assadd1.classA();
		assadd1.classB();
	}

}
