#include <stdio.h>
#include <stdlib.h>
typedef struct Node
{
    char *name;
    struct Node *next;
    struct Node *previous;
} ListNode;
ListNode *head = NULL;
ListNode *tail = NULL;
ListNode *reverse(ListNode *node);
ListNode *addAtEnd(ListNode *node, char *name);
void printValueFromTail(ListNode *start);
void printValueFromHead(ListNode *start);
char *getHead();
char *getTail();
ListNode *addAtFront(ListNode *node, char *name);
int main()
{
    head = (ListNode *)malloc(sizeof(ListNode));
    head->name = "hana";
    head = addAtEnd(head, "james");
    addAtEnd(head, "john");
    addAtEnd(head, "thomas");
    addAtEnd(head, "johana");
    printValueFromHead(head);

    head = reverse(head);
    printValueFromHead(head);
    printf("Head => %s\n", getHead());
    printf("Tail => %s\n", getTail());
    return 0;
}
ListNode *addAtEnd(ListNode *node, char *name)
{
    if (name == NULL)
        node->name = name;
    else
    {
        ListNode *temp = node;
        ListNode *newNode = (ListNode *)malloc(sizeof(ListNode));
        newNode->name = name;

        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = newNode;
        newNode->previous = temp;
        newNode->next = NULL;
        tail = newNode;
    }
    return node;
}
char *getHead()
{
    if (head == NULL)
    {
        printf("%s\n", "The list is empty!");
        return NULL;
    }
    return head->name;
}
char *getTail()
{
    if (tail == NULL)
    {
        printf("%s\n", "The list is empty!");
        return NULL;
    }
    return tail->name;
}
ListNode *addAtFront(ListNode *node, char *name)
{
    if (name == NULL)
        node->name = name;
    else
    {
        ListNode *temp = node;
        ListNode *newNode = (ListNode *)malloc(sizeof(ListNode));
        node = newNode;
        temp->previous = node;
        node->next = temp;
        tail = newNode;
    }
    return node;
}
ListNode *reverse(ListNode *node)
{
    if (node == NULL)
    {
        return node;
    }
    else
    {
        tail = node;
        ListNode *temp = node;
        ListNode *currPrevious = NULL;
        ListNode *currNode = NULL;
        ListNode *currNext = NULL;

        while (temp != NULL)
        {

            currNode = temp;

            currNext = currNode->next;

            currPrevious = currNode->previous;

            currNode->previous = currNext;

            temp = temp->next;

            currNode->next = currPrevious;
        }
        node = currNode;
    }
    return node;
}
void printValueFromHead(ListNode *start)
{

    ListNode *temp = start;
    while (temp != NULL)
    {
        printf("[%s] <=> ", temp->name);

        temp = temp->next;
    }

    printf("\n");
}
void printValueFromTail(ListNode *start)
{

    ListNode *temp = tail;
    while (temp != NULL)
    {
        printf("[%s] <=> ", temp->name);
        temp = temp->previous;
    }

    printf("\n");
}
