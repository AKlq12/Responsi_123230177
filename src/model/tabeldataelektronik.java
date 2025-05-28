package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tabeldataelektronik extends AbstractTableModel {

    List<elektronik> list;

    public tabeldataelektronik(List<elektronik> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        elektronik e = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getNama_customer();
            case 1:
                return e.getBarang();
            case 2:
                return e.getHarga_barang();
            case 3:
                return e.getCicilan();
            case 4:
                return e.getBunga_perbulan();
            case 5:
                return e.getAngsuran();
            case 6:
                return e.getTotal_pembayaran();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Customer";
            case 1:
                return "Barang";
            case 2:
                return "Harga Barang";
            case 3:
                return "Cicilan(perbulan)";
            case 4:
                return "Bunga perbulan";
            case 5:
                return "Angsuran perbulan";
            case 6:
                return "Total Pembayaran";
            default:
                return null;
        }
    }

}
