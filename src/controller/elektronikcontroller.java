package controller;

import java.util.List;
import DAOElektronik.ElektronikDAO;
import DAOImplement.elektronikimplement;
import java.awt.Frame;
import javax.swing.JOptionPane;
import model.elektronik;
import model.tabeldataelektronik;
import view.mainview;

public class elektronikcontroller {
    mainview frame;
    elektronikimplement implelekronik;
    List<elektronik> de;
    
    public elektronikcontroller(mainview frame){
        this.frame = frame;
        implelekronik = new ElektronikDAO();
        de = implelekronik.getAll();
    }
    public void isirable(){
        de = implelekronik.getAll();
        tabeldataelektronik ne = new tabeldataelektronik(de);
        frame.getJT
    }
    
    public void insert(){
        
    }
    
    public void edit(){
        
    }
    
    public void delete(){
        
    }
    
    public void clear(){
        
    }
    
    public elektronik getDetail(String namacustomer){
        
    }
}
