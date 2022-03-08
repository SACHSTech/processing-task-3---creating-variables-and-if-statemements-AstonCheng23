import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float xDraw = 0; 

  float xStartPos = random(0, 800);
  float yStartPos = random(0, 800);

  boolean limit = true;
  boolean stop = false;
  
  int radius = 100;
  double inversion = 0.01;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0, 0, 0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    int s = second();  // Values from 0 - 59
    int m = minute();  // Values from 0 - 59
    int h = hour();    // Values from 0 - 23
    //copied straight from https://processing.org/reference/second_.html
    
    
    stroke(250);
    line(s*13, 0, s*13, 33);

    stroke(0);
    text(s, s*14, 33);
    
    stroke(250);
    line(m*13, 33, m*13, 66);
    
    stroke(250);
    line(h*12, 66, h*12, 100);


    xDraw ++;
    double yDraw = inversion*(xDraw - xStartPos)*(xDraw - xStartPos);

    stroke((float)xDraw*s, (float)yDraw*s, (float)s);
    line(xStartPos, yStartPos, (float)xDraw, (float)yDraw);  

//    stroke(0);
//    line((float)xDraw, (float)yDraw, (float)xDraw, (float)yDraw);

/*
    if (colour > 255 && limit == true){
      limit = false;
    } else if (colour < 1 && limit == false){
      limit = true;
    } 
    
    if (limit = false || limit != true){
      colour --;
    } else if (limit = true){
      colour ++;
    }

  // define other methods down here.
    if (xDraw > 800 || yDraw < 0) {
      stop = true;
        while (stop == true)
          xDraw = 0;
    }
*/

  }
}