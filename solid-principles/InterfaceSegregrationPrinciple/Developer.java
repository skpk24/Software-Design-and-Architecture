public class Developer implements Employee {

	@Override
	public void work() {
		System.out.println("Developer Work");
	}

	@Override
	public void applyForLeave() {
		System.out.println("Developer Need Leave");
	}

}
