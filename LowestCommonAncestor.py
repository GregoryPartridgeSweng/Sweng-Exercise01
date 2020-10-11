class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


def findLowestCommonAncestor(root, x, y):
       if root is None: return None
       if root.key == x or root.key == y: return root

       LowestCommonAncestorLeft = findLowestCommonAncestor(root.left, x, y)
       LowestCommonAncestorRight = findLowestCommonAncestor(root.right, x, y)

       if LowestCommonAncestorLeft and LowestCommonAncestorRight: return root
       if LowestCommonAncestorLeft is not None: return LowestCommonAncestorLeft
       else: return LowestCommonAncestorRight

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)

print(findLowestCommonAncestor(root, 6, 7).key)
print(findLowestCommonAncestor(root, 1, 7).key)
print(findLowestCommonAncestor(root, 4, 5).key)
print(findLowestCommonAncestor(root, 2, 5).key)