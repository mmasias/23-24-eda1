public class BinaryTree<T extends Comparable> implements  IDataStructure<T>{
private     TreeNode<T> root;

    public BinaryTree() {
        this.root=null;
    }
public void insert(T data){
        if (root==null){
            root= new TreeNode<>(data);
        }else {insert(data,root);}

}
public void insert(T data, TreeNode<T> node){
        if (node !=null){
            final int comparison= data.compareTo(node.getData());
            if (comparison<0){
                if (node.getLeftNode() ==null){
                    node.setLeftNode(new TreeNode<>(data));
            }else {
                    insert(data, node.getLeftNode());
                }
        } else if (comparison>0) {
                if (node.getRightNode()==null){
                    node.setRightNode(new TreeNode<>(data));
                }else {
                    insert(data, node.getRightNode());
                }

            }
        }
    }
private TreeNode<T> searchNode(TreeNode<T> node, T data){
        if (node==null){
            return null;
        }else {
            if (node.getData()==data)
                return node;
                final TreeNode<T> inLeft= searchNode(node.getLeftNode(),data);
            if (inLeft!=null )
                return node;
                return searchNode(node.getRightNode(),data);

            }

        }
    public TreeNode<T> search(T data){
        return searchNode(root,data);
    }
public void remove(T data){

}



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] listData() {
        return new Object[0];
    }
}
