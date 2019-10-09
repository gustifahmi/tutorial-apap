package apap.tutorial.gopud.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

import apap.tutorial.gopud.model.MenuModel;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="restoran")
public class RestoranModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestoran;

    @NotNull
    @Size(max = 20)
    @Column(name="nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 30)
    @Column(name = "alamat", nullable = false)
    private String alamat;

    @NotNull
    @Column(name = "nomorTelepon", nullable = false)
    private Integer nomorTelepon;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating = 0;

    @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MenuModel> listMenu;

    public Long getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public List<MenuModel> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<MenuModel> listMenu) {
        this.listMenu = listMenu;
    }
}
