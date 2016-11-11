package easy;

/**
 * Created by kekai on 16/11/8.
 */
public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode mark = newList;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                newList.next = l1;
                l1 = l1.next;
            } else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }

        while(l1 != null) {
            newList.next = l1;
            l1 = l1.next;
            newList = newList.next;
        }

        while(l2 != null) {
            newList.next = l2;
            l2 = l2.next;
            newList = newList.next;
        }
        return mark.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode tmp = mergeTwoLists(l1, l2);
        System.out.println(tmp.val);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
