import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class Home extends JFrame{

	private Plug plug1;
	private Plug plug2;
	private Refrigerator refrigerator;
	private SolarPanel solarPanel1;
	private SolarPanel solarPanel2;
	private Battery battery1;
	private int batMaxTime;

	private JProgressBar BatteryBar;
	JLabel Plug1Draw;
	JLabel Plug2Draw;
	JLabel FridgeDraw;
	JLabel Solar1Input;
	JLabel Solar2Input;
	JLabel BatDraw;

	public Home(Plug p1, Plug p2, Refrigerator r, SolarPanel s1, SolarPanel s2, Battery b1){
		//You may want to change the name
		super("Dome Home GUI Extrodinaire");
		setLocation(new Point(10, 10));
		setMinimumSize(new Dimension(475, 400));
		this.setSize(new Dimension(475, 400));
		this.setTitle("Dome Home GUI Extrodinaire");

		plug1 = p1;
		plug2 = p2;
		refrigerator = r;
		solarPanel1 = s1;
		solarPanel2 = s2;
		battery1 = b1;
		batMaxTime = b1.getRemainingTime();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{66, 373, 0};
		gridBagLayout.rowHeights = new int[]{14, 14, 14, 14, 8, 14, 14, 14, 98, 14, 38, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblEnergyBeingUsed = new JLabel("Energy being used by :");
		lblEnergyBeingUsed.setFocusable(false);
		GridBagConstraints gbc_lblEnergyBeingUsed = new GridBagConstraints();
		gbc_lblEnergyBeingUsed.anchor = GridBagConstraints.NORTH;
		gbc_lblEnergyBeingUsed.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnergyBeingUsed.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnergyBeingUsed.gridwidth = 2;
		gbc_lblEnergyBeingUsed.gridx = 0;
		gbc_lblEnergyBeingUsed.gridy = 0;
		getContentPane().add(lblEnergyBeingUsed, gbc_lblEnergyBeingUsed);

		JLabel lblPlug = new JLabel("Plug1:");
		lblPlug.setFocusable(false);
		GridBagConstraints gbc_lblPlug = new GridBagConstraints();
		gbc_lblPlug.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPlug.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlug.gridx = 0;
		gbc_lblPlug.gridy = 1;
		getContentPane().add(lblPlug, gbc_lblPlug);

		Plug1Draw = new JLabel("");
		GridBagConstraints gbc_Plug1Draw = new GridBagConstraints();
		gbc_Plug1Draw.anchor = GridBagConstraints.NORTH;
		gbc_Plug1Draw.fill = GridBagConstraints.HORIZONTAL;
		gbc_Plug1Draw.insets = new Insets(0, 0, 5, 0);
		gbc_Plug1Draw.gridx = 1;
		gbc_Plug1Draw.gridy = 1;
		getContentPane().add(Plug1Draw, gbc_Plug1Draw);

		JLabel lblPlug_1 = new JLabel("Plug2:");
		lblPlug_1.setFocusable(false);
		GridBagConstraints gbc_lblPlug_1 = new GridBagConstraints();
		gbc_lblPlug_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPlug_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlug_1.gridx = 0;
		gbc_lblPlug_1.gridy = 2;
		getContentPane().add(lblPlug_1, gbc_lblPlug_1);

		Plug2Draw = new JLabel("");
		GridBagConstraints gbc_Plug2Draw = new GridBagConstraints();
		gbc_Plug2Draw.anchor = GridBagConstraints.NORTH;
		gbc_Plug2Draw.fill = GridBagConstraints.HORIZONTAL;
		gbc_Plug2Draw.insets = new Insets(0, 0, 5, 0);
		gbc_Plug2Draw.gridx = 1;
		gbc_Plug2Draw.gridy = 2;
		getContentPane().add(Plug2Draw, gbc_Plug2Draw);

		JLabel lblRefrigerator = new JLabel("Refrigerator:");
		lblRefrigerator.setFocusable(false);
		GridBagConstraints gbc_lblRefrigerator = new GridBagConstraints();
		gbc_lblRefrigerator.anchor = GridBagConstraints.NORTH;
		gbc_lblRefrigerator.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRefrigerator.insets = new Insets(0, 0, 5, 5);
		gbc_lblRefrigerator.gridx = 0;
		gbc_lblRefrigerator.gridy = 3;
		getContentPane().add(lblRefrigerator, gbc_lblRefrigerator);

		FridgeDraw = new JLabel("");
		GridBagConstraints gbc_FridgeDraw = new GridBagConstraints();
		gbc_FridgeDraw.anchor = GridBagConstraints.NORTH;
		gbc_FridgeDraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_FridgeDraw.insets = new Insets(0, 0, 5, 0);
		gbc_FridgeDraw.gridx = 1;
		gbc_FridgeDraw.gridy = 3;
		getContentPane().add(FridgeDraw, gbc_FridgeDraw);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 2;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		getContentPane().add(separator, gbc_separator);

		JLabel lblEnergyBeingGathered = new JLabel("Energy being gathered by Solar Panels:");
		lblEnergyBeingGathered.setFocusable(false);
		GridBagConstraints gbc_lblEnergyBeingGathered = new GridBagConstraints();
		gbc_lblEnergyBeingGathered.anchor = GridBagConstraints.NORTH;
		gbc_lblEnergyBeingGathered.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnergyBeingGathered.insets = new Insets(0, 0, 5, 0);
		gbc_lblEnergyBeingGathered.gridwidth = 2;
		gbc_lblEnergyBeingGathered.gridx = 0;
		gbc_lblEnergyBeingGathered.gridy = 5;
		getContentPane().add(lblEnergyBeingGathered, gbc_lblEnergyBeingGathered);

		JLabel lblSolarPanel = new JLabel("Solar Panel 1:");
		lblSolarPanel.setFocusable(false);
		GridBagConstraints gbc_lblSolarPanel = new GridBagConstraints();
		gbc_lblSolarPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSolarPanel.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolarPanel.gridx = 0;
		gbc_lblSolarPanel.gridy = 6;
		getContentPane().add(lblSolarPanel, gbc_lblSolarPanel);

		Solar1Input = new JLabel("");
		GridBagConstraints gbc_Solar1Input = new GridBagConstraints();
		gbc_Solar1Input.anchor = GridBagConstraints.NORTH;
		gbc_Solar1Input.fill = GridBagConstraints.HORIZONTAL;
		gbc_Solar1Input.insets = new Insets(0, 0, 5, 0);
		gbc_Solar1Input.gridx = 1;
		gbc_Solar1Input.gridy = 6;
		getContentPane().add(Solar1Input, gbc_Solar1Input);

		JLabel lblSolarPanel_1 = new JLabel("Solar Panel 2:");
		lblSolarPanel_1.setFocusable(false);
		GridBagConstraints gbc_lblSolarPanel_1 = new GridBagConstraints();
		gbc_lblSolarPanel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSolarPanel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolarPanel_1.gridx = 0;
		gbc_lblSolarPanel_1.gridy = 7;
		getContentPane().add(lblSolarPanel_1, gbc_lblSolarPanel_1);

		Solar2Input = new JLabel("");
		GridBagConstraints gbc_Solar2Input = new GridBagConstraints();
		gbc_Solar2Input.anchor = GridBagConstraints.NORTH;
		gbc_Solar2Input.fill = GridBagConstraints.HORIZONTAL;
		gbc_Solar2Input.insets = new Insets(0, 0, 5, 0);
		gbc_Solar2Input.gridx = 1;
		gbc_Solar2Input.gridy = 7;
		getContentPane().add(Solar2Input, gbc_Solar2Input);

		JLabel lblBattery = new JLabel("Battery:");
		lblBattery.setFocusable(false);
		GridBagConstraints gbc_lblBattery = new GridBagConstraints();
		gbc_lblBattery.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBattery.insets = new Insets(0, 0, 5, 5);
		gbc_lblBattery.gridx = 0;
		gbc_lblBattery.gridy = 9;
		getContentPane().add(lblBattery, gbc_lblBattery);

		BatDraw = new JLabel("");
		GridBagConstraints gbc_BatDraw = new GridBagConstraints();
		gbc_BatDraw.anchor = GridBagConstraints.NORTH;
		gbc_BatDraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_BatDraw.insets = new Insets(0, 0, 5, 0);
		gbc_BatDraw.gridx = 1;
		gbc_BatDraw.gridy = 9;
		getContentPane().add(BatDraw, gbc_BatDraw);

		BatteryBar = new JProgressBar();
		BatteryBar.setPreferredSize(new Dimension(150, 15));
		BatteryBar.setStringPainted(true);
		GridBagConstraints gbc_BatteryBar = new GridBagConstraints();
		gbc_BatteryBar.fill = GridBagConstraints.BOTH;
		gbc_BatteryBar.gridwidth = 2;
		gbc_BatteryBar.gridx = 0;
		gbc_BatteryBar.gridy = 10;
		getContentPane().add(BatteryBar, gbc_BatteryBar);
		BatteryBar.setString(Integer.toString(getBatPer())+"%");
		BatteryBar.setIndeterminate(false);
		BatteryBar.setMaximum(batMaxTime*100);
		BatteryBar.setValue(getBatPer());

		setResizable(false);
		setVisible(true);
		update();
	}
	public void update() {
		BatteryBar.setValue(getBatPer());
		Plug1Draw.setText(Integer.toString(plug1.getUsage()));
		Plug2Draw.setText(Integer.toString(plug2.getUsage()));
		FridgeDraw.setText(Integer.toString(refrigerator.getUsage()));
		Solar1Input.setText(Integer.toString(solarPanel1.getAddition()));
		Solar2Input.setText(Integer.toString(solarPanel2.getAddition()));
		if (getIn()-getDraw()>=0) {
			BatDraw.setText("+"+Integer.toString(getIn()-getDraw()));
		} else {
			BatDraw.setText(Integer.toString(getIn()-getDraw()));
		}
	}
	public int getIn() {
		return solarPanel1.getAddition()+solarPanel2.getAddition();
	}
	public int getDraw() {
		return plug1.getUsage()+plug2.getUsage()+refrigerator.getUsage();
	}
	public int getBatPer() {
		int result = 0;
		result = 100*(int) Math.ceil(battery1.getRemainingTime()/batMaxTime);
		if (result == batMaxTime) {
			return 100*batMaxTime;
		}
		return result;
	}
	public Plug getPlug1() {
		return plug1;
	}
	public void setPlug1(Plug plug1) {
		this.plug1 = plug1;
	}

	public Plug getPlug2() {
		return plug2;
	}

	public void setPlug2(Plug plug2) {
		this.plug2 = plug2;
	}

	public Refrigerator getRefrigerator() {
		return refrigerator;
	}

	public void setRefrigerator(Refrigerator refrigerator) {
		this.refrigerator = refrigerator;
	}

	public SolarPanel getSolarPanel1() {
		return solarPanel1;
	}

	public void setSolarPanel1(SolarPanel solarPanel1) {
		this.solarPanel1 = solarPanel1;
	}

	public SolarPanel getSolarPanel2() {
		return solarPanel2;
	}

	public void setSolarPanel2(SolarPanel solarPanel2) {
		this.solarPanel2 = solarPanel2;
	}

	public Battery getBattery1() {
		return battery1;
	}

	public void setBattery1(Battery battery1) {
		this.battery1 = battery1;
	}
}
