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
public class pendaftargetset {

    private int idpendaftar;
    private String nim;
    private String nama;
    private String alamatsekarang;
    private String divisi;
    private String alasan;

    public pendaftargetset() {
    }

    public pendaftargetset(int idpendaftar, String nim, String nama, String alamatsekarang, String divisi, String alasan) {
        this.idpendaftar = idpendaftar;
        this.nim = nim;
        this.nama = nama;
        this.alamatsekarang = alamatsekarang;
        this.divisi = divisi;
        this.alasan = alasan;
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

}
