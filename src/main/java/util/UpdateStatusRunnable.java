package util;

import java.util.concurrent.TimeUnit;

public class UpdateStatusRunnable implements Runnable {

	private Long time;
	
	public UpdateStatusRunnable(Long time){
		this.time = time;
	}
	
	public void run() {
		System.out.printf("\r%s minutes, %s seconds", TimeUnit.SECONDS.toMinutes(time.longValue()), time.longValue() % TimeUnit.MINUTES.toSeconds(1));
		time = Long.valueOf(time.longValue() + 1);
	}

}
