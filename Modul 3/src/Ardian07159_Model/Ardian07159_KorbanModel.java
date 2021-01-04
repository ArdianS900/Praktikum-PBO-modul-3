package Ardian07159_Model;

import Ardian07159_Entity.Ardian07159_KorbanEntity;
import java.util.ArrayList;

public class Ardian07159_KorbanModel implements Ardian07159_ModelInterfaces {

    private ArrayList<Ardian07159_KorbanEntity> korbanEntityArrayList;

    public Ardian07159_KorbanModel() {
        korbanEntityArrayList = new ArrayList<Ardian07159_KorbanEntity>();
    }

    public void insert(Ardian07159_KorbanEntity korban) {
        korbanEntityArrayList.add(korban);
    }

    @Override
    public void login() {
        for (Ardian07159_KorbanEntity korbanEntity : korbanEntityArrayList) {
            System.out.println("===========================================");
            System.out.println(" NIK : " + korbanEntity.getArdian07159_nik() + "\n Nama : "
                    + korbanEntity.getArdian07159_nama() + "\n Pekerjaan : " + korbanEntity.getArdian07159_pekerjaan()
                    + "\n Golongan Darah : " + korbanEntity.getArdian07159_goldarah() + "\n Agama : " + korbanEntity.getArdian07159_agama()
                    + "\n Jenis Kelamin : " + korbanEntity.getArdian07159_jeniskelamin() + "\n No Telp : "
                    + korbanEntity.getArdian07159_notelp() + "\n Tanggal Lahir : " + korbanEntity.getArdian07159_TglLahir());
            System.out.println("===========================================");
        }
    }

    public int cekData(String nik, String nama) {
        int loop = 0;
        while (!korbanEntityArrayList.get(loop).getArdian07159_nik().equals(nik)
                && !korbanEntityArrayList.get(loop).getArdian07159_nama().equals(nama)) {
            loop++;
        }
        return loop;
    }

    public void hapusisi(int indeks) {
        korbanEntityArrayList.remove(indeks);
    }

    public Ardian07159_KorbanEntity getkorbanEntityArrayList(int index) {
        return korbanEntityArrayList.get(index);
    }

    public ArrayList<Ardian07159_KorbanEntity> getkorbanEntityArrayList() {
        return korbanEntityArrayList;
    }
}
