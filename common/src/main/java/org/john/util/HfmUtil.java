package org.john.util;

import java.util.ArrayList;
import java.util.List;

public class HfmUtil {

    public static void test() {
        List<BinaryTree> list = new ArrayList<>();
        for (long i = 1; i < 20L; i += 2) {
            list.add(new BinaryTree(i));
        }
        BinaryTree binaryTree = buildTree(list);

        System.out.println("wancheng");
    }

    public static BinaryTree buildTree(List<BinaryTree> list) {
        BinaryTree root = null;
        while (list.size() > 1) {
            BinaryTree left = list.get(0);
            BinaryTree right = list.get(1);
            root = new BinaryTree(left.getValue() + right.getValue());
            root.setLeftChild(left);
            root.setRightChild(right);
            list.remove(left);
            list.remove(right);

            for (int i = list.size() - 1; i >= 0; i--) {
                if (root.getValue() > list.get(i).getValue()) {
                    if (i == list.size() - 1) {
                        list.add(root);
                    } else {
                        list.set(i + 1, root);
                        break;
                    }
                } else {
                    if (i == list.size() - 1) {
                        list.add(list.getLast());
                    } else {
                        list.set(i + 1, list.get(i));
                        if (i == 0) {
                            list.set(0, root);
                        }
                    }
                }
            }
        }
        return root;
    }
}
