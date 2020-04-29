package datastructure.array.arraygenericity;

/**
 * 使用泛型的数组
 * @param <E>
 */
public class ArrayGenericity<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造泛型array
    public ArrayGenericity(int capacity) {
        // 不能直接new E[],做一个强制类型转换
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayGenericity() {
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
    public void addLast(E e) {
        insert(size,e);
    }
    public void addFirst(E e) {
        insert(0,e);
    }
    public void insert(int index,E e) {
        //查看当前数组剩余空间是否可以容纳新元素
        if (size == data.length)
            throw new IllegalArgumentException("Add failed.Array is full.");

        // ** 用户传的index必须合法：校验大小
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Requir index >= 0 || index <= size.");

        //长度一定记得 -1
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }
    // 获取index位置的元素
    E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        return data[index];
    }
    // 修改index索引元素为e
    void set(int index ,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Index is Illegal.");
        data[index] = e;
    }
    // 查找数组中是否有重复元素e
    public boolean contains(E e){
        for (int i = 0 ;i < size ; i ++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    // 查找数组中是否有元素e,如果有，索引是多少，如果不存在元素e,返回 -1
    public int find(E e){
        for (int i = 0 ;i < size ; i ++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    // 删除指定位置元素,返回删除的元素
    public E remove(int index){
        // ** 用户传的index必须合法：校验大小
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed.Requir index >= 0 || index <= size.");

        E ret = data[index];
        for (int i = index + 1;i < size ;i ++){
            data[i - 1] = data[i];
        }
        size -- ;
        data[size] = null; //loitering objects != memory leak
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }
    // 删除某个元素
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
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
}
