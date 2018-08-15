import ddf.minim.*;
import ddf.minim.ugens.*;

// Purple Rain

Drop[] drops = new Drop[500];

void setup() {
  size(640, 360);
  for (int i = 0; i < drops.length; i++) {
    drops[i] = new Drop();
  }
}

void draw() {
  background(230, 230, 250);
  for (Drop d : drops) {
    d.fall(this);
    d.show();
  }
}
