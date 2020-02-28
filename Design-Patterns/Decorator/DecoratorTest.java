interface Dress{
    void stitch();
}
class DressDecorator implements Dress{
    protected Dress dress;
    
    public DressDecorator(Dress dress){
        this.dress = dress;
    }
    
    @Override
    public void stitch(){
        this.dress.stitch();
    }
}
class BasicDress implements Dress{
    
    @Override
    public void stitch(){
        System.out.println("Basic Stitching");
    }
}
class SportsDress extends DressDecorator{
    
    public SportsDress(Dress dress){
        super(dress);
    }
    
    @Override
    public void stitch(){
        super.stitch();
        System.out.println("Sports Stitching");
    }
}

class CasualDress extends DressDecorator{
    
    public CasualDress(Dress dress){
        super(dress);
    }
    
    @Override
    public void stitch(){
        super.stitch();
        System.out.println("Casual Stitching. ");
    }
}

public class DecoratorTest {

   public static void main(String []args) {
      Dress sportsDress = new SportsDress(new BasicDress());
      sportsDress.stitch();
      System.out.println();
      
      Dress dress = new CasualDress(new SportsDress(new BasicDress()));
      dress.stitch();
   }
}
