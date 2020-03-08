
public class Stack {

	int top = -1;
	int arr[];
	int size;

	public Stack(int size) {
		this.size = size;
		this.arr = new int[size];
	}

	void push(int key) {
		if (top == size - 1) {
			System.out.println("Stack Overflow.");
			return;
		}
		arr[++top] = key;
	}

	int pop() {
		if (top == -1) {
			System.out.println("Stack Undeflow.");
			return -1;
		}
		return arr[top--];
	}
	
	void printStack() {
		for (int i = top; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(10);
		stack.push(29);
		stack.push(4);
		stack.push(67);
		stack.push(78);
		stack.push(45);
		stack.push(34);
		
		stack.printStack();
		stack.pop();
		System.out.println("----------");
		stack.printStack();
	}
}
