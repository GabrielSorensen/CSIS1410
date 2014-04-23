import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;


public class WindowFrame extends JFrame {

	private static final long serialVersionUID = 6584841265852410186L;
	private Panel map;
	private JLabel LivesDisplay;
	private JLabel CashDisplay;
	private JLabel WaveDisplay;
	private JCheckBoxMenuItem InfiniteLives;
	private JCheckBoxMenuItem InfiniteCash;
	private JPanel PlayingField;
	private int wave = 1;
	private String Loc;
	private static final Icon t1 = new ImageIcon(TowerDefenceObject.TOWER_1);
	private static final Icon t2 = new ImageIcon(TowerDefenceObject.TOWER_2);
	private static final Icon t3 = new ImageIcon(TowerDefenceObject.TOWER_3);
	private final ButtonGroup buttonGroup = new ButtonGroup();


	public WindowFrame(String Map) throws HeadlessException {
		this.Loc = Map;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(775, 685));
		setResizable(false);
		setSize(new Dimension(473, 800));

		setWave(1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BugDefender by:GS");
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(new Dimension(455, 21));
		menuBar.setBounds(0, 0, 469, 21);
		getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		mnFile.setSize(new Dimension(75, 21));
		menuBar.add(mnFile);

		JMenu mnCheats = new JMenu("Cheats");
		mnCheats.setSize(new Dimension(75, 21));
		mnCheats.setMnemonic(KeyEvent.VK_C);
		mnCheats.setToolTipText("Provides some cheats to this game, for fun of course.");
		menuBar.add(mnCheats);

		InfiniteLives = new JCheckBoxMenuItem("Infinite Lives?");
		InfiniteLives.setMnemonic('L');
		InfiniteLives.setMnemonic(KeyEvent.VK_L);
		InfiniteLives.setToolTipText("For when You, The Player, never want to quit.");
		mnCheats.add(InfiniteLives);

		InfiniteCash = new JCheckBoxMenuItem("Infinite Cash?");
		InfiniteCash.setToolTipText("Because in this world, there is no such thing as Economy.");
		InfiniteCash.setMnemonic('I');
		InfiniteCash.setMnemonic(KeyEvent.VK_I);
		mnCheats.add(InfiniteCash);

		PlayingField = new JPanel();
		PlayingField.setBorder(new LineBorder(new Color(0, 0, 0)));
		PlayingField.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		PlayingField.setSize(new Dimension(764, 549));
		PlayingField.setBounds(10, 27, 448, 576);
		getContentPane().add(PlayingField);
		PlayingField.setLayout(new BorderLayout(0, 0));

		JPanel Interface = new JPanel();
		Interface.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		Interface.setBounds(0, 614, 469, 158);
		getContentPane().add(Interface);

		Interface.setLayout(null);
		LivesDisplay = new JLabel("");
		LivesDisplay.setBounds(47, 11, 66, 20);
		Interface.add(LivesDisplay);

		CashDisplay = new JLabel("");
		CashDisplay.setBounds(47, 42, 66, 20);
		Interface.add(CashDisplay);

		this.map = new Panel(Map, LivesDisplay, CashDisplay);
		map.setSize(new Dimension(746, 540));
		this.map.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		PlayingField.add(this.map);
		map.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PlayingField.removeAll();
				wave = 1;
				map = new Panel(Loc, LivesDisplay, CashDisplay);
				map.setSize(new Dimension(746, 540));
				map.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				PlayingField.add(map);
				map.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				update();
				map.update();
			}
		});

		mntmReset.setMnemonic('R');
		mntmReset.setMnemonic(KeyEvent.VK_R);
		mntmReset.setToolTipText("Start Over?");
		mnFile.add(mntmReset);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenu mnNewGame = new JMenu("New Game");
		mnNewGame.setMnemonic('N');
		mnNewGame.setMnemonic(KeyEvent.VK_N);
		mnFile.add(mnNewGame);

		JMenuItem mntmSimple = new JMenuItem("Simple");
		mntmSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loc = "null";
				PlayingField.removeAll();
				map = new Panel(Loc, LivesDisplay, CashDisplay);
				map.setSize(new Dimension(746, 540));
				map.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				PlayingField.add(map);
				map.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			}
		});
		mntmSimple.setToolTipText("A basic map with one path across the middle.");
		mntmSimple.setMnemonic('S');
		mntmSimple.setMnemonic(KeyEvent.VK_S);
		mnNewGame.add(mntmSimple);

		JMenuItem mntmComplex = new JMenuItem("Complex");
		mntmComplex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loc = "Map2";
				PlayingField.removeAll();
				map = new Panel(Loc, LivesDisplay, CashDisplay);
				map.setSize(new Dimension(746, 540));
				map.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				PlayingField.add(map);
				map.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			}
		});
		mntmComplex.setToolTipText("Not yet programmed, so Really this does nothing");
		mntmComplex.setMnemonic('C');
		mntmComplex.setMnemonic(KeyEvent.VK_C);
		mnNewGame.add(mntmComplex);
		mntmExit.setMnemonic('E');
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		JMenu mnSpeed = new JMenu("Speed");
		mnSpeed.setToolTipText("Game Speed Settings");
		mnSpeed.setMnemonic('S');
		mnSpeed.setMnemonic(KeyEvent.VK_S);
		menuBar.add(mnSpeed);
		
		JRadioButtonMenuItem megaSlow = new JRadioButtonMenuItem("Mega-Slow");
		megaSlow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.setSleepSpeed(100);
			}
		});
		buttonGroup.add(megaSlow);
		megaSlow.setMnemonic('1');
		megaSlow.setMnemonic(KeyEvent.VK_1);
		mnSpeed.add(megaSlow);
		
		JRadioButtonMenuItem slightlyslow = new JRadioButtonMenuItem("Slightly-Slow");
		slightlyslow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.setSleepSpeed(50);
			}
		});
		buttonGroup.add(slightlyslow);
		slightlyslow.setMnemonic('2');
		slightlyslow.setMnemonic(KeyEvent.VK_2);
		mnSpeed.add(slightlyslow);
		
		JRadioButtonMenuItem normal = new JRadioButtonMenuItem("Normal");
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.setSleepSpeed(30);
			}
		});
		buttonGroup.add(normal);
		normal.setMnemonic(KeyEvent.VK_3);
		normal.setSelected(true);
		mnSpeed.add(normal);
		
		JRadioButtonMenuItem fast = new JRadioButtonMenuItem("Fast");
		fast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.setSleepSpeed(10);
			}
		});
		buttonGroup.add(fast);
		fast.setMnemonic(KeyEvent.VK_4);
		mnSpeed.add(fast);
		
		JRadioButtonMenuItem ultrafast = new JRadioButtonMenuItem("Ultra-Fast");
		ultrafast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.setSleepSpeed(5);
			}
		});
		buttonGroup.add(ultrafast);
		ultrafast.setMnemonic(KeyEvent.VK_5);
		mnSpeed.add(ultrafast);
		
		

		JTextPane txtCash = new JTextPane();
		txtCash.setFocusable(false);
		txtCash.setVerifyInputWhenFocusTarget(false);
		txtCash.setOpaque(false);
		txtCash.setText("Cash:");
		txtCash.setBounds(10, 42, 37, 20);
		Interface.add(txtCash);

		JTextPane txtLives = new JTextPane();
		txtLives.setFocusable(false);
		txtLives.setVerifyInputWhenFocusTarget(false);
		txtLives.setOpaque(false);
		txtLives.setText("Lives:");
		txtLives.setBounds(10, 11, 37, 20);
		Interface.add(txtLives);

		JTextPane txtWave = new JTextPane();
		txtWave.setOpaque(false);
		txtWave.setVerifyInputWhenFocusTarget(false);
		txtWave.setFocusable(false);
		txtWave.setText("Wave:");
		txtWave.setBounds(10, 73, 37, 20);
		Interface.add(txtWave);

		WaveDisplay = new JLabel("0");
		WaveDisplay.setBounds(47, 73, 66, 20);
		Interface.add(WaveDisplay);

		JButton StartWaveBtn = new JButton("GO!");
		StartWaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Starting Wave "+Integer.toString(wave));
				map.startGame(wave);
				wave++;
				update();
			}
		});
		StartWaveBtn.setBounds(10, 104, 103, 43);
		Interface.add(StartWaveBtn);

		JButton Tower3 = new JButton("");
		Tower3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.choseTower(5);
			}
		});
		Tower3.setMaximumSize(new Dimension(64, 64));
		Tower3.setMinimumSize(new Dimension(64, 64));
		Tower3.setBackground(Color.GRAY);
		Tower3.setBounds(349, 12, 103, 74);
		Tower3.setIcon(t3);
		Interface.add(Tower3);

		JLabel Tower3cost = new JLabel("$150");
		Tower3cost.setHorizontalTextPosition(SwingConstants.CENTER);
		Tower3cost.setHorizontalAlignment(SwingConstants.CENTER);
		Tower3cost.setBounds(349, 97, 103, 20);
		Interface.add(Tower3cost);

		JButton Tower2 = new JButton("");
		Tower2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				map.choseTower(4);
			}
		});
		Tower2.setMinimumSize(new Dimension(64, 64));
		Tower2.setMaximumSize(new Dimension(64, 64));
		Tower2.setBackground(Color.GRAY);
		Tower2.setBounds(236, 11, 103, 74);
		Tower2.setIcon(t2);
		Interface.add(Tower2);

		JLabel Tower2cost = new JLabel("$100");
		Tower2cost.setHorizontalTextPosition(SwingConstants.CENTER);
		Tower2cost.setHorizontalAlignment(SwingConstants.CENTER);
		Tower2cost.setBounds(236, 96, 103, 20);
		Interface.add(Tower2cost);

		JButton Tower1 = new JButton("");
		Tower1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				map.choseTower(3);
			}
		});
		Tower1.setMinimumSize(new Dimension(64, 64));
		Tower1.setMaximumSize(new Dimension(64, 64));
		Tower1.setBackground(Color.GRAY);
		Tower1.setBounds(123, 11, 103, 74);
		Tower1.setIcon(t1);
		Interface.add(Tower1);

		JLabel Tower1cost = new JLabel("$50");
		Tower1cost.setHorizontalTextPosition(SwingConstants.CENTER);
		Tower1cost.setHorizontalAlignment(SwingConstants.CENTER);
		Tower1cost.setAlignmentX(Component.CENTER_ALIGNMENT);
		Tower1cost.setBounds(123, 96, 103, 20);
		Interface.add(Tower1cost);

		setVisible(true);

		update();
	}
	public void update() {
		WaveDisplay.setText(Integer.toString(getWave()));
		map.paintComponents(map.getGraphics());
		if (InfiniteLives.isSelected()) {
			map.setInfLives(true);
		} else {
			map.setInfLives(false);
		}
		if (InfiniteCash.isSelected()) {
			map.setInfMoney(true);
		} else {
			map.setInfMoney(false);
		}
	}
	public int getWave() {
		return wave;
	}
	public void setWave(int wave) {
		if (wave>0&&wave<1000) {
			this.wave = wave;
		}
	}
	public static void main(String[] args) {
		new WindowFrame("Map1");
	}
}
