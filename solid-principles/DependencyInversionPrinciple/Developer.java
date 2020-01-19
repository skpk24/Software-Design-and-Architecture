public class Developer implements Employee{
	
	@Override
	public void work() {
		writeCode();
		unitTest();
		bugFix();
		release();
	}
	
	public void writeCode() {
		System.out.println("Developer writing code.");
	}
	
	public void unitTest() {
		System.out.println("Developer unit test.");
	}
	
	public void bugFix() {
		System.out.println("Developer fix bugs.");
	}
	
	public void release() {
		System.out.println("Developer releases.");
	}
}
