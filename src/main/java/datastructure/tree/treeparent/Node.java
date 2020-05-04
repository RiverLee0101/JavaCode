package datastructure.tree.treeparent;

public class Node<T> {
    private T data;
    public int parent;

    /**
     * 构造函数
     *
     * @param data
     * @param parent
     */
    public Node(T data, int parent){
        this.data = data;
        this.parent = parent;
    }

    /**
     * getData()
     *
     * @return
     */
    public T getData(){
        return data;
    }

    public String toString() {
        return "Node{" +
                "data=" + data +
                ", parent=" + parent +
                '}';
    }
}
