package com.furkanozerdem.depremler.Model;

import com.google.gson.annotations.SerializedName;

public class Data {
    public Data () { }

    public Data(String tarih, String saat, String enlem, String boylam, String derinlik, String buyukluk, String yer, String sehir) {
        this.tarih = tarih;
        this.saat = saat;
        this.enlem = enlem;
        this.boylam = boylam;
        this.derinlik = derinlik;
        this.buyukluk = buyukluk;
        this.yer = yer;
        this.sehir = sehir;
    }

    @SerializedName("tarih")
    private String tarih;
    @SerializedName("saat")
    private String saat;
    @SerializedName("enlem")
    private String enlem;
    @SerializedName("boylam")
    private String boylam;
    @SerializedName("derinlik")
    private String derinlik;
    @SerializedName("buyukluk")
    private String buyukluk;
    @SerializedName("yer")
    private String yer;
    @SerializedName("sehir")
    private String sehir;
    public String getTarih() {
        return tarih;
    }
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    public String getSaat() {
        return saat;
    }
    public void setSaat(String saat) {
        this.saat = saat;
    }
    public String getEnlem() {
        return enlem;
    }
    public void setEnlem(String enlem) {
        this.enlem = enlem;
    }
    public String getBoylam() {
        return boylam;
    }
    public void setBoylam(String boylam) {
        this.boylam = boylam;
    }
    public String getDerinlik() {
        return derinlik;
    }
    public void setDerinlik(String derinlik) {
        this.derinlik = derinlik;
    }
    public String getBuyukluk() {
        return buyukluk;
    }
    public void setBuyukluk(String buyukluk) {
        this.buyukluk = buyukluk;
    }
    public String getYer() {
        return yer;
    }
    public void setYer(String yer) {
        this.yer = yer;
    }
    public String getSehir() {
        return sehir;
    }
    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
}