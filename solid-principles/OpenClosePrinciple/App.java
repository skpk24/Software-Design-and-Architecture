public class App {

	public static void main(String[] args) {
		Product product = new FinishedProduct();
		
		product.fetchProductDetails();
		
		product = new DigitalProduct();
		
		product.fetchProductDetails();
		
		product = new ConfigurableProduct();
		
		product.fetchProductDetails();
	}
	
}
