package com.kampusdeveloper.easykampus.model;

/**
 * Created by Dodi Rivaldi on 19/08/2016.
 */
public class Data {
    private String nama,jabatan, nomor;

    public Data() {
    }

    public Data(String nama,String jabatan,String nomor) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }
}
