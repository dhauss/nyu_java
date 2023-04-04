package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 
 Q1
 * Without synchronization, there is no guarantee that lines 25-31 will run atomically, and more importantly,
 * no guarantee that line 26 will execute immediately after line 25 without another thread interrupting the
 * current thread. A noSuchElementException will occur if, for example, the m1 thread (an IntegerMiddleman)
 * runs all of line 25 and finds an integer after peeking at the queue. Assume this is the only element in
 * the generalProducerQueue. If m1 immediately blocks, and m2 starts up at its own line 25, completes line 26
 * and removes that same integer to assign to m2.outObj, the generalPurposeQueue will now be empty. If m2 now
 * blocks and m1 starts again before the Producer thread runs, m1 will continue to line 26 and remove an
 * object from an empty queue, and "in.remove()" will throw a NoSuchElementException.
 * 
 * A NullPointerException will occur if m1 runs the first half of line 25 ((in.peek() != null) and then
 * immediately blocks in a similar scenario. m2 then removes the last element from the generalPurposeQueue
 * and m1 resumes at (isInstance(in.peek().getClass())) on a now empty generalPurposeQueue. in.peek() will
 * return a null pointer, and calling the instance method, isInstance(), on that null pointer will throw the
 * NullPointerException

Q2
 * There is only one producer thread, and no other class adds to the generalPurposeQueue. The count may
 * not be current by the time p randomly adds a string or an integer to the queue. For instance, p may run
 * line 43 and get the size of the generalPurposeQueue, immediately block, then the middleman threads may
 * run for awhile and take some elements off of the generalPurposeQueue. When p wakes back up, the count
 * it received will be outdated before it adds a string or integer to the generalPurposeQueue. The true
 * current size of generalPurposeQueue will only ever be less than or equal to the outdated out.size() count 
 * whenever p reawakens, though, because no matter what other threads run, they will only
 * ever remove elements from generalPurposeQueue, or in the case of Consumer threads, only remove elements
 * from the integer or string queues and leave the generalPurposeQueue untouched. The block from lines
 * 43-57 would only need to be synchronized if there were more than one producer thread in MonitorQueues.

Q3 
 * I synchronized lines 56-66 on the out queue to fix this. line 56 "if (out.size() >= 10)" implicitly
 * checks if the queue is small enough to add to and then adds the outObj to the out queue (either
 * integerQueue or stringQueue). If these lines are not synchronized, m1 may check line 56 and conclude
 * that the out queue is small enough to add to. If it immediately blocks and m2 adds the 10th element
 * to the same out queue before m1 wakes up and offers its outObj, the integerQueue will have 11 elements
 * and trigger the alert "Alert. Queue 1  > 10. Shouldn't happen". A symmetrical situation can of course
 * occur with m3, m4 and the StringQueue, leading to the alert "Alert. Queue 2 > 10. Shouldn't happen".
 * By making lines 56-66 an atomic operation, we can ensure that the "if (out.size() >= 10)" check remains
 * current until the thread places a new object on its respective out queue
 */

public class MonitorQueues implements Runnable {

	Queue<Object> generalPurposeQueue;
	Queue<Object> integerQueue;
	Queue<Object> stringQueue;
	
	private IntegerMiddleMan m1,m2;
	private StringMiddleMan m3,m4;
	private Consumer c1;
	private Consumer c2;
	private Producer p;
	private static final int DELAY = 10;
	
	public MonitorQueues() {
		generalPurposeQueue = new LinkedList<Object>();
		integerQueue = new ConcurrentLinkedQueue<Object>();
		stringQueue = new ConcurrentLinkedQueue<Object>();
		
		p = new Producer(generalPurposeQueue);
		m1 = new IntegerMiddleMan(generalPurposeQueue, integerQueue);
		m2 = new IntegerMiddleMan(generalPurposeQueue, integerQueue);
		m3 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		m4 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		c1 = new Consumer(integerQueue);
		c2 = new Consumer(stringQueue);
		
	}

	@Override
	public void run() {
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(m1).start();
		new Thread(m2).start();
		new Thread(m3).start();
		new Thread(m4).start();
		new Thread(p).start();
		while (true) {
			if (integerQueue.size() > 10) {
				System.out.println("Alert. Queue 1  > 10. Shouldn't happen");
			}
			if (stringQueue.size() > 10) {
				System.out.println("Alert. Queue 2 > 10. Shouldn't happen");
			}
			
			if (generalPurposeQueue.size() > Producer.MAX_QUEUE_SIZE) {
				System.out.println("Alert. Input Queue > " + Producer.MAX_QUEUE_SIZE + ". Shouldn't happen");
			}
			
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MonitorQueues mq = new MonitorQueues();
		Thread t = new Thread(mq);
		t.start();
	}
}
