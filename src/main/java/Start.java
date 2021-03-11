import javax.swing.plaf.multi.MultiTableHeaderUI;

public class Start {
	private static final int size = 10000000;
	private static final int h = size / 2;
		
	public static void main(String[] args) {
		float[] arr = new float[size];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 1;
		}
			
		long start = System.currentTimeMillis();
		
		System.out.println("Usual operation one thred: " + start);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}

		long end = System.currentTimeMillis();
		
		System.out.println("Usual operation result: " + (end - start));
		
		multithreiding();
		
	}
	
	public static void multithreiding(){
		
		float[] arr = new float[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		
		long start = System.currentTimeMillis();
		
		float[] arrayFirst = new float[h];
		float[] arraySecond = new float[h];
		
		System.arraycopy(arr, 0, arrayFirst, 0, h);
				
		System.arraycopy(arr, h, arraySecond, 0, h);
		
		MyThread thread = new MyThread("first", arrayFirst);
		MyThread threadTwo = new MyThread("second", arraySecond);
		
		try {
			thread.join();
			threadTwo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		long end = System.currentTimeMillis();
		
		System.out.println("Multithreiding operation : " + (end - start));		
		
		}	
}
