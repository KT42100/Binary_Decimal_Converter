import java.util.*;
public class dec_bin_converter {

public static void main (String args[]){
    int decision = -1;
    int decision_1 = -1;
    do {

        System.out.println("\nChoose binary to decimanl or decimal to binary transformation...\n Press 1 to binary to decimal\n Press 2 to decimal to binary\n Press 0 to Restart\n Press any number(positive) except 0,1,2 to Exit!\n__________________________________________________________________________________________________");
        decision = test_choice();  

        if (decision == 0){
            //continue;
        }
        else if(decision == 1){
            System.out.println("This is for binry to decimal conversion");
            //String decimal_value = test_choice1();
            //bin_to_dec(decimal_value); 
            System.out.println("If you pick the wrong conversion mode, please press 0 to restart or 1 to continue or press any other numbers to quit");
            decision_1 = test_choice();
            if (decision_1 == 0){
                continue;
            } 
            else if(decision_1 == 1){
                 System.out.println("Please Enter Binary Value");
                 String decimal_value = test_choice1();
                 bin_to_dec(decimal_value);   
            }
            else{
                System.out.println("Good Bye!_________________________________________________________________________________________");//0
                System.exit(0);
            }
            
            
        }
        else if(decision == 2){ 
            System.out.println("This is for decimal to binary conversion");
            System.out.println("If you pick the wrong conversion mode, please press 0 to restart or 1 to continue or press any other numbers to quit");
            //int binary_value = test_choice();
            //dec_to_bin(binary_value);
            decision_1 = test_choice();
            if (decision_1 == 0){
                continue;
            } 
            else if(decision_1 == 1){
                 System.out.println("\n In Java max int value is 2,147,483,647\n Please Enter Decimal Value\n Please Enter Decimal Value");
                 int binary_value = test_choice();
                 dec_to_bin(binary_value);
            }
            else{
                System.out.println("Good Bye!_________________________________________________________________________________________");//0
                System.exit(0);
            }        
            
        }
        else{
            System.out.println("Good Bye!_________________________________________________________________________________________");//0
            System.exit(0);
        }



    }while(decision < 3 && decision >= 0);

}

public static int test_choice (){
    Scanner scan = new Scanner(System.in);
    int c = 0;
    while (true){
        try{   
            return scan.nextInt();
        }
        catch(InputMismatchException e){
            scan.next();
            System.out.println("Enter only Integer or Number too big\n Enter the numbers within the limit\n Try again");
            c+=1;
        }
        finally{
            if (c<0)
                scan.close();
        }
    }
}
public static String test_choice1 (){
    Scanner scan = new Scanner(System.in);
    int c = 0;
    /* 
    while (true){
        try{   
            return scan.next();
        }
        catch(Exception exception){
            scan.next();
            System.out.println("Enter only binary numbers or Number too big\n Enter the numbers within the limit\n Try again");
            c+=1;
        }
        finally{
            if (c<0)
                scan.close();
        }
    }
    */
    while (true){
        String str = scan.next();
        if ( ( !str.matches(".*[^a-z].*") ) || (str.matches(".*[2-9].*"))) {
            System.out.println("Enter only binary numbers(0 and 1)\n The system do not accept alphabets or other numbers rather than 0 and 1\n Try again");
            c+=1;
            continue;
        }
        else{
            if (c<0){
                scan.close();
            }    
            return str;
        }
    }
}

public static void dec_to_bin (int a){                                  //not using java predefined method 
                                                                         
    int bin_array [] = new int [40];                                    //using array (1D) to put the remainders of 2
    int index = 0;   
    while (a>0){
        bin_array [index++] = a%2;                                      //no matter what a is u got the ans 1 or 0 as remainder
        a = a / 2;
    }
    for (int i = index-1; i>=0 ;i--){                                   //to make reverse array - from index
        System.out.print (bin_array[i]);                                         
    }        
}
 public static void bin_to_dec (String a){
    int base    = 1; // for 2^0
    int decimal = 0;
    int length  = a.length();
    for (int i = length - 1; i >= 0; i--){        //check all until it reached the end of string that is if u put 11111 (length is 5) it checked from 4 to 0
        if (a.charAt(i) == '1'){                  //check at each spot if it is 0 or 1
           decimal += base;                       //if 1 is found, increment the decimal with 2^n value 
           
        }
        base = base * 2;                          //start from 2^0 = 1(base)
    }
    System.out.println(decimal);

}

// from java built in methods **** Really easy if we use them  lol ;)
// from decimal to binary _______    String biinary = Integer.toBinaryString(a);
// from binary  to decimal_______    int deciimal   = Integer.parseInt(binaryString,2); (String str, int redix)

}