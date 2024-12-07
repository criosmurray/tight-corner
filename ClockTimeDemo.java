//Criostoir Murray
import java.util.Scanner;
public class ClockTimeDemo {

	    public static void main(String[] args) 
	    {
	    	
	        Scanner scanner = new Scanner(System.in);  
	        
	        boolean repeat = true;  

	        //display intro text
	        System.out.println("Convert military time into 12-hour clock time!");

	        while (repeat) 
	        {
	            try
	            {
	                //enter military standard time
	                TimeConverter timeConverter1 = new TimeConverter();

	                System.out.println("Enter the hours on the military clock (0-23): ");
	                
	                int hours = Integer.parseInt(scanner.nextLine());

	                System.out.println("Enter the minutes on the military clock (0-59): ");
	                
	                int minutes = Integer.parseInt(scanner.nextLine());

	                System.out.println("Enter the seconds on the military clock (0-59): ");
	                
	                int seconds = Integer.parseInt(scanner.nextLine());

	                //enter 12 hour format
	                timeConverter1.updateTime(hours, minutes, seconds);

	                //show the 12 hour time
	                System.out.print("12-hour clock time:");
	                
	                timeConverter1.displayTime();

	                //enter time as string
	                System.out.println("Enter 24 hour clock time in the format \"hours:minutes:seconds\": ");
	                String timeString = scanner.nextLine();

	                //create second object
	                TimeConverter timeConverter2 = new TimeConverter();
	                timeConverter2.updateTime(timeString);  

	                //show 12 hour time
	                System.out.print("12-hour clock time:");
	                timeConverter2.displayTime();

	            } 
	            catch (TimeException e) 
	            {
	                System.out.println(e.getMessage());
	                
	            } 
	            catch (NumberFormatException e) 
	            {
	                System.out.println("EXCEPTION: Invalid input! Enter valid numbers");
	                
	            }

	            //ask user if they want to do it again
	            System.out.println("Would you like to do this again? Enter \"Yes\" or \"No\": ");
	            
	            String userChoice = scanner.nextLine().trim();

	            //program to exit loop
	            if (userChoice.equalsIgnoreCase("No")) 
	            {
	                repeat = false;
	                
	                System.out.println("Exiting the program!");
	            } 
	            else if 
	            (!userChoice.equalsIgnoreCase("Yes")) 
	            {
	                System.out.println("Invalid response. Exiting the program!");
	               
	                repeat = false;
	            }
	        }

	        
	}

}
