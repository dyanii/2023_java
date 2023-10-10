package Week05_01;

class Container<T>{
	private T t;
	
	public T get() {
		return t;
	}
	public void set(T t) {
		this.t = t;
	}
	
}

public class ContainerExample {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(2321);
		int value = container2.get();
		System.out.println(value);
	}

}
