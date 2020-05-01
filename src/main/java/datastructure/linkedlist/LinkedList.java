package datastructure.linkedlist;

public class LinkedList<E> {

    // 使用虚拟头结点 可以避免对head进行特殊操作
    private Node dummyHead;
    private int size;

    /**
     * LinkedList() 构造函数
     * 构造一个空节点 虚拟头结点
     *
     */
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    // 获取链表大小
    public int getSize() {
        return size;
    }

    // 链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * （增）在链表的index位置添加元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("index不合法");
        }

        Node prev = dummyHead;

        // 从头结点开始遍历，遍历到插入索引的前一个索引
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//        // 创建一个新节点
//        Node node = new Node(e);
//        // 新节点指向上一个节点的下一个节点
//        node.next = prev.next;
//        // 上一个节点的指向新节点
//        prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * （增）插入到链表头
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * （增）插入到链表尾
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * （查）获取指定索引的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("index不合法");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return (E) cur.e;
    }

    /**
     * （查）获取头结点
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * （查）获取尾节点
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * （改）修改链表中index位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if(index < 0 && index > size){
            throw new IllegalArgumentException("index不合法");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * （查）查找链表中是否存在元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * （删）删除指定索引的节点
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("index不合法");
        }

        // 指向要删除节点的前一个位置
        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node removeNode = prev.next;
        prev.next = removeNode.next;
        removeNode.next = null;
        size--;
        return (E) removeNode.e;
    }

    /**
     *（删）删除头结点
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * （删）删除尾结点
     *
     * @return
     */
    public E removeLast() {
        return remove(size-1);
    }

    /**
     * toString()
     *
     * @return
     */
    public  String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "--->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
