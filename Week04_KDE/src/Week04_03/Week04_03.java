package Week04_03;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Week04_03 {
	public static void main(String[] args) {
		String name="김덕성";
		String job="프로젝트 매니저";
		String company="덕성주식회사";
		
		String imagePath="C:/Users/kdaeu/OneDrive/사진/인물퀴즈/보아.jpeg";
		
		JFrame frame = new JFrame();
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imagePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		JLabel imageLabel = new JLabel(new ImageIcon(image));
		frame.add(imageLabel, BorderLayout.WEST);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3,1));
		JLabel nameLabel = new JLabel("이름: "+ name);
		JLabel jobLabel = new JLabel("직업: "+job);
		JLabel companyLabel = new JLabel("회사: "+ company);
		textPanel.add(nameLabel);
		textPanel.add(jobLabel);
		textPanel.add(companyLabel);
		frame.add(textPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
