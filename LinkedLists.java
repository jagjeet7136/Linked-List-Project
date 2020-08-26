package linkedLists;
import java.util.Scanner;
public class LinkedLists<T> {

	T data;
	LinkedLists<T> next;

	public LinkedLists(T data) {
		this.data = data;
		next=null;
	}

	public static LinkedLists<Integer> input() {       //Input function to add nodes according to user it will terminate when user enters -1

		System.out.print("Enter Elements : ");
		LinkedLists<Integer> head = null;
		LinkedLists<Integer> temp = null;

		Scanner scan= new Scanner(System.in);
		int data = scan.nextInt();

		while(data!=-1) {
			LinkedLists<Integer> node = new LinkedLists<Integer>(data);
			if(head==null) {
				head = node;
				temp = node;
			}

			else {
				temp.next=node;
				temp=node;
			}

			data = scan.nextInt();
		}
		scan.close();
		return head;
	}

	public static void print(LinkedLists<Integer> head) {       //Function for printing the elements of Linked list
		System.out.print("Elements in Linked List : ");
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}

	public static int length(LinkedLists<Integer> head) {
		int length = 0;

		while(head!=null) {
			length++;
			head = head.next;
		}

		return length;
	}

	public static void printIth(LinkedLists<Integer> head, int position) {    // Function for printing element of given index value
		int length=0;
		length=length(head);

		if(length<position || length<=0) {
			System.out.println("Wrong Index Entered");
			return;
		}

		int i = 0;
		while(head!=null) {
			if(position==i) {
				System.out.println("Data at "+position+" "+":"+" "+head.data);
				return;
			}

			i++;
			head = head.next;
		}

		System.out.println();
	}

	public static void index(LinkedLists<Integer> head, int data) {       // Function for printing index of given data element
		int position=0;
		int length=length(head);
		int count=0;
		while(head!=null) {
			if(head.data==data) {
				System.out.println("Index of "+data+" : "+position);
				return;
			}
			count++;
			position++;
			head=head.next;
		}
		if(count==length) {
			System.out.println("No Element Present : "+data);
		}
	}

	public static LinkedLists<Integer> insert(LinkedLists<Integer> head,int data, int position) {   // Function for inserting a node at desired location

		LinkedLists<Integer> node = new LinkedLists<Integer>(data);
		LinkedLists<Integer> temp = head;
		int i=1;

		if(position==0) {

			node.next=head;
			head=node;
			return head;

		}

		while(i<position) {

			temp=temp.next;
			i++;
		}

		node.next=temp.next;
		temp.next=node;

		return head;
	}

	public static LinkedLists<Integer> delete(LinkedLists<Integer> head, int position) {   // Function for deleting a node from desired location

		int i=1;
		LinkedLists<Integer> temp=head;
		int length=0;
		length=length(head);
		if(position==length-1) {
			while(i<position) {
				temp=temp.next;
				i++;
			}
			temp.next=null;
			return head;
		}

		if(position==0) {
			head=head.next;
			return head;
		}

		while(i<position) {
			temp=temp.next;
			i++;
		}

		temp.next=temp.next.next;
		return head;


	}

	public static LinkedLists<Integer> append(LinkedLists<Integer> head, int num) {    // Function appends last nth nodes to beginning of Linked list
		int length=length(head);
		if(num==0 || num==length) {
			return head;
		}
		LinkedLists<Integer> temp=head;
		LinkedLists<Integer> tail=head;
		LinkedLists<Integer> Null=head;
		int i=1;
		while(i<=length-num) {
			head=head.next;
			i++;
		}

		i=1;
		while(i<length) {
			temp=temp.next;
			i++;
		}

		i=1;
		while(i<length-num) {
			Null=Null.next;
			i++;
		}
		Null.next=null;

		temp.next=tail;
		return head;
	}

	public static LinkedLists<Integer> removeDuplicate(LinkedLists<Integer> head) {   // Function for removing consecutive duplicates from given Linked list
		LinkedLists<Integer> first = head;
		LinkedLists<Integer> second = head.next;

		while(second!=null) {
			if(first.data==second.data) {
				first.next=first.next.next;
				second=first.next;
			}
			else {
				first=first.next;
				second=second.next;
			}
		}
		return head;
	}

	public static void reverse(LinkedLists<Integer> head) {  // Function for reversing a given Linked list using recursion

		if(head==null) {
			return;
		}
		reverse(head.next);
		System.out.print(head.data+" ");
	}

	public static void palindrome(LinkedLists<Integer> head) {   // Function to tell whether a given Linked list is palindrome or not
		int length=length(head);
		int i=0;
		int x=length/2;
		int y=0;
		while(i<length/2) {
			LinkedLists<Integer> front = head;
			LinkedLists<Integer> end = head;

			int j=0;
			while(j<(length/2)-x) {
				front=front.next;
				j++;
			}

			int k=1;
			while(k<length-y) {
				end=end.next;
				k++;
			}

			if(front.data!=end.data) {
				System.out.println("isPalindrome : "+false);
				return;
			}

			y++;
			x--;
			i++;
		}

		System.out.println("isPalindrome : "+true);
		return;

	}

	public static void midPoint(LinkedLists<Integer> head) {   // Function to print mid point node of Linked list

		int length=length(head);
		if(length==0) {
			System.out.println("No Midpoint");
			return;
		}
		if(length%2!=0) {
			int i=1;
			while(i<=length/2) {
				head=head.next;
				i++;
			}

			System.out.println("MidPoint is : "+head.data);
		}
		else {
			int i=1;
			while(i<length/2) {
				head=head.next;
				i++;
			}
			System.out.println("MidPoint is : "+head.data);
		}

	}

	public static LinkedLists<Integer> removeOccurences(LinkedLists<Integer> head, int num) {  // Function to delete all occurrences of a element


		if(length(head) == 0) {
			return null;
		}
		int count=0;
		while(head.data == num && head!= null) {
			head = head.next;
			count++;
			if(count>=length(head)) {
				return null;
			}

		}

		LinkedLists<Integer> temp = head;

		while(temp!=null && temp.next!=null) {
			if(temp.next.data == num) {
				temp.next = temp.next.next;
			}
			else {
				temp=temp.next;
			}
		}

		return head;
	}

	public static void isEvenOrOdd(LinkedLists<Integer> head) {  // Function to tell whether the given Linked list contains even or odd number of nodes
		int length=0;

		while(head!=null) {
			length++;
			head=head.next;
		}
		if(length%2==0) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}

	public static void sumEqualsX(LinkedLists<Integer> head1, LinkedLists<Integer> head2, int X) {  // Function to tell how many pairs are there in Linked list whose sum is equal to given number
		int count=0;
		LinkedLists<Integer> temp;

		while(head1!=null) {
			temp=head2;
			while(temp!=null) {
				if( (head1.data+temp.data) == X) {
					count=count+1;
				}
				temp = temp.next;
			}
			head1=head1.next;
		}
		System.out.println(count);
	}

	public static void countOccurences(LinkedLists<Integer> head, int key) {  //Function to count occurrences of a given element

		int count=0;
		while(head!=null) {
			if(head.data==key) {
				count=count+1;
			}
			head=head.next;
		}
		System.out.println(count);
	}

	public static LinkedLists<Integer> deleteALternate(LinkedLists<Integer> head) {  // Function to delete alternate elements
		LinkedLists<Integer> temp = head;

		while(temp!=null && temp.next!=null) {
			temp.next=temp.next.next;
			temp=temp.next;
		}
		return head;
	}

	public static LinkedLists<Integer> reArrange(LinkedLists<Integer> head) {  // Function to arrange the given Linked list to ( L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ... )
		int length=length(head); 
		int i=1;
		int x = length;

		while(i<=length/2) {
			LinkedLists<Integer> front = head;
			LinkedLists<Integer> end = head;
			LinkedLists<Integer> node = head;

			int j=1;
			while(j<=length-x) {
				front = front.next;
				j++;
			}
			j=1;

			while(j<length) {
				end = end.next;
				j++;
			}

			j=1;
			while(j<length-1) {
				node=node.next;
				j++;
			}

			node.next = null;
			end.next = front.next;
			front.next = end;

			i+=1;
			x-=2;

		}

		return head;
	}

	public static LinkedLists<Integer> merge2SortedLL(LinkedLists<Integer> head1, LinkedLists<Integer> head2) {  // Function to Merge two sorted Linked list into a single sorted list
		LinkedLists<Integer> head = null;
		LinkedLists<Integer> temp = head;


		while(head1!=null && head2!=null) {

			if(head1.data < head2.data) {
				if(head==null) {
					LinkedLists<Integer> node = new LinkedLists<Integer>(head1.data);
					head = node;
					temp = head;
					head1 = head1.next;

				}
				else {
					LinkedLists<Integer> node = new LinkedLists<Integer>(head1.data);
					temp.next =node;
					temp = temp.next;
					head1 = head1.next;
				}
			}

			else {
				if(head==null) {
					LinkedLists<Integer> node = new LinkedLists<Integer>(head2.data);
					head = node;
					temp = head;
					head2 = head2.next;
				}

				else {
					LinkedLists<Integer> node = new LinkedLists<Integer>(head2.data);
					temp.next = node;
					temp = temp.next;
					head2= head2.next;
				}
			}
		}

		while(head1!=null) {
			LinkedLists<Integer> node = new LinkedLists<Integer>(head1.data);
			temp.next =node;
			temp = temp.next;
			head1 = head1.next;

		}

		while(head2!=null) {
			LinkedLists<Integer> node = new LinkedLists<Integer>(head2.data);
			temp.next = node;
			temp = temp.next;
			head2= head2.next;
		}

		return head;
	}

	public static LinkedLists<Integer> evenAfterOdd(LinkedLists<Integer> head) {   // Function which arrange all even nodes after all the odd nodes.
		LinkedLists<Integer> even = null;
		LinkedLists<Integer> evenTemp = even;

		if(head==null) {
			return null;
		}

		while(head!=null && head.data%2==0 ) {

			if(even==null) {
				LinkedLists<Integer> node = new LinkedLists<Integer>(head.data);
				even = node;
				evenTemp = node; 
				head = head.next;
			}
			else {
				LinkedLists<Integer> node = new LinkedLists<Integer>(head.data);
				evenTemp.next = node;
				evenTemp = evenTemp.next;
				head = head.next;
			}		
		}

		LinkedLists<Integer> temp = head;
		if(temp==null) {return even;}

		while(temp.next!=null) {
			if((temp.next.data%2)==0) {

				if(even==null) {
					LinkedLists<Integer> node = new LinkedLists<Integer>(temp.next.data);
					even = node;
					evenTemp = node; 
				}
				else {
					LinkedLists<Integer> node = new LinkedLists<Integer>(temp.next.data);
					evenTemp.next = node;
					evenTemp = evenTemp.next;
				}

				temp.next = temp.next.next;
			}

			else {
				temp = temp.next;
			}
		}

		temp.next = even;
		return head;
	}

	public static LinkedLists<Integer> skipMdeleteN(LinkedLists<Integer> head) {  // Function which skips m number of nodes from beginning and delete n number of nodes and so-on.

		int m =2, n=3;
		if(m==0) {
			return null;
		}
		LinkedLists<Integer> temp = head;

		while(temp!=null) {
			int i = 1;
			while(i<m) {
				temp = temp.next;
				i++;
			}

			int j = 1;
			while(j<=n) {
				if(temp==null || temp.next==null) {
					return head;
				}
				temp.next=temp.next.next;
				j++;
			}
			temp=temp.next;
		}

		return head;
	}

	public static LinkedLists<Integer> swap(LinkedLists<Integer> head, int m, int n) {  //Function for swapping 2 given entire nodes
		int small = m<n ? m:n;
		int largest = m>n ? m:n;

		if(head==null ) {
			return null;
		}
		if(m==n || small<0 || largest>=length(head) || length(head)==1) {
			return head;
		}

		LinkedLists<Integer> first = head;
		LinkedLists<Integer> temp = head;

		if(small==0) {
			first = head;
			head = head.next;
		}
		if(small ==1) {
			first = head.next;
			head.next = head.next.next;
		}

		int i=1;
		while(i<small) {
			temp = temp.next;
			if(i==small-1) {
				first = temp.next;
				temp.next = temp.next.next;
			}
			i++;
		}
		head = insert(head, first.data, largest);

		if(small ==0 && largest ==1) {
			return head;
		}


		temp = head;
		LinkedLists<Integer> second = head;
		i =1;
		while(i<largest-1) {
			temp = temp.next;
			if(i==largest-2) {
				second = temp.next;
				temp.next = temp.next.next;
			}
			i++;
		}
		head = insert(head, second.data, small);

		return head;
	}

	public static LinkedLists<Integer> bubbleSort(LinkedLists<Integer> head) {  // Function to implement bubble sort on given Linked list, also this function shifts entire nodes not just the data


		for(int i =0;i<length(head)-1;i++) {
			LinkedLists<Integer> first = head;
			LinkedLists<Integer> second = head.next;
			LinkedLists<Integer> prev = head;
			for(int j=0;j<length(head)-1;j++) {

				if(prev == head && first == head) {
					if(first.data > second.data) {
						LinkedLists<Integer> node = second;
						first.next = first.next.next;
						node.next = first;
						head = node;
						second = first.next;
						prev =head;
					}
					else {
						first = first.next;
						second = second.next;
					}
				}

				else if(first.data > second.data) {
					LinkedLists<Integer> node = second;
					first.next = first.next.next;
					node.next = first;
					prev.next = node;
					second = first.next;
					prev = prev.next;
				}

				else {
					first= first.next;
					second = second.next;
					prev = prev.next;
				}	
			}
		}
		return head;
	}

	public static LinkedLists<Integer> newReversedLL(LinkedLists<Integer> head) {  // Function which accepts a Linked list and returns same linked list in reversal order
		LinkedLists<Integer> root = null;
		LinkedLists<Integer> prev = null;
		int length = length(head);
		int i =1;
		int x = 0;
		while(i<=length) {
			LinkedLists<Integer> temp = head;
			int j = 1;
			while(j< length - x) {
				temp =temp.next;
				j++;
			}
			LinkedLists<Integer> node = new LinkedLists<Integer>(temp.data);
			if(root==null) {
				root = node;
				prev = node;

			}
			else {
				prev.next = node;
				prev = prev.next;
			}
			x++;
			i++;
		}

		return root;
	}

	public static LinkedLists<Integer> duplicates(LinkedLists<Integer> head) {  // Function to remove duplicates at different location in linked list
		LinkedLists<Integer> var = head;

		while(var!=null)  {
			LinkedLists<Integer> prev = var;
			LinkedLists<Integer> temp = var.next;
			while(temp!=null) {
				if(var.data == temp.data) {
					prev.next = prev.next.next;
					temp = prev.next;
				}
				else {
					prev = prev.next;
					temp = temp.next;
				}
			}
			var = var.next;
		}
		return head;
	}

	public static void union(LinkedLists<Integer> head1, LinkedLists<Integer> head2) {  // Function which accepts two linked lists and returns their union
		LinkedLists<Integer> head = null;

		LinkedLists<Integer> temp = head;
		while(head1!=null) {
			LinkedLists<Integer> node = new LinkedLists<Integer>(head1.data);
			if(head==null) {
				head = node;
				temp = head;
			}
			else {
				temp.next = node;
				temp = node;
			}
			head1 = head1.next;
		}

		while(head2!=null) {
			LinkedLists<Integer> node = new LinkedLists<Integer>(head2.data);
			if(head==null) {
				head = node;
				temp = head;
			}
			else {
				temp.next = node;
				temp = node;
			}
			head2 = head2.next;
		}

		head = duplicates(head);
		head = bubbleSort(head);
		print(head);

	}

	public static LinkedLists<Integer> deleteMiddle(LinkedLists<Integer> head) {  // Function which delete middle node of the Linked list
		if(head.next==null) {
			return null;
		}
		LinkedLists<Integer> temp = head;
		int length = length(head);
		if(length%2!=0) {
			int i = 1;
			while(i<length/2) {
				temp = temp.next;
				i++;
			}
			temp.next = temp.next.next;
		}

		else {
			int i = 1;
			while(i<length/2) {
				temp = temp.next;
				i++;
			}
			temp.next = temp.next.next;
		}
		return head;

	}

	public static LinkedLists<Integer> intersection(LinkedLists<Integer> head1, LinkedLists<Integer> head2) {  // Function to return intersection of two given Linked list
		LinkedLists<Integer> head = null;
		LinkedLists<Integer> temp = null;
		while(head1!=null) {
			LinkedLists<Integer> temp2 = head2;

			while(temp2!=null) {
				if(head1.data == temp2.data) {
					LinkedLists<Integer> node = new LinkedLists<Integer>(head1.data);
					temp2.data = Integer.MAX_VALUE;
					if(head==null) {
						head = node;
						temp = node;
					}
					else {
						temp.next = node;
						temp = temp.next;
					}

				}
				temp2 = temp2.next;
			}
			head1 = head1.next;
		}
		return head;
	}

	public static LinkedLists<Integer> rotate(LinkedLists<Integer> head, int k) {  // Function to rotate a given Linked list anti clockwise by number k
		LinkedLists<Integer> start = head;
		LinkedLists<Integer> end = head;
		LinkedLists<Integer> temp = head;
		int i = 1;
		while(temp.next!=null) {
			temp = temp.next;
			if(i<k) {
				end = end.next;
			}
			i++;
		}
		head = end.next;
		end.next = null;
		temp.next = start;
		return head;
	}

}
