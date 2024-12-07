//Criostoir Murray
public class TimeConverter {
	
	    private int hours;
	    
	    private int minutes;
	    
	    private int seconds;
	    
	    private boolean notPM;  

	    //constructor
	    public TimeConverter() 
	    {
	        this.hours = 0;  
	       
	        this.minutes = 0;  
	        
	        this.seconds = 0;  
	        
	        this.notPM = true;  
	        
	    }

	    //parameterized constructor
	    public TimeConverter(int hours, int minutes, int seconds) throws TimeException 
	    {
	        setHours(hours);
	    
	        setMinutes(minutes);
	        
	        setSeconds(seconds);
	        
	        this.notPM = true;  
	        
	    }

	    //accessors 
	    public int getHours() 
	    {
	        return hours;
	        
	    }

	    public int getMinutes() 
	    {
	        return minutes;
	        
	    }

	    public int getSeconds() 
	    {
	        return seconds;
	        
	    }

	    public boolean isNotPM() 
	    {
	        return notPM;
	        
	    }

	    //mutators 
	    public void setHours(int hours) throws TimeException 
	    {
	        if (hours < 0 || hours >= 24) 
	        {
	            throw new TimeException("Invalid hour value: " + hours);
	            
	        }
	        
	        this.hours = hours;
	    }

	    public void setMinutes(int minutes) throws TimeException 
	    {
	        if (minutes < 0 || minutes >= 60) 
	        {
	            throw new TimeException("Invalid minutes value: " + minutes);
	        }
	       
	        this.minutes = minutes;
	    }

	    public void setSeconds(int seconds) throws TimeException 
	    {
	        if (seconds < 0 || seconds >= 60) 
	        {
	            throw new TimeException("Invalid seconds value: " + seconds);
	        }
	       
	        this.seconds = seconds;
	    }

	    //update method
	    public void updateTime(int hours, int minutes, int seconds) throws TimeException 
	    {
	        setHours(hours);
	       
	        setMinutes(minutes);
	        
	        setSeconds(seconds);

	        //convert to 12 hour system
	        if (this.hours >= 12) 
	        {
	            this.notPM = true;
	           
	            if (this.hours > 12) 
	            {
	                this.hours -= 12;
	            }
	        } 
	        else 
	        {
	            this.notPM = false;
	           
	            if (this.hours == 0) 
	            {
	                this.hours = 12; 
	                
	            }
	        }
	    }

	    //change method to accept a different format
	    public void updateTime(String timeString) throws TimeException 
	    {
	        try 
	        {
	            String[] parts = timeString.split(":");
	          
	            if (parts.length != 3) {
	            
	            	throw new TimeException("Invalid time format. Must be hh:mm:ss");
	            	
	            }

	            int hours = Integer.parseInt(parts[0]);
	            
	            int minutes = Integer.parseInt(parts[1]);
	            
	            int seconds = Integer.parseInt(parts[2]);

	            
	            updateTime(hours, minutes, seconds);
	        } 
	        catch (NumberFormatException e) 
	        {
	            throw new TimeException("Non-numeric values entered.");
	        
	        } 
	        catch (Exception e) 
	        {
	            throw new TimeException("Error processing the time string.");
	            
	        }
	    }

	    //display the format which prints in a 12 hour format
	    public void displayTime() 
	    {
	        String timeOfDay = (notPM) ? "AM" : "PM";
	        
	        System.out.printf("%02d:%02d:%02d %s\n", hours, minutes, seconds, timeOfDay);
	    
	}

}
