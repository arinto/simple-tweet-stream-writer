package writer;

import twitter4j.StatusListener;
import twitter4j.TwitterStream;


public class BasicWriter implements Runnable {
	
	private final TwitterStream twitterStream;
	private final StatusListener statusListener;
	
	public BasicWriter(TwitterStream twitterStream, StatusListener statusListener){
		this.twitterStream = twitterStream;
		this.statusListener = statusListener;
	}

	public void run() {
		this.twitterStream.addListener(this.statusListener);
		this.twitterStream.sample();
	}

}
