package Exercise;
//제네릭 메소드의 예

class Box2<T>{
	private T t;
	
	public T get() {
		return t;
	}
	
	public void set(T t) {
		this.t = t;
	}
}

public class GenericMe {
	//제레닉 메소드
	public static <T> Box2<T> boxing(T t){
		Box2<T> box = new Box2<T>();
		box.set(t);
		return box;
	}
	public static void main(String[] args) {
		Box2<Integer> box1 = boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);
		
		Box2<String> box2 = boxing("안녕");
		String strValue = box2.get();
		System.out.println(strValue);
	}
}
