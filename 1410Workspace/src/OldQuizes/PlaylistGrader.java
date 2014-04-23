/**
 * 
 * @author Dr B
 * @version Spring 2010
 */
public class PlaylistGrader {

	private static int points = 99;
	private static int deduction = 11;
	private static final double delta = 0.001;

	public static void deduct(String s){
		System.err.println(s);
		points -= deduction;
	}
	public static boolean goodEnough(double a, double b){
		if (a + delta > b && b + delta > a){
			return true;
		}
		return false;
	}
	public static boolean goodEnough(int a, int b){
		if (a == b){
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		Playlist c = new Playlist();

		try{
			if (! (goodEnough(c.getTotalPlaylistTime(),0.0)  && goodEnough(c.getTotalSongs(),0))){
				deduct("Error: A new playlist should have a total time of 0.0 and 0 songs in it");
			}
		}
		catch(Exception e){
			deduct("Error: A new playlist should have a total time of 0.0 and 0 songs in it");
		}

		try{
			if(! (goodEnough(c.getCurrentSongTime(),0.0) && c.getCurrentSongName() == null)){
				deduct("Error: A new playlist should have a current song time of 0.0 and current song name of null");
			}
		}
		catch(Exception e){
			deduct("Error: A new playlist should have a current song time of 0.0 and current song name of null");
		}

		String [] songs = {"When We Dance", "If You Love Somebody Set Them Free", "Fields of Gold", "All This Time", "Fortress Around Your Heart", "Be Still My Beating Heart", "They Dance Alone (Cueca Solo)", "If I Ever Lose My Faith in You", "Fragile", "Why Should I Cry for You", "Englishman in New York", "We'll Be Together", "Russians", "This Cowboy Song", "Java Rocks"};
		double [] times = {5.59, 7.15, 3.39, 4.55, 4.36, 5.32, 7.10, 4.31, 3.53, 4.50, 4.27, 3.51, 3.58, 5.00, 10.00};

		double totalTime = 0;
		boolean added = true;
		boolean totalSongs = true;
		boolean totalTimeBoolean = true;
		//add all the valid songs
		for (int i = 0; i < songs.length-1; i++){
			totalTime += times[i];
			added = c.addSong(songs[i], times[i]) && added;

			if (c.getTotalSongs() != i+1){
				totalSongs = false;
			}
			double time = c.getTotalPlaylistTime();
			totalTimeBoolean = goodEnough(time,totalTime) && totalTimeBoolean;

		}
		if (added == false){
			deduct("Error: when adding a valid song, somehow the value false was returned");
		}
		if(totalSongs == false){
			deduct("Error: when adding a valid song, somehow the total number of songs was incorrect");
		}
		if(totalTimeBoolean == false){
			deduct("Error: when adding a valid song, somehow the total time of the playlist was incorrect");
		}

		//check the list of songs
		boolean songNames = true;
		boolean songTimes = true;
		for (int i = 0; i < songs.length-1; i++){
			String s = c.getCurrentSongName();
			songNames = songs[i].equals(s) && songNames;
			if(!songs[i].equals(s)){
				System.out.println("Song " + s + " should be " + songs[i]);
			}

			double time = c.getCurrentSongTime();
			songTimes = songTimes && goodEnough(time, times[i]);
			c.advanceToNextSong();
		}

		if (songNames == false){
			deduct("Error: getting the current song name does not work correctly");
		}
		if (songTimes == false){
			deduct("Error: getting the current song time does not work correctly");
		}

		//Should already be on the first song, so advance to the 3rd, which is spot 2 of our array
		c.advanceToNextSong();
		c.advanceToNextSong();
		if(! (songs[2].equals(c.getCurrentSongName()) && goodEnough(times[2],c.getCurrentSongTime()))){
			deduct("Error: advancing from the end to the beginning doesn't seem to work");
		}


		added = c.addSong("Java Rocks", 5.0);
		double time = c.getTotalPlaylistTime();
		int numSongs = c.getTotalSongs();
		if (added == true || ! goodEnough(time,totalTime) || numSongs != c.getTotalSongs()){
			deduct("Error: Your addSong returned true, or changed the total number of songs or total time for a playlist that went over the total length");
		}



		if(points == 99){
			points = 100;
		}
		System.out.println("Your total score is: " + points);
	}


}
