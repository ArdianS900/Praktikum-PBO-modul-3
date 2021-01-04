package Ardian07159_Controller;

import Ardian07159_Entity.Ardian07159_DataKorbanEntity;
import Ardian07159_Entity.Ardian07159_KorbanEntity;
import java.util.ArrayList;
import java.util.Date;

public class Ardian07159_KorbanController implements Ardian07159_ControllerInterfaces {
    int indexLogin=0;
    
        
    public Ardian07159_KorbanEntity getData(){
        return Ardian07159_AllObjectModel.korbanModel.getkorbanEntityArrayList(indexLogin);
       }
    
    public void daftarstatus (int indexStatus, Ardian07159_KorbanEntity korban){
       Ardian07159_AllObjectModel.datakorbanModel.insertDataDataKorban(new Ardian07159_DataKorbanEntity(indexStatus,korban));
    }
    
    @Override
    public void login (String nik , String nama){
        indexLogin = Ardian07159_AllObjectModel.korbanModel.cekData(nik, nama);
    }
      
    public void insert (String Ardian07159_nik, String Ardian07159_nama,
               String Ardian07159_pekerjaan,String Ardian07159_goldarah,String Ardian07159_agama,
               String Ardian07159_jeniskelamin,String Ardian07159_notelp,
               String Ardian07159_bantuan,Date Ardian07159_TglLahir){
       Ardian07159_AllObjectModel.korbanModel.insert(new Ardian07159_KorbanEntity(Ardian07159_nik,Ardian07159_nama,Ardian07159_pekerjaan,Ardian07159_goldarah,
            Ardian07159_agama,Ardian07159_jeniskelamin, Ardian07159_notelp,Ardian07159_bantuan,Ardian07159_TglLahir));
    }
    
     public Ardian07159_KorbanEntity korban(){
        return Ardian07159_AllObjectModel.korbanModel.getkorbanEntityArrayList(indexLogin);
    }
    
    public int cekDataKorban(String nik){
        int cek = Ardian07159_AllObjectModel.datakorbanModel.cekData(nik, null);
        return cek;
    }
    
    public Ardian07159_DataKorbanEntity showDataKorban (int index){
        return Ardian07159_AllObjectModel.datakorbanModel.showDataKorban(index);
    }
    
    public void HapusIsiData(int indeks){
        Ardian07159_AllObjectModel.korbanModel.hapusisi(indeks);
    }

    public void update(String nik) {
        Ardian07159_AllObjectModel.datakorbanModel.update(nik);
    }
    
    public ArrayList<Ardian07159_KorbanEntity> cekArrayListKorban() {
        return Ardian07159_AllObjectModel.korbanModel.getkorbanEntityArrayList();
    }
}
