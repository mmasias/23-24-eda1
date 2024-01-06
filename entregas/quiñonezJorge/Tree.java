public class Tree<T> {

 private Node<T> root = null;

 public Node<T> getRoot() {
  return root;
 }

 public void printInOrder(Node<T> node) {
  if (node == null) {
   return;
  }
  printInOrder(node.getLeft());
  System.out.println(node.getIndex());
  printInOrder(node.getRight());
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

  boolean leftResult = recursiveHas(root.getLeft(), node);
  boolean rightResult = recursiveHas(root.getRight(), node);

  return leftResult || rightResult;
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
