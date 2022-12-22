import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab12 { 
    
    public static void main(String[] args) throws FileNotFoundException { 
        
        // scanners
        String file = "customer_list.txt";
        Scanner a1 = new Scanner(new File(file));
        Scanner b2 = new Scanner(new File(file));
        
        // line counter
        int count = 0;
        while (a1.hasNextLine()) {
            a1.nextLine();
            count++;
        }
        
        System.out.println("There are " + count + " lines in the file");
        
        // creates an array of customers with the data from given file
        Customer[] list = new Customer[count];
        for (int i = 0; i < list.length; i++) {
            if (b2.hasNext()) {
                // constructor 
                list[i] = new Customer(b2.next(), b2.nextLong());
            }       
        }
        
        Customer key =  new Customer("CSE174", 1111111111);
        int index = linearSearch(list, key);
        System.out.println("The object " + key
            + " located at the index of : " + index);
            
        int ind = binarySearch(list, key);
        System.out.printf("The object " + key
            + " located at the index of : " + ind);
            
    } // End of main
    
    // Linear search method
    public static int linearSearch(Customer[] arr, Customer key) {
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            count++;
            
            if (arr[i].equals(key)) {
                System.out.println("Linear Search: The key is found"
                    + " after " + count + " comparison");
                                    
                return i;
            }
              
        }
        System.out.println("Linear Search: The key is found"
            + " after " + count + " comparison");

        return -1; // return -1 if key is not within list
        
    } // End of linearSearch method
    
    public static int binarySearch(Customer[] arr, Customer key) {
        
        // Starting index
        int low = 0;
        // last index
        int high = arr.length - 1;
        int count = 0;
        
        while (high >= low) {
            // counts how many times the method loops
            count++;
            
            // midpoint of array list
            int mid = (high + low) / 2;
            if (arr[mid].equals(key)) {
                System.out.println("Binary Search: the key is found"
                    + " after " + count + " comparison");   
                return mid;
            } else if (arr[mid].getId() < key.getId()) {
                low = mid + 1;   
            } else if (arr[mid].getId() > key.getId()) {
                high = mid - 1;
            }
        
        }
        System.out.println("Binary Search: the key is found"
            + " after " + count + " comparison");
            
        return -1; // return -1 if key is not within list
    } // End of binarySearch method

} // End of Class