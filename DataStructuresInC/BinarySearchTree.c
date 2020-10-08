#include <stdio.h>
#include <stdlib.h>
typedef struct Node
{
    int item;
    struct Node *left;
    struct Node *right;
} TreeNode;
TreeNode *root = NULL;
void preOrder();
TreeNode *addRecursive(TreeNode *node, int data);
TreeNode *addIterative(TreeNode *node, int data);
int removeRoot(TreeNode *node);
int getMax(TreeNode *node);
int getMin(TreeNode *node);

int main()
{
    root = addRecursive(root, 0);
    addRecursive(root, 1);
    addRecursive(root, 2);
    int value = removeRoot(root);
    preOrder(root);

    return -1;
}
TreeNode *addRecursive(TreeNode *node, int data)
{
    //if the tree ie empty
    if (node == NULL)
    {
        TreeNode *newNode = (TreeNode *)malloc(sizeof(TreeNode));
        newNode->item = data;
        node = newNode;
    }
    //if the data is greater than the parent node value
    else if (node->item > data)
        node->left = addRecursive(node->left, data);
    //if the data is less or equal to the parent node value
    else
        node->right = addRecursive(node->right, data);
    return node;
}
TreeNode *addIterative(TreeNode *node, int data)
{
    TreeNode *newNode = (TreeNode *)malloc(sizeof(TreeNode));
    newNode->item = data;
    node = newNode;
    TreeNode *temp = node;
    TreeNode *curr = NULL;
    while (temp != NULL)
    {
        curr = temp;
        if (data > temp->item)
            temp = temp->left;
        else
            temp = temp->right;
    }
    if (node == NULL)
        temp = newNode;
    else if (data < node->item)
        node->left = newNode;
    else if (data > node->item)
        node->right = newNode;
    return temp;
}
int getMin(TreeNode *node)
{
    int value = 100000;
    TreeNode *temp = node;
    if (node == NULL)
        return value;
    else if (node->left == NULL)
    {
        return node->item;
    }
    else
    {
        while (temp != NULL)
        {
            value = temp->item;
            temp = temp->left;
        }
    }
    return value;
}

int getMax(TreeNode *node)
{
    int value = -1;
    TreeNode *temp = node;
    if (node == NULL)
        return value;
    else if (node->right == NULL)
    {
        return node->item;
    }
    else
    {
        while (temp != NULL)
        {
            value = temp->item;
            temp = temp->right;
        }
    }
    return value;
}

int removeRoot(TreeNode *node)
{
    TreeNode *temp = root;
    if (node == NULL)
        return -1;

    int value = node->item;

    if (node->left == NULL)
        root = (node->right != NULL) ? node->right : NULL;

    if (node->right == NULL)
        root = (node->left != NULL) ? node->left : NULL;

    if (node->left == NULL && node->right == NULL)
        root = NULL;

    else if (node->left != NULL)
    {
        if (root->left->right != NULL)
        {
            temp = temp->left;
            temp->right->right = root->right;
        }
        else
        {
            temp = temp->left;
            temp->right = root->right;
        }
        root = temp;
    }

    return value;
}

void preOrder(TreeNode *node)
{
    if (node == NULL)
        return;
    else
    {
        printf("%d\n", node->item);
        preOrder(node->left);
        preOrder(node->right);
    }
}