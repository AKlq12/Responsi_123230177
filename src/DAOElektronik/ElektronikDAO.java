/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOElektronik;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.elektronik;
import DAOImplement.elektronikimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElektronikDAO implements elektronikimplement {

    private final Connection Connection;

    private static final String SELECT_ALL = "SELECT * FROM pembayaran";
    private static final String INSERT = "INSERT INTO pembayaran(nama_customer,barang,harga_barang,cicilan) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE pembayaran SET nama_customer=?, barang=?, harga_barang=?, cicilan=? WHERE nama_customer=?";
    private static final String DELETE = "DELETE FROM pembayaran WHERE nama_customer=?";

    public ElektronikDAO() {
        this.Connection = connector.connection();
    }

    @Override
    public void insert(elektronik e) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, e.getNama_customer());
            statement.setString(2, e.getBarang());
            statement.setFloat(3, e.getHarga_barang());
            statement.setInt(4, e.getCicilan());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElektronikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(elektronik e) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, e.getNama_customer());
            statement.setString(2, e.getBarang());
            statement.setFloat(3, e.getHarga_barang());
            statement.setInt(4, e.getCicilan());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElektronikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<elektronik> getAll() {
        List<elektronik> elektronikList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                elektronik e = new elektronik();
                e.setNama_customer(rs.getString("nama_customer"));
                e.setBarang(rs.getString("barang"));
                e.setHarga_barang(rs.getFloat("harga_barang"));
                e.setCicilan(rs.getInt("cicilan"));
                e.setBunga_perbulan(rs.getFloat("bunga_perbulan"));
                e.setAngsuran_perbulan(rs.getFloat("angsuran_perbulan"));
                e.setTotal_pembayaran(rs.getFloat("total_pembayaran"));
                elektronikList.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElektronikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elektronikList;
    }

    @Override
    public void delete(String namacustomer) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, namacustomer);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElektronikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public elektronik getDetail(String namacustomer) {
        String query = "SELECT * FROM pembayaran WHERE nama_customer=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, namacustomer);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                elektronik e = new elektronik();
                e.setNama_customer(rs.getString("nama_customer"));
                e.setBarang(rs.getString("barang"));
                e.setHarga_barang(rs.getFloat("harga_barang"));
                e.setCicilan(rs.getInt("cicilan"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElektronikDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
