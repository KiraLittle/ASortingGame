import greenfoot.*;

public class Score extends Actor
{
    private GreenfootImage scoreImage;
    private int score;

    public Score()
    {
        updateScore();
    }

    private void updateScore()
    {
        long elapsedSeconds = StopWatch.elapsedTime() / 1000;
        score = (int)(300 - (elapsedSeconds * 1));

        if (score < 0)
        {
            score = 0;
        }
    }

    private void displayScore()
    {
        scoreImage = new GreenfootImage(200,50);
        scoreImage.setColor(Color.RED);
        scoreImage.setFont(new Font(true,false,24));

        scoreImage.clear();
        scoreImage.drawString("Score: " + score,10,30);
        setImage(scoreImage);
    }
    
     
    //Act - do whatever the Score wants to do. This method is called whenever
    // the 'Act' or 'Run' button gets pressed in the environment.*/
    public void act(){
        updateScore();
        displayScore();
        }   
}