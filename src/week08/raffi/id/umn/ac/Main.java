package week08.raffi.id.umn.ac;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Item> ListOfItems = new ArrayList<Item>();
    static ArrayList<Payment> ListOfPayments = new ArrayList<Payment>();
    static Scanner s = new Scanner(System.in);

    public static void seedData() {
        ListOfItems.add(new Item("Kulkas", "Electronic", 4800000));
        ListOfItems.add(new Item("TV", "Electronic", 1280000));
        ListOfItems.add(new Item("Laptop", "Computer", 6000000));
        ListOfItems.add(new Item("PC", "Computer", 12000000));
    }

    public static void printItem(Item item) {
        System.out.println("Nama  : " + item.getName());
        System.out.println("Tipe  : " + item.getType());
        System.out.println("Harga : " + item.getPrice());
    }

    public static void main(String[] args) {
        int opt = 0;
        seedData();
        do {
            System.out.println("----Program Toko Elektronik----");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            opt = s.nextInt();

            if (opt == 1) {
                System.out.println("----Daftar Barang----");
                for (int i = 0; i < ListOfItems.size(); i++) {
                    System.out.println("No : " + (i + 1));
                    printItem(ListOfItems.get(i));
                    System.out.println("--------------------------------");
                }

                System.out.print("Pilih : ");
                int id = s.nextInt();

                if (id > 0 && id <= ListOfItems.size()) {
                    Item selected = ListOfItems.get(id - 1);
                    printItem(selected);

                    System.out.println("----Tipe Pembayaran----");
                    System.out.println("1. Cash");
                    System.out.println("2. Credit");
                    System.out.print("Pilih : ");
                    int payOpt = s.nextInt();

                    Payment p = null;

                    if (payOpt == 1) {
                        p = new Cash(selected);
                        System.out.print("Bayar (Y/N): ");
                        char confirm = s.next().charAt(0);
                        if (confirm == 'Y' || confirm == 'y') {
                            int bayar = p.pay();
                            System.out.println("Harga Pembayaran : " + bayar);
                            System.out.println("Transaksi telah dibayar lunas");
                        } else {
                            System.out.println("Transaksi telah disimpan");
                        }
                        ListOfPayments.add(p);

                    } else if (payOpt == 2) {
                        System.out.print("Lama Cicilan (3/6/9/12): ");
                        int cicil = s.nextInt();
                        p = new Credit(selected, cicil);

                        System.out.print("Bayar (Y/N): ");
                        char confirm = s.next().charAt(0);
                        if (confirm == 'Y' || confirm == 'y') {
                            int bayar = p.pay();
                            System.out.println("Harga Pembayaran : " + bayar);
                            System.out.println("Transaksi telah dibayar");
                        } else {
                            System.out.println("Transaksi telah disimpan");
                        }
                        ListOfPayments.add(p);
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                } else {
                    System.out.println("Pilihan tidak valid!");
                }

            } else if (opt == 2) {
                if (ListOfPayments.isEmpty()) {
                    System.out.println("Belum ada pesanan.");
                } else {
                    System.out.println("----Daftar Pesanan----");
                    for (int i = 0; i < ListOfPayments.size(); i++) {
                        Payment p = ListOfPayments.get(i);
                        System.out.println("No : " + (i + 1));
                        System.out.println("Nama : " + p.getItemName());
                        System.out.println("Tipe : " + p.getItem().getType());
                        System.out.println("Status : " + p.getStatus());
                        System.out.println("Sisa Pembayaran : " + p.getRemainingAmount());
                        System.out.println("--------------------------------");
                    }

                    System.out.print("Pilih No Transaksi : ");
                    int trans = s.nextInt();

                    if (trans > 0 && trans <= ListOfPayments.size()) {
                        Payment p = ListOfPayments.get(trans - 1);
                        System.out.println("Nama : " + p.getItemName());
                        System.out.println("Tipe : " + p.getItem().getType());
                        System.out.println("Status : " + p.getStatus());
                        System.out.println("Sisa Pembayaran : " + p.getRemainingAmount());

                        if (!p.isPaidOff()) {
                            System.out.print("Bayar (Y/N): ");
                            char confirm = s.next().charAt(0);
                            if (confirm == 'Y' || confirm == 'y') {
                                int bayar = p.pay();
                                System.out.println("Bayar : " + bayar);
                                if (p.isPaidOff()) {
                                    System.out.println("Transaksi telah dibayar lunas");
                                } else {
                                    System.out.println("Transaksi telah dibayar");
                                }
                            }
                        }
                    } else {
                        System.out.println("Nomor transaksi tidak valid!");
                    }
                }

            } else if (opt == 0) {
                System.out.println("Terima kasih!");
            } else {
                System.out.println("Salah input!");
            }

        } while (opt != 0);
    }
}
