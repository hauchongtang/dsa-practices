class Node {
    int val;
    Node left;
    Node right;
    Node next;
    
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    public void dfs(Node root) {
        if (root == null) return;
        if (root.right != null) root.left.next = root.right;
        if (root.next != null && root.next.left != null) root.right.next = root.next.left;
        dfs(root.left);
        dfs(root.right);
    }
}
