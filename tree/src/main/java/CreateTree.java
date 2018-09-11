import java.util.Stack;

public class CreateTree {
    Node root;
    int size;
    //tree 所有的树
    Object[] data;

    public class Node {
        private Node left;
        private Node right;
        private Object data;

        public Node(Object data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public CreateTree(Object[] data) {
        this.data = data;
        size = data.length;
        root = create(0);
    }

    public Node create(int index) {
        if (index >= size) {
            return null;
        }
        Node node = new Node(data[index]);
        node.left = create(2 * index + 1);
        node.right = create(2 * index + 2);
        return node;
    }


    /**
     * traversing using recursion
     * @param node
     */
    public void traversingPre(Node node){
        if(node != null){
            System.out.println(node.data);
            traversingPre(node.left);
            traversingPre(node.right);
        }
    }

    public void traversingMiddle(Node node){
        if(node != null){
            traversingMiddle(node.left);
            System.out.println(node.data);
            traversingMiddle(node.right);
        }
    }

    public void traversingBack(Node node){
        if(node != null){
            traversingBack(node.left);
            traversingBack(node.right);
        }
    }

    public void preShow(Node root){
        Stack<Node> stack = new Stack<>();

        Node p = root;
        while(p != null && !stack.isEmpty()){
            while(p != null){
                System.out.println(p.data);
                stack.push(p);
                p = p.left ;
            }
            p = stack.pop();
            p = p.right;
        }
    }

    public void middleShow(Node root){
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null && !stack.empty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            System.out.println(p.data);
            p = p.right ;
        }
    }

    public void noRecPostOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        while (root != null ){
            // push left node to stack
            for(;root.left != null ;root = root.left){
                stack.push(root);
            }
            // if node.right has read or null , sout
            while(root != null&&(root.right == null || root.right == p )){
                System.out.println(root.data);
                p = root;
                if(stack.empty()){
                    return;
                }
                root = stack.pop();
            }
            stack.push(root);
            root = root.right;
        }
    }


    public static void main(String[] args) {
        Object[] objects = new Object[]{'1', '2', '3', '4', '0', '5', '6', '7', '8', '0', '0', '9', 'A'};
        CreateTree tree = new CreateTree(objects);
        System.out.println("前序遍历：");
        tree.traversingPre(tree.root);
        System.out.println("中序遍历：");
        tree.traversingMiddle(tree.root);
        System.out.println("后序遍历：");
        tree.traversingBack(tree.root);
    }
}
