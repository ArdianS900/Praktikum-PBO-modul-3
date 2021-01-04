package Ardian07159_Model;

import Ardian07159_Entity.Ardian07159_DataKorbanEntity;
import Ardian07159_Entity.Ardian07159_KorbanEntity;
import Ardian07159_Entity.Ardian07159_StatusEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Ardian07159_DataKorbanModel implements Ardian07159_ModelInterfaces {

    private static Scanner input = new Scanner(System.in);
    private ArrayList<Ardian07159_DataKorbanEntity> datakorbanArrayList;
    private Object datakorban;
    private Object datakorbanmodel;
    private Object Ardian07159_datakorbanmodel;

    public Ardian07159_DataKorbanModel() {
        datakorbanArrayList = new ArrayList<Ardian07159_DataKorbanEntity>();
    }

    public void insertDataDataKorban(Ardian07159_DataKorbanEntity datakorban) {
        datakorbanArrayList.add(datakorban);
    }

    public ArrayList<Ardian07159_DataKorbanEntity> getdatakorbanArrayList() {
        return datakorbanArrayList;
    }

    @Override
    public void login() {
        for (Ardian07159_DataKorbanEntity datakorban : datakorbanArrayList) {
            System.out.println("===========================================");
            System.out.println(" NIK : " + datakorban.getKorban().getArdian07159_nik() + "\n Nama : "
                    + datakorban.getKorban().getArdian07159_nama() + "\n Pekerjaan : " + datakorban.getKorban().getArdian07159_pekerjaan()
                    + "\n Golongan Darah : " + datakorban.getKorban().getArdian07159_goldarah()
                    + "\n Agama : " + datakorban.getKorban().getArdian07159_agama() + "\n Jenis Kelamin : "
                    + datakorban.getKorban().getArdian07159_jeniskelamin() + "\n No Telp : "
                    + datakorban.getKorban().getArdian07159_notelp() + "\n Tanggal Lahir : "
                    + new SimpleDateFormat("dd-MM-yyyy").format(datakorban.getKorban().getArdian07159_TglLahir())
                    + "\n Status : " + Ardian07159_StatusEntity.Ardian07159_Status[datakorban.getIndexStatus()]);
        }
    }

    public int cekData(String nik, String nama) {
        int loop = 0;
        if (datakorbanArrayList.size() == 0) {
            loop = -1;
        } else {
            for (int i = 0; i < datakorbanArrayList.size(); i++) {
                if (datakorbanArrayList.get(i).getKorban().getArdian07159_nik().equals(nik)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public Ardian07159_DataKorbanEntity showDataKorban(int index) {
        return datakorbanArrayList.get(index);
    }

    public int carinik(String Ardian07159_nik) {
        int index = -1;
        for (int i = 0; i < datakorbanArrayList.size(); i++) {
            if (Ardian07159_nik.equals(datakorbanArrayList.get(i).getKorban().getArdian07159_nik())) {
                index = i;
            }
        }
        return index;
    }

    public void update(String Ardian07159_nik) {
        if (carinik(Ardian07159_nik) != -1) {
            for (int i = 0; i < Ardian07159_StatusEntity.Ardian07159_Status.length; i++) {
                System.out.println(i + ". " + Ardian07159_StatusEntity.Ardian07159_Status[i]);
            }
            System.out.print("Update Status = ");
            int statusbaru = input.nextInt();
            datakorbanArrayList.get(carinik(Ardian07159_nik)).setIndexStatus(statusbaru);
        } else {
            System.out.println("Data tidak Ditemukan");
        }
    }

    /*public void hapus(String nik) {
     for(Ardian07159_DataKorbanEntity datakorbanentity:datakorbanArrayList){
     if(datakorbanentity.){
             
     }   
     }
     }*/
}
