public class ListNode {
    Buku data;
    
    ListNode next;
    public ListNode(Buku data) {
        this.data = data;
        this.next = null;
    }
    
    public Buku getData() {
        return data;
    }
}
