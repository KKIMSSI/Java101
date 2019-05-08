package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import dao.SignUpDao;
import dto.SignUp;
import rhythm16.DynamicBeat;
import rhythm16.Main;
import rhythm16.Music;

public class Start extends JFrame implements MouseListener {

	public static SignUp su;
	

	private JPanel contentPane;
	private JTextField tfId;
	private JPasswordField tfPw;
	JButton btnLogin;
	JButton btnJoin;
	JPanel pMain;
	
	private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));
	private int mouseX, mouseY;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon("images/exit_1.png");
	private ImageIcon exitButtonBasicImage = new ImageIcon("images/exit_2.png");
	private JButton exitButton = new JButton(exitButtonBasicImage);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ȭ�� ũ�� ����
		setUndecorated(true);// ��ܹ�
		setVisible(true);		
		
		
		// ������ ũ��
		int xFrame = 1280;
		int yFrame = 720;

		int xPosition = (int) (screen.getWidth() / 2 - xFrame / 2);
		int yPosition = (int) (screen.getHeight() / 2 - yFrame / 2);
		setBounds(xPosition, yPosition, xFrame, yFrame); // ������ ����
		System.out.println("xPosition: " + xPosition + ", yPosition: " + yPosition);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // ������ ����, ���� �Ұ�
		setTitle("�̴ϰ���"); // Ÿ��Ʋ ����
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// ���ΰ�
		Image logo = new ImageIcon("start_image/RhythmGameTitle4.png").getImage();
		logo = logo.getScaledInstance(1300, 800, java.awt.Image.SCALE_SMOOTH);

		JPanel pMain = new JPanel();
		pMain.setBounds(0, 30, 1280, 720);
		pMain.setLayout(new BorderLayout(0, 0));
		contentPane.add(pMain);

		this.pMain = pMain;

		JPanel pLogo = new JPanel();
		pLogo.setBackground(Color.BLACK);
		pLogo.setPreferredSize(new Dimension(1100, 300));
		pMain.add(pLogo, BorderLayout.NORTH);

		JLabel lblMainImg = new JLabel();
		lblMainImg.setIcon(new ImageIcon(logo));
		pLogo.add(lblMainImg);

		JPanel pIdpw = new JPanel();
		pIdpw.setPreferredSize(new Dimension(1100, 130));
		pIdpw.setLayout(new GridLayout(0, 1, 0, 0));
		pMain.add(pIdpw, BorderLayout.CENTER);

		// id
		JPanel pId = new JPanel();
		pId.setBackground(Color.BLACK);
		pId.setPreferredSize(new Dimension(1100, 80));
		pIdpw.add(pId);

		JLabel lblId = new JLabel();
		lblId.setBackground(Color.BLACK);
		lblId.setIcon(new ImageIcon("start_image/img_id.png"));
		lblId.setHorizontalAlignment(SwingConstants.CENTER); // ���� ��� ����
		lblId.setVerticalAlignment(SwingConstants.CENTER);
		lblId.setVerticalAlignment(SwingConstants.CENTER); // ���� ��� ����
		pId.add(lblId);

		tfId = new JTextField();
		tfId.setFont(new Font("����", Font.PLAIN, 28));
		tfId.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.black));
		tfId.setColumns(10);		
		pId.add(tfId);

		JPanel pPw = new JPanel();
		pPw.setBackground(Color.BLACK);
		pPw.setPreferredSize(new Dimension(1100, 65));
		pIdpw.add(pPw);

		JLabel lblPw = new JLabel();
		lblPw.setIcon(new ImageIcon("start_image/img_pw.png"));
		lblPw.setBackground(Color.BLACK);
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		pPw.add(lblPw);

		tfPw = new JPasswordField(); // �Է¹��ڸ� default �ܷ� �����Ѵ�.
		tfPw.setFont(new Font("����", Font.PLAIN, 28));
		tfPw.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.black, Color.black));
		tfPw.setColumns(10);
		tfPw.setEchoChar('*'); // �Է¹��ڸ� �����Ѵ�.
		pPw.add(tfPw);

		JPanel pBtn = new JPanel();
		pBtn.setBackground(Color.BLACK);
		pBtn.setPreferredSize(new Dimension(1100, 200));
		pMain.add(pBtn, BorderLayout.SOUTH);

		btnLogin = new JButton();
		Image btnLog = new ImageIcon("start_image/img_login.png").getImage();
		btnLog = btnLog.getScaledInstance(360, 80, java.awt.Image.SCALE_SMOOTH);
		pBtn.add(btnLogin);

		btnLogin.setBackground(Color.BLACK);
		btnLogin.setIcon(new ImageIcon(btnLog));

		btnLogin.setBorderPainted(false); // ��ư �׵θ� ����
		btnLogin.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		btnLogin.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		btnLogin.setName("login");

		btnJoin = new JButton();
		btnJoin.setBackground(Color.BLACK);
		btnJoin.setIcon(new ImageIcon("start_image/img_join.png"));
		btnJoin.setBorderPainted(false); // ��ư �׵θ� ����
		btnJoin.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		btnJoin.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		btnJoin.setName("join");
		pBtn.add(btnJoin);

		JPanel pMember = new JPanel();
		pMember.setBackground(Color.BLACK);
		pMember.setBounds(0, 30, 1280, 720);
		pMember.setLayout(null);
		contentPane.add(pMember);

		JPanel pJoin = new JPanel();
		pJoin.setBounds(420, 50, 400, 600);
		pJoin.setPreferredSize(new Dimension(400, 600));
		pJoin.setBackground(Color.BLACK);
		pJoin.setLayout(null);
		pJoin.setVisible(false);
		pMember.add(pJoin);

		JPanel pLogin = new JPanel();
		pLogin.setBackground(Color.BLACK);
		pLogin.setBounds(0, 30, xFrame, yFrame);
		contentPane.add(pLogin);

		JButton btnStart = new JButton();
		btnStart.setIcon(new ImageIcon("start_image/img_start.png"));
		pLogin.setVisible(false);
		pLogin.add(btnStart);

		btnLogin.addMouseListener(this);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton tmp = (JButton) e.getSource();
				if (tmp.getName().equals("login")) {
					String id = tfId.getText();
					// getPassword�� char���̶� ����ȯ �ʿ�
					String pw = new String(tfPw.getPassword());

					if (tfId.getText().equals("admin") && pw.equals("1234")) {
						// ������ �α���
						System.out.println("���� �����ڴ�!");
						tfId.setText(""); // id �Է�ĭ �ʱ�ȭ
						tfPw.setText(""); // pw �Է�ĭ �ʱ�ȭ
						pMain.setVisible(false);
						pLogin.setVisible(true);
						// new DynamicBeat();
					} else {
						// ȸ�� �α���
						SignUpDao dao = SignUpDao.getInstance();
						int n = dao.userComfirm(id, pw);
						if (n == 1) {
							// JOptionPane.showMessageDialog(null, "�α��� ����");
							
							su = new SignUp(id);
							System.out.println(su);
							System.out.println("�α��� ����");
							tfId.setText(""); // id �Է�ĭ �ʱ�ȭ
							tfPw.setText(""); // pw �Է�ĭ �ʱ�ȭ
							pMain.setVisible(false);
							pLogin.setVisible(true);		// ���� ����
							
							//new Main();							
							new DynamicBeat();
							dispose();
							
						} else if (n == 0) {
							JOptionPane.showMessageDialog(null, "��й�ȣ ����");
							tfPw.setText(""); // pw �Է�ĭ �ʱ�ȭ
						} else if (n == -1) {
							JOptionPane.showMessageDialog(null, "ID ����");
							tfId.setText(""); // id �Է�ĭ �ʱ�ȭ
							tfPw.setText(""); // pw �Է�ĭ �ʱ�ȭ
						}
					}
				}
			}
		});

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���� ����");

				pMain.setVisible(true);
				pLogin.setVisible(false);

			}
		});

		btnJoin.addMouseListener(this);
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("membership");
				tfId.setText(""); // id �Է�ĭ �ʱ�ȭ
				tfPw.setText(""); // pw �Է�ĭ �ʱ�ȭ
				pMain.setVisible(false);
				pJoin.setVisible(true);

				// ȸ������ â ����
				 pJoin.add(new SignUpPage(pMain));

			}
		});
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		getContentPane().add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		getContentPane().add(menuBar);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Click");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// â�� Ŀ�� �� ��
		System.out.println("Entered");
		JButton tmp = (JButton) e.getSource();
		if (tmp.getName().equals("login"))
			btnLogin.setIcon(new ImageIcon("start_image/img_login2.png"));
		else
			btnJoin.setIcon(new ImageIcon("start_image/img_join2.png"));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// â���� Ŀ���� ���� ��
		System.out.println("Exited");
		JButton tmp = (JButton) e.getSource();
		if (tmp.getName().equals("login"))
			btnLogin.setIcon(new ImageIcon("start_image/img_login.png"));
		else
			btnJoin.setIcon(new ImageIcon("start_image/img_join.png"));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
