/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkasirbarokah;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "BARANG", catalog = "", schema = "PROJECTBUFAR")
@NamedQueries({
    @NamedQuery(name = "Barang_1.findAll", query = "SELECT b FROM Barang_1 b")
    , @NamedQuery(name = "Barang_1.findByIdBarang", query = "SELECT b FROM Barang_1 b WHERE b.idBarang = :idBarang")
    , @NamedQuery(name = "Barang_1.findByNamaBarang", query = "SELECT b FROM Barang_1 b WHERE b.namaBarang = :namaBarang")
    , @NamedQuery(name = "Barang_1.findByHargaBarang", query = "SELECT b FROM Barang_1 b WHERE b.hargaBarang = :hargaBarang")})
public class Barang_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BARANG")
    private BigDecimal idBarang;
    @Column(name = "NAMA_BARANG")
    private String namaBarang;
    @Column(name = "HARGA_BARANG")
    private BigInteger hargaBarang;

    public Barang_1() {
    }

    public Barang_1(BigDecimal idBarang) {
        this.idBarang = idBarang;
    }

    public BigDecimal getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(BigDecimal idBarang) {
        BigDecimal oldIdBarang = this.idBarang;
        this.idBarang = idBarang;
        changeSupport.firePropertyChange("idBarang", oldIdBarang, idBarang);
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        String oldNamaBarang = this.namaBarang;
        this.namaBarang = namaBarang;
        changeSupport.firePropertyChange("namaBarang", oldNamaBarang, namaBarang);
    }

    public BigInteger getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(BigInteger hargaBarang) {
        BigInteger oldHargaBarang = this.hargaBarang;
        this.hargaBarang = hargaBarang;
        changeSupport.firePropertyChange("hargaBarang", oldHargaBarang, hargaBarang);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang_1)) {
            return false;
        }
        Barang_1 other = (Barang_1) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectkasirbarokah.Barang_1[ idBarang=" + idBarang + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
