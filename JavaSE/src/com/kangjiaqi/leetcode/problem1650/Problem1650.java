package com.kangjiaqi.leetcode.problem1650;

import java.util.HashSet;
import java.util.Set;

public class Problem1650 {
    Set<Integer> exits = new HashSet<>();

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        n1.left = n2;
        n1.right = n3;
        n3.parent = n1;
        n2.parent = n1;

        Problem1650 p = new Problem1650();
        Node n = p.lowestCommonAncestor(n2, n3);
        System.out.println(n.val);
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        Node curNode = p;
        while(curNode != null){
            exits.add(curNode.val);
            curNode = curNode.parent;
        }
        curNode = q;
        while(curNode != null){
            if(exits.contains(curNode.val)){
                return curNode;
            }
            curNode = curNode.parent;
        }
        return null;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
    public Node(int val) {
        this.val = val;
    }
}

