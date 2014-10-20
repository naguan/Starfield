Particle[] joe = new Particle[5000];

void setup()
{
  background(0);
  size(700, 700);
  for (int i = 1; i<joe.length; i++)
    {
      joe[i]= new NormalParticle(350, 350);
    }
    joe[0] = new Oddball(350,350);
}
void draw()
{ background(0);

    for (int i = 1; i<joe.length; i++)
  {
    joe[i].show();
    joe[i].move();
  }
    joe[0].show();
    joe[0].move();
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
interface Particle
{
  void show();
  void move();
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
    speed=(Math.random()*10);
    angle=(Math.random()*2*Math.PI);
  }
  public void move()
  {
    myX=myX+Math.cos(angle)*speed;
    myY=myY+Math.sin(angle)*speed;
    if( myX<0|| myX>700 )
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
