public class Tree {

 private Node<T> root = null;

 public Node<T> getRoot() {
  return root;
 }

 public void printInOrder(Node<T> node){
  if (node == null) {
   return;
  }
  printInOrder(node.getLeft());
  System.out.println(node.printData());
  printInOrder(node.getRight())
 }

 public void insert(Node<T> newNode, int index) {
  this.root = recursiveInsert(root, newNode, index);
 }

 private Node<T> recursiveInsert(Node<T> node, Node<T> newNode, int index) {
  if (node == null) {
   node = newNode;
   return node;
  }
  if (index < node.getIndex()) {
   node.setLeft(recursiveInsert(node.getLeft(), newNode, index));
  } else if (index > node.getIndex()) {
   node.setRight(recursiveInsert(node.getRight(), newNode, index))
  }
  return node;
 }
}
