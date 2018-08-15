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

public class purple_rain extends PApplet {

// Purple Rain

Drop[] drops = new Drop[500];

public void setup(){
  
  for(int i = 0; i < drops.length; i++){
       drops[i] = new Drop();
  }
}

public void draw(){
  background(230, 230, 250);
  for(Drop d : drops){
    d.fall();
    d.show();
  }
}
class Drop{
  float x = random(width);
  float y = random(-500);
  float z = random(20);
  float g = map(z, 0, 20, 0.05f, 0.2f);
  float speed = map(z, 0, 20, 1, 20);
  float len = map(z, 0, 20, 10, 20);
  float thick = map(z, 0, 20, 1, 3);
  
  Splash[] splashes = new Splash[20];
  
  public void fall(){
    y+= speed;
    speed+= g;
    
    if(y > height){
      for(Splash s : splashes){
        s = new Splash();
        s.explode(x);
      }
       y = random(-500); 
       speed = map(z, 0, 20, 4, 10);
    }
  }
  public void show(){
    strokeWeight(thick);
    stroke(138, 43, 226);
    line(x, y, x, y+10);
  }  
}

class Splash{
  public void explode(float x){
    strokeWeight(0.5f);
     line(x+random(-5, 5), height, x+random(-10, 10), height-random(10)); 
  }
}
  public void settings() {  size(640, 360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "purple_rain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
