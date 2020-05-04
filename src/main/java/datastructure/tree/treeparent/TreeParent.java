package datastructure.tree.treeparent;

import java.util.ArrayList;
import java.util.List;

public class TreeParent<Item> {

    // 树的容量，能容纳的最大结点数
    private int treeCapacity;
    // 树的结点数目
    private int nodesNum;
    // 存放树的所有结点
    private Node<Item>[] nodes;

    // 以指定树大小初始化树
    public TreeParent(int treeCapacity) {
        this.treeCapacity = treeCapacity;
        nodes = new Node[treeCapacity];
    }

    // 以默认树的大小初始化树
    public TreeParent() {
        treeCapacity = 128;
        nodes = new Node[treeCapacity];
    }

    /**
     * 设置根节点
     *
     * @param data
     */
    public void setRoot(Item data) {
        // 跟结点
        nodes[0] = new Node<>(data, -1);
        nodesNum++;
    }

    /**
     * 添加孩子节点
     *
     * @param data
     * @param parent
     */
    public void addChild(Item data, Node<Item> parent) {
        if (nodesNum < treeCapacity) {
            // 新的结点放入数组中第一个空闲位置
            nodes[nodesNum] = new Node<>(data, index(parent));
            nodesNum++;
        } else {
            throw new RuntimeException("树已满，无法再添加结点！");
        }
    }

    // 用nodeNum是因为其中无null，用treeCapacity里面很多null值根本无需比较
    private int index(Node<Item> parent) {
        for (int i = 0; i < nodesNum; i++) {
            if (nodes[i].equals(parent)) {
                return i;
            }
        }
        throw new RuntimeException("无此结点");
    }

    /**
     * 创建一棵树
     *
     * @param datas   数据集合
     * @param parents 父节点集合
     */
    public void createTree(List<Item> datas, List<Integer> parents) {
        if (datas.size() > treeCapacity) {
            throw new RuntimeException("数据过多，超出树的容量！");
        }
        setRoot(datas.get(0));
        for (int i = 1; i < datas.size(); i++) {
            addChild(datas.get(i), nodes[parents.get(i - 1)]);
        }
    }

    public boolean isEmpty() {
        return nodesNum == 0;
    }

    /**
     * 寻找节点的父节点
     *
     * @param node
     * @return
     */
    public Node<Item> parentTo(Node<Item> node) {
        return nodes[node.parent];
    }

    /**
     * 寻找节点的孩子节点
     *
     * @param parent
     * @return
     */
    public List<Node<Item>> childrenFromNode(Node<Item> parent) {
        List<Node<Item>> children = new ArrayList<>();
        for (int i = 0; i < nodesNum; i++) {
            if (nodes[i].parent == index(parent)) {
                children.add(nodes[i]);
            }
        }
        return children;
    }

    // 树的度
    public int degreeForTree() {
        int max = 0;
        for (int i = 0; i < nodesNum; i++) {
            if (childrenFromNode(nodes[i]).size() > max) {
                max = childrenFromNode(nodes[i]).size();
            }
        }
        return max;
    }

    // 某一个节点的度
    public int degreeForNode(Node<Item> node) {
        return childrenFromNode(node).size();
    }

    // 树的深度
    public int depth() {
        int max = 0;
        for (int i = 0; i < nodesNum; i++) {
            int currentDepth = 1;
            int parent = nodes[i].parent;
            while (parent != -1) {
                parent = nodes[parent].parent;
                currentDepth++;
            }
            if (currentDepth > max) {
                max = currentDepth;
            }
        }
        return max;
    }

    // 树的结点数
    public int nodesNum() {
        return nodesNum;
    }
    // 返回跟结点
    public Node<Item> root(){
        return nodes[0];
    }
    // 让树为空
    public void clear() {
        for (int i = 0; i < nodesNum; i++) {
            nodes[i] = null;
            nodesNum = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree{\n");
        for (int i = 0; i < nodesNum - 1; i++) {
            sb.append(nodes[i]).append(", \n");
        }
        sb.append(nodes[nodesNum - 1]).append("}");
        return sb.toString();
    }
}
