package Run;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

	Surface sf = new Surface();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JButton bt1 = new JButton();
	JButton bt2 = new JButton();
	JButton bt3 = new JButton();
	JButton bt4 = new JButton();
	JButton bt0 = new JButton();

	// ham khoi tao
	public MainFrame() {
		// ham khoi tao cac gia tri do hoa
		initUI();
	}

	public void initUI() {
		this.setSize(1100, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ex4 - Ellipse");

		// o trong nhap so lieu

		tf2.setBounds(140, 110, 100, 40);
		tf2.setFocusable(true);
		tf2.setText("");
		tf2.setEditable(true);
                
                tf1.setBounds(140, 200, 100, 40);
		tf1.setFocusable(true);
		tf1.setText("");
		tf1.setEditable(true);

		label2.setBounds(20, 110, 150, 40);
		label2.setEnabled(false);
		label2.setText("ban kinh a: ");
		label2.setFont(new Font("Ink Free", Font.BOLD, 20));
		
                label1.setBounds(20, 150, 300, 40);
		label1.setEnabled(false);
		label1.setText("(Theo truc hoanh) ");
		label1.setFont(new Font("Ink Free", Font.BOLD, 15));
                
		label3.setBounds(50, 600, 150, 40);
		label3.setEnabled(false);
		label3.setText("Limit: a,b <= 200 ");
		label3.setFont(new Font("Ink Free", Font.BOLD, 20));
                
                label4.setBounds(20, 200, 150, 40);
		label4.setEnabled(false);
		label4.setText("ban kinh b: ");
		label4.setFont(new Font("Ink Free", Font.BOLD, 20));
                
                label5.setBounds(20, 240, 300, 40);
		label5.setEnabled(false);
		label5.setText("(Theo truc tung) ");
		label5.setFont(new Font("Ink Free", Font.BOLD, 15));
                
                label7.setBounds(20, 50, 300, 40);
		label7.setEnabled(false);
		label7.setText("Tam O(0,0), ban kinh R(a,b)");
		label7.setFont(new Font("Ink Free", Font.BOLD, 20));

		// nut thu nhat
		bt0.setText("DRAW!");
		bt0.setBounds(70, 300, 100, 50);
		bt0.setBorder(BorderFactory.createBevelBorder(1));
		bt0.setFocusable(false);
		bt0.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));
		bt0.setMnemonic(KeyEvent.VK_ENTER);
		this.getRootPane().setDefaultButton(bt0);
		

		label6.setBounds(50, 640, 600, 40);
		label6.setEnabled(false);
		label6.setText("NOTE: 5 pixels/square!!! ");
		label6.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 20));

		this.add(label2);
		this.add(tf2);
		this.add(label6);
		this.add(label3);
                this.add(label4);
                this.add(label1);
                this.add(label5);
                this.add(label7);
                this.add(tf1);
		// nut0
		this.add(bt0);
		bt0.setActionCommand("DRAW!");
		bt0.addActionListener(this);

		// add Panel
		this.add(sf);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			sf.index = 0;
			xuLy();
			break;
		}
	}

	public void xuLy() {
		try {
                        int r1 = Integer.parseInt(tf2.getText());
			int r2 = Integer.parseInt(tf1.getText());
			if (r2 <= 200 && r1 <= 200) {
				sf.R2 = r2;
                                sf.R1 = r1;
				System.out.print(sf.R1);
                                System.out.print(sf.R2);
				sf.repaint();
			} else {
				String message = "Vui long nhap dung dinh dang! ";
				JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception q) {
			String message = "Vui long nhap dung dinh dang! ";
			JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("DRAW!".equals(e.getActionCommand()) ) {
			sf.index = 0;
			xuLy();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainframe = new MainFrame();
				mainframe.setVisible(true);
			}
		});
	}
}
