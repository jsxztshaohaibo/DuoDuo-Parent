
public class Test {

	public static void main(String[] args) {
		int [] arr = new int[10];
		arr[0] =1 ;
		arr[9] =9 ;
		System.out.println(arr.length);
		int pos = 6;
		for(int i = arr.length-1 -1;i>=pos-1;i--){
			arr[i+1] =arr[i];
		}
		arr[pos-1] =5;
		
		
		for(int i : arr){
			System.out.println(i);
		}
	}

}
