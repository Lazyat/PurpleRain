class Drop{
  float x = random(width);
  float y = random(-500);
  float z = random(20);
  float g = map(z, 0, 20, 0.05, 0.2);
  float speed = map(z, 0, 20, 1, 20);
  float len = map(z, 0, 20, 10, 20);
  float thick = map(z, 0, 20, 1, 3);
  
  Splash[] splashes = new Splash[20];
  
  void fall(){
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
  void show(){
    strokeWeight(thick);
    stroke(138, 43, 226);
    line(x, y, x, y+10);
  }  
}

class Splash{
  void explode(float x){
    strokeWeight(0.5);
     line(x+random(-5, 5), height, x+random(-10, 10), height-random(10)); 
  }
}
