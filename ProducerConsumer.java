import java.io.PushbackInputStream;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ProducerConsumer{
	public static void main(String args[]) throws InterruptedException {
		StackWithArray<Integer> stack = new StackWithArray<Integer>();
		Thread producer = new Producerr(stack);
		Thread consumer = new Consumerr(stack);
		producer.start();
		consumer.start();
	}
}
class StackWithArray<T> {
	private volatile static int size = 0;
	StackList<T> stack;
	private static Semaphore popSem,pushSem;
	private static final int Upper_Bound  =10;
	public StackWithArray() throws InterruptedException {
		stack =new StackList<T>();
		popSem = new Semaphore(Upper_Bound);
		pushSem=new Semaphore(Upper_Bound);
		popSem.acquire(Upper_Bound);
	}
	public T pop() throws Exception {
		popSem.acquire();
		if(stack.head==null) {
			throw new Exception("Stack is empty");
		}
		T val = stack.head.value;
		stack.head=stack.head.next;
		size--;
		System.out.println("popping:"+val);
		if(size<Upper_Bound) {
		pushSem.release();
		}
		return val;
	}
	public void push(T value) throws InterruptedException {
		ListNode<T> node = new ListNode<T>(value);
		pushSem.acquire();
		if(stack.head!=null) {
			node.next=stack.head;
			stack.head=node;
		}else
			{
			stack.head=node;
			}
		size++;
		System.out.println("pushing:"+value);
		if(size>0) {
		popSem.release();
		}
	}

	public T peek() {
		return stack.head.value;
	}
}

class ListNode<T> {
	T value;
	ListNode<T> next;
	//ListNode prev;
	public ListNode(T val) {
		this.value = val;
	}

}
class StackList<T>{
	ListNode<T> head;
	public StackList(){
		head = null;
	}
}
class Producerr extends Thread {
	private StackWithArray<Integer> stack;
	int counter = 0;
	public Producerr(StackWithArray<Integer> stack) {
		this.stack=stack;
	}
	@Override
	public void run() {
		while(true) {
			try {
				stack.push(counter++);
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Consumerr extends Thread {
	private StackWithArray<Integer> stack;
	public Consumerr(StackWithArray<Integer> stack) {
		this.stack=stack;
	}
	@Override
	public void run() {
		while(true) {
			try {
				stack.pop();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}