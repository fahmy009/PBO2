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
public class dataPendaftargetset {
    private int idpendaftar;
    private String nim;
    private String nama;
    private String tanggal;
    private String alamatsekarang;
    private String divisi;
    private String alasan;
    private String HP;
    private String angkatan;

    public dataPendaftargetset(int idpendaftar, String nim, String nama,String tanggal, String alamatsekarang, String divisi, String alasan, String HP, String angkatan) {
        this.idpendaftar = idpendaftar;
        this.nim = nim;
        this.nama = nama;
        this.tanggal = tanggal;
        this.alamatsekarang = alamatsekarang;
        this.divisi = divisi;
        this.alasan = alasan;
        this.HP = HP;
        this.angkatan = angkatan;
    }

    public dataPendaftargetset() {
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getIdpendaftar() {
        return idpendaftar;
    }

    public void setIdpendaftar(int idpendaftar) {
        this.idpendaftar = idpendaftar;
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

    public String getAlamatsekarang() {
        return alamatsekarang;
    }

    public void setAlamatsekarang(String alamatsekarang) {
        this.alamatsekarang = alamatsekarang;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public String getHP() {
        return HP;
    }

    public void setHP(String HP) {
        this.HP = HP;
    }
    
    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }
    
    
}
