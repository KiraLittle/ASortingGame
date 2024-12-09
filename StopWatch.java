import java.util.Calendar;
/**
 
Write a description of class StopWatch here.
@author (your name)
@version (a version number or a date)*/
public class StopWatch
{
    private static boolean isInReset;
    private static long initialTime;
    private static long currentTime;

    public StopWatch()
    {
        reset();
    }

    public static void reset()
    {
        isInReset = true;
        initialTime = 0;
        currentTime = 0;
    }

    public static void set(long seconds){
    currentTime = Calendar.getInstance().getTimeInMillis();
        initialTime = currentTime - (seconds*1000);
    }

    public static void startStop()
    {
        currentTime = Calendar.getInstance().getTimeInMillis();
        if (isInReset){
            initialTime = currentTime;
            isInReset = false;
        }
    }

    public static long elapsedTime()
    {
        return currentTime-initialTime;
    }

    public String toString()
    {
        long elapsedSecs = elapsedTime()/1000;
        long elapsedHours = elapsedSecs/3600;
        elapsedSecs -= (elapsedHours*3600);
        long elapsedMins = elapsedSecs/60;
        elapsedSecs -= (elapsedMins*60);
        return elapsedMins + "m " + elapsedSecs + "s";
    }

}