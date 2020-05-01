package datastructure.linkedlist;

public class Node<E> {

    // 实例数据
    public E e;

    // 指向下一个节点
    public Node next;

    /**
     * 构造函数 1
     *
     * @param e
     * @param next
     */
    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }

    /**
     * 构造函数 2
     *
     * @param e
     */
    public Node(E e) {
        this(e, null);
    }

    /**
     * 无参构造函数
     */
    public Node() {
        this(null, null);
    }

    /**
     * toString()
     *
     * @return
     */
    public String toString() {
        return e.toString();
    }
}
