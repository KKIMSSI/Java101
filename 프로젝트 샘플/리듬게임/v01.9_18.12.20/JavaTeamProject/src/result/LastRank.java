package result;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.RecodeDao;
import dto.Recode;
import rhythm16.DynamicBeat;

public class LastRank extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTable table;
	private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png")); // ��� ��
	JButton btnReturn;
	JButton btnClose;
	private ArrayList<Recode> rankList;
	private String[] rankNames = { "����", "�뷡����", "���̵�", "����" };
	private int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LastRank frame = new LastRank();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LastRank() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ȭ�� ũ�� ����
		setUndecorated(true);// ��ܹ�

		setBounds(710, 160, 500, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar.setBounds(0, 0, 500, 30); // ��ܹ� ����
		getContentPane().add(menuBar);

		JPanel panelRank = new JPanel();
		panelRank.setBackground(Color.BLACK);
		panelRank.setBounds(0, 30, 500, 120);
		contentPane.add(panelRank);
		panelRank.setLayout(null);

		JLabel lblTitle = new JLabel("");
		Image imgTitle = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\SCORE.png")
				.getImage();
		imgTitle = imgTitle.getScaledInstance(200, 65, java.awt.Image.SCALE_SMOOTH);
		lblTitle.setIcon(new ImageIcon(imgTitle));
		lblTitle.setBounds(0, 10, 177, 47);
		panelRank.add(lblTitle);
		lblTitle.setFont(new Font("����", Font.PLAIN, 20));

		// �� ����(�۾���)
		JLabel lblMyRank = new JLabel();
		Image imgRank = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\RANK.png")
				.getImage();
		imgRank = imgRank.getScaledInstance(200, 65, java.awt.Image.SCALE_SMOOTH);
		lblMyRank.setIcon(new ImageIcon(imgRank));
		lblMyRank.setBounds(0, 63, 177, 47);
		panelRank.add(lblMyRank);
		lblMyRank.setFont(new Font("����", Font.PLAIN, 20));

		JLabel lblTest = new JLabel();
		Image imgTest = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\RankTotal.png")
				.getImage();
		imgTest = imgTest.getScaledInstance(180, 60, java.awt.Image.SCALE_SMOOTH);
		lblTest.setIcon(new ImageIcon(imgTest));
		lblTest.setBounds(189, 68, 180, 37);
		panelRank.add(lblTest);
		// ���� ���̺�
		rankDB();
		
		JLabel lblTotal = new JLabel(rankList.size()+"");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBackground(Color.BLACK);
		lblTotal.setBounds(381, 77, 57, 15);
		panelRank.add(lblTotal);

		JPanel panelTotal = new JPanel();
		panelTotal.setBackground(Color.BLACK);
		panelTotal.setBounds(0, 150, 500, 470);
		contentPane.add(panelTotal);
		panelTotal.setLayout(null);

		JLabel lblTotalRank = new JLabel();
		Image imgTotal = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\TOTAL.png")
				.getImage();
		imgTotal = imgTotal.getScaledInstance(200, 65, java.awt.Image.SCALE_SMOOTH);

		lblTotalRank.setIcon(new ImageIcon(imgTotal));
		lblTotalRank.setFont(new Font("����", Font.PLAIN, 20));
		lblTotalRank.setBounds(0, 10, 180, 37);
		panelTotal.add(lblTotalRank);


		table.setBounds(32, 232, 347, 181);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 55, 430, 350);
		panelTotal.add(scrollPane);
		// scrollPane.setViewportView(table);

		JPanel panelBtn = new JPanel();
		panelBtn.setBackground(Color.BLACK);
		panelBtn.setBounds(0, 620, 500, 100);
		contentPane.add(panelBtn);
		panelBtn.setLayout(new GridLayout(0, 2, 0, 0));

		btnReturn = new JButton();
		btnReturn.setBackground(Color.BLACK);
		Image imgReturn = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\RESTART.png")
				.getImage();
		imgReturn = imgReturn.getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
		btnReturn.setIcon(new ImageIcon(imgReturn));
		btnReturn.setBorderPainted(false); // ��ư �׵θ� ����
		btnReturn.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		btnReturn.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		btnReturn.setName("Return");
		panelBtn.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose(); // ����â �ݱ�

				new DynamicBeat().backMain();

			}
		});

		btnClose = new JButton();
		btnClose.setBackground(Color.BLACK);
		Image imgClose = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\CLOSE.png")
				.getImage();
		imgClose = imgClose.getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
		btnClose.setIcon(new ImageIcon(imgClose));
		btnClose.setBorderPainted(false); // ��ư �׵θ� ����
		btnClose.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		btnClose.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		btnClose.setName("Close");
		panelBtn.add(btnClose);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		setVisible(true);
	}

	private void rankDB() {
		RecodeDao dao = RecodeDao.getInstance();
		rankList = dao.selectAll();

		DefaultTableModel model = new DefaultTableModel(rankNames, 0) {
			@Override // ���̺� ���� �Ұ�
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column >= 0)
					return false;
				else
					return true;
			}
		};
		Object[] obj = new Object[4];
		for (int i = 0; i < rankList.size(); i++) {
			Recode r = rankList.get(i);
			obj[0] = r.getId();
			obj[1] = r.getTitleName();
			obj[2] = r.getDifficulty();
			obj[3] = r.getScore();
			model.addRow(obj);
		}
		table = new JTable(model);

		// �÷� ���� ��� ����
		DefaultTableCellRenderer cellAlignCenter = new DefaultTableCellRenderer();
		cellAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		// ������ ���̺��� ColumnModel�� ������
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(cellAlignCenter);
		}

		// �÷� �ʺ� ����
		table.getColumn("����").setPreferredWidth(10);
		table.getColumn("�뷡����").setPreferredWidth(180);
		table.getColumn("���̵�").setPreferredWidth(15);
		table.getColumn("����").setPreferredWidth(15);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton tmp = (JButton) e.getSource();
		if (tmp.getName().equals("Return")) {
			Image imgReturn = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\RESTART.png")
					.getImage();
			imgReturn = imgReturn.getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
			btnReturn.setIcon(new ImageIcon(imgReturn));
		} else {
			Image imgClose = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\CLOSE.png")
					.getImage();
			imgClose = imgClose.getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
			btnClose.setIcon(new ImageIcon(imgClose));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton tmp = (JButton) e.getSource();
		if (tmp.getName().equals("Return")) {
			Image imgReturn = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\RESTART2.png")
					.getImage();
			imgReturn = imgReturn.getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
			btnReturn.setIcon(new ImageIcon(imgReturn));
		} else {
			Image imgClose = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\rank_image\\CLOSE2.png")
					.getImage();
			imgClose = imgClose.getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
			btnClose.setIcon(new ImageIcon(imgClose));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
