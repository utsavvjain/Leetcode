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
    public void reorderList(ListNode head) {
        List<ListNode> lst=new ArrayList<>();
        ListNode ptr=head;
        while(ptr!=null) {
            ListNode next=ptr.next;
            ptr.next=null;
            lst.add(ptr);
            ptr=next;
        }
        ListNode newHead=new ListNode();
        ptr=newHead;
        for(int i=0,j=lst.size()-1;i<=j;i++,j--){
            ListNode front=lst.get(i);
            ListNode back=lst.get(j);
            ptr.next=front;
            if(front!=back) front.next=back;
            ptr=back;
        }
    }
}