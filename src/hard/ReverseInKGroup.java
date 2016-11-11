package hard;

/**
 * Created by kekai on 16/11/10.
 */

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        Pair pair = reverseList(head, k);

        ListNode mark = pair.tail;
        while(mark.next != null) {
            Pair newPair = reverseList(mark.next, k);
            mark.next = newPair.head;
            mark = newPair.tail;
        }
        return pair.head;
    }

    public Pair reverseList(ListNode head, int k) {
        ListNode mark = head;
        int count = 1;
        while(head != null) {
            if(count == k) {
                break;
            }
            if(head.next == null) {
                break;
            }else {
                head = head.next;
                count++;
            }

        }
        if(count < k) {
            return new Pair(mark, head);
        }
        ListNode last = dfsReverse(mark, k);
        return new Pair(head, last);
    }

    public ListNode dfsReverse(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        if(k == 1) {
            return head;
        }
        k = k - 1;
        ListNode last = dfsReverse(head.next, k);
        head.next = last.next;
        last.next = head;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ReverseInKGroup r = new ReverseInKGroup();
        ListNode tmp = r.reverseKGroup(l1, 3);
        System.out.println(tmp.val);
    }
}

class Pair{
    public ListNode head;
    public ListNode tail;

    public Pair(ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
    }
}
