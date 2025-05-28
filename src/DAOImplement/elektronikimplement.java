/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;

import java.util.List;
import model.*;

public interface elektronikimplement {
    public void insert (elektronik e);
    public void edit (elektronik e);
    public void delete (String namacustomer);
    public List<elektronik> getAll();
    public  elektronik getDetail(String namacustomer);
}
