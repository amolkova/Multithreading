
public class MyThread extends Thread{
	private float[] arr;
	
	public MyThread(String name, float[] arr) {
		super(name);
		this.arr = arr;
		start();
	}
		
	@Override
	public void run() {
		
		System.out.println(getName() + " start");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));	
		}
	
		System.out.println(getName() + " finish");
	}
	
}
