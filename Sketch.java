import java.util.Random;

import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float xDraw = 0; 

  float xStartPos = random(0, 1600);
  float yStartPos = random(0, 800);

  int colour = 0;

  boolean limit = true;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1600, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(100, 100, 100);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    xDraw ++;
    double yDraw = 0.005*(xDraw - xStartPos)*(xDraw - xStartPos) ;

    stroke(colour);
    line(xStartPos, yStartPos, (float)xDraw, (float)yDraw);  

//    stroke(0);
//    line((float)xDraw, (float)yDraw, (float)xDraw, (float)yDraw);

    if (colour > 255 && limit == true){
      limit = false;
    } else if (colour < 1 && limit == false){
      limit = true;
    } else if (limit = true){
      colour ++;
    } else if (limit = false){
      colour --;
    }
  
  // define other methods down here.
  }
}