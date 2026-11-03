/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val-b.val);

       

        for(ListNode l:lists){
            if(l!=null){
                minHeap.add(l);
            }
        }

        ListNode node = new ListNode(-1);
        ListNode head = node;

        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            // System.out.println(smallest.val);
            node.next=smallest;
            node = node.next;

            if(smallest.next!=null){
                minHeap.add(smallest.next);
            }
        }

        return head.next;
       
    }
}
