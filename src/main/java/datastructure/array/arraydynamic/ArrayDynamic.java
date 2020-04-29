package datastructure.array.arraydynamic;

// 动态数组

// E表示数据类型，具体是什么传什么

public class ArrayDynamic<E> {
	private E[] data;
	private int size;
	
	public ArrayDynamic(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}
	public ArrayDynamic() {
		this(10);
	}
	public int getSize() {
		return size;
	}
	public int getCapacity() {
		return data.length;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void  addLast(E e) {
		insert(size, e);
	}
	public void addFirst(E e) {
		insert(0, e);
	}
	public void insert(int index, E e) {
		// ** 用户传的index必须合法：校验大小
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Requir index >= 0 || index <= size.");
        // 如果元素个数等于容量，那么扩容至两倍
        if(size == data.length) {
        		resize(2 * data.length);
        }
        for (int i=size-1; i>=index; i--) {
        		data[i+1] = data[i];
        }
        data[index] = e;
        size++;
	}
	// 获取index位置的元素
	// 知道index直接获取元素，时间复杂度为O(1)
    E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        return data[index];
    }
    // 修改index索引位置的元素为e
    void set(int index ,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        data[index] = e;
    }
    public boolean contains(E e) {
    		for (int i=0; i<size; i++) {
    			if(data[i].equals(e))
    				return true;
    		}
    		return false;
    }
    // 查找数组中是否有元素e,如果有索引是多少，没有返回-1
    // 因为不知道index要遍历整个数组，所以时间复杂度为O(n)
    public int find(E e) {
    		for (int i=0; i<size; i++) {
    			if(data[i].equals(e))
    				return i;
    		}
    		return -1;
    }
    // 删除指定位置的元素，返回删除的元素
    public E remove(int index) {
    		if (index < 0 || index >= size)
    			throw new IllegalArgumentException("Get failed.Index is Illegal.");
    		E ret = data[index];
    		for (int i=index+1; i<size; i++) {
    			data[i-1] = data[i];
    		}
    		// 这里size--,两层含义：1）去掉一个元素size减去一个。2）去掉末尾的元素
    		size--;
    		data[size] = null;
    		if(size==data.length/2) {
    			resize(data.length/2);
    		}
    		return ret;
    }
    
    public E removeFirst(){
        return remove(0);
    }
 
    public E removeLast(){
        return remove(size - 1);
    }
    public void removeElement(E e) {
    		int index = find(e);
    		if(index != -1) {
    			remove(index);
    		}
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d,capacity = %d \n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i ++){
            res.append(data[i]);
            if (i != size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
    
    public void resize(int newCapacity) {
    		E[] newData = (E[]) new Object[newCapacity];
    		for (int i=0; i<size; i++) {
    			newData[i] = data[i];
    		}
    		data = newData;
    }
}
