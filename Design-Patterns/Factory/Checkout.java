public class Checkout {
	
	public static void main(String args[]) {
		Address billingAddress = AddressFactory.getInstance("BILLING");
		billingAddress.createAddress();
		
		Address shippingAddress = AddressFactory.getInstance("SHIPPING");
		shippingAddress.createAddress();
	}
}
