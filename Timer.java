import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Timer extends Actor
{
    private GreenfootImage stopwatchImage;
    private StopWatch stopWatch;
    private boolean isPaused;

    public Timer()
    {
        stopWatch = new StopWatch();
        Font font = new Font(true,false,24);
        stopwatchImage = new GreenfootImage(250,50);
        stopwatchImage.setColor(Color.BLUE);
        stopwatchImage.setFont(font);
        stopwatchImage.drawString(stopWatch.toString(),0,20);
        setImage(stopwatchImage);
        isPaused = false;
    }
    //Act - do whatever the Timer wants to do. This method is called whenever
    //the 'Act' or 'Run' button gets pressed in the environment.*/
    public void act(){
        StopWatch.startStop();
        stopwatchImage.clear();

        stopwatchImage.drawString(stopWatch.toString(), 0, 20);
        setImage(stopwatchImage);
        }
}