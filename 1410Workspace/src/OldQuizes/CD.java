

/**
 * 
 * @author GSorensen
 * @version
 */
public class CD {
	private static final double MAXTIME = 80.0;
	private String[] songs = {null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
	private double[] lengths= {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};

	/**
	 * 
	 * @param trackName is the name of a track
	 * @param length is the time of the track
	 * @return true if the total time of the CD including this new song <= MAXTIME
	 *         false if the track cannot be added
	 */
	public boolean addTrack(String trackName, double length){
		if (getTotalTime()+length<=MAXTIME) {
			for (int i=0; i<songs.length; i++) {
				if (songs[i]==null) {
					songs[i]=trackName;
					lengths[i]=length;
					return true;
				} 
			}
		} else {
			return false;
		}
		return false;
	}

	/**
	 * 
	 * @param track is the track the user wants
	 * @return the track name if 'track' is a valid track
	 *         null if 'track' is an invalid track
	 */
	public String getTrackName(int track){
		if (track>=0&&track<songs.length+1) {
			return songs[track-1];
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param track is the track the user wants
	 * @return the track time if 'track' is a valid track
	 *         0.0 if 'track' is an invalid track
	 */
	public double getTrackTime(int track){
		try {
			double result = 0;
			if (track>=0&&getTrackName(track)!=null) {
				result = lengths[track-1];
				return result;
			}
		} catch(Exception e) {
			return 0;
		}
		return 0;
	}

	/**
	 * 
	 * @return the current number of tracks on the CD
	 */
	public int getTotalTracks(){
		int result = 0;
		for (int i=0; i<lengths.length; i++) {
			if (lengths[i]==0) {
				return result;
			} else{ 
				result++;
			}
		}
		return result;
	}

	/**
	 * 
	 * @return the current total time of the cd
	 */
	public double getTotalTime(){
		double result = 0;
		for (int i=0; i<lengths.length; i++) {
			result+=lengths[i];
		}
		System.out.println(result);
		return result;
	}

}
