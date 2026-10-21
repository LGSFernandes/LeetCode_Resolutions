class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode | None, l2: ListNode | None) -> ListNode | None:
        dummy_head = ListNode(0)
        atual = dummy_head
        carry = 0
        
        while l1 is not None or l2 is not None or carry > 0:
            val1 = l1.val if l1 is not None else 0
            val2 = l2.val if l2 is not None else 0
            
            soma_total = val1 + val2 + carry
            
            carry = soma_total // 10
            novo_digito = soma_total % 10
            
            atual.next = ListNode(novo_digito)
            atual = atual.next
            
            if l1 is not None: l1 = l1.next
            if l2 is not None: l2 = l2.next
                
        return dummy_head.next


def lista_para_listnode(lista):
    dummy = ListNode(0)
    atual = dummy
    for item in lista:
        atual.next = ListNode(item)
        atual = atual.next
    return dummy.next

def listnode_para_lista(node):
    resultado = []
    while node:
        resultado.append(node.val)
        node = node.next
    return resultado

solution = Solution()

l1 = lista_para_listnode([2, 4, 3])
l2 = lista_para_listnode([5, 6, 4])
resultado1 = solution.addTwoNumbers(l1, l2)
print(listnode_para_lista(resultado1))

l3 = lista_para_listnode([0])
l4 = lista_para_listnode([0])
resultado2 = solution.addTwoNumbers(l3, l4)
print(listnode_para_lista(resultado2))

l5 = lista_para_listnode([9, 9, 9, 9, 9, 9, 9])
l6 = lista_para_listnode([9, 9, 9, 9])
resultado3 = solution.addTwoNumbers(l5, l6)
print(listnode_para_lista(resultado3))
