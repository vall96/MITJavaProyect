/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vrodriguez
 */
public class Mlib {

    Config config = new Config();
    PreparedStatement ps = null;
    Connection con;
    ResultSet rs;
    Mvar mvar;
    ResultSetMetaData rsmd;
    String sql, consulta, search;
    public static String Val_Data = null;
    String prueba;

//Articulos
    public class mlibArticles implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM Articulos WHERE (art_Id) = '" + id + "'";
            sql = " INSERT INTO Articulos(art_Id,art_Nom) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        con.close();
                        Val_Data = "Registrado";
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select art_Id, art_Nom, art_Unidad from Articulos";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update Articulos set  art_Nom = '" + Description + "'WHERE art_Id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM Articulos WHERE art_Id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Atributos
    public class mlibAttributes implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM Atributos WHERE (Atrib_id) = '" + id + "'";
            sql = " INSERT INTO Atributos([Atrib_id],[Atrib_descripcion]) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from Atributos";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = "Update Atributos set Atrib_descripcion= '" + Description + "'Where Atrib_id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM Atributos WHERE Atrib_id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Perfil de Empleado
    public class mlibEmployeeProfile implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM PerfilesEmpleados WHERE (PerfilesEmp_Id) = '" + id + "'";
            sql = " INSERT INTO PerfilesEmpleados(PerfilesEmp_Id, PerfilesEmp_Descripcion, PefilEmp_Sueldo) VALUES ('" + id + " ', '" + Description + "',  ?)";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select PerfilesEmp_Id, PerfilesEmp_Descripcion, PefilEmp_Sueldo from PerfilesEmpleados";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update PerfilesEmpleados set PefilEmp_Sueldo = ?,  PerfilesEmp_Descripcion = '" + Description + "'WHERE PerfilesEmp_Id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM PerfilesEmpleados WHERE PerfilesEmp_Id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Maquinas
    public class mlibMachine implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM Maquinas WHERE (Maq_id) = '" + id + "'";
            sql = " INSERT INTO Maquinas([Maq_id],[Maq_descripcion]) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from Maquinas";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update Maquinas set Maq_descripcion= '" + Description + "'Where Maq_id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM Maquinas WHERE Maq_id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Gastos de Fabrica
    public class mlibMachineExpenses implements Interface {

        @Override
        public String create(String id, String Description) {
            sql = " INSERT INTO GastosFabrica(GastosFab_id,GastosFab_descripcion) VALUES ('" + id + " ', '" + Description + "')";
            consulta = "SELECT 1 FROM GastosFabrica WHERE (GastosFab_id) = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from GastosFabrica";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update GastosFabrica set  GastosFab_descripcion= '" + Description + "'Where GastosFab_id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM GastosFabrica WHERE GastosFab_id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Falla de Maquinas
    public class mlibMachineFaults implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM FallasMaquina WHERE (FallasMaq_id) = '" + id + "'";
            sql = " INSERT INTO FallasMaquina([FallasMaq_id],[FallaMaq_descripcion]) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from FallasMaquina";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();

            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update FallasMaquina set  FallaMaq_descripcion= '" + Description + "'Where FallasMaq_id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM FallasMaquina WHERE FallasMaq_id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Estatus de Maquina
    public class mlibMachineStatus implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM EstatusdeMaquinas WHERE ([EstMaq_id]) = '" + id + "'";
            sql = " INSERT INTO EstatusdeMaquinas([EstMaq_id],[EstMaq_descripcion]) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from EstatusdeMaquinas";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update EstatusdeMaquinas set  EstMaq_descripcion= '" + Description + "'WHERE EstMaq_id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM EstatusdeMaquinas WHERE EstMaq_id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Cedula de producto
    public class mlibProductCertificate implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM CedulaProducto WHERE (CedPro_Id) = '" + id + "'";
            sql = " INSERT INTO CedulaProducto(CedPro_Id,CedPro_Descrip, CedPro_Producto, CedPro_Unidad, CedPro_Duracion, CedPro_DuracionHoraDias, CedPro_Cantidad, CedPro_Fecha) VALUES ('" + id + " ', '" + Description + "', ?, ?, ?, ?, ?, ?)";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select CedPro_Id, CedPro_Descrip, CedPro_Producto, CedPro_Unidad, CedPro_Duracion, CedPro_DuracionHoraDias, CedPro_Cantidad, CedPro_Fecha from CedulaProducto";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update CedulaProducto set  CedPro_Descrip = '" + Description + "'WHERE CedPro_Id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM CedulaProducto WHERE CedPro_Id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Orden de Producto
    public class mlibProductOrder implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM OrdProd WHERE (OrdProd_Cod) = '" + id + "'";
            sql = " INSERT INTO OrdProd(OrdProd_Cod,OrdProd_Desc) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select OrdProd_Cod, OrdProd_Desc, OrdProd_UniOrd, OrdProd_Canpt from OrdProd";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update OrdProd set  OrdProd_Desc = '" + Description + "'WHERE OrdProd_Cod = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM OrdProd WHERE OrdProd_Cod = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Tareas
    public class mlibTask implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM Tareas WHERE (Tareas_Id) = '" + id + "'";
            sql = " INSERT INTO Tareas(Tareas_Id, Tareas_Descripcion) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from Tareas";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = "Update Tareas set  Tareas_Descripcion = '" + Description + "'WHERE Tareas_Id = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM Tareas WHERE Tareas_Id = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }
    }

//Cedula de Artuculos\
    public class mlibCedArticles implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM CedulaArticulos WHERE (CedArt_CedulaID) = '" + id + "'";
            sql = " INSERT INTO CedulaArticulos(CedArt_CedulaID,CedArt_ArticuloId) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select CedArt_CedulaID, CedArt_ArticuloId, CedArt_CodUnidad, CedArt_CantUnidad from CedulaArticulos";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update CedulaArticulos set  CedArt_ArticuloId = '" + Description + "'WHERE CedArt_CedulaID = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM CedulaArticulos WHERE CedArt_CedulaID = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }

    }

//Cedula de Gastos de Fabrica
    public class mlibCedMachineExpenses implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM Cedula_GastosFabrica WHERE (cedula_GastFabId) = '" + id + "'";
            sql = " INSERT INTO Cedula_GastosFabrica(cedula_GastFabId,cedula_CedulaID) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select cedula_GastFabId, cedula_CedulaID from Cedula_GastosFabrica";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update Cedula_GastosFabrica set  cedula_CedulaID = '" + Description + "'WHERE cedula_GastFabId = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM Cedula_GastosFabrica WHERE cedula_GastFabId = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }

    }

//Cedula de Perfil de Empleado
    public class mlibCedEmployeeProfile implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM CedulaTareas WHERE (CedTarea_IdCedProd) = '" + id + "'";
            sql = " INSERT INTO CedulaTareas(CedTarea_IdCedProd,CedTarea_IdTarea) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select cedula_CedulaID, cedula_perfilID from Cedula_PerfilEmp";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update CedulaTareas set  CedTarea_IdTarea = '" + Description + "'WHERE CedTarea_IdCedProd = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM CedulaTareas WHERE CedTarea_IdCedProd = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }

    }

//Cedula de Tareas
    public class mlibCedTask implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM CedulaTareas WHERE (CedTarea_IdCedProd) = '" + id + "'";
            sql = " INSERT INTO CedulaTareas(CedTarea_IdCedProd,CedTarea_IdTarea) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "SELECT * FROM CedulaTareas";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update CedulaTareas set  CedTarea_IdTarea = '" + Description + "'WHERE CedTarea_IdCedProd = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM CedulaTareas WHERE CedTarea_IdCedProd = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }

    }

//Tareas de Maquinas
    public class mlibTaskMachine implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM TareasMaquinas WHERE (TareasMaq_TareaId) = '" + id + "'";
            sql = " INSERT INTO TareasMaquinas(TareasMaq_TareaId,TareasMaq_MaqId) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from TareasMaquinas";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update TareasMaquinas set  TareasMaq_MaqId = '" + Description + "'WHERE TareasMaq_TareaId = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM TareasMaquinas WHERE TareasMaq_TareaId = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }

    }

//Tareas de Atributos
    public class mlibTaskAttributes implements Interface {

        @Override
        public String create(String id, String Description) {
            consulta = "SELECT 1 FROM TareasMaquinas WHERE (TareasAtrib_TareaId) = '" + id + "'";
            sql = " INSERT INTO TareasMaquinas(TareasAtrib_TareaId,TareasMaq_MaqId) VALUES ('" + id + " ', '" + Description + "')";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Val_Data = "Existe";
                }
                if (!"Existe".equals(Val_Data)) {
                    try {
                        con = DriverManager.getConnection(config.getConnectionstr());
                        Statement st = con.createStatement();
                        st.executeUpdate(sql);
                        Val_Data = "Registrado";
                        con.close();
                    } catch (SQLException ex) {
                        System.err.println(ex);
                    }
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }

            return Val_Data;
        }

        @Override
        public ArrayList<Object[]> read() {
            ArrayList<Object[]> data = new ArrayList<>();
            try {
                String sql = "select * from TareasAtributos";
                con = DriverManager.getConnection(config.getConnectionstr());
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                rsmd = rs.getMetaData();

                while (rs.next()) {

                    Object[] fila = new Object[rsmd.getColumnCount()];

                    for (int i = 0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }
                    data.add(fila);
                }
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Mlib.class.getName()).log(Level.SEVERE, null, ex);
            }
            return data;
        }

        @Override
        public String update(String id, String Description) {
            sql = " Update TareasAtributos set  TareasAtrib_TareaId = '" + Description + "'WHERE TareasAtrib_TareaId = '" + id + "' ";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return null;
        }

        @Override
        public String delete(String id) {
            sql = "DELETE FROM TareasAtributos WHERE TareasAtrib_TareaId = '" + id + "'";
            try {
                con = DriverManager.getConnection(config.getConnectionstr());
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                Val_Data = "eliminar";
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                Val_Data = "no eliminar";
            }
            return Val_Data;
        }

        @Override
        public String search() {
            return null;
        }

    }
    
    //prueba valerie VERIFICAR 
    public class mlibinventory implements Interface{

        @Override
        public String create(String id, String Description) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ArrayList<Object[]> read() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String update(String id, String Description) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String delete(String id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String search() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
