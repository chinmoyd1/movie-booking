package com.varNcremenet.authenticateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class AuthenticateServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AuthenticateServiceApplication.class, args);
		//243 564
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(3);

		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		Solution s = new Solution();

		ListNode head = s.addTwoNumbers(head1, head2);
		while(head!=null){
			System.out.println("-->"+head.val);
			head = head.next;
		}
	}
}

	class ListNode {
	 	int val;
	 	ListNode next;
	 	ListNode(int x) { val = x; }
	 }

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			System.out.println("addTwoNombers called...");
			l1 = reverseLinkedList(l1);
			l2 = reverseLinkedList(l2);



			int l1Int = converToInt(l1);
			int l2Int = converToInt(l2);

			int sum = l1Int + l2Int;

			System.out.println("SUM-->"+sum);
			ListNode head = null;
			ListNode current = null;

			while(sum > 0){
				int digit = sum % 10;
				if(head == null){
					head  = new ListNode(digit);
					current = head;
				}else{
					current.next = new ListNode(digit);
					current = current.next;
				}
				System.out.println(current.val);
				sum /= 10;
			}

			//head = reverseLinkedList(head);
			return head;

		}
		public int converToInt(ListNode head){
			String number = "";
			while(head!=null){
				number += String.valueOf(head.val);
				head = head.next;
			}
			System.out.println("number->"+number);
			return Integer.valueOf(number);
		}
		public ListNode reverseLinkedList(ListNode l){
			System.out.println("Reversing linked list...");
			ListNode current = l;
			ListNode prev = null;
			ListNode next = null;

			while(current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			l = prev;
			return l;
		}
	}
