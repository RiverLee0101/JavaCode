package datastructure.array.arrayencapsulation;

/**
 * 二次封装数组
 */
public class Array {
    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参构造函数，默认容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向所有元素后添加一个新元素
    public void addLast(int e) {
        insert(size, e);
    }

    // 向所有元素前添加一个新元素
    public void addFirst(int e) {
        insert(0, e);
    }

    public void insert(int index, int e ) {
        // 查看当前数组剩余空间是否可以容纳新元素
        if(size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        // 用户传入的index必须合法
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Requir index >= 0 || index <= size.");
        }

        // 将要插入的那个位置及其后面的所有元素后移一个位置
        for(int i=size-1; i>=index; i--) {
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    // 获取index位置的元素
    int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        data[index] = e;
    }
    // 查找数组中是否有元素e
    public boolean contains(int e) {
        for(int  i=0; i<size; i++) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }
    // 查找数组中是否有元素e,如果有，索引是多少，如果不存在元素e,返回 -1
    public int find(int e) {
        for(int i=0; i<size; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }
    // 删除指定位置的元素，返回删除的元素
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Requir index >= 0 || index <= size.");
        int ret = data[index];
        // 将指定位置后面的元素全部向前移动一个位置
        for(int i=index+1; i<size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }
    public int removeLast() {
        return remove(size-1);
    }
    // 删除某个元素
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, Capacity = %d \n", size, data.length));
        res.append("[");
        for(int i=0; i<size; i++) {
            res.append(data[i]);
            if(i!=size-1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
