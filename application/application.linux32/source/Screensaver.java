import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Screensaver extends PApplet {

Lines[] myLines;




public void setup()
{
  background(18);
  // size(500, 500);
  

  myLines = new Lines[15];
  for (int i = 0; i < myLines.length; i++) {
    int  stroke = color(random(30, 200), random(0, 30), random(200, 225));
    float   strokeWi = random(1, 3);
    float  p = random(1, 20);
    float x = random(width);
    float y = random(height);
    myLines[i] = new Lines(strokeWi, p, stroke, x, y);
  }
}

public void draw() { 

  if (frameCount > 2000) {
    background(18);
    frameCount = 0;
  } else {
    for (int i = 0; i < myLines.length; i++) {
      myLines[i].display();
    }
  }
}

class Lines {

  float xpos, ypos, strokeW, pointCount;
int s;


  Lines(float tempstrokeW, float temppointCount, int tempstroke, float tempX, float tempY) {

    xpos = tempX;
    ypos = tempY;
    strokeW = tempstrokeW;
    pointCount = temppointCount;
    s = tempstroke;
  }

  // display method
  public void display() {
    pointCount = random(1,25);
    float d = random(0, 101); 
    stroke(s);
    strokeWeight(strokeW);
    if (xpos > width || xpos < 0 || ypos > height || ypos < 0) {
      xpos = random(width);
      ypos = random(height);
    } else {
      if (d <= 25 ) {
        moveRight(xpos, ypos, pointCount);
      } else if (d <= 50) {
        moveLeft(xpos, ypos, pointCount);
      } else if (d <= 75) {
        moveUp(xpos, ypos, pointCount);
      } else if (d <= 100) {
        moveDown(xpos, ypos, pointCount);
      }
    }
  }

  public void moveRight(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX+i, startY);
      xpos = startX + i;
      ypos = startY;
    }
  }

  public void moveLeft(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX-i, startY);
      xpos = startX - i;
      ypos = startY;
    }
  }

  public void moveUp(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX, startY -i);
      xpos = startX;
      ypos = startY - i;
    }
  }

  public void moveDown(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX, startY+i);
      xpos = startX;
      ypos = startY + i;
    }
  }
}
  public void settings() {  size(displayWidth, displayHeight); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Screensaver" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
