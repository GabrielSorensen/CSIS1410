/**
 * 
 * @author Dr B
 * @version Spring 2011
 */
public class CDGrader {

	static int points = 100;
	static int deduction = 10;
	static boolean [] notDeducted = {true, true, true, true, true, true, true, true, true, true};


	public static void main(String[] args) {
		CD c = new CD();

		int addWorks = 0;
		//boolean overTheLimitWorks = true;
		int getTotalTracksWorks = 1;
		int getTotalTimeWorks = 2;
		int getTrackNameWorks = 3;
		int getTrackTimeWorks = 4;
		int overAddWorks = 5;
		int overTimeWorks = 6;
		int overTracksWorks = 7;
		int bogusGetTrackNameWorks = 8;
		int bogusGetTrackTimeWorks = 9;
		double delta = 0.01;

		int x = c.getTotalTracks();
		if (x != 0){
			deduct("Error: A new CD should have 0 tracks", getTotalTracksWorks);
		}

		String [] songs = {"When We Dance", "If You Love Somebody Set Them Free", "Fields of Gold", "All This Time", "Fortress Around Your Heart", "Be Still My Beating Heart", "They Dance Alone (Cueca Solo)", "If I Ever Lose My Faith in You", "Fragile", "Why Should I Cry for You", "Englishman in New York", "We'll Be Together", "Russians", "This Cowboy Song", "Java Rocks"};
		double [] times = {5.59, 7.15, 3.39, 4.55, 4.36, 5.32, 7.10, 4.31, 3.53, 4.50, 4.27, 3.51, 3.58, 5.00, 10.00};
		
		double totalTime = 0;
		//add all the songs
		for (int i = 0; i < songs.length; i++){
			totalTime += times[i];
			boolean added = c.addTrack(songs[i], times[i]);
			if (added == false){
				deduct("Error: when adding a valid song, somehow the value false was returned", addWorks);
			}

			x = c.getTotalTracks();
			if (x != i+1){
				deduct("Error: A CD with " + (i+1) + "songs should have " + (i+1) + " tracks", getTotalTracksWorks);
			}
			double time = c.getTotalTime();
			if ((!(time + delta >= totalTime && totalTime+delta >= time))){
				deduct("Error: after adding " + (i+1) + " songs the time should be " + totalTime + " and not " + time, getTotalTimeWorks);
			}
			
		}
		//check the list of songs
		for (int i = 0; i < songs.length; i++){
			String s = c.getTrackName(i+1);
			if ((! songs[i].equals(s))){
				deduct("Error: song " + (i+1) + " should have a name '" + songs[i] + "' and not '" + s + "'", getTrackNameWorks);
			}

			double time = c.getTrackTime(i+1);
			if ((!(time + delta >= times[i] && times[i]+delta >= time))){
				deduct("Error: song " + (i+1) + " should have a time of " + times[i] + " and not " + time, getTrackTimeWorks);
			}
		}

		boolean added = c.addTrack("Java Rocks", 5.0);
		if (added == true){
			deduct("Error: Your addTrack returned true for a cd that went over the total length", overAddWorks);
		}
		double time = c.getTotalTime();
		if (!(time + delta >= totalTime && totalTime+delta >= time)){
			deduct("Error: Your total time after adding a song that is too long is wrong", overTimeWorks);
		}
		int numSongs = c.getTotalTracks();
		if (numSongs != songs.length){
			deduct("Error: Your total tracks after adding a song that is too long is wrong" , overTracksWorks);
		}
		
		try{
			String s = c.getTrackName(-1);
			if (s != null){
				deduct("Error: getTrackName does not return null on an invalid track", bogusGetTrackNameWorks);
			}
			s = c.getTrackName(16);
			if (s != null){
				deduct("Error: getTrackName does not return null on an invalid track", bogusGetTrackNameWorks);
			}
		}
		catch(Exception e){
			deduct("Error: getTrackName does not return null on an invalid track", bogusGetTrackNameWorks);
		}

		try{
			double t = c.getTrackTime(-1);
			if ( t != 0){
				deduct("Error: getTrackTime does not return 0 on an invalid track", bogusGetTrackTimeWorks);
			}
			t = c.getTrackTime(16);
			if ( t != 0){
				deduct("Error: getTrackTime does not return 0 on an invalid track", bogusGetTrackTimeWorks);
			}
		}
		catch(Exception e){
			deduct("Error: getTrackTime does not return 0 on an invalid track", bogusGetTrackTimeWorks);
		}
		
		
		System.out.println("Your total score is: " + points);
	}

	public static void deduct(String s, int b){
		if (notDeducted[b] == true){
			System.err.println(s);
			notDeducted[b] = false;
			points -= deduction;
		}
	}
	
}
