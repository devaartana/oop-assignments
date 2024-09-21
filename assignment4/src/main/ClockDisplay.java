package main;

public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String currTimeString;
    
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTimeString();
    }
    
    private void setTimeString()
    {
        currTimeString = hours.getDisplayValue() + 
        ":" + minutes.getDisplayValue() +
        ":" + seconds.getDisplayValue();
    }
    
    public void setTime (int hour, int minute, int second)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        setTimeString();
    }
    
    public String getTime()
    {
        return currTimeString;
    }
    
    public void minIncrement()
    {
        seconds.increment();
        if (seconds.getValue() == 0)minutes.increment();
        if (minutes.getValue() == 0) hours.increment();
        setTimeString();
    }
}

