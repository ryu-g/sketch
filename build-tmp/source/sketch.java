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

public class sketch extends PApplet {

ArrayList<Tile> tile;
int id = 0;
final int tilesize = 10; 
int dx = tilesize;
int dy = tilesize;

public void setup() {
	
	tile = new ArrayList<Tile>();
	for(int x=0 ; x<width; x++){
		for (int y=0 ; y<height; y++){
			tile.add(new Tile(id, tilesize, false));
			id++;
		}
	}
}

public void draw() {
	background(255,50);
	imageMode(CENTER);
	rectMode(CENTER);
	shapeMode(CENTER);
	noStroke();


 	id=0;
	for(int x=0 ; x<width; x+=dx){
		for (int y=0 ; y<width; y+=dy){
			tile.get(id).colorCheck(10+x, 10+y, tilesize);
			tile.get(id).display(10+x, 10+y, tilesize);
			id++;
		}
	}
	text(id, 200, 200);
}

class Tile{
	int id;
	int posx;
	int posy;
	int tileSize;
	int tileColor;
	boolean onMouse;

	Tile(int _id, int _tileSize, boolean _onMouse){
		id = _id;
		tileSize = _tileSize;
		onMouse = _onMouse;
	}

	public void display(int posx, int posy, int tileSize){
		rect(posx, posy, tileSize, tileSize);
	}
	public void colorCheck(int posx, int posy, int tileSitze){
		boolean onmouse = onMoused(posx, posy, tileSize, tileSize);
		if(onmouse){
			fill(255,0,0);
		}else fill(255);
	}

	public boolean onMoused(int x,int y,int w,int h){
		boolean onMouse = false;
		if(x-w/2<mouseX&&mouseX<x+w/2&&y-h/2<mouseY&&mouseY<y+h/2){onMouse = true;}
		return onMouse;
	}
}
  public void settings() { 	size(400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
