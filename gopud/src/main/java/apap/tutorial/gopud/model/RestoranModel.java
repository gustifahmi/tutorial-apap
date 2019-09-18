package apap.tutorial.gopud.model;

public class RestoranModel {
    private string idRestoran;
    private string nama;
    private string alamat;
    private Integer nomorTelepon

    public RestoranModel(string idRestoran, string nama, string alamat, Integer nomorTelepon) {
        this.idRestoran = idRestoran;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }

    public string getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(string idRestoran) {
        this.idRestoran = idRestoran;
    }

    public string getNama() {
        return nama;
    }

    public void setNama(string nama) {
        this.nama = nama;
    }

    public string getAlamat() {
        return alamat;
    }

    public void setAlamat(string alamat) {
        this.alamat = alamat;
    }

    public Integer getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}
