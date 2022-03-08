import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float xDraw = 0; 

  float xStartPos = random(0, 800);
  float yStartPos = random(0, 800);

  boolean limit = true;
  boolean stop = false;
  
  int radius = 100;
  double inversion = 0.01;

  public void settings() {
    size(800, 800);
  }
  public void setup() {
    background(0, 0, 0);
  }

  public void draw() {

    int s = second();  // Values from 0 - 59
    int m = minute();  // Values from 0 - 59
    int h = hour();    // Values from 0 - 23
    //copied straight from https://processing.org/reference/second_.html
    
    stroke(0);
    text(s, s * 13, 33);
    
    stroke(255);
    text(m, m * 13, 66);
    
    stroke(255);
    text(h, h * 33, 99);

    // why is this making other text commands black?
/*    if (s == 59){
      stroke(0, 0, 0);
      fill(0, 0, 0);
      rect(0, 0, 800, 33);
    }
*/
    xDraw ++;
    double yDraw = inversion*(xDraw - xStartPos)*(xDraw - xStartPos);

    if (m < 20) {
      stroke((float) xDraw * s, (float) yDraw * s, (float) s);
    }
    if (m >= 20 && m <= 40) {
      stroke((float) s, (float) xDraw * s, (float) yDraw * s);
    }
    if (m > 40) {
      stroke((float) yDraw * s, (float) s, (float) xDraw * s);
    }

    line(xStartPos, yStartPos, (float) xDraw, (float) yDraw);  

  // for some reason, it doesn't stop stuff when yDraw is < 0
    if (xDraw > 800 || yDraw < 0) {
      stop = true;      
    }
    while (stop == true){
      xDraw = 0;
      stop = false;
    }

  }
}