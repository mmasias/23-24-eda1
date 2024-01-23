package utils;

public class TreeNode<T extends TreeObject> {
    private ListNode<T> parent;
    private List<TreeNode<T>> children;

    public TreeNode () {
        this.parent = new ListNode<T>(null);
        this.children = new List<TreeNode<T>>();
    }
    public TreeNode(ListNode<T> parent) {
        this.parent = parent;
        this.children = new List<TreeNode<T>>();
    }
    public void setData(T data) {
        this.parent.setData(data);
    }
    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
    public void addChild(T data){
        ListNode<T> newParent = new ListNode<T>(data);
        TreeNode<T> newChild = new TreeNode<T>(newParent);

        this.children.insert(newChild, -1);
    }
    public T getData() {
        return parent.getData();
    }
    public List<TreeNode<T>> getChildren(){
        return this.children;
    }
    public int childrenSize(){
        return this.children.size();
    }
}
