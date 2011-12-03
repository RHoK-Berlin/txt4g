package org.rhok.txt4g;

import java.util.Date;

/**
 * Runs a job frequently. As opposed to a cronjob this can hold data (i.e. cache hits)
 * and avoids gc operations. 
 * 
 * @author ddebray, mwinter
 * 
 * @param <T>
 *            job to be run
 */
public class ThreadRunner<T extends MessagingJob> implements Runnable {
	private static final int SLEEPTIME_IN_MS = 20;
	private static final int INTERVAL_IN_MS = 3000; // TODO: externalize to properties-file
	private Date lastJobStarted;
	private T job;

	public ThreadRunner(T job) {
		this.job = job;
	}

	public void run() {
		lastJobStarted = new Date();
		while (true) {
			try {
				if (lastJobStarted.getTime() + INTERVAL_IN_MS > new Date().getTime()) {
					job.run();
				} else {
					Thread.sleep(SLEEPTIME_IN_MS);
				}
			} catch (InterruptedException e) {
			}
		}
	}
}