
class Lines {

  float xpos, ypos, strokeW, pointCount;
color s;


  Lines(float tempstrokeW, float temppointCount, color tempstroke, float tempX, float tempY) {

    xpos = tempX;
    ypos = tempY;
    strokeW = tempstrokeW;
    pointCount = temppointCount;
    s = tempstroke;
  }

  // display method
  void display() {
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

  void moveRight(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX+i, startY);
      xpos = startX + i;
      ypos = startY;
    }
  }

  void moveLeft(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX-i, startY);
      xpos = startX - i;
      ypos = startY;
    }
  }

  void moveUp(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX, startY -i);
      xpos = startX;
      ypos = startY - i;
    }
  }

  void moveDown(float startX, float startY, float moveCount)
  {
    for (float i = 0; i< moveCount; i++)
    {
      point(startX, startY+i);
      xpos = startX;
      ypos = startY + i;
    }
  }
}