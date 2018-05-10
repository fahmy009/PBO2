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
public class datamahasiswagetset {

    private String nim;
    private String nama;
    private String tanggal;
    private String alamat;
    private String HP;
    private String agama;
    private String angkatan;

    public datamahasiswagetset(String nim, String nama, String tanggal, String alamat, String HP, String agama, String angkatan) {
        this.nim = nim;
        this.nama = nama;
        this.tanggal = tanggal;
        this.alamat = alamat;
        this.HP = HP;
        this.agama = agama;
        this.angkatan = angkatan;
    }

    public datamahasiswagetset() {
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

    public String getHP() {
        return HP;
    }

    public void setHP(String HP) {
        this.HP = HP;
    }

}
