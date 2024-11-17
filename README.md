<h1 style="text-align: center;">Java_AVL_Tree</h1>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="48" height="48" />

This is an Java code of AVL tree. 

<h1 style="text-align: center;">What is an AVL TREE ?</h1>

Basically, an AVL tree is a type of tree that uses a method of storing values to speed up the search for values.

e.g.

Lets suposse, that we want to add in a Tree, the folowing numbers and in the order that they are presented:

5 -> 4 -> 3 -> 2 -> 1.

If you add those numbers, in a Binary Search Tree(i.e.,**non** AVL-Tree), you will have the following representation:


![image](https://github.com/user-attachments/assets/2202d2c4-88cf-4492-97e6-d8ff0969bcae)


But, if you add the same sequence of numbers, in an AVL-Tree, you will have this representation:

![image](https://github.com/user-attachments/assets/e7743324-fe76-4b1a-b064-ee67ed9f4833)


If you caculate, for each tree, how much time it takes to store, the following sequence. You will see that to insert them in an Binary Search Tree(BST), it will take much lees time than in an AVL-Tree. 
Neverthless, if you cauculate the time to find an specific value. You will see that sometimes, to do it in an AVL-Tree, it will be faster than to do it in a Binary Search Tree(BST).

e.g., Looking for the number 1

In the BST, you will go through the following numbers:

- 5
- 4
- 3
- 2
- 1

But, if you do it in an AVL-Tree, you will go through in less numbers:

- 4
- 2
- 1

Obsviusly, in this example, the time is almost the same. But, imagine if you had a tree with 100 numbers, and you insert each number in-order(1,2,3,4...100). If you were asked to get the number
100 in a BST you would need to go trough, all the numbers in the tree. But in an avl tree you would need to go through much less numbers, to find the number 100.

<h1 style="text-align: center;">AVL TREE</h1>

In the AVL-Tree, thou can do the following actions:

 - Insert and remove values in a balanced way
 - Find an specific value
 - Walk and show the values in 3 different types: pre-order, in-order and post-order.


