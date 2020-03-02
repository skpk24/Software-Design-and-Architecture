
enum Processor 
{ 
    I3("CORE i3"), I5("CORE i5"), I7("CORE i7"); 
	
	private String code;
	
	Processor(String code){
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
} 

public class LapTop {
	private String brand;
	private String processorType;
	private String ram;
	private String screenType;
	private Boolean isTouch;
	private String graphicCardRam;
	private Double screenSize;
	
	public String getbrand() {
		return brand;
	}
	public String getProcessorType() {
		return processorType;
	}
	public String getRam() {
		return ram;
	}
	public String getScreenType() {
		return screenType;
	}
	public Boolean getIsTouch() {
		return isTouch;
	}
	public String getGraphicCardRam() {
		return graphicCardRam;
	}
	public Double getScreenSize() {
		return screenSize;
	}
	
	private LapTop(LaptopBuilder builder) {
		this.brand = builder.brand;
		this.processorType = builder.processorType;
		this.ram = builder.ram;
		this.screenType = builder.screenType;
		this.isTouch = builder.isTouch;
		this.graphicCardRam = builder.graphicCardRam;
		this.screenSize = builder.screenSize;
	}
	
	@Override
	public String toString() {
		return "LapTop [brand=" + brand + ", processorType=" + processorType + ", ram=" + ram + ", screenType="
				+ screenType + ", isTouch=" + isTouch + ", graphicCardRam=" + graphicCardRam + ", screenSize="
				+ screenSize + "]";
	}

	public static class LaptopBuilder {
		private String brand;
		private String processorType;
		private String ram;
		private String screenType;
		private Boolean isTouch;
		private String graphicCardRam;
		private Double screenSize;
		
		{
			this.screenType = "LED";
			this.isTouch = false;
			this.graphicCardRam = "256KB";
			this.screenSize = 14.5;
		}
		
		public LaptopBuilder(String brand, String processorType, String ram) {
			this.brand = brand;
			this.processorType = processorType;
			this.ram = ram;
		}
		
		public LapTop build() {
			return new LapTop(this);
		}

		public String getGraphicCardRam() {
			return graphicCardRam;
		}

		public void setScreenType(String screenType) {
			this.screenType = screenType;
		}

		public void setIsTouch(Boolean isTouch) {
			this.isTouch = isTouch;
		}

		public void setGraphicCardRam(String graphicCardRam) {
			this.graphicCardRam = graphicCardRam;
		}

		public void setScreenSize(Double screenSize) {
			this.screenSize = screenSize;
		}
	}
}
