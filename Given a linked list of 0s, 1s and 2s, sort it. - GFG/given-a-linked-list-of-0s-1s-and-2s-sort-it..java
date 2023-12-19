//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        
        Node zero=new Node(-1);
        Node one=new Node(-1);
        Node two=new Node(-1);
        
        Node zerohead=zero;
        Node onehead=one;
        Node twohead=two;
        
        Node temp=head;
        
        while(temp!=null){
            
            if(temp.data==0){
                zerohead.next=temp;
                zerohead=zerohead.next;
            }
            else if(temp.data==1){
                onehead.next=temp;
                onehead=onehead.next;
            }
            else{
                twohead.next=temp;
                twohead=twohead.next;
            }
            
            temp=temp.next;
        }
        
        if(zero.next==null){
            if(one.next==null){
                if(two.next==null){
                    return null;
                }
                else{
                    twohead.next=null;
                    return two.next;
                }
            }
            else{
                if(two.next!=null){
                    onehead.next=two.next;
                    twohead.next=null;
                    return one.next;
                }
                else{
                    onehead.next=null;
                    return one.next;
                }
            }
        }
        else{
            if(one.next==null){
                if(two.next==null){
                    zerohead.next=null;
                    return zero.next;
                }
                else{
                    zerohead.next=two.next;
                    twohead.next=null;
                    return zero.next;
                }
            }
            else{
                if(two.next==null){
                    zerohead.next=one.next;
                    onehead.next=null;
                    return zero.next;
                }else{
                    zerohead.next=one.next;
                    onehead.next=two.next;
                    twohead.next=null;
                    return zero.next;
                }
            }
        }
        
        
    }
}


