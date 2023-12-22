package game;

import java.awt.Color;
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
import javax.swing.JOptionPane;
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
		x = 300;
		y = 250;
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
	
	private volatile boolean isRunning = true;
	
	public MyPanel() {
		super();
		setBackground(Color.PINK);
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		
		ddd = new DDD("ddd.png");
		kirby = new Kirby("kirby.png");
		stars = new ArrayList<>();
		stars.add(new Star("star.png"));
		class MyThread extends Thread{
			public void run() {
				while(isRunning) {
					ddd.update();
					kirby.update();
					for(Star star : stars) {
						star.update();
						
						Rectangle dddBounds = new Rectangle(ddd.x, ddd.y, ddd.img.getWidth(), ddd.img.getHeight());
						Rectangle starBounds = new Rectangle(star.x, star.y, star.img.getWidth(), star.img.getHeight());
						
						if(dddBounds.intersects(starBounds)) {
							showGameOverDialog();
							stopGame();
						}
						
						Rectangle kirbyBounds = new Rectangle(kirby.x, kirby.y, kirby.img.getWidth(), kirby.img.getHeight());
						Rectangle dddBounds1 = new Rectangle(ddd.x, ddd.y, ddd.img.getWidth(), ddd.img.getHeight());
						
						if(kirbyBounds.intersects(dddBounds1)) {
							showGameOverDialog1();
							stopGame();
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
	
	private void stopGame() {
		isRunning = false;
	}
	
	private void showGameOverDialog() {
		JOptionPane.showMessageDialog(this, "디디디대왕을 물리쳤습니다!", "게임 종료", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void showGameOverDialog1() {
		JOptionPane.showMessageDialog(this, "게임 오버!!!", "게임 공략 실패", JOptionPane.INFORMATION_MESSAGE);
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
		setTitle("별의 커비 시리즈 - 디디디대왕을 찾아서");
		add(new MyPanel());
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Game();
	}
}