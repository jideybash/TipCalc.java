package tipcalc;

import java.util.Scanner;
import java.text.NumberFormat;

/**
 *
 * @author jideybash
 */
public class TipCalc {

    //global variables here...(global scope)
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        double taxrate, billamt,tip15, tip18, tip20, taxamt, custtip;
        String choice;
        NumberFormat curr = NumberFormat.getCurrencyInstance();
        
        System.out.println("Welcome to the Tip Calculator");
        do {
            taxrate = getValue("Please enter the sales tax rate (7.25% = .075): ");
            if (taxrate > .25) {
                System.out.println("Tax rate out of bounds: 0 to .25 (25%) only.");
            }
        } while (taxrate > .25);
        
        do {
            custtip = getValue("Enter a custom tip if you like or zero(25% = .25): ");
            if (custtip > 1) {
                System.out.print("Limit on custom tip is 100%");
            }
        } while (custtip > 1);
        
        sc.nextLine();
        //priming read..
        System.out.print("Do you have a bill amout? (Y/N): ");
        
        choice = sc.nextLine();
        
        //System.out.println("Your answer was: "+ choice);
        while(choice.toUpperCase().startsWith("Y")) {
               billamt = getValue("Please enter the food and beverage total: ");
               //System.out.println("You spent " + billamt + " on food and drink?");
            
               taxamt = billamt * taxrate;
               tip15 = billamt *    .15;
               
               System.out.println(" Tipping 15% on a bill of " + curr.format(billamt) + "you will pay " +
                      curr.format ( (billamt + taxamt + tip15) ) + " which includes tax of " + curr.format(taxamt) + " and tip of " + curr.format(tip15));
            
               taxamt = billamt * taxrate;
               tip18 = billamt *    .18;
               
               System.out.println(" Tipping 18% on a bill of " + curr.format(billamt) + "you will pay " +
                      curr.format ( (billamt + taxamt + tip18) ) + " which includes tax of " + curr.format(taxamt) + " and tip of " + curr.format(tip18));
               
               taxamt = billamt * taxrate;
               tip20 = billamt * .20;
               
               System.out.println(" Tipping 20% on a bill of " + curr.format(billamt) + "you will pay " +
                      curr.format ( (billamt + taxamt + tip20) ) + " which includes tax of " + curr.format(taxamt) + " and tip of " + curr.format(tip20));
               
               
               if (custtip > 0){
                //calculate and display the result for custom tip
            }         
               sc.nextLine();
            System.out.println("Do you have another bill? (Y/N)");
             choice = sc.nextLine();
            
        } //end of while
    
    
        System.out.print("Thanks for using the Tip Calculator");
        
    }//end of main
    
    public static double getValue(String prompt){
        double v = -1;
        do {
            try {
                System.out.print(prompt);
                v  = sc.nextDouble();
                if (v < 0){
                    System.out.println("Please enter the non-negative value.");
                }
                
            } catch (Exception e) {
                System.out.println("Ileegal input: non-numeric.");
                v = -1;
                sc.nextLine();
            } 
            
        } while (v < 0);
        
        return v;
    }
    
}//end of class
