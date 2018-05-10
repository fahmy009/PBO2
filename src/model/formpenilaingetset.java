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
public class formpenilaingetset {

    private int idPenilaian;
    private int idPendaftar;
    private String nama;
    private double nilaiPengalaman;
    private double nilaiEtika;
    private double nilaiPenampilan;
    private String status;

    public formpenilaingetset(int idPenilaian, int idPendaftar, String nama, double nilaiPengalaman, double nilaiEtika, double nilaiPenampilan, String status) {
        this.idPenilaian = idPenilaian;
        this.idPendaftar = idPendaftar;
        this.nama = nama;
        this.nilaiPengalaman = nilaiPengalaman;
        this.nilaiEtika = nilaiEtika;
        this.nilaiPenampilan = nilaiPenampilan;
        this.status = status;
    }

    public formpenilaingetset() {
    }

    public int getIdPenilaian() {
        return idPenilaian;
    }

    public void setIdPenilaian(int idPenilaian) {
        this.idPenilaian = idPenilaian;
    }

    public int getIdPendaftar() {
        return idPendaftar;
    }

    public void setIdPendaftar(int idPendaftar) {
        this.idPendaftar = idPendaftar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getNilaiPengalaman() {
        return nilaiPengalaman;
    }

    public void setNilaiPengalaman(double nilaiPengalaman) {
        this.nilaiPengalaman = nilaiPengalaman;
    }

    public double getNilaiEtika() {
        return nilaiEtika;
    }

    public void setNilaiEtika(double nilaiEtika) {
        this.nilaiEtika = nilaiEtika;
    }

    public double getNilaiPenampilan() {
        return nilaiPenampilan;
    }

    public void setNilaiPenampilan(double nilaiPenampilan) {
        this.nilaiPenampilan = nilaiPenampilan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
