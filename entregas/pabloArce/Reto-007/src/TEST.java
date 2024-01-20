import utils.Tree;

public class TEST {
    public static void main(String[] args){
        Tree<String> tree = new Tree<String>("Root");

        tree.addChildByParentIndex("Child1", 0);
        tree.addChildByParentIndex("Child2", 0);
        tree.addChildByParentIndex("Child3", 0);
        tree.addChildByParentData("Child4", "Child3");
        tree.addChildByParentData("Child5", "Child3");
        tree.addChildByParentData("Child6", "Child5");
        tree.addChildByParentData("Child7", "Child6");


        tree.printTree(true);
    }
}
