/*Merge k sorted linked lists and return it as one sorted list. O(n*logk) O(k)

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         //BST2
        if(lists == null || lists.length < 1){
            return null;
        }
        Queue<ListNode> minHeap = new PriorityQueue<>(11, new MyComparator());
        ListNode dummy = new ListNode(0), d = dummy;
        for(ListNode node : lists){
            if(node != null){
            minHeap.offer(node);
            }
        }
        while(!minHeap.isEmpty()){
            d.next = minHeap.poll();
            if(d.next.next != null){
                minHeap.offer(d.next.next);
            }
            d = d.next;
        }
        return dummy.next;
    }
    static class MyComparator implements Comparator<ListNode>{
        @Override
        public int compare(ListNode one, ListNode two){
            if(one.val == two.val){
                return 0;
            }
            return one.val < two.val? -1 : 1;
        }
    }
}
