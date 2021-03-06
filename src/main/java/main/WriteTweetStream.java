package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import listener.BasicStatusListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import util.UpdateStatusRunnable;

public class WriteTweetStream {
	
	private static final Logger logger = LoggerFactory.getLogger(WriteTweetStream.class);
	private static final String usage = "Usage main.WriteTweetStream <duration in minutes>";
	
	public static void main(String[] args) throws InterruptedException {
		
		if(args.length < 1){
			System.out.printf("%s%n", usage);
		}
		
		long duration = 0;
		try {
			duration = Long.valueOf(args[0]);
		} catch (NumberFormatException e1) {
			System.out.printf("Wrong format of duration argument. %s%n", usage);
			return;
		}
		
		System.out.printf("Start writing tweet stream, duration: %s minutes%n", duration);
		
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		StatusListener statusListener = new BasicStatusListener();
		twitterStream.addListener(statusListener);
		twitterStream.sample();
		
		Long init = Long.valueOf(0);
		Runnable updateStatus = new UpdateStatusRunnable(init);
		
		ScheduledExecutorService theScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		theScheduledExecutor.scheduleAtFixedRate(updateStatus, 0, 1, TimeUnit.SECONDS);
		
		try {
			TimeUnit.MINUTES.sleep(duration);
		} catch (InterruptedException e) {
			logger.info("Interrupted!", e);
		} finally{
			twitterStream.cleanUp();
			theScheduledExecutor.shutdown();
			theScheduledExecutor.awaitTermination(10, TimeUnit.SECONDS);
		}

	}

}
