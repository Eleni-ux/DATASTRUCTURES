class LinkdList:
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

    def __init__(self, head):
        self.head = None

    # adding at the front of the list

    def insert(self, data):
        newNode = self.Node(data)
        if self.head == None:
            self.head = newNode
            self.head = None
        newNode.next = self.head
        self.head = newNode

    def printList(self):
        temp = self.head
        while temp != None:
            print(temp.data)
            temp = temp.next


m = LinkdList(None)
m. insert(1)
m. insert(2)
m. insert(3)
m.printList()
