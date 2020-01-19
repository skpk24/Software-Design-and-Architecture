public class App {

	public static void main(String[] args) {
    
		Rectangle rectangle = new Rectangle();
		
		rectangle.setLength(10);
		rectangle.setWidth(20);
		
		System.out.println(rectangle.calculateArea());
		
		Rectangle squar = new Squar();
		
		squar.setLength(20);
		
		System.out.println(squar.calculateArea());

	}

}

