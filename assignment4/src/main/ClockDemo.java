package main;

public class ClockDemo
{
    public static void main (String[] args) throws InterruptedException
    {
        ClockDisplay clock = new ClockDisplay();
        clock.setTime(14,10,0);
        
        while(true){
            clock.minIncrement();
            System.out.println("Current time: " + clock.getTime());
            
            Thread.sleep(999);
        }
    }
}
