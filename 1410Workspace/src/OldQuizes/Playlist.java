/**
 * 
 * @author
 * @version
 */
public class Playlist {
	private static final int MAXSONGS = 14;
	private String[] songs = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
	private double[] lengths= {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	private static int current = 0;
	/**
	 * 
	 * @param trackName is the name of a track
	 * @param length is the time of the track
	 * @return true if the song can be added, false if the song cannot be added
	 *         Only MAXSONGS can display on the screen, so only that many can be added
	 *
	 * GOTCHAS:  Adding a song does not advance the playlist EXCEPT when adding the first
	 *           song, so that getCurrentSongName() works
	 */
	public boolean addSong(String songName, double length){
		if (getTotalSongs()<MAXSONGS) {
			for (int i=0; i<songs.length; i++) {
				if (songs[i]==null) {
					songs[i]=songName;
					lengths[i]=length;
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @return the current song name or null if there are no songs in the playlist
	 * 
	 */
	public String getCurrentSongName(){
		return songs[current];
	}
	
	/**
	 * 
	 * @return the current song time or 0.0 if there are no songs in the playlist
	 */
	public double getCurrentSongTime(){
		return lengths[current];	
	}
	
	/**
	 * 
	 * @return the current number of songs in the playlist
	 */
	public int getTotalSongs(){
		for (int i=0; i<songs.length; i++) {
			if (songs[i]==null) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * This method advances the playlist to the next song
	 * If it reaches the end, it should advance to the first song added
	 */
	public void advanceToNextSong(){
		if (current==13) {
			current = 0;
		} else {
			current++;
		}
	}
	
	/**
	 * 
	 * @return the current total time of the playlist
	 */
	public double getTotalPlaylistTime(){
		double time=0;
		for (int i=0; i<songs.length; i++) {
			time+=lengths[i];
		}
		return time;
	}
}
