public class Tree<T extends DataProvider> {

 private Node<T> root = null;

 public Node<T> getRoot() {
  return root;
 }

 public void printInOrder(Node<T> node) {
  if (node == null) {
   return;
  }
  printInOrder(node.getLeft());
  node.getData().printData();
  printInOrder(node.getRight());
 }

 public T get(int index) {
  return recursiveGet(this.root, index);
 }

 private T recursiveGet(Node<T> root, int index) {
  if (root == null) {
   return null;
  }
  if (root.getIndex() == index) {
   return root.getData();
  }
  if (index < root.getIndex()) {
   return recursiveGet(root.getLeft(), index);
  } else {
   return recursiveGet(root.getRight(), index);
  }
 }

 public boolean has(Node<T> node) {
  return recursiveHas(this.root, node);
 }

 private boolean recursiveHas(Node<T> root, Node<T> node) {

  if (root == null) {
   return false;
  }

  if (root.getIndex() == node.getIndex()) {
   return true;
  }

  boolean leftNode = recursiveHas(root.getLeft(), node);
  boolean rightNode = recursiveHas(root.getRight(), node);

  return leftNode || rightNode;
 }

 public void insert(Node<T> newNode) {
  this.root = recursiveInsert(this.root, newNode);
 }

 private Node<T> recursiveInsert(Node<T> actualNode, Node<T> newNode) {
  if (actualNode == null) {
   actualNode = newNode;
   return actualNode;
  }
  if (newNode.getIndex() < actualNode.getIndex()) {
   actualNode.setLeft(recursiveInsert(actualNode.getLeft(), newNode));
  } else if (newNode.getIndex() > actualNode.getIndex()) {
   actualNode.setRight(recursiveInsert(actualNode.getRight(), newNode));
  }
  return actualNode;
 }
}
