public class Architect implements Employee {

	@Override
	public void work() {
		System.out.println("Architect Work");
	}

	@Override
	public void applyForLeave() {
		System.out.println("Architect Need Leave");
	}

}
