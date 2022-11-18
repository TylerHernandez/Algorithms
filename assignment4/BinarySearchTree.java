public class BinarySearchTree {

    public static int comparisons = 0;

    // Holds pointer to the root of the tree.
    TreeNode root;
    public BinarySearchTree() {
        this.root = null; // initialize with null value.
    }

    // Checks if BinarySearchTree has a root node, calls real insert method.
    public void insert(TreeNode treeNode) {
        System.out.print("[");
        // pretty cool; because the function is head recursive this will give us back our original root.
        this.root = recursiveInsert(this.root, treeNode);
    }

    // Uses recursion to check where treeNode should be inserted into.
    public TreeNode recursiveInsert(TreeNode currentRoot, TreeNode desiredInsertNode) {

        // Once we reach this statement, we can insert our desiredInsertNode into this slot
        // and unravel the recursion.
        if (currentRoot == null) {
            currentRoot = desiredInsertNode;
            System.out.println("]");
            return desiredInsertNode;
        }

        // Determine if we should move left or right, down our tree.
        if (currentRoot.value.compareTo(desiredInsertNode.value) < 0) {
            System.out.print("R, "); // We will be going to the right of our currentRoot.
            currentRoot.right = recursiveInsert(currentRoot.right, desiredInsertNode);
        } else if (currentRoot.value.compareTo(desiredInsertNode.value) > 0) {
            System.out.print("L, "); // We will be going to the left of our currentRoot.
            currentRoot.left = recursiveInsert(currentRoot.left, desiredInsertNode);
        }

        return currentRoot;

    }


    // Recursively performs in-order traversal of tree(alphabetical).
    public void traverseInOrder(TreeNode currentRoot) {
        if (currentRoot != null) {
            // Declare left of current root as the new root to look at.
            traverseInOrder(currentRoot.left); 
            System.out.println(currentRoot.value);
            // Declare right of current root as the new root to look at.
            traverseInOrder(currentRoot.right);
        }
    }

    // User's lookup function to return how many iterations of 
    public int lookup(String desiredNodeValue) {
        comparisons = 0;
        System.out.print("[");
        this.find(this.root, desiredNodeValue);
        System.out.print("] ");
        return comparisons;

    }


    // Actual searching function to find a desired tree node.
    private TreeNode find(TreeNode currentRoot, String desiredNodeValue) {
        comparisons++;
        // We've either found our TreeNode, or it does not exist.
        if ( currentRoot == null || currentRoot.value.equals(desiredNodeValue)){
            return currentRoot;
        }
 
        // Desired tree node is greater than(to the right) of current root.
        if ( currentRoot.value.compareTo(desiredNodeValue) < 0 ) {
            System.out.print("R, ");
            return find(currentRoot.right, desiredNodeValue);
        }
 
        // otherwise, desired tree node is less than(to the left) of current root.
        else {
            System.out.print("L, ");
            return find(currentRoot.left, desiredNodeValue);
        }


  }

}