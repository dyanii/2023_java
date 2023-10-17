package Week06_02;

interface ArrayProcessing{
	double apply(double[] array);
}

public class LambdaTest {
	//주어진 배열에서 최댓값을 계산하는 람다식 작성
	public static final ArrayProcessing maxer = array -> {
		if(array.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		double max = array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i]> max) {
				max = array[i];
			}
		}
		return max;
	};
	//주어진 배열에서 최솟값을 계산하는 람다식 작성
	public static final ArrayProcessing miner = array -> {
		if(array.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		double min = array[0];
		for(int i=1; i<array.length; i++) {
			if(array[i]< min) {
				min = array[i];
			}
		}
		return min;
	};
	//주어진 배열에서 평균값을 계산하는 람다식 작성
	public static final ArrayProcessing sumer = array -> {
		if(array.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		double sum = 0;
		for(double number : array) {
			sum += number;
		}
		return sum / array.length;
	};
	
	public static void main(String[] args) {
		double[] numbers = {1,2,3,4,5};
		
		System.out.println("Maximum value: " + maxer.apply(numbers));
		System.out.println("Miniimum value: " + miner.apply(numbers));
		System.out.println("Average value: " + sumer.apply(numbers));
	}
}
