import java.util.Queue;
import java.util.LinkedList;

class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (!q.isEmpty()) {
                        q.add(null);
                    } else {
                        break;
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            return Math.max(height(root.left), height(root.right)) + 1;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            return count(root.left) + count(root.right) + 1;
        }

        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
        }

        public static int diameter2(Node root) { // O(n^2)
            if (root == null) {
                return 0;
            }
            int leftDia = diameter2(root.left);
            int leftHt = height(root.left);
            int rightDia = diameter2(root.right);
            int rightHt = height(root.right);
            int selfDia = leftHt + rightHt + 1;
            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }

        public static Info diameter(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);
            int diam = Math.max(leftInfo.diam, Math.max(rightInfo.diam, leftInfo.ht + rightInfo.ht + 1));
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, ht);
        }

        public static Node nca(Node root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftNCA = nca(root.left, n1, n2);
            Node rightNCA = nca(root.right, n1, n2);

            if (rightNCA == null) {
                return leftNCA;
            }
            if (leftNCA == null) {
                return rightNCA;
            }
            return root;
        }

        public static int distance(Node root, int n) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }
            int leftDis = distance(root.left, n);
            int rightDis = distance(root.right, n);

            if (leftDis == -1 && rightDis == -1) {
                return -1;
            } else if (leftDis == -1) {
                return rightDis + 1;
            } else {
                return leftDis + 1;
            }
        }

        public static int minDistance(Node root, int n1, int n2) {
            Node lca = nca(root, n1, n2);
            int dist1 = distance(lca, n1);
            int dist2 = distance(lca, n2);

            return dist1 + dist2;
        }
    }

    public int transformToSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int val = root.data;
        int sum = transformToSumTree(root.left);
        sum += transformToSumTree(root.right);
        root.data = sum;
        return sum + val;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.minDistance(root, 4, 6));
    }

}