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

public class Starfield extends PApplet {

Particle[] joe = new Particle[5000];

public void setup()
{
  background(0);
  size(700, 700);
  for (int i = 2; i<joe.length; i++)
  {
    joe[i]= new NormalParticle(350, 350);
  }
  joe[0] = new Oddball(350, 350);
  joe[1] = new Jumbo(350, 350);
}
public void draw()
{ 
  background(0);

  for (int i = 2; i<joe.length; i++)
  {
    joe[i].show();
    joe[i].move();
  }
  joe[0].show();
  joe[0].move();
  joe[1].show();
  joe[1].move();
}
class NormalParticle implements Particle
{
  int colors, colors1, colors2;
  double myX, myY, speed, angle;
  NormalParticle(int x, int y)
  {
    colors1=(int)(Math.random()*256);
    colors2=(int)(Math.random()*256);
    colors=(int)(Math.random()*256);
    myX= x;
    myY= y;
    speed=(Math.random()*5);
    angle=(Math.random()*2*Math.PI);
  }
  NormalParticle()
  {
    colors1=(int)(Math.random()*256);
    colors2=(int)(Math.random()*256);
    colors=(int)(Math.random()*256);
    myX= 350;
    myY= 350;
    speed=(Math.random()*5);
    angle=(Math.random()*2*Math.PI);
  }
  public void move()
  {
    myX=myX+Math.cos(angle)*speed;
    myY=myY+Math.sin(angle)*speed;
  }
  public void show()
  {
    fill(colors, colors1, colors2);
    ellipse( (float)myX, (float)myY, 2, 2);
  }
}
class Jumbo extends NormalParticle
{
  double myX, myY;
  Jumbo(int x, int y)
  {
    speed = 5;
    myX= x;
    myY= y;
  }
  public void show()
  {
    ellipse( (float)myX, (float)myY, 25, 25);
  }
  
  public void move()
  {
    myX=myX+Math.cos(angle)*speed;
    myY=myY+Math.sin(angle)*speed;
     if ( myX<0|| myX>700 )
    {
      angle=PI * angle;
    }
    if (myY<0 || myY>700 )
    {
      angle = -angle;
    }
  }
}
interface Particle
{
  public void show();
  public void move();
}
class Oddball implements Particle
{
  int colors, colors1, colors2;
  double myX, myY, speed, angle;
  Oddball( int x, int y)
  {
    colors1=(int)(Math.random()*256);
    colors2=(int)(Math.random()*256);
    colors=(int)(Math.random()*256);
    myX= x;
    myY= y;
    speed=5;
    angle=(Math.random()*2*Math.PI);
  }
  public void move()
  {
    myX=myX+Math.cos(angle)*speed;
    myY=myY+Math.sin(angle)*speed;
    if ( myX<0|| myX>700 )
    {
      angle=PI * angle;
    }
    if (myY<0 || myY>700 )
    {
      angle = -angle;
    }
  }
  public void show()
  {
    fill(colors, colors1, colors2);
    ellipse( (float)myX, (float)myY, 50, 50);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
