public class Architect implements Employee{

	@Override
	public void work() {
		designDB();
		desing();
		workOnSpike();
		createPoC();
	}
	
	public void designDB() {
		System.out.println("Archited design DB.");
	}
	
	public void desing() {
		System.out.println("Architec design system.");
	}
	
	public void workOnSpike() {
		System.out.println("Architect work on spike.");
	}
	
	public void createPoC() {
		System.out.println("Architect creates POC.");
	}
}
