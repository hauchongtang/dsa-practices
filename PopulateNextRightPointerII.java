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
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = search(root.next);
        }
        else if (root.left != null) root.left.next = search(root.next);
        else if (root.right != null) root.right.next = search(root.next);
        dfs(root.right);
        dfs(root.left);
    }

    Node search(Node root) {
        if (root == null) return null;
        else if (root.left != null) return root.left;
        else if (root.right != null) return root.right;
        return search(root.next);
    }
}
