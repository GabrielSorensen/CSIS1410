import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


@SuppressWarnings("serial")
public class Panel extends JPanel {

	private int lives = 100;
	private int cash = 100;
	private int currentType = 0;
	private int Mx;
	private int My;
	private Tower t;
	private Tower t2;
	private Enemy E;
	private JLabel livesDisplay;
	private JLabel cashDisplay;
	private BufferedImage[][] map;
	private boolean towerButtonClicked = false;
	private boolean infMoney;
	private boolean infLives;
	private boolean enemyDestroyed = false;
	private ArrayList<TowerDefenceObject> things = new ArrayList<TowerDefenceObject>();
	private ArrayList<Projectile> orBS = new ArrayList<Projectile>();
	private long sleepSpeed = 30;
	public static ArrayList<TowerDefenceObject> MAP_OBJECT = new ArrayList<TowerDefenceObject>();

	public Panel() {
		setSize(new Dimension(735, 549));
		this.map = basicMap();
		ML listener = new ML();
		addMouseMotionListener(listener);
		addMouseListener(listener);
		//		System.out.println("Created new Basic map    "+things.size());
	}
	public Panel(String location, JLabel labelLives, JLabel labelCash){
		setSize(new Dimension(735, 549));
		ML listener = new ML();
		addMouseMotionListener(listener);
		addMouseListener(listener);
		getMapLayout(location);
		lives = 100;
		cash = 100;
		this.setLivesDisplay(labelLives);
		this.setCashDisplay(labelCash);
		update();
	}
	public boolean isInfMoney() {
		return infMoney;
	}
	public void setInfMoney(boolean infMoney) {
		this.infMoney = infMoney;
	}
	public boolean isInfLives() {
		return infLives;
	}
	public void setInfLives(boolean infLives) {
		this.infLives = infLives;
	}
	public long getSleepSpeed() {
		return sleepSpeed;
	}
	public void setSleepSpeed(long sleepSpeed) {
		this.sleepSpeed = sleepSpeed;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getSubtractlives() {
		return lives;
	}
	public void setSubtractlives(int subtractlives) {
		this.lives = subtractlives;
	}
	public int getCurrentType() {
		return currentType;
	}
	public void setCurrentType(int currentType) {
		this.currentType = currentType;
	}
	public JLabel getLivesDisplay() {
		return livesDisplay;
	}
	public void setLivesDisplay(JLabel livesDisplay) {
		this.livesDisplay = livesDisplay;
	}
	public JLabel getCashDisplay() {
		return cashDisplay;
	}
	public void setCashDisplay(JLabel cashDisplay) {
		this.cashDisplay = cashDisplay;
	}
	public BufferedImage[][] getMap() {
		return map;
	}
	public void setMap(BufferedImage[][] map) {
		this.map = map;
	}
	public ArrayList<TowerDefenceObject> getThings() {
		return things;
	}
	public void setThings(ArrayList<TowerDefenceObject> things) {
		this.things = things;
	}
	public BufferedImage[][] getMapLayout(String location){
		BufferedImage [][] field = null;
		try {
			File f = new File(location+".txt");
			Scanner in = new Scanner(f);
			int w = 0;
			int h = 0;
			w = in.nextInt();
			h = in.nextInt();
			field = new BufferedImage[w][h];
			for (int i=0; i<map.length; i++) {
				for (int j=0; j<map[i].length; j++) {
					if (in.next().equals("W")) {
						map[i][j] = TowerDefenceObject.GRASS;
						TowerDefenceObject t = new TowerDefenceObject(i*64, j*64, TowerDefenceObject.GRASS, 64, 64);
						MAP_OBJECT.add(t);
						//						System.out.println("W at :"+i+"\t"+j);
					} else if (in.next().equals("R")) {
						map[i][j] = TowerDefenceObject.PATH;
						TowerDefenceObject t = new TowerDefenceObject(i*64, j*64, TowerDefenceObject.PATH, 64, 64);
						MAP_OBJECT.add(t);
						//						System.out.println("R at :"+i+"\t"+j);
					} else {
						System.err.println("error on handling map tiles.");
					}
					Thread.sleep(10);
				}
			}
			in.close();
		} catch (Exception e) {
			System.err.println("");
			this.map = basicMap();
			return this.map;
		}
		return field;
	}
	public BufferedImage[][] basicMap() {
		try {
			BufferedImage[][] map = new BufferedImage[7][9];
			for (int i=0; i<7; i++) {
				for (int j=0; j<9; j++) {
					if (j==4) {
						map[i][j]= TowerDefenceObject.PATH;
						TowerDefenceObject t = new TowerDefenceObject(i*64, j*64, TowerDefenceObject.PATH, 64, 64);
						MAP_OBJECT.add(t);
					} else {
						map[i][j]= TowerDefenceObject.GRASS;
						TowerDefenceObject t = new TowerDefenceObject(i*64, j*64, TowerDefenceObject.GRASS, 64, 64);
						MAP_OBJECT.add(t);
					}
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void paintComponent(Graphics g) {
		try {
			if (towerButtonClicked) {
				switch (currentType) {
				case 3:
					Projectile p = new Projectile(-50, -50, TowerDefenceObject.BULLET_1, 20, 20, 1, 1, 0, 0);
					t = new Tower(Mx-32, My-32, TowerDefenceObject.TOWER_1, 64, 64, 100, 50, p);
					t.setX(Mx-32);
					t.setY(My-32);
					things.add(t);
					break;
				case 4:
					Projectile p2 = new Projectile(-50, -50, TowerDefenceObject.BULLET_1, 20, 20, 5, 1, 0, 0);
					t = new Tower(Mx-32, My-32, TowerDefenceObject.TOWER_2, 64, 64, 100, 40, p2);
					t.setX(Mx-32);
					t.setY(My-32);
					things.add(t);
					break;
				case 5:
					Projectile p3 = new Projectile(-50, -50, TowerDefenceObject.BULLET_2, 20, 20, 10, 1, 0, 0);
					t = new Tower(Mx-32, My-32, TowerDefenceObject.TOWER_3, 64, 64, 100, 10, p3);
					t.setX(Mx-32);
					t.setY(My-32);
					things.add(t);
					break;
				}
			}
			for (TowerDefenceObject t : MAP_OBJECT) {
				t.drawTheImage(g);
				repaint();
			}
			for (int i=0; i<things.size(); i++) {
				if (things.get(i) instanceof Enemy) {
					if (things.get(i).getX()>450) {
						things.remove(i);
						this.lives --;
						i--;
						continue;
					}
				}
				things.get(i).drawTheImage(g);
				repaint();
				if (things.get(i)==t) {
					things.remove(i);
					i--;
					continue;
				}
				if (things.get(i) instanceof Enemy) {
					E = (Enemy) things.get(i);
					int val = 0;
					if (E.getValue()<0) {
						val = E.getValue();
					} else {
						val = 10;
					}
					if (((Enemy) things.get(i)).getHp()<=0) {
						things.remove(things.get(i));
						System.out.println("Enemy Destroyed!");
						enemyDestroyed = true;
						if (enemyDestroyed) {   
							cash += val;
							enemyDestroyed = false;
							E = null;
						}
						i--;
						continue;
					}
					//					System.out.println("Ex :"+E.getX()+"    Ey: "+E.getY());
				}
				if (things.get(i) instanceof Tower) {
					Tower t = (Tower) things.get(i);
					if (t.getTimeUntilReload()<=2) {
						try {
							if (E != null) {
//								double C = Math.sqrt( Math.pow(t.getX()-E.getX(), 2) + Math.pow(t.getY()-E.getY(), 2) );
								if (true) {  //first fire at first enemy then get the radius working
								Projectile p = t.fireAtEnemy(E);
								if (p != null) {
									orBS.add(p);
								}
								}
							}
						} catch (NullPointerException n) {
							break;
						}
					}
				}
			} // end things
			try {
				for (Projectile p : orBS) {
					p.drawTheImage(g);
					if (E != null) {
						if (p.intersects(E)) {
							E.setHp(E.getHp()-p.getDamage());
							orBS.remove(p);
						}
					}
				} 
			}catch (ConcurrentModificationException e) {
				//ignore trying to remove bad projectiles.
			}
			update();
			Thread.sleep(sleepSpeed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//		System.out.println("Painted."+things.size());
	}
	public void startGame(int wave) {
		for (int i=0; i<wave+wave/2; i++) {
			things.add(new Enemy((int) (-70-(50*i)-(i*i*5)), 256, TowerDefenceObject.BUG1_ANIM, 64, 64, 1, 0, 1, 10));
			if (wave>5) {
				//some wave to start adding harder enemies check me later.
				things.add(new Enemy((int) (-120-(50*i)-(i*i*5)), 256, TowerDefenceObject.BUG2_ANIM, 64, 64, 1, 0, 5, 50));
			}
		}
	}
	public void choseTower(int towerType) {
		setCurrentType(towerType);
		towerButtonClicked = true;
	}
	public void placeTower(Tower t3) {
		int cost = 999999999;
		if (currentType==3) {
			cost = 50; 
		} else if (currentType==4) {
			cost = 100;
		} else if (currentType==5) {
			cost = 150;
		}
		if (cost<=this.cash) {
			things.add(t3);
			cash -= cost;
		}
	}
	public void update() {
		if (infMoney) {
			setCash(9999);
		}
		if (infLives) {
			setSubtractlives(999999);
		}
		cashDisplay.setText(Integer.toString(getCash()));
		livesDisplay.setText(Integer.toString(getSubtractlives()));
		if (Integer.parseInt(getLivesDisplay().getText())<=0) {
			things.clear();
			MAP_OBJECT.clear();
			setCash(0);
			setSubtractlives(0);
			this.setSize(0, 0);
			JOptionPane.showMessageDialog(this, "You lost.");
		}
		repaint();
	}
	class ML implements MouseMotionListener, MouseInputListener {
		@Override
		public void mouseDragged(MouseEvent M) {
			towerButtonClicked = false;
		}
		@Override
		public void mouseMoved(MouseEvent M) {
			update();
			Mx = M.getX();
			My = M.getY();
		}
		@Override
		public void mouseClicked(MouseEvent M) {
			if (towerButtonClicked) {
				if (M.getButton()==MouseEvent.BUTTON1) {
					t2 = new Tower(t);
					placeTower(t2);
					towerButtonClicked = false;
				}
			} else if (M.getButton()==MouseEvent.BUTTON2 || M.getButton()==MouseEvent.BUTTON3) {
				towerButtonClicked = false;
			}
		}
		@Override
		public void mouseEntered(MouseEvent M) {
		}
		@Override
		public void mouseExited(MouseEvent M) {
		}
		@Override
		public void mousePressed(MouseEvent M) {
		}
		@Override
		public void mouseReleased(MouseEvent M) {
		}
	}
}