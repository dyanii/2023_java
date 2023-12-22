package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GraphicObject{
	BufferedImage img = null;
	int x=0, y=0;
	
	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name));
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	public void update() {
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public void keyPressed(KeyEvent event) {
	}
}

class Star extends GraphicObject{
	boolean launched = false;
	
	public Star(String name) {
		super(name);
		y = -200;
	}
	
	public void update() {
		if(launched)
			y -= 1;
		if(y < -100)
			launched = false;
	}
	
	public void keyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			this.x = x;
			this.y = y;
		}
	}
}

class DDD extends GraphicObject{
	int dx = -10;
	
	public DDD(String name) {
		super(name);
		x = 250;
		y = 0;
	}
	
	public void update() {
		x += dx;
		if(x<0)
			dx = +10;
		if(x > 500)
			dx = -10;
	}
}

class Kirby extends GraphicObject{
	public Kirby(String name) {
		super(name);
		x = 150;
		y = 350;
	}
	
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}
	}
}

class MyPanel extends JPanel implements KeyListener{
	DDD ddd;
	Kirby kirby;
	ArrayList<Star> stars;
	
	
	public MyPanel() {
		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		
		ddd = new DDD("ddd.png");
		kirby = new Kirby("kirby.png");
		stars = new ArrayList<>();
		stars.add(new Star("star.png"));
		class MyThread extends Thread{
			public void run() {
				while(true) {
					ddd.update();
					kirby.update();
					for(Star star : stars) {
						star.update();
						
						Rectangle dddBounds = new Rectangle(ddd.x, ddd.y, ddd.img.getWidth(), ddd.img.getHeight());
						Rectangle starBounds = new Rectangle(star.x, star.y, star.img.getWidth(), star.img.getHeight());
						
						if(dddBounds.intersects(starBounds)) {
							System.out.println("디디디대왕을 물리쳤습니다!");
						}
					}
					repaint();
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
					}
				}
			}
		}
		Thread t = new MyThread();
		t.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		ddd.draw(g);
		kirby.draw(g);
		for(Star star : stars) {
			star.draw(g);
		}
	}
	
	public void keyPressed(KeyEvent event) {
		kirby.keyPressed(event);
		for(Star star : stars) {
			star.keyPressed(event, kirby.x, kirby.y);
		}
		
	}
	
	public void keyReleased(KeyEvent arg0) {
	}
	
	public void keyTyped(KeyEvent arg0) {
	}
}

public class Game extends JFrame{
	public Game() {
		setTitle("My Game");
		add(new MyPanel());
		setSize(700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Game();
	}
}