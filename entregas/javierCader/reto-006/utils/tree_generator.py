import random
from typing import List, Optional, Any
from data_structures.tree import Tree
from data_structures.node import Node

class RandomTreeGenerator:
    def __init__(self, max_size: int, max_children: Optional[int] = None, max_depth: Optional[int] = None, values: Optional[List[Any]] = None):
        self.max_size = max_size
        self.max_children = max_children if max_children is not None else max_size
        self.max_depth = max_depth
        self.values = values if values is not None else [chr(i) for i in range(65, 91)] 

    def generate(self) -> Tree:
        random.shuffle(self.values)
        tree_size = random.randint(1, self.max_size)

        root = Node(self.values[0])
        tree = Tree(root)
        
        def add_random_child(node: Node, depth: int, remaining_values: List[str]) -> None:
            if remaining_values and node and (self.max_depth is None or depth < self.max_depth):
                while remaining_values and len(node.children) < self.max_children:
                    new_child = Node(remaining_values.pop())
                    node.add_child(new_child)
                    if random.choice([True, False]):
                        add_random_child(new_child, depth + 1, remaining_values)

        remaining_values = self.values[1:tree_size]  
        add_random_child(root, 1, remaining_values)

        return tree
