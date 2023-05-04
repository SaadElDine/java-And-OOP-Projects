package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Saad
 */
public class RedBlackTree implements Tree {

    private Node root;
    private int size;
//
//    public RedBlackTree(int value) {
//        root = new Node(value);
//    }
    public RedBlackTree() {
        this.size = 0;
    }
    
    public int printTreeSize()
    {
        return this.size;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Node getroot() {
        return root;
    }

    @Override
    public void traverse() {
        if (root != null) {
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(Node N) {
        if (N.getLeftChild() != null) {
            inOrderTraversal(N.getLeftChild());//because  Traversal start from left -> root -> right 
        }
        System.out.println(N + " -- ");
        if (N.getRightChild() != null) {
            inOrderTraversal(N.getRightChild());//because  Traversal start from left -> root -> right 
        }
    }

    private void rightRotate(Node N) {
        //System.out.println("Rotating to the right on Node num: " + N);
        Node tempLeftNode = N.getLeftChild();
        N.setLeftChild(tempLeftNode.getRightChild());
        if (N.getLeftChild() != null) {
            N.getLeftChild().setParent(N);
        }
        tempLeftNode.setParent(N.getParent());

        if (tempLeftNode.getParent() == null) {
            root = tempLeftNode;
        } else if (N == N.getParent().getLeftChild()) {
            N.getParent().setLeftChild(tempLeftNode);

        } else {
            N.getParent().setRightChild(tempLeftNode);
        }
        tempLeftNode.setRightChild(N);
        N.setParent(tempLeftNode);

    }

    private void leftRotate(Node N) {
        //System.out.println("Rotating to the left on Node num: " + N);
        Node tempRightNode = N.getRightChild();
        N.setRightChild(tempRightNode.getLeftChild());
        if (N.getRightChild() != null) {
            N.getRightChild().setParent(N);
        }
        tempRightNode.setParent(N.getParent());

        if (tempRightNode.getParent() == null) {
            root = tempRightNode;
        } else if (N == N.getParent().getLeftChild()) {
            N.getParent().setLeftChild(tempRightNode);

        } else {
            N.getParent().setRightChild(tempRightNode);
        }
        tempRightNode.setLeftChild(N);
        N.setParent(tempRightNode);

    }

    @Override
    public void insert(String data) {
        Node node = new Node(data);
        if(this.searchNode(this.getroot(), data) == true)  
            JOptionPane.showMessageDialog(null, "Can't Insert, " + data + " already Exists!");
        this.root = insertIntoTree(this.root, node);
        this.size++;
        fixViaolations(node);
    }

    private void fixViaolations(Node N) {
        Node parentNode = null;
        Node grandParentNode = null;
        while (N != root && N.getColor() != ColorOfTheNode.Black && N.getParent().getColor() == ColorOfTheNode.Red) {
            parentNode = N.getParent();
            grandParentNode = N.getParent().getParent();
            // مش شرط اعرف انا هضيف نود شمال ولا يمين اهم حاجه العم احمر 
            //----------------------------------------------------
            if (parentNode == grandParentNode.getLeftChild()) // it means that the parent node of the node we will insert is a left child of the grand parent
            {
                Node uncle = grandParentNode.getRightChild();
                if (uncle != null && uncle.getColor() == ColorOfTheNode.Red) {
                    grandParentNode.setColor(ColorOfTheNode.Red);
                    parentNode.setColor(ColorOfTheNode.Black);
                    uncle.setColor(ColorOfTheNode.Black); // case 1 uncle red
                    N = grandParentNode;

                } else {// uncle is black so i need to specify if iam left or right node
                    if (N == parentNode.getRightChild()) {
                        leftRotate(parentNode);
                        N = parentNode;
                        parentNode = N.getParent();
                    }
                    rightRotate(grandParentNode);//??????????
                    ColorOfTheNode tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    N = parentNode;
                }
                //-------------------------------
                // this section was for left child of right child 
            } else { // parent is right child 
                // نفس كل حاجه بس اكنك بتضيف من اليمين 
                Node uncle = grandParentNode.getLeftChild();
                if (uncle != null && uncle.getColor() == ColorOfTheNode.Red) {
                    grandParentNode.setColor(ColorOfTheNode.Red);
                    parentNode.setColor(ColorOfTheNode.Black);
                    uncle.setColor(ColorOfTheNode.Black); // case 1 uncle red
                    N = grandParentNode;
                } else {// 
                    if (N == parentNode.getLeftChild()) {
                        rightRotate(parentNode);
                        N = parentNode;
                        parentNode = N.getParent();
                        //// left child of right parent case rl
                    }
                    //
                    leftRotate(grandParentNode);
                    ColorOfTheNode tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());
                    grandParentNode.setColor(tempColor);
                    N = parentNode;
                    //right child of right parent case rr
                }

            }

        }//while
        if (root.getColor() == ColorOfTheNode.Red) {
            root.setColor(ColorOfTheNode.Black);// ROOT IS ALWAAYES BLACK
        }
    }//function

    private Node insertIntoTree(Node root, Node N) {
        if (root == null) {
            return N;
        }
        //N.getValue() < root.getValue()
        if (( (N.getValue()).compareToIgnoreCase(root.getValue()))<0) {
            root.setLeftChild(insertIntoTree(root.getLeftChild(), N));
            root.getLeftChild().setParent(root);
        //N.getValue() > root.getValue()
        //
        } else if ((N.getValue()).compareToIgnoreCase(root.getValue())> 0) {
            root.setRightChild(insertIntoTree(root.getRightChild(), N));
            root.getRightChild().setParent(root);
        }
        
        return root;
    }
    
    public int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.getLeftChild());
            int rDepth = maxDepth(node.getRightChild());
 
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
    
    void printTreeHeight()
    {
        System.out.println("the longest path from the root to a leaf-node is " + maxDepth(root));
    }
    
    public boolean searchNode(Node node, String data)  
    {      
        if(node == null)
        {
            return false;
        }
        
        if ((data.compareToIgnoreCase(node.getValue())) == 0)
        {
            return true;
        }
        else if(data.compareToIgnoreCase(node.getValue()) < 0)
        {
            return searchNode(node.getLeftChild(), data);
        }
        else 
        {
            return searchNode(node.getRightChild(), data);
        }   
    } 
    
        public Node preNode(Node node, String data)
        {
            Node temp = node;
            Node pre = null;
        while(temp != null)
        {
            if(data.compareToIgnoreCase(node.getValue()) < 0)
            {
                pre = temp;
                temp = temp.getLeftChild();
            }
            else
            {
                pre = temp;
                temp = temp.getRightChild();
            }
        }
            return pre;
        }
            
    public Node inOrderpredecessor(Node root, Node n)
    {
 
        // step 1 of the above algorithm
        if (n.getLeftChild() != null) {
            return maxValue(n.getLeftChild());
        }
 
        // step 2 of the above algorithm
        Node p = n.getParent();
        while (p != null && n == p.getLeftChild()) {
            n = p;
            p = p.getParent();
        }
        return p;
    }
        
    Node maxValue(Node node)
    {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }
    public Node inOrderSuccessor(Node root, Node n)
    {
 
        // step 1 of the above algorithm
        if (n.getRightChild() != null) {
            return minValue(n.getRightChild());
        }
 
        // step 2 of the above algorithm
        Node p = n.getParent();
        while (p != null && n == p.getRightChild()) {
            n = p;
            p = p.getParent();
        }
        return p;
    }
 
    /* Given a non-empty binary search
       tree, return the minimum data 
       value found in that tree. Note that
       the entire tree does not need
       to be searched. */
    Node minValue(Node node)
    {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }
}
