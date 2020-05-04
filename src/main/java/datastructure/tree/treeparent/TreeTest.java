package datastructure.tree.treeparent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {

        // 按照以下定义，生成树
        List<String> datas = new ArrayList<>(Arrays.asList("Bob", "Tom", "Jerry", "Rose", "Jack"));
        List<Integer> parents = new ArrayList<>(Arrays.asList(0, 0, 1, 2));

        TreeParent<String> tree = new TreeParent<>();
        tree.createTree(datas, parents);
        Node<String> root = tree.root();
        // root的第一个孩子
        List<Node<String>> childrenOfRoot = tree.childrenFromNode(root);
        System.out.println(childrenOfRoot);
        Node<String> aChild = tree.childrenFromNode(root).get(0);
        System.out.println(aChild.getData() + "的父结点是" + tree.parentTo(aChild).getData());
        System.out.println("根结点的孩子" + tree.childrenFromNode(root));
        System.out.println("该树深度为" + tree.depth());
        System.out.println("该树的度为" + tree.degreeForTree());
        System.out.println("该树的结点数为" + tree.nodesNum());
        System.out.println(tree);
    }
}
