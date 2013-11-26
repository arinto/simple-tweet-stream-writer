package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class BasicStatusListener implements StatusListener{

	private static final Logger logger = LoggerFactory.getLogger(BasicStatusListener.class);
	
	public void onException(Exception ex) {
		//do nothing
	}

	public void onStatus(Status status) {
		logger.trace("{}:{}", status.getUser().getScreenName(), status.getText());
		logger.info("{}", status.getText().replaceAll("[\\r\\n]", " "));
	}

	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		//do nothing
	}

	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		//do nothing
	}

	public void onScrubGeo(long userId, long upToStatusId) {
		//do nothing
	}

	public void onStallWarning(StallWarning warning) {
		//do nothing
	}
}
