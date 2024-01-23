package utils;

public class Tree<T extends TreeObject> implements IDataStructure<T>{
    private TreeNode<T> root;
    public Tree(T rootData) {
        root = new TreeNode<T>();
        root.setData(rootData);
    }
    public TreeNode<T> getRoot(){
        return root;
    }

    public void addChildByParentIndex(T data, int parentNumber) {
        addChildByParentIndex(root, data, parentNumber, 0);
    }

    private void addChildByParentIndex(TreeNode<T> currentNode, T data, int parentNumber, int currentCount) {
        if (currentCount == parentNumber) {
            currentNode.addChild(data);
        } else if (currentNode.getChildren() != null) {
            for (TreeNode<T> child : currentNode.getChildren()) {
                addChildByParentIndex(child, data, parentNumber, currentCount + 1);
            }
        }
    }

    private TreeNode<T> findNodeByData(TreeNode<T> currentNode, String d1) {
        if (currentNode.getData().toString().equals(d1)) {
            return currentNode;
        }

        if (currentNode.getChildren() != null) {
            for (TreeNode<T> child : currentNode.getChildren()) {
                TreeNode<T> foundNode = findNodeByData(child, d1);
                if (foundNode != null) {
                    return foundNode;
                }
            }
        }

        return null;
    }

    public void addChildByParentData(T data, String d1) {
        TreeNode<T> parentNode = findNodeByData(root, d1);
        if (parentNode != null) {
            parentNode.addChild(data);
        } else {
            System.out.println("Error: No se encontró el nodo padre con los datos especificados.");
        }
    }

    public void addFoodByParentsData(T data, String d1, String d2) {
        TreeNode<T> parentNode = findNodeByData(root, d1);

        if (parentNode != null) {
            TreeNode<T> intakeNode = findNodeByData(parentNode, d2);

            if (intakeNode != null) {
                intakeNode.addChild(data);
            } else {
                System.out.println("Error: No se encontró el nodo Intake con los datos especificados.");
            }
        } else {
            System.out.println("Error: No se encontró el nodo Day con los datos especificados.");
        }
    }

    public void deleteFoodByData(String d1, String d2, String food) {
        TreeNode<T> parentNode = findNodeByData(root, d1);

        if (parentNode != null) {
            TreeNode<T> intakeNode = findNodeByData(parentNode, d2);

            if (intakeNode != null) {
                TreeNode<T> foodNode = findNodeByData(intakeNode, food);
                if (foodNode != null) {
                    intakeNode.deleteChild(foodNode.getData());
                } else {
                    System.out.println("Error: No se encontró el nodo Food con los datos especificados.");
                }
            } else {
                System.out.println("Error: No se encontró el nodo Intake con los datos especificados.");
            }
        } else {
            System.out.println("Error: No se encontró el nodo Day con los datos especificados.");
        }
    }

    public TreeNode<T> getTreeNodeByData(String d1) {
        TreeNode<T> parentNode = findNodeByData(root, d1);
        return parentNode;
    }
    public TreeNode<T> getTreeNodeByTwoData(String d1, String d2) {
        TreeNode<T> parentNode = findNodeByData(root, d1);

        if (parentNode != null) {
            return findNodeByData(parentNode, d2);
        } else {
            System.out.println("Error: No se encontró el nodo Day con los datos especificados.");
            return null;
        }
    }

    public void addChildToTreeNode(T data, TreeNode<T> parent){
        parent.addChild(data);
    }

    public void printTree(boolean order){
        if (order) printTreePreOrder();
        else printTreePostOrder();
   }

    public void printTreePreOrder() {
        printTreePreOrder(root, 0);
    }

    private void printTreePreOrder(TreeNode<T> node, int depth) {
        if (node != null) {
            for (int i = 0; i < depth; i++) {
                if (i == depth - 1) {
                    System.out.print(" ".repeat(4) + "└─--");
                } else {
                    System.out.print(" ".repeat(4));
                }
            }
            System.out.println(node.getData().getDetails());

            if (node.getChildren() != null) {
                for (TreeNode<T> child : node.getChildren()) {
                    printTreePreOrder(child, depth + 1);
                }
            }
        }
    }

    public void printTreePostOrder() {
        printTreePostOrder(root, 0);
    }

    private void printTreePostOrder(TreeNode<T> node, int depth) {
        if (node != null) {
            if (node.getChildren() != null) {
                for (TreeNode<T> child : node.getChildren()) {
                    printTreePostOrder(child, depth + 1);
                }
            }

            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println(node.getData().getDetails());
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] listData() {
        return new Object[0];
    }
}
