public class AddressFactory {
	
	public static Address getInstance(String type) {
		if(type == null) return null;
		
		if(type.equals("SHIPPING")) {
			return new ShippingAddress();
		}else if(type.equals("BILLING")){
			return new BillingAddress();
		}
		return null;
	}
}
