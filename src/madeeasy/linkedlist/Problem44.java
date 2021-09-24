package madeeasy.linkedlist;

import java.util.Scanner;

public class Problem44 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0){
			int n = in.nextInt();
			int m = in.nextInt();
			getJosephusPosition(n, m);
		}
	}

	public static void getJosephusPosition(int n, int m) {
		ListNode<Integer> p, q;
		p = new ListNode<>(1);
		q = p;
		for(int i=2; i<=n; i++) {
			p.next = new ListNode<>(i);
			p = p.next;
		}
		p.next = q;

		while(q.next != q) {
			for(int j=1; j<m; j++) {
				p = q;
				q = q.next;
			}
			q = q.next;
			p.next = q;
		}
		System.out.println(q);
	}
}