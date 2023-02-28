package Model;


import Controller.Controller;
import java.io.IOException;

public class ProductionMIT {

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // TODO code application logic here
        Controller production = new Controller();
        Controller.production production1 = production.new production();
        production1.Start();
    }

}
