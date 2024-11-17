<h1 style="text-align: center;">Java_AVL_Tree</h1>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="48" height="48" />

This is an Java code of AVL tree. 

<h1 style="text-align: center;">What is an AVL TREE ?</h1><a name="modulo2"></a>

If you don't know what is a tree: [what is a tree ?](#modulo1) 

An AVL tree is a type of tree that uses a method of storing values to speed up the search for values.

*Note: AVL = named after inventors Adelson-Velsky and Landis*

e.g.

Lets suposse, that we want to insert in a Tree, the folowing numbers and in the order that they are below:

5 -> 4 -> 3 -> 2 -> 1.

If you add those numbers, in a Binary Search Tree(BST), you will have the following representation:


![image](https://github.com/user-attachments/assets/2202d2c4-88cf-4492-97e6-d8ff0969bcae)


But, if you add the same sequence of numbers, in an AVL-Tree, you will have this representation:

![image](https://github.com/user-attachments/assets/e7743324-fe76-4b1a-b064-ee67ed9f4833)


If you caculate, for each tree, how much time it takes to store, the following sequence. You will see that to insert them in an BST, it will take much lees time than in an AVL-Tree(since an AVL-Tree, has a more complex insert method). 
Neverthless, if you cauculate the time to find an specific value. You will see that sometimes, to do it in an AVL-Tree, it will be faster than to do it in a BST.

e.g., Looking for the number <span style="color: orange;">1</span>

In the BST, you will go through the following numbers:

- 5
- 4
- 3
- 2
- <span style="color: orange;">1</span>

But, if you do it in an AVL-Tree, you will go through in less numbers:

- 4
- 2
- <span style="color: orange;">1</span>

Obsviusly, in this example, the time is almost the same. But, imagine if you had a tree with 100 numbers, and you insert each number in-order(1,2,3,4...100). If you were asked to get the number
100 in a BST you would need to go trough all the numbers in the tree. But in an avl tree you would need to go through many fewer numbers, to find the number 100.

*for more information*

* how an AVL-Tree works: https://www.geeksforgeeks.org/introduction-to-avl-tree/

<h1 style="text-align: center;">AVL TREE CODE</h1>

In this AVL-Tree, thou can do the following actions:

 - Insert and remove values in a balanced way
 - Find an specific value
 - Walk and show the values in 3 different types: pre-order, in-order and post-order.

<h1 style="text-align: center;">What is a Tree ?</h1> <a name="modulo1"></a> 

Theres is many ways to store data in programming(e.g., Arrays, linked lists, stacks...). And one of them, is Tree. The main purpose of Tree or a Binary Search Tree(BST) is to store data, in a way that is fast to find them(*a simptom from the logic of produce more and faster*)


In a Tree, you have the root — which is the first and constant value. And, always when you need to walk trough the Tree(e.i., to insert a value), you pass on the root.

e.g., 

Lets say, we want to insert in this sequence:

5 -> 2 -> 7

- In this case, we will insert 5 and nominate him as the root
- We will see if number 2 is smaller than number 5, and if it is, it will go to the left of 5. But if it is bigger, it will go to the right.
- After put 2, on the left of number 5, we will apply the same logic for the insertion of 7.


So, in the end, the representation will by like this:

![image](https://github.com/user-attachments/assets/e30ffa5f-e7ef-4a1c-b96b-d485319d3f21)


But, the problem with BTS is it depends on the order that the data is inserted, to work well.

e.g.,

Inserting this sequence:

10 -> 9 -> 8 -> 7 -> 6 -> 5.

The representation will be like this:

![image](https://github.com/user-attachments/assets/f922ff63-47c3-49c7-ba50-63f83d2ba97a)

And, the problem with it, is that if we would need to look for number 5, we would need to go through all the numbers, to find him. Thereby, The Tree(BST) would ends up being a an ArrayList.

So, to tackle that problem. It was created the AVL TREE: [What is an AVL TREE ?](#modulo2)


