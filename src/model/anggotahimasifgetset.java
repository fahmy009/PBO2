/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Muhammad Fahmy
 */
public class anggotahimasifgetset {

    private int id;
    private int iduser;
    private String nim;
    private String jabatan;
    private String nama;
    private String tanggal;
    private String alamat;
    private String HP;
    private String agama;
    private String angkatan;

    public anggotahimasifgetset(int id, int iduser, String nim, String nama,String Jabatan, String tanggal, String alamat, String HP, String agama, String angkatan) {
        this.id = id;
        this.iduser = iduser;
        this.nim = nim;
        this.jabatan = Jabatan;
        this.nama = nama;
        this.tanggal = tanggal;
        this.alamat = alamat;
        this.HP = HP;
        this.agama = agama;
        this.angkatan = angkatan;
    }
    
    public anggotahimasifgetset(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHP() {
        return HP;
    }

    public void setHP(String HP) {
        this.HP = HP;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    

    
}
