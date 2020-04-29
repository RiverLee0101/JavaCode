package datastructure.array.arraydynamic;

public class ArrayDynamicTest {

	public static void main(String[] args) {
		ArrayDynamic<Integer> arr = new ArrayDynamic<>(); // 无参构造函数设为容量为10的数组
		for(int i=0; i<10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr);
		
		// 插入之前先扩容至20
		arr.insert(1,100);
        System.out.println(arr);
 
        arr.addFirst(-1);
        System.out.println(arr);
        //[-1,0,100,1,2,3,4,5,6,7,8,9]
 
        arr.remove(2);
        System.out.println(arr);
        //[-1,0,1,2,3,4,5,6,7,8,9]
 
        arr.removeElement(4);
        System.out.println(arr);
        //[-1,0,1,2,3,5,6,7,8,9]
 
        arr.removeFirst();
        System.out.println(arr);
        //[0,1,2,3,5,6,7,8,9]
	}
	

}
