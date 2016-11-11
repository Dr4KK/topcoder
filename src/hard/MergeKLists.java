package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kekai on 16/11/10.
 */
public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return lists[0];
        }

        List<ListNode> result = new ArrayList<>();
        int low = 0, high = len - 1;
        while (low <= high) {
            if (low == high) {
                result.add(lists[low]);
                break;
            }
            result.add(mergeTwoLists(lists[low], lists[high]));
            low++;
            high--;

        }
        ListNode[] nodes = new ListNode[result.size()];
        nodes = result.toArray(nodes);
        return mergeKLists(nodes);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode mark = newList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newList.next = l1;
                l1 = l1.next;
            } else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }

        while (l1 != null) {
            newList.next = l1;
            l1 = l1.next;
            newList = newList.next;
        }

        while (l2 != null) {
            newList.next = l2;
            l2 = l2.next;
            newList = newList.next;
        }
        return mark.next;

    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = null;
        listNodes[1] = null;
        ListNode li = mergeKLists(listNodes);
        System.out.println(li.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
