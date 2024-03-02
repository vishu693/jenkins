package com.myaccount;

public class MyLinkedList {
	
	
	Node head;
	
	static class Node
	{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next=null;
		}	
		
		
	}
	
	
	public static MyLinkedList insert(MyLinkedList list,int data)
	{
		
		Node newNode=new Node(data);
		
		
		if(list.head==null)
			list.head=newNode;
		else
		{
			
			Node last=list.head;
			while(last.next!=null)
			{
				last=last.next;
			}
			
			last.next=newNode;
			
		}
		return list;
		
	}
	
	
	public static void print(MyLinkedList list) {
		
		Node currNode=list.head;
		
		while(currNode!=null)
		{
			System.out.println(currNode.data);
			currNode=currNode.next;
		}
		
	}
	//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
	
	public static MyLinkedList delete(MyLinkedList list,int key) {
		
		Node currNode=list.head;
		Node previousNode=null;
		
		
		if(currNode!=null && currNode.data==key)
		{
			list.head=currNode.next;
			System.out.println("Key deleted "+key);
			return list;
		}
		
		
		
		while(currNode!=null)
		{
			
			if(currNode.data==key)
			{
				
				System.out.println("Key deleted "+key);
				return list;
			}
			
			previousNode=currNode;
			currNode=currNode.next;
		}
		
		
		
		return null;
		
	}

}
