package Ardian07159_SistemInformasiPendataanKorbanBencana;

import Ardian07159_Entity.Ardian07159_StatusEntity;
import Ardian07159_Controller.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ardian07159_Main {

    private static Ardian07159_KorbanController korban = new Ardian07159_KorbanController();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int loop = 0;
        do {
            int pilih = 0;
            System.out.print("\n Sistem Informasi Korban Bencana"
                    + "\n 1. Daftar Korban Baru"
                    + "\n 2. Login Data Korban"
                    + "\n 3. Update Status "
                    + "\n 4. Hapus "
                    + "\n 0. Stop"
                    + "\n Masukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if (pilih == 1) {
                daftar();
            } else if (pilih == 2) {
                logindata();
            } else if (pilih == 3) {
                updatestatus();
            } else if (pilih == 4) {
                hapus();
            } else if (pilih != 5) {
                break;
            } else {
            }
        } while (loop != 1);
    }

    static void daftar() {
        try {
            System.out.print("Input NIK = ");
            String nik = input.next();
            System.out.print("Input Nama = ");
            String nama = input.next();
            System.out.print("Input Pekerjaan = ");
            String pekerjaan = input.next();
            System.out.print("Input Golongan Darah = ");
            String goldar = input.next();
            System.out.print("Input Agama = ");
            String agama = input.next();
            System.out.print("Input Jenis Kelamin = ");
            String jeniskelamin = input.next();
            System.out.print("Input No Telp = ");
            String notelp = input.next();
            System.out.print("Input Tgl Lahir (mm/dd/yyyy) = ");
            Date tanggal;
            tanggal = new Date(input.next());
            System.out.print("Bantuan = ");
            String bantuan = input.next();
            korban.insert(nik, nama, pekerjaan, goldar,
                    agama, jeniskelamin, notelp, bantuan, tanggal);
            System.out.println("Daftar Sukses !!");
        } catch (Exception exception) {
            System.out.println("Format Pengisian Salah !!");
        }
    }

    static void logindata() {
        System.out.print("NIK : ");
        String nik = input.next();
        System.out.print("Nama : ");
        String nama = input.next();
        try {
            korban.login(nik, nama);
            System.out.println("\n Data Dari " + korban.korban().getArdian07159_nama());
            int cek = korban.cekDataKorban(korban.korban().getArdian07159_nik());
            if (cek == -1) {
                System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
            } else if (cek == -2) {
                System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
            } else {
                System.out.println("Nama = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_nama());
                System.out.println("NIK = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_nik());
                System.out.println("Pekerjaan = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_pekerjaan());
                System.out.println("Golongan Darah = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_goldarah());
                System.out.println("Agama = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_agama());
                System.out.println("Jenis Kelamin = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_jeniskelamin());
                System.out.println("No Telp = " + korban.showDataKorban(cek).
                        getKorban().getArdian07159_notelp());
                System.out.println("Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").
                        format(korban.showDataKorban(cek)
                                .getKorban().getArdian07159_TglLahir()));
                System.out.println("Status Korban = " + Ardian07159_StatusEntity.Ardian07159_Status[korban.showDataKorban(cek).getIndexStatus()]);

            }
        }catch(Exception e){
            System.out.println("Data Tidak Tersedia \n");
        }
    }

    static void daftarstatus() {
        System.out.print("Pilih Status = \n");
        for (int i = 0; i < Ardian07159_StatusEntity.Ardian07159_Status.length; i++) {
            System.out.println(i + ". " + Ardian07159_StatusEntity.Ardian07159_Status[i]);
        }
        System.out.print("Pilih Status = ");
        int pilstatus = input.nextInt();
        korban.daftarstatus(pilstatus, korban.getData());
    }

    static void updatestatus() {
        System.out.print("Input NIK = ");
        String nik = input.next();
        korban.update(nik);
    }

    static void hapus() {
        int indeks;
        if (korban.cekArrayListKorban().isEmpty()) {
            System.out.println("Keranjang Kosong");
        } else {
            System.out.print("Masukkan Urutan Data = ");
            indeks = input.nextInt();
            indeks = indeks - 1;
            if (indeks > korban.cekArrayListKorban().size() || indeks < 0) {
                System.out.println("Urutan Kue Tidak Tersedia Di Keranjang");
            } else {
                korban.HapusIsiData(indeks);
            }
        }
    }
}
