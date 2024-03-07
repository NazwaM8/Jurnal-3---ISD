import java.util.NoSuchElementException;

public class SingleLinkList {
    private ListNode firstNode;
    private ListNode lastNode;
    private String name;
    
    public SingleLinkList() {
        this("List Buku");
    }

    public SingleLinkList(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    // tambahawal
    public void insertAtFront (Buku insertItem) {
        ListNode newNode = new ListNode(insertItem);

        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }

    //tambahakhir
    public void insertAtBack(Buku insertItem) {
        ListNode newNode = new ListNode(insertItem);

        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    //tambahindex
    public void insertFromIndex(int index, Buku inserItem) {
        ListNode newNode = new ListNode(inserItem);
        

        if (index < 0) {
            System.out.println("indeks tidak valid");
            return;
        } else if (index == 0) {
            insertAtFront(inserItem);
            return;
        }
        ListNode iterator = firstNode;
        int counter = 0;
        while (iterator != null && counter < index-1) {
            iterator = iterator.next;
            counter++;
        }
        if (iterator == null) {
            System.out.println("indeks tidak valid");
            return;
        }
        newNode.next = iterator.next;
        iterator.next = newNode;
    }

    //hapusakhir
    public Buku removeFromBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(name + " berhasil dihapus");
        }

        Buku removedItem = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            ListNode current = firstNode;

            while (current.next != lastNode) {
                current = current.next;
            }
            lastNode = current;
            current.next = null;
        }
        return removedItem;
    }

    //hapusawal
    public Buku removeFromFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(name + " berhasil dihapus");
        }

        Buku removedItem = firstNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.next;
        }
        return removedItem;
    }

    //hapusjudul
    public Buku removebyTitle(String judul) throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(name + " berhasil dihapus");
        }

        Buku removedItem = firstNode.data;

        if (firstNode == null) {
        return removedItem;
        } else if (firstNode.data.getJudul().equals(judul)) {
            firstNode = firstNode.next;
        }
        ListNode iterator = firstNode;
        while (iterator.data.getJudul().equals(judul)) {
            iterator = iterator.next;
        }
        if (iterator.next.data.getJudul().equals(judul)) {
            iterator.next = iterator.next.next;
        }
        iterator = iterator.next;
        return removedItem;
    }

    private boolean isEmpty() {
        return firstNode == null;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("anda belum menambahkan buku apapun");
            return;
        }

        System.out.printf("%s adalah: %n", name);
        ListNode current = firstNode;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }

}
