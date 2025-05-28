/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lab Informatika
 */
public class elektronik {
    private String nama_customer;
    private String barang;
    private float harga_barang;
    private int cicilan;
    private float bunga_perbulan;
    private float angsuran_perbulan;
    private float total_pembayaran;

    public void setBunga_perbulan(float bunga_perbulan) {
        this.bunga_perbulan = bunga_perbulan;
    }

    public void setAngsuran_perbulan(float angsuran_perbulan) {
        this.angsuran_perbulan = angsuran_perbulan;
    }

    public void setTotal_pembayaran(float total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }

    public float getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(float harga_barang) {
        this.harga_barang = harga_barang;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public int getCicilan() {
        return cicilan;
    }

    public void setCicilan(int cicilan) {
        this.cicilan = cicilan;
    }
    
    public float getBunga_perbulan(){
        return (float) (((0.015 * cicilan)/100) * harga_barang);
    }
    
    public float getAngsuran(){
        return (float) ((harga_barang/cicilan) + getBunga_perbulan());
    }
    
    public float getTotal_pembayaran(){
        return (float) (getAngsuran() * cicilan);
    }
}
