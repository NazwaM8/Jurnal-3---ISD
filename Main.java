import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        SingleLinkList list1 = new SingleLinkList();
        int pilihan;
        String yesOrNo;
        boolean on = true;

        while (on) {
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cetak Daftar Buku");
            System.out.println("4. Keluar");
            System.out.print("Masukan Operator: ");
            pilihan = userInput.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Judul Buku: ");
                String judulBuku = userInput.next();
                System.out.print("Masukkan Penulis: ");
                String penulis = userInput.next();
                System.out.print("Masukkan Tahun Terbit: ");
                String tahunTerbit = userInput.next();

                System.out.println("Tambah data di? (awal/akhir/indeks)");
                yesOrNo = userInput.next();

                if (yesOrNo.equals("indeks")) {
                    System.out.print("Masukan indeks: ");
                    int index = userInput.nextInt();
                    list1.insertFromIndex(index, new Buku(judulBuku, penulis, tahunTerbit));
                    System.out.println("Data buku berhasil ditambahkan di indeks tersebut");
                }
                else if (yesOrNo.equals("awal")) {
                    list1.insertAtFront(new Buku(judulBuku, penulis, tahunTerbit));
                    System.out.println("Data buku berhasil ditambahkan di awal");
                } else {
                    list1.insertAtBack(new Buku(judulBuku, penulis, tahunTerbit));
                    System.out.println("Data buku berhasil ditambahkan di akhir");
                }
                break;

            case 2:
                System.out.println("Hapus data? (awal/akhir/judul)");
                yesOrNo = userInput.next();

                if (yesOrNo.equals("judul")) {
                    userInput.nextLine();
                    String title = userInput.nextLine();
                    list1.removebyTitle(title);
                    System.out.println("Data buku tersebut berhasil dihapus");
                } else if (yesOrNo.equals("awal")) {
                    list1.removeFromFront();
                    System.out.println("Data buku di awal list berhasil dihapus");
                } else {
                    list1.removeFromBack();
                    System.out.println("Data buku di akhir list berhasil dihapus");
                }
                break;

            case 3:
                list1.print();
                System.out.println();
                break;

            case 4:
                on=false;
                break;
            }
        }
    }
}