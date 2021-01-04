package Ardian07159_Entity;

public class Ardian07159_DataKorbanEntity {
    private Ardian07159_KorbanEntity korban;
    private int indexStatus; 

    public Ardian07159_DataKorbanEntity(int indexStatus, Ardian07159_KorbanEntity korban) {
        this.indexStatus = indexStatus;
        this.korban = korban;
    }

      public Ardian07159_KorbanEntity getKorban() {
        return korban;
    }

    public void setKorban(Ardian07159_KorbanEntity korban) {
        this.korban = korban;
    }

    public int getIndexStatus() {
        return indexStatus;
    }

    public void setIndexStatus(int indexStatus) {
        this.indexStatus = indexStatus;
    }
        
}
