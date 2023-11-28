from data_structures.tree import Tree
from utils.tree_generator import RandomTreeGenerator
from utils.tree_drawer import TreeDrawer

if __name__ == "__main__":
    generator: RandomTreeGenerator = RandomTreeGenerator(max_size=26, max_children=3, max_depth=4)
    random_tree: Tree = generator.generate()
    drawer: TreeDrawer = TreeDrawer()
    drawer.draw_tree(random_tree)
