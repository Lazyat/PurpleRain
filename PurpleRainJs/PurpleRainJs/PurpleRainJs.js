var drops = [];
var nbDrops = 500;
var nbSplash = 20;

function setup() {
  createCanvas(600, 600);

  for (var i = 0; i < nbDrops; i++) {
    drops[i] = new drop();
  }
}

function draw() {
  background(230, 230, 250);
  for ( var i = 0; i < nbDrops; i++) {
    var d = drops[i];
    d.fall();
    d.show();
  }
}

function drop() {
  this.x = random(width);
  this.y = random(-500);
  this.z = random(20);
  this.g = map(this.z, 0, 20, 0.05, 0.2);
  this.speed = map(this.z, 0, 20, 1, 20);
  this.len = map(this.z, 0, 20, 10, 20);
  this.thick = map(this.z, 0, 20, 1, 3);
  this.splashes = [];

  this.fall = function() {
    this.y += this.speed;
    this.speed += this.g;
    
    if(this.y > height){
       for(var i = 0; i < nbSplash; i++){
         var s = this.splashes[i] = new splash();
         s.explode(this.x);
       }
       this.y = random(-500);
       this.speed =  map(this.z, 0, 20, 4, 10);
    }
  }
  
  this.show = function(){
      strokeWeight(this.thick);
      stroke(138, 43, 226);
      line(this.x, this.y, this.x, this.y+10);
  }  
}

function splash(x){
   this.explode = function(x){
     strokeWeight(0.5);
     line(x+random(-5, 5), height, x+random(-10, 10), height-random(10));
   }
}
