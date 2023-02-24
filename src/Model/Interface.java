/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author hcorrea
 */
public interface Interface {
    public String create(String id, String Description);
    
    public ArrayList<Object[]> read();
    
    public String update(String id, String Description); 
    
    public String delete(String id);
    
    public String search();
}
