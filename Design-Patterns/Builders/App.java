
import com.ilinks.practice.designpattern.creational.builders.LapTop.LaptopBuilder;

public class App {

	public static void main(String[] args) {

		LapTop laptop = new LapTop.LaptopBuilder("Lenovo", Processor.I7.getCode(), "16GB").build();
		
		System.out.println("Default Conf New LapTop : "+ laptop);
		LaptopBuilder builder = new LapTop.LaptopBuilder("Lenovo", Processor.I7.getCode(), "16GB");
		builder.setGraphicCardRam("2GB");
		builder.setIsTouch(true);
		builder.setScreenSize(15.5);
		builder.setScreenType("OLED");
		System.out.println("Custom Conf New LapTop : "+ builder.build());
	}

}
