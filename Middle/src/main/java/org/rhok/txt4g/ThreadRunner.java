package org.rhok.txt4g;

import java.util.Date;

public class ThreadRunner<T extends MessagingJob> implements Runnable {
	private Date lastJobStarted;
	private T job;

	public ThreadRunner(T job) {
		this.job = job;
	}

	public void run() {
		lastJobStarted = new Date();
		while (true) {
			try {
				if (lastJobStarted.getTime() > new Date().getTime()) {
					job.run();
				} else {
					Thread.sleep(20);
				}
			} catch (InterruptedException e) {
			}
		}
	}
}