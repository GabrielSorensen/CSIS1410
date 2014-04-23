package GameLogic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import Entities.PlayableCharacter;

public class PrefsParser {

	private static final File prefs = new File("src/prefs.ini");
	private File save;
	private PlayableCharacter player;
	private static int count = 0;
	private boolean success = false;

		public PrefsParser () {
			
		}
	public PrefsParser (PlayableCharacter c) {
		this.player = c;
	}
	public boolean saveGame(int spot) {
		Formatter out = null;
		try {
			save = new File("save/game"+spot);
			out = new Formatter(save);
			if (save.canWrite()) {
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutput output = null;
				System.out.println("Saving Game in Spot: "+spot);
				try {
					output = new ObjectOutputStream(bos);   
					output.writeObject(player);
					byte[] gabe = bos.toByteArray();
					out.format(gabe.toString(), "");
					success = true;
				} finally {
					output.close();
					bos.close();
					out.flush();
					out.close();
				}
				if (success) {
					resetCount();
					return true;
				} else {
					resetCount();
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			if  (count<=5) {
			saveGame(spot);
			} else {
				resetCount();
				return false;
			}
		}
		return success;
	}
	public PlayableCharacter loadGame(int spot) throws IOException {
		save = new File("save/game"+spot);
		if (save.canRead()) {
			Scanner in = new Scanner(save);
			ByteArrayInputStream bis = null;
			ObjectInput input = null;
			String s = new String();
			try {
				while (in.hasNext()) {
					s+=in.next();
				}
				byte [] bytes = s.getBytes();
				bis = new ByteArrayInputStream(bytes);
				input = new ObjectInputStream(bis);
				player = (PlayableCharacter) input.readObject();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				in.close();
				bis.close();
				input.close();
			}
		}
		return player;
	}
	public int savePrefs() {
		
		return -1;
	}
	public ArrayList<String> loadPrefs(String location) throws IOException {
		FileReader in= null;
		BufferedReader input = new BufferedReader(in);
		ArrayList<String> settings = new ArrayList<String>();
		try {
			in = new FileReader(prefs);
			while (input.readLine()!=null) {
				settings.add(input.readLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		
		return settings;
	}
	@SuppressWarnings("static-access")
	public int resetCount() {
		this.count = 0;
		return 0;
	}
}
