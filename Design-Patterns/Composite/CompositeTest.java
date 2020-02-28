import java.util.*;
import java.util.stream.*;
abstract class Government{
    public abstract double budget();
}
class CompositeNationalGovernment extends Government{
    private double budget;
    private String name;
    
    private List<Government> states = new ArrayList<>();
    
    public CompositeNationalGovernment(String name){
        super();
        this.budget = 0.0;
        this.name = name;
        System.out.println("NATION Name : "+ name);
    }
    
    public void add(Government corp){
        states.add(corp);
    }
    
    public void remove(Government corp){
        states.remove(corp);
    }

    @Override
    public double budget(){
        budget = 0;
        budget += states.stream().map(s -> s.budget())
        .collect(Collectors.summingDouble(Double::doubleValue));
        return budget;
    }
}
class StateGovernment extends Government{
    private double budget;
    private String name;
    private List<Government> corporations = new ArrayList<>();
    
    public void add(Government corp){
        corporations.add(corp);
    }
    
    public void remove(Government corp){
        corporations.remove(corp);
    }
    
    public StateGovernment(String name, double budget){
        super();
        this.budget = budget;
        this.name = name;
        System.out.println("STATE Name : "+ name +" Budget (in Mn $) : "+ this.budget);
    }
    
    @Override
    public double budget(){
        budget += corporations.stream().map(c -> c.budget())
        .collect(Collectors.summingDouble(Double::doubleValue));
        return budget;
    }
}

class CorporationGovernment extends Government{
    private double budget;
    private String name;
    public CorporationGovernment(String name, double budget){
        super();
        this.budget = budget;
        this.name = name;
        System.out.println("CORPORATION Name : "+ name +" Budget (in Mn $) : "+ this.budget);
    }
    
    @Override
    public double budget(){
        return this.budget;
    }
}

class UnionTeriroryGovernment extends Government{
    private double budget;
    private String name;
    public UnionTeriroryGovernment(String name, double budget){
        super();
        this.budget = budget;
        this.name = name;
        System.out.println("UT Name : "+ name +" Budget (in Mn $) : "+ this.budget);
    }
    
    @Override
    public double budget(){
        return this.budget;
    }
}

public class CompositeTest {

   public static void main(String []args) {
      CompositeNationalGovernment india = new CompositeNationalGovernment("Bharatha");
      Government pondichary = new UnionTeriroryGovernment("PONDICHARY", 300.00);
      india.add(pondichary);
      Government blrCorp = new CorporationGovernment("BANGALORE", 1200.00);
      StateGovernment karnataka = new StateGovernment("KARNATAKA", 14000.00);
      karnataka.add(blrCorp);
      india.add(karnataka);
      System.out.println();
	  System.out.println("| ============================ |");
	  System.out.println("| NATION BUDGET : "+ india.budget()+"      |");
	  System.out.println("| ============================ |");
   }
}
