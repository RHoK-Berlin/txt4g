package org.rhok.txt4g;


/**
 * Main class for the middleware.
 * 
 * @author ddebray, mwinter
 *
 */
public class Txt4gRunner {

	/**
	 * Main method.
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception{
    	ThreadRunner<MessagingJob> tr = new ThreadRunner<MessagingJob>(new MessagingJob());
    	Thread t = new Thread(tr);
    	t.start();
    }
}