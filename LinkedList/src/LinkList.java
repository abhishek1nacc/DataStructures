
public class LinkList {

	static class Node {
		int data;
		Node next;

		public Node(int x) {
			this.data = x;
		}
	}

	Node head;

	void addNode(Node node) {
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	void deleteNode(int key) {
		if (head.data == key) {
			head = head.next;
		} else {
			Node temp = head;
			Node prev = head;
			boolean isFound = false;
			while (temp != null) {
				if (temp.data == key) {
					isFound = true;
					break;
				}
				prev = temp;
				temp = temp.next;
			}
			if (isFound) {
				prev.next = temp.next;
			}
		}
	}

	void traverseLL() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "--->");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LinkList mLinkList = new LinkList();
		mLinkList.addNode(new Node(10));
		mLinkList.addNode(new Node(20));
		mLinkList.addNode(new Node(30));
		mLinkList.addNode(new Node(40));
		mLinkList.addNode(new Node(50));
		mLinkList.addNode(new Node(60));

		mLinkList.traverseLL();

		System.out.println();
		mLinkList.deleteNode(40);
		mLinkList.traverseLL();

		System.out.println();
		mLinkList.deleteNode(20);
		mLinkList.traverseLL();

		System.out.println();
		mLinkList.deleteNode(60);
		mLinkList.traverseLL();
	}
}
