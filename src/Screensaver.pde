Lines[] myLines;

color  stroke = color(random(255), random(90, 150), random(90, 150));
float   strokeWi = random(1, 3);
float  p = random(1, 20);
float x = random(width);
float y = random(height);


void setup()
{
  background(18);
  // size(500, 500);
  size(displayWidth, displayHeight);

  myLines = new Lines[15];
  for (int i = 0; i < myLines.length; i++) {
    stroke = color(random(255), random(90, 150), random(90, 150));
    strokeWi = random(1, 3);
    p = random(1, 20);
    x = random(width);
    y = random(height);
    myLines[i] = new Lines(strokeWi, p, stroke, x, y);
  }
}

void draw() { 

  if (frameCount > 2000) {
    background(18);
    frameCount = 0;
  } else {
    for (int i = 0; i < myLines.length; i++) {
      myLines[i].display();
    }
  }
}