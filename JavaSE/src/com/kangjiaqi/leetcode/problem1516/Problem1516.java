package com.kangjiaqi.leetcode.problem1516;

import java.util.ArrayList;
import java.util.List;

public class Problem1516 {
    public Node pParent;
    public Node qParent;

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n2.children.add(n5);
        n3.children.add(n6);
        n4.children.add(n7);
        n4.children.add(n8);

        List<Node> ancestors = new ArrayList<>();
        Problem1516 p = new Problem1516();
        Node res = p.moveSubTree(n1, n1, n2);
        System.out.println(res.val);
    }
    public Node moveSubTree(Node root, Node p, Node q) {
        Node feakP  = new Node(-1);
        feakP.children.add(root);
        findParent(feakP, p, q);
        if(pParent == q) return root;
        List<Node> ancestors = new ArrayList<>();
        int tmp = findLCA(root, p, q, ancestors);
        Node lca = ancestors.get(0);
        if(lca == q){
            pParent.children.remove(p);
            q.children.add(p);
        } else if(lca == p){
            qParent.children.remove(q);
            q.children.add(p);
            pParent.children.set(pParent.children.indexOf(p), q);
        }
        else{
            pParent.children.remove(p);
            q.children.add(p);
        }
        return feakP.children.get(0);
    }
    public int findLCA(Node root, Node p, Node q, List<Node> ancestors) {
        if (root == null) return 0;
        int sum = 0;
        if (root == p || root == q) ++sum;
        for (Node child:root.children) {
            sum = sum + findLCA(child, p, q, ancestors);
        }
        if(sum == 2) ancestors.add(root);
        return sum;
    }
    public void findParent(Node root, Node p, Node q){
        if (root.children.size() == 0) return;
        for(Node child:root.children){
            if(child == p) {
                pParent = root;
            }
            if(child == q){
                qParent = root;
            }
        }
        for(Node child:root.children){
            findParent(child, p, q);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};