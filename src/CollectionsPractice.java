import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Collections
         */

        // ===== PERBEDAAN ARRAY VS ARRAYLIST =====
        System.out.println("=== PERBEDAAN ARRAY VS ARRAYLIST ===");

        // Array ukuran tetap
        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        System.out.println("Array (fixed size, isi 3): ");
        for (int a : arr) System.out.print(a + " ");
        System.out.println();

        // ArrayList dinamis
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("ArrayList (dinamis, isi 5): " + list);

        // ===== GENERICS DASAR =====
        System.out.println("\n=== GENERICS DASAR ===");

        ArrayList rawList = new ArrayList(); // tanpa generics
        rawList.add("Teks");
        rawList.add(123);
        rawList.add(45.6);
        System.out.println("Raw List: " + rawList);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("Alice");
        strList.add("Bob");
        System.out.println("String List: " + strList);

        ArrayList<Double> dblList = new ArrayList<>();
        dblList.add(12.5);
        dblList.add(99.9);
        System.out.println("Double List: " + dblList);

        // ===== OPERASI CRUD PADA ARRAYLIST =====
        System.out.println("\n=== OPERASI CRUD PADA ARRAYLIST ===");

        ArrayList<String> daftarMahasiswa = new ArrayList<>();
        daftarMahasiswa.add("Alice");
        daftarMahasiswa.add("Bob");
        daftarMahasiswa.add("Charlie");
        daftarMahasiswa.add("Diana");
        daftarMahasiswa.add("Eva");
        daftarMahasiswa.add(2, "Frank"); // tambah di index tertentu
        System.out.println("Daftar Mahasiswa: " + daftarMahasiswa);

        // Read
        System.out.println("Mahasiswa pertama: " + daftarMahasiswa.get(0));
        System.out.println("Mahasiswa terakhir: " + daftarMahasiswa.get(daftarMahasiswa.size() - 1));
        System.out.println("Apakah ada 'Charlie'? " + daftarMahasiswa.contains("Charlie"));
        System.out.println("Index 'Bob': " + daftarMahasiswa.indexOf("Bob"));
        System.out.println("Ukuran daftar: " + daftarMahasiswa.size());

        // Update
        daftarMahasiswa.set(1, "Bobby");
        System.out.println("Setelah update: " + daftarMahasiswa);

        // Delete
        daftarMahasiswa.remove(0);
        daftarMahasiswa.remove("Eva");
        System.out.println("Setelah delete sebagian: " + daftarMahasiswa);
        daftarMahasiswa.clear();
        System.out.println("Setelah clear: " + daftarMahasiswa + " | Kosong? " + daftarMahasiswa.isEmpty());

        // ===== ITERASI ARRAYLIST =====
        System.out.println("\n=== ITERASI ARRAYLIST ===");
        ArrayList<Integer> angka = new ArrayList<>();
        angka.add(10);
        angka.add(20);
        angka.add(30);
        angka.add(40);
        angka.add(50);

        System.out.println("For loop:");
        for (int i = 0; i < angka.size(); i++) System.out.print(angka.get(i) + " ");
        System.out.println();

        System.out.println("For-each:");
        for (int x : angka) System.out.print(x + " ");
        System.out.println();

        System.out.println("While loop:");
        int i = 0;
        while (i < angka.size()) {
            System.out.print(angka.get(i) + " ");
            i++;
        }
        System.out.println();

        System.out.println("Iterator:");
        Iterator<Integer> it = angka.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        // ===== ARRAYLIST DENGAN TIPE DATA KOMPLEKS =====
        System.out.println("\n=== ARRAYLIST DENGAN TIPE DATA KOMPLEKS ===");
        ArrayList<String[]> dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add(new String[]{"Alice", "101", "TI"});
        dataMahasiswa.add(new String[]{"Bob", "102", "SI"});
        dataMahasiswa.add(new String[]{"Charlie", "103", "DKV"});

        System.out.println("Nama\tNIM\tJurusan");
        for (String[] mhs : dataMahasiswa) {
            System.out.println(mhs[0] + "\t" + mhs[1] + "\t" + mhs[2]);
        }

        // ===== UTILITY METHODS COLLECTIONS =====
        System.out.println("\n=== UTILITY METHODS COLLECTIONS ===");
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 64, 34, 25, 12, 22, 11, 90);
        System.out.println("Awal: " + numbers);
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);
        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Frequency of 22: " + Collections.frequency(numbers, 22));

        // ===== SEARCHING DAN SORTING =====
        System.out.println("\n=== SEARCHING DAN SORTING ===");
        ArrayList<String> buah = new ArrayList<>();
        Collections.addAll(buah, "Apel", "Jeruk", "Mangga", "Pisang", "Anggur");
        Collections.sort(buah);
        System.out.println("Sorted buah: " + buah);
        int idx = Collections.binarySearch(buah, "Mangga");
        System.out.println("BinarySearch Mangga: " + idx);
        int linear = linearSearch(buah, "Pisang");
        System.out.println("LinearSearch Pisang: " + linear);

        // ===== ARRAYLIST 2D =====
        System.out.println("\n=== ARRAYLIST 2D ===");
        ArrayList<ArrayList<Integer>> matrix2D = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            matrix2D.add(new ArrayList<>());
            for (int c = 0; c < r + 2; c++) {
                matrix2D.get(r).add((r + 1) * (c + 1));
            }
        }
        printMatrix2D(matrix2D);

        // ===== SKENARIO APLIKASI NYATA =====
        System.out.println("\n=== SKENARIO APLIKASI NYATA ===");
        ArrayList<String[]> daftarBuku = new ArrayList<>();
        daftarBuku.add(new String[]{"Java Basics", "Andi", "2020", "tersedia"});
        daftarBuku.add(new String[]{"Python Dasar", "Budi", "2021", "tersedia"});
        daftarBuku.add(new String[]{"C++ OOP", "Cici", "2019", "tersedia"});
        daftarBuku.add(new String[]{"Web Design", "Dina", "2022", "tersedia"});
        daftarBuku.add(new String[]{"Database", "Eka", "2018", "tersedia"});

        pinjamBuku(daftarBuku, "Python Dasar");
        kembalikanBuku(daftarBuku, "Python Dasar");
        String[] hasilCari = cariBuku(daftarBuku, "Web Design");
        if (hasilCari != null) System.out.println("Ditemukan: " + hasilCari[0] + " - " + hasilCari[3]);

        System.out.println("Buku tersedia:");
        for (String[] b : daftarBuku) {
            if (b[3].equals("tersedia"))
                System.out.println(b[0] + " (" + b[3] + ")");
        }

        // ===== PERFORMANCE COMPARISON =====
        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        // Simulasi sederhana
        long startArr = System.nanoTime();
        int[] arrTest = new int[1000];
        for (int k = 0; k < arrTest.length; k++) arrTest[k] = k;
        long endArr = System.nanoTime();
        System.out.println("Array isi 1000 elemen: " + (endArr - startArr) + " ns");

        long startList = System.nanoTime();
        ArrayList<Integer> listTest = new ArrayList<>();
        for (int k = 0; k < 1000; k++) listTest.add(k);
        long endList = System.nanoTime();
        System.out.println("ArrayList isi 1000 elemen: " + (endList - startList) + " ns");
    }

    // ===== HELPER METHODS =====
    public static void printArrayList(ArrayList<?> list, String title) {
        System.out.println(title + ": " + list);
    }

    public static int linearSearch(ArrayList<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) return i;
        }
        return -1;
    }

    public static void printMatrix2D(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }

    public static boolean pinjamBuku(ArrayList<String[]> daftarBuku, String judul) {
        for (String[] b : daftarBuku) {
            if (b[0].equals(judul) && b[3].equals("tersedia")) {
                b[3] = "dipinjam";
                return true;
            }
        }
        return false;
    }

    public static boolean kembalikanBuku(ArrayList<String[]> daftarBuku, String judul) {
        for (String[] b : daftarBuku) {
            if (b[0].equals(judul) && b[3].equals("dipinjam")) {
                b[3] = "tersedia";
                return true;
            }
        }
        return false;
    }

    public static String[] cariBuku(ArrayList<String[]> daftarBuku, String judul) {
        for (String[] b : daftarBuku) {
            if (b[0].equals(judul)) return b;
        }
        return null;
    }

    public static double hitungRataRata(ArrayList<Integer> values) {
        int sum = 0;
        for (int v : values) sum += v;
        return values.size() > 0 ? (double) sum / values.size():0.0;
    }
}