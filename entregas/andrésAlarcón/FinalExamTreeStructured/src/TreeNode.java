class TreeNode {
  Object data;
  List children;

  public TreeNode(Object data) {
      this.data = data;
      this.children = new List();
  }

  public void addChild(Object childData) {
      TreeNode childNode = new TreeNode(childData);
      children.add(childNode);
  }
}
