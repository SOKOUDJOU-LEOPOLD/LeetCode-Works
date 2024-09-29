# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # create list to store nodes
        list_nodes = []
        
        # filling the nodes
        pa = headA
        while pa != None:
            list_nodes.append(pa)
            pa = pa.next
        pa = headB
        while pa != None:
            list_nodes.append(pa)
            pa = pa.next
        
        # find the intersect
        seen = set()
        for i in range(len(list_nodes)):
            if list_nodes[i] not in seen:
                seen.add(list_nodes[i])
            else:
                return list_nodes[i]
        
        return None