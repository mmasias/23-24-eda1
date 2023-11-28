from typing import Any, Optional, List, Tuple
from data_structures.node import Node
from data_structures.tree import Tree

class TreeDrawer:
    def __init__(self):
        pass

    def draw_tree(self, tree: Tree) -> None:
        if tree.root is not None:
            tree_lines, _, _, _ = self._display_aux(tree.root)
            for line in tree_lines:
                print(line)

    def _display_aux(self, node: Node) -> Tuple[List[str], int, int, int]:
        if not node.children:
            node_line = f"[{node.data}]"
            line_width = len(node_line)
            line_height = 1
            line_middle = line_width // 2
            return [node_line], line_width, line_height, line_middle

        if len(node.children) == 1:
            child_lines, child_width, child_height, child_middle = self._display_aux(node.children[0])
            node_representation = f"[{node.data}]"
            node_width = len(node_representation)
            first_line = (child_middle + 1) * ' ' + (child_width - child_middle - 1) * '_' + node_representation
            second_line = child_middle * ' ' + '/' + (child_width - child_middle - 1 + node_width) * ' '
            shifted_lines = [line + node_width * ' ' for line in child_lines]
            return [first_line, second_line] + shifted_lines, child_width + node_width, child_height + 2, child_width + node_width // 2
          
        left_lines, left_width, left_height, left_middle = self._display_aux(node.children[0])
        right_lines, right_width, right_height, right_middle = self._display_aux(node.children[1])
        node_representation = f"[{node.data}]"
        node_width = len(node_representation)
        first_line = (left_middle + 1) * ' ' + (left_width - left_middle - 1) * '_' + node_representation + right_middle * '_' + (right_width - right_middle) * ' '
        second_line = left_middle * ' ' + '/' + (left_width - left_middle - 1 + node_width + right_middle) * ' ' + '\\' + (right_width - right_middle - 1) * ' '
        if left_height < right_height:
            left_lines += [left_width * ' '] * (right_height - left_height)
        elif right_height < left_height:
            right_lines += [right_width * ' '] * (left_height - right_height)
        combined_lines = zip(left_lines, right_lines)
        tree_lines = [first_line, second_line] + [left + node_width * ' ' + right for left, right in combined_lines]
        return tree_lines, left_width + right_width + node_width, max(left_height, right_height) + 2, left_width + node_width // 2