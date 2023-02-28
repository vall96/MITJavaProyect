/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Background;
import Model.Mlib;
import Model.Mvar;
import View.Articles;
import View.Attributes;
import View.ConsultArticles;
import View.ConsultAttribute;
import View.ConsultEmployeeProfile;
import View.ConsultExpenseInquiry;
import View.ConsultHomework;
import View.ConsultMachine;
import View.ConsultMachineFault;
import View.ConsultProductCertificate;
import View.ConsultProductOrder;
import View.ConsultStatus;
import View.EmployeeProfile;
import View.MachineExpenses;
import View.MachineFaults;
import View.MachineStatus;
import View.Machines;
import View.ProductCertificate;
import View.ProductOrder;
import View.Production;
import View.Task;
import View.Inventory;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

/**
 *
 * @author hcorrea
 */
public class Controller {

    public static String Codigo, Descripcion, Sueldo;
    Mlib mlib;
    Mvar mvar;
    ArrayList<Object[]> data;
    DefaultTableModel model, model1;
    TableRowSorter trs;

    public Controller() {
        mlib = new Mlib();
        mvar = new Mvar();
        data = new ArrayList<>();
        trs = new TableRowSorter<>(model);
    }

    public class articles implements ActionListener, MouseListener, KeyListener {

        Articles articles;
        ConsultArticles consultArticles;
        Mlib.mlibArticles articles1;
        String[] colum = {"Código", "Descripcion", "Unidad"};

        public articles() {
            consultArticles = new ConsultArticles();
            articles = new Articles();
            articles1 = mlib.new mlibArticles();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            articles.setTitle("Articulos");
            articles.getBtnAdd().addActionListener(this);
            articles.getBtnCancel().addActionListener(this);
            articles.getBtnConsult().addActionListener(this);
            articles.getBtnConsult1().addActionListener(this);
            articles.getBtnConsult2().addActionListener(this);
            articles.getBtnDelete().addActionListener(this);
            articles.getBtnEdit().addActionListener(this);
            articles.getBtnSave().addActionListener(this);
            articles.getBtnSearch().addActionListener(this);
            articles.getTxtDescription().addActionListener(this);
            articles.getCodigo5().addActionListener(this);
            articles.getCodigo6().addActionListener(this);
            articles.getCodigo7().addActionListener(this);
            articles.getjTextField4().addActionListener(this);
            articles.getjTextField5().addActionListener(this);
            articles.getjTextField6().addActionListener(this);
            articles.getjTextField7().addActionListener(this);
            articles.getjTextField8().addActionListener(this);
            articles.getjCheckBox1().addActionListener(this);
            articles.getjCheckBox2().addActionListener(this);
            articles.getjComboBox2().addActionListener(this);
            articles.getjTable1().addMouseListener(this);
            articles.getjTable3().addMouseListener(this);
            consultArticles.getBtnExit().addActionListener(this);
            consultArticles.getBtnAccept().addActionListener(this);
            consultArticles.getBtnSearch().addActionListener(this);
            consultArticles.getTxtCode().addActionListener(this);
            consultArticles.getTxtDescription().addActionListener(this);
            consultArticles.getTxtDescription().addKeyListener(this);
            consultArticles.getTblConsult().addMouseListener(this);
            Production.getJdpEscritorio().add(articles);
            articles.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(articles.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultArticles);
                consultArticles.setTitle("Consulta de Articulos");
                loadTable();
                consultArticles.setVisible(true);
                articles.dispose();
            }

            if (e.getSource().equals(articles.getBtnAdd())) {
                articles.getBtnSave().setEnabled(true);

            }

            if (e.getSource().equals(articles.getBtnEdit())) {
                articles.getTxtCode().setEditable(false);

            }

            if (e.getSource().equals(articles.getBtnSave())) {
                if (articles.getTxtCode().getText().isEmpty() || articles.getTxtDescription().getText().isEmpty()) {
                    articles.getLblValidate().setText("Los campos no pueden estar vacios.");
                } else if (articles.getTxtCode().getText().equals(articles.getTxtCode().getText())) {
                    articles1.update(articles.getTxtCode().getText().trim(), articles.getTxtDescription().getText().trim());
                    articles.getLblValidate().setText("Cambio realizado.");
                } else if (!articles.getTxtCode().getText().isEmpty() & !articles.getTxtDescription().getText().isEmpty()) {
                    articles1.create(articles.getTxtCode().getText(), articles.getTxtDescription().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        articles.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        articles.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    articles.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(articles.getBtnDelete())) {
                articles1.delete(articles.getTxtCode().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    articles.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    articles.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }
                articles.getLblValidate().setText("Eliminación exitosa.");
            }

            if (e.getSource().equals(articles.getBtnCancel())) {
                articles.getTxtCode().setEditable(true);

            }

            if (e.getSource().equals(consultArticles.getBtnExit())) {
                Production.getJdpEscritorio().add(articles);
                articles.setVisible(true);
                consultArticles.dispose();
            }

            if (e.getSource().equals(consultArticles.getBtnAccept())) {
                Codigo = consultArticles.getTxtCode().getText();
                Descripcion = consultArticles.getTxtDescription().getText();
                Production.getJdpEscritorio().add(articles);
                articles.getTxtCode().setText(Codigo);
                articles.getTxtDescription().setText(Descripcion);
                articles.getTxtCode().setText(Codigo);
                articles.getTxtDescription().setText(Descripcion);
                articles.getLblValidate().setText("");
                articles.setVisible(true);
                consultArticles.dispose();
            }

        }

///
        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultArticles.getTxtCode().getText();
            Descripcion = consultArticles.getTxtDescription().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(articles);
                articles.getTxtCode().setText(Codigo);
                articles.getTxtDescription().setText(Descripcion);
                articles.getTxtCode().setText(Codigo);
                articles.getTxtDescription().setText(Descripcion);
                articles.getLblValidate().setText("");
                articles.setVisible(true);
                consultArticles.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultArticles.getTxtCode().setText(consultArticles.getTblConsult().getValueAt(consultArticles.getTblConsult().getSelectedRow(), 0).toString());
            consultArticles.getTxtDescription().setText(consultArticles.getTblConsult().getValueAt(consultArticles.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultArticles.getTxtDescription().getText(), 1));
            consultArticles.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(3);
            data = articles1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultArticles.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultArticles.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }

    }

    public class attributes implements ActionListener, MouseListener, KeyListener {

        Attributes attributes;
        ConsultAttribute consultAttribute;
        Mlib.mlibAttributes attributes1;
        String[] colum = {"Código", "Descripcion"};

        public attributes() {
            attributes = new Attributes();
            consultAttribute = new ConsultAttribute();
            attributes1 = mlib.new mlibAttributes();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            attributes.setTitle("Atributos");
            Production.getJdpEscritorio().add(attributes);
            attributes.setVisible(true);
            attributes.getBtnAdd().addActionListener(this);
            attributes.getBtnCancel().addActionListener(this);
            attributes.getBtnConsult().addActionListener(this);
            attributes.getBtnDelete().addActionListener(this);
            attributes.getBtnEdit().addActionListener(this);
  
            attributes.getBtnSave().addActionListener(this);
            attributes.getBtnSearch().addActionListener(this);
            attributes.getTxtCode().addActionListener(this);
            attributes.getTxtCodeGen().addActionListener(this);
            attributes.getTxtDescripGen().addActionListener(this);
            attributes.getTxtDescription().addActionListener(this);
            consultAttribute.getBtnAccept().addActionListener(this);
            consultAttribute.getBtnExit().addActionListener(this);
            consultAttribute.getBtnSearch1().addActionListener(this);
            consultAttribute.getTxtCode2().addActionListener(this);
            consultAttribute.getTxtDescription2().addActionListener(this);
            consultAttribute.getTblConsult().addMouseListener(this);
        }
///

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(attributes.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultAttribute);
                consultAttribute.setTitle("Consulta de Atributos");
                loadTable();
                consultAttribute.setVisible(true);
                attributes.dispose();
            }

         

            if (e.getSource().equals(attributes.getBtnAdd())) {
                attributes.getBtnSave().setEnabled(true);
            }

            if (e.getSource().equals(attributes.getBtnEdit())) {
                attributes.getTxtCodeGen().setEditable(false);

            }

            if (e.getSource().equals(attributes.getBtnSave())) {
                if (attributes.getTxtCodeGen().getText().isEmpty() || attributes.getTxtDescripGen().getText().isEmpty()) {
                    attributes.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (attributes.getTxtCodeGen().getText().equals(attributes.getTxtCode().getText())) {
                    attributes1.update(attributes.getTxtCodeGen().getText().trim(), attributes.getTxtDescripGen().getText().trim());
                    attributes.getLblValidate().setText("Cambio realizado.");
                } else if (!attributes.getTxtCodeGen().getText().isEmpty() & !attributes.getTxtDescripGen().getText().isEmpty()) {

                    attributes1.create(attributes.getTxtCodeGen().getText(), attributes.getTxtDescripGen().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        attributes.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        attributes.getLblValidate().setText("Registro exitoso.");
                    }

                } else {
                    attributes.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(attributes.getBtnDelete())) {
                attributes1.delete(attributes.getTxtCodeGen().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    attributes.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    attributes.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }
            }

            if (e.getSource().equals(attributes.getBtnCancel())) {
                attributes.getTxtCodeGen().setEditable(true);

            }

            if (e.getSource().equals(consultAttribute.getBtnExit())) {

                Production.getJdpEscritorio().add(attributes);
                attributes.setVisible(true);
                consultAttribute.dispose();
            }

            if (e.getSource().equals(consultAttribute.getBtnAccept())) {
                Codigo = consultAttribute.getTxtCode2().getText();
                Descripcion = consultAttribute.getTxtDescription2().getText();
                Production.getJdpEscritorio().add(attributes);
                attributes.getTxtCode().setText(Codigo);
                attributes.getTxtDescription().setText(Descripcion);
                attributes.getTxtCodeGen().setText(Codigo);
                attributes.getTxtDescripGen().setText(Descripcion);
                attributes.getLblValidate().setText("");
                attributes.setVisible(true);
                consultAttribute.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultAttribute.getTxtCode2().getText();
            Descripcion = consultAttribute.getTxtDescription2().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(attributes);
                attributes.getTxtCode().setText(Codigo);
                attributes.getTxtDescription().setText(Descripcion);
                attributes.getTxtCodeGen().setText(Codigo);
                attributes.getTxtDescripGen().setText(Descripcion);
                attributes.getLblValidate().setText("");
                attributes.setVisible(true);
                consultAttribute.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultAttribute.getTxtCode2().setText(consultAttribute.getTblConsult().getValueAt(consultAttribute.getTblConsult().getSelectedRow(), 0).toString());
            consultAttribute.getTxtDescription2().setText(consultAttribute.getTblConsult().getValueAt(consultAttribute.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultAttribute.getTxtDescription2().getText(), 1));
            consultAttribute.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(2);
            data = attributes1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultAttribute.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultAttribute.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }

    public class employeeProfile implements ActionListener, MouseListener, KeyListener {

        EmployeeProfile employeeProfile;
        ConsultEmployeeProfile consultEmployeeProfile;
        Mlib.mlibEmployeeProfile emProfile1;
        String[] colum = {"Código", "Descripcion"};

        public employeeProfile() {
            employeeProfile = new EmployeeProfile();
            consultEmployeeProfile = new ConsultEmployeeProfile();
            emProfile1 = mlib.new mlibEmployeeProfile();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            employeeProfile.setTitle("Perfil de Empleados");
            Production.getJdpEscritorio().add(employeeProfile);
            employeeProfile.setVisible(true);
            employeeProfile.getBtnAdd().addActionListener(this);
            employeeProfile.getBtnCancel().addActionListener(this);
            employeeProfile.getBtnConsult().addActionListener(this);
            employeeProfile.getBtnDelete().addActionListener(this);
            employeeProfile.getBtnEdit().addActionListener(this);
          
            employeeProfile.getBtnSave().addActionListener(this);
            employeeProfile.getBtnSearch().addActionListener(this);
            consultEmployeeProfile.getBtnAccept().addActionListener(this);
            consultEmployeeProfile.getBtnExit().addActionListener(this);
            consultEmployeeProfile.getBtnSearch().addActionListener(this);
            consultEmployeeProfile.getTblConsult().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(employeeProfile.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultEmployeeProfile);
                consultEmployeeProfile.setTitle("Consulta Perfil de Empleados");
                loadTable();
                consultEmployeeProfile.setVisible(true);
                employeeProfile.dispose();
            }
           

            if (e.getSource().equals(employeeProfile.getBtnAdd())) {
                employeeProfile.getBtnSave().setEnabled(true);
            }

            if (e.getSource().equals(employeeProfile.getBtnEdit())) {
                employeeProfile.getTxtCodeGen().setEditable(false);

            }
///nota me falta enviar el sueldo en create y update
            if (e.getSource().equals(employeeProfile.getBtnSave())) {
                if (employeeProfile.getTxtCodeGen().getText().isEmpty() || employeeProfile.getTxtDescripGen().getText().isEmpty()) {
                    employeeProfile.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (employeeProfile.getTxtCodeGen().getText().equals(employeeProfile.getTxtCode().getText())) {
                    emProfile1.update(employeeProfile.getTxtCodeGen().getText().trim(), employeeProfile.getTxtDescripGen().getText().trim());
                    employeeProfile.getLblValidate().setText("Cambio realizado.");
                } else if (!employeeProfile.getTxtCodeGen().getText().isEmpty() & !employeeProfile.getTxtDescripGen().getText().isEmpty()) {
                    emProfile1.create(employeeProfile.getTxtCodeGen().getText().trim(), employeeProfile.getTxtDescripGen().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        employeeProfile.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        employeeProfile.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    employeeProfile.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(employeeProfile.getBtnDelete())) {
                emProfile1.delete(employeeProfile.getTxtCode().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    employeeProfile.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    employeeProfile.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }
            }

            if (e.getSource().equals(employeeProfile.getBtnCancel())) {
                employeeProfile.getTxtCodeGen().setEditable(true);

            }

            if (e.getSource().equals(consultEmployeeProfile.getBtnExit())) {
                Production.getJdpEscritorio().add(employeeProfile);
                employeeProfile.setVisible(true);
                consultEmployeeProfile.dispose();
            }
            if (e.getSource().equals(consultEmployeeProfile.getBtnAccept())) {
                Codigo = consultEmployeeProfile.getTxtCode().getText();
                Descripcion = consultEmployeeProfile.getTxtDescription().getText();
                Sueldo = consultEmployeeProfile.getTblConsult().getValueAt(consultEmployeeProfile.getTblConsult().getSelectedRow(), 2).toString();
                Production.getJdpEscritorio().add(employeeProfile);
                employeeProfile.getTxtCode().setText(Codigo);
                employeeProfile.getTxtDescription().setText(Descripcion);
                employeeProfile.getTxtCodeGen().setText(Codigo);
                employeeProfile.getTxtDescripGen().setText(Descripcion);
                employeeProfile.getTxtDescripGen1().setText(Sueldo);
                employeeProfile.getLblValidate().setText("");
                employeeProfile.setVisible(true);
                consultEmployeeProfile.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultEmployeeProfile.getTxtCode().getText();
            Descripcion = consultEmployeeProfile.getTxtDescription().getText();
            Sueldo = consultEmployeeProfile.getTblConsult().getValueAt(consultEmployeeProfile.getTblConsult().getSelectedRow(), 2).toString();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(employeeProfile);
                employeeProfile.getTxtCode().setText(Codigo);
                employeeProfile.getTxtDescription().setText(Descripcion);
                employeeProfile.getTxtCodeGen().setText(Codigo);
                employeeProfile.getTxtDescripGen().setText(Descripcion);
                employeeProfile.getTxtDescripGen1().setText(Sueldo);
                employeeProfile.getLblValidate().setText("");
                employeeProfile.setVisible(true);
                consultEmployeeProfile.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            consultEmployeeProfile.getTxtCode().setText(consultEmployeeProfile.getTblConsult().getValueAt(consultEmployeeProfile.getTblConsult().getSelectedRow(), 0).toString());
            consultEmployeeProfile.getTxtDescription().setText(consultEmployeeProfile.getTblConsult().getValueAt(consultEmployeeProfile.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultEmployeeProfile.getTxtDescription().getText(), 1));
            consultEmployeeProfile.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(2);
            data = emProfile1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultEmployeeProfile.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultEmployeeProfile.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }

    public class machine implements ActionListener, MouseListener, KeyListener {

        Machines machines;
        ConsultMachine consultMachine;
        Mlib.mlibMachine machine1;
        String[] colum = {"Código", "Descripcion"};

        public machine() {
            machines = new Machines();
            consultMachine = new ConsultMachine();
            machine1 = mlib.new mlibMachine();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            machines.setTitle("Maquinas");
            Production.getJdpEscritorio().add(machines);
            machines.setVisible(true);
            machines.getBtnAdd().addActionListener(this);
            machines.getBtnCancel().addActionListener(this);
            machines.getBtnConsult().addActionListener(this);
            machines.getBtnDelete().addActionListener(this);
            machines.getBtnEdit().addActionListener(this);
         
            machines.getBtnSave().addActionListener(this);
            machines.getBtnSearch().addActionListener(this);
            machines.getTxtCode().addActionListener(this);
            machines.getTxtCodeGen().addActionListener(this);
            machines.getTxtDescripGen().addActionListener(this);
            machines.getTxtDescription().addActionListener(this);
            consultMachine.getBtnExit().addActionListener(this);
            consultMachine.getBtnSearch().addActionListener(this);
            consultMachine.getBtnAccept().addActionListener(this);
            consultMachine.getTxtCode1().addActionListener(this);
            consultMachine.getTxtDescription1().addActionListener(this);
            consultMachine.getTblConsult().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(machines.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultMachine);
                consultMachine.setTitle("Consulta de Maquinas");
                loadTable();
                consultMachine.setVisible(true);
                machines.dispose();
            }
           

            if (e.getSource().equals(machines.getBtnAdd())) {
                machines.getBtnSave().setEnabled(true);
            }

            if (e.getSource().equals(machines.getBtnEdit())) {
                machines.getTxtCodeGen().setEditable(false);

            }

            if (e.getSource().equals(machines.getBtnSave())) {
                if (machines.getTxtCodeGen().getText().isEmpty() || machines.getTxtDescripGen().getText().isEmpty()) {
                    machines.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (machines.getTxtCodeGen().getText().equals(machines.getTxtCode().getText())) {
                    machine1.update(machines.getTxtCodeGen().getText().trim(), machines.getTxtDescripGen().getText().trim());
                    machines.getLblValidate().setText("Cambio realizado.");
                } else if (!machines.getTxtCodeGen().getText().isEmpty() & !machines.getTxtDescripGen().getText().isEmpty()) {
                    machine1.create(machines.getTxtCodeGen().getText(), machines.getTxtDescripGen().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        machines.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        machines.getLblValidate().setText("Registro exitoso.");
                    }

                } else {
                    machines.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(machines.getBtnDelete())) {

                machine1.delete(machines.getTxtCodeGen().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    machines.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    machines.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }

            }

            if (e.getSource().equals(machines.getBtnCancel())) {
                machines.getTxtCodeGen().setEditable(true);
            }

            if (e.getSource().equals(consultMachine.getBtnExit())) {
                Production.getJdpEscritorio().add(machines);
                machines.setVisible(true);
                machines.toFront();
                consultMachine.dispose();
            }

            if (e.getSource().equals(consultMachine.getBtnAccept())) {
                machines.getTxtCodeGen().setEditable(true);
                consultMachine.getTxtCode1().getText();
                consultMachine.getTxtDescription1().getText();
                Production.getJdpEscritorio().add(machines);
                machines.getTxtCode().setText(Codigo);
                machines.getTxtDescription().setText(Descripcion);
                machines.getTxtCodeGen().setText(Codigo);
                machines.getTxtDescripGen().setText(Descripcion);
                machines.getLblValidate().setText("");
                machines.setVisible(true);
                consultMachine.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultMachine.getTxtCode1().getText();
            Descripcion = consultMachine.getTxtDescription1().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(machines);
                machines.getTxtCode().setText(Codigo);
                machines.getTxtDescription().setText(Descripcion);
                machines.getTxtCodeGen().setText(Codigo);
                machines.getTxtDescripGen().setText(Descripcion);
                machines.getLblValidate().setText("");
                machines.setVisible(true);
                consultMachine.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultMachine.getTxtCode1().setText(consultMachine.getTblConsult().getValueAt(consultMachine.getTblConsult().getSelectedRow(), 0).toString());
            consultMachine.getTxtDescription1().setText(consultMachine.getTblConsult().getValueAt(consultMachine.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultMachine.getTxtDescription1().getText(), 1));
            consultMachine.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(2);
            data = machine1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultMachine.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultMachine.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }

    public class machineExpenses implements ActionListener, MouseListener, KeyListener {

        MachineExpenses machineExpenses;
        ConsultExpenseInquiry consultExpenseInquiry;
        Mlib.mlibMachineExpenses maExpenses1;
        String[] colum = {"Código", "Descripcion"};

        public machineExpenses() {
            machineExpenses = new MachineExpenses();
            consultExpenseInquiry = new ConsultExpenseInquiry();
            maExpenses1 = mlib.new mlibMachineExpenses();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            machineExpenses.setTitle("Gastos de Fabrica");
            Production.getJdpEscritorio().add(machineExpenses);
            machineExpenses.setVisible(true);
            machineExpenses.getBtnAdd().addActionListener(this);
            machineExpenses.getBtnCancel().addActionListener(this);
            machineExpenses.getBtnConsult().addActionListener(this);
            machineExpenses.getBtnDelete().addActionListener(this);
            machineExpenses.getBtnEdit().addActionListener(this);
          
            machineExpenses.getBtnSave().addActionListener(this);
            machineExpenses.getBtnSearch().addActionListener(this);
            machineExpenses.getTxtCode().addActionListener(this);
            machineExpenses.getTxtCodeGen().addActionListener(this);
            machineExpenses.getTxtDescripGen().addActionListener(this);
            machineExpenses.getTxtDescription().addActionListener(this);
            consultExpenseInquiry.getBtnAccept().addActionListener(this);
            consultExpenseInquiry.getBtnExit().addActionListener(this);
            consultExpenseInquiry.getBtnSearch().addActionListener(this);
            consultExpenseInquiry.getTxtCode1().addActionListener(this);
            consultExpenseInquiry.getTxtDescription1().addActionListener(this);
            consultExpenseInquiry.getTblConsult().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(machineExpenses.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultExpenseInquiry);
                consultExpenseInquiry.setTitle("Consulta del Gasto de Fabrica");
                loadTable();
                consultExpenseInquiry.setVisible(true);
                machineExpenses.dispose();
            }
            

            if (e.getSource().equals(machineExpenses.getBtnAdd())) {
                machineExpenses.getBtnSave().setEnabled(true);
            }

            if (e.getSource().equals(machineExpenses.getBtnEdit())) {
                machineExpenses.getTxtCodeGen().setEditable(false);
            }

            if (e.getSource().equals(machineExpenses.getBtnSave())) {
                if (machineExpenses.getTxtCodeGen().getText().isEmpty() || machineExpenses.getTxtDescripGen().getText().isEmpty()) {
                    machineExpenses.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (machineExpenses.getTxtCodeGen().getText().equals(machineExpenses.getTxtCode().getText())) {
                    maExpenses1.update(machineExpenses.getTxtCodeGen().getText().trim(), machineExpenses.getTxtDescripGen().getText().trim());
                    machineExpenses.getLblValidate().setText("Cambio realizado.");
                } else if (!machineExpenses.getTxtCodeGen().getText().isEmpty() & !machineExpenses.getTxtDescripGen().getText().isEmpty()) {
                    maExpenses1.create(machineExpenses.getTxtCodeGen().getText(), machineExpenses.getTxtDescripGen().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        machineExpenses.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        machineExpenses.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    machineExpenses.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(machineExpenses.getBtnDelete())) {
                maExpenses1.delete(machineExpenses.getTxtCodeGen().getText());
                machineExpenses.getLblValidate().setText("Eliminación exitosa.");
            }

            if (e.getSource().equals(machineExpenses.getBtnCancel())) {
                machineExpenses.getTxtCodeGen().setEditable(true);
            }

            if (e.getSource().equals(consultExpenseInquiry.getBtnExit())) {
                Production.getJdpEscritorio().add(machineExpenses);
                machineExpenses.setVisible(true);
                consultExpenseInquiry.dispose();
            }

            if (e.getSource().equals(consultExpenseInquiry.getBtnAccept())) {
                Codigo = consultExpenseInquiry.getTxtCode1().getText();
                Descripcion = consultExpenseInquiry.getTxtDescription1().getText();
                Production.getJdpEscritorio().add(machineExpenses);
                machineExpenses.getTxtCode().setText(Codigo);
                machineExpenses.getTxtDescription().setText(Descripcion);
                machineExpenses.getTxtCodeGen().setText(Codigo);
                machineExpenses.getTxtDescripGen().setText(Descripcion);
                machineExpenses.getLblValidate().setText("");
                machineExpenses.setVisible(true);
                consultExpenseInquiry.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultExpenseInquiry.getTxtCode1().getText();
            Descripcion = consultExpenseInquiry.getTxtDescription1().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(machineExpenses);
                machineExpenses.getTxtCode().setText(Codigo);
                machineExpenses.getTxtDescription().setText(Descripcion);
                machineExpenses.getTxtCodeGen().setText(Codigo);
                machineExpenses.getTxtDescripGen().setText(Descripcion);
                machineExpenses.getLblValidate().setText("");
                machineExpenses.setVisible(true);
                consultExpenseInquiry.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultExpenseInquiry.getTxtCode1().setText(consultExpenseInquiry.getTblConsult().getValueAt(consultExpenseInquiry.getTblConsult().getSelectedRow(), 0).toString());
            consultExpenseInquiry.getTxtDescription1().setText(consultExpenseInquiry.getTblConsult().getValueAt(consultExpenseInquiry.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultExpenseInquiry.getTxtDescription1().getText(), 1));
            consultExpenseInquiry.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(2);
            data = maExpenses1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultExpenseInquiry.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultExpenseInquiry.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }

    public class machineFaults implements ActionListener, MouseListener, KeyListener {

        MachineFaults machineFaults;
        ConsultMachineFault consultMachineFault;
        Mlib.mlibMachineFaults maFaults1;
        String[] colum = {"Código", "Descripcion"};

        public machineFaults() {
            machineFaults = new MachineFaults();
            consultMachineFault = new ConsultMachineFault();
            maFaults1 = mlib.new mlibMachineFaults();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            machineFaults.setTitle("Falla de Maquina");
            Production.getJdpEscritorio().add(machineFaults);
            machineFaults.setVisible(true);
            machineFaults.getBtnAdd().addActionListener(this);
            machineFaults.getBtnCancel().addActionListener(this);
            machineFaults.getBtnConsult().addActionListener(this);
            machineFaults.getBtnDelete().addActionListener(this);
            machineFaults.getBtnEdit().addActionListener(this);
           
            machineFaults.getBtnSave().addActionListener(this);
            machineFaults.getBtnSearch().addActionListener(this);
            machineFaults.getTxtCode().addActionListener(this);
            machineFaults.getTxtCodeGen().addActionListener(this);
            machineFaults.getTxtDescripGen().addActionListener(this);
            machineFaults.getTxtDescription().addActionListener(this);
            consultMachineFault.getBtnAccept().addActionListener(this);
            consultMachineFault.getBtnExit().addActionListener(this);
            consultMachineFault.getBtnSearch().addActionListener(this);
            consultMachineFault.getTxtCode1().addActionListener(this);
            consultMachineFault.getTxtDescription1().addActionListener(this);
            consultMachineFault.getTblConsult().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(machineFaults.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultMachineFault);
                consultMachineFault.setTitle("Consulta Falla de Maquina");
                loadTable();
                consultMachineFault.setVisible(true);
                machineFaults.dispose();
            }
            

            if (e.getSource().equals(machineFaults.getBtnAdd())) {
                machineFaults.getBtnSave().setEnabled(true);

            }

            if (e.getSource().equals(machineFaults.getBtnEdit())) {
                machineFaults.getTxtCodeGen().setEditable(false);

            }

            if (e.getSource().equals(machineFaults.getBtnSave())) {
                if (machineFaults.getTxtCodeGen().getText().isEmpty() || machineFaults.getTxtDescripGen().getText().isEmpty()) {
                    machineFaults.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (machineFaults.getTxtCodeGen().getText().equals(machineFaults.getTxtCode().getText())) {
                    maFaults1.update(machineFaults.getTxtCodeGen().getText().trim(), machineFaults.getTxtDescripGen().getText().trim());
                    machineFaults.getLblValidate().setText("Cambio realizado.");
                } else if (!machineFaults.getTxtCodeGen().getText().isEmpty() & !machineFaults.getTxtDescripGen().getText().isEmpty()) {
                    maFaults1.create(machineFaults.getTxtCodeGen().getText(), machineFaults.getTxtDescripGen().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        machineFaults.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        machineFaults.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    machineFaults.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(machineFaults.getBtnDelete())) {
                maFaults1.delete(machineFaults.getTxtCodeGen().getText());
                machineFaults.getLblValidate().setText("Eliminación exitosa.");
            }

            if (e.getSource().equals(machineFaults.getBtnCancel())) {
                machineFaults.getTxtCodeGen().setEditable(true);

            }

            if (e.getSource().equals(consultMachineFault.getBtnExit())) {
                Production.getJdpEscritorio().add(machineFaults);
                machineFaults.setVisible(true);
                machineFaults.toFront();
                consultMachineFault.dispose();
            }

            if (e.getSource().equals(consultMachineFault.getBtnAccept())) {
                machineFaults.getTxtCodeGen().setEditable(true);
                Codigo = consultMachineFault.getTxtCode1().getText();
                Descripcion = consultMachineFault.getTxtDescription1().getText();
                Production.getJdpEscritorio().add(machineFaults);
                machineFaults.getTxtCode().setText(Codigo);
                machineFaults.getTxtDescription().setText(Descripcion);
                machineFaults.getTxtCodeGen().setText(Codigo);
                machineFaults.getTxtDescripGen().setText(Descripcion);
                machineFaults.getLblValidate().setText("");
                machineFaults.setVisible(true);
                consultMachineFault.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultMachineFault.getTxtCode1().getText();
            Descripcion = consultMachineFault.getTxtDescription1().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(machineFaults);
                machineFaults.getTxtCode().setText(Codigo);
                machineFaults.getTxtDescription().setText(Descripcion);
                machineFaults.getTxtCodeGen().setText(Codigo);
                machineFaults.getTxtDescripGen().setText(Descripcion);
                machineFaults.getLblValidate().setText("");
                machineFaults.setVisible(true);
                consultMachineFault.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultMachineFault.getTxtCode1().setText(consultMachineFault.getTblConsult().getValueAt(consultMachineFault.getTblConsult().getSelectedRow(), 0).toString());
            consultMachineFault.getTxtDescription1().setText(consultMachineFault.getTblConsult().getValueAt(consultMachineFault.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultMachineFault.getTxtDescription1().getText(), 1));
            consultMachineFault.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(2);
            data = maFaults1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultMachineFault.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultMachineFault.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }

    public class machineStatus implements ActionListener, MouseListener, KeyListener {

        MachineStatus machineStatus;
        ConsultStatus consultStatus;
        Mlib.mlibMachineStatus maStatus1;
        String[] colum = {"Código", "Descripcion"};

        public machineStatus() {
            machineStatus = new MachineStatus();
            consultStatus = new ConsultStatus();
            maStatus1 = mlib.new mlibMachineStatus();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            machineStatus.setTitle("Estatus de Maquina");
            Production.getJdpEscritorio().add(machineStatus);
            machineStatus.setVisible(true);
            machineStatus.getBtnAdd().addActionListener(this);
            machineStatus.getBtnCancel().addActionListener(this);
            machineStatus.getBtnConsult2().addActionListener(this);
            machineStatus.getBtnDelete().addActionListener(this);
            machineStatus.getBtnEdit().addActionListener(this);
         
            machineStatus.getBtnSave().addActionListener(this);
            machineStatus.getBtnSearch2().addActionListener(this);
            machineStatus.getTxtCode2().addActionListener(this);
            machineStatus.getTxtCodeGen().addActionListener(this);
            machineStatus.getTxtDescripGen().addActionListener(this);
            machineStatus.getTxtDescription2().addActionListener(this);
            consultStatus.getBtnAccept().addActionListener(this);
            consultStatus.getBtnExit().addActionListener(this);
            consultStatus.getBtnSearch().addActionListener(this);
            consultStatus.getTxtCode1().addActionListener(this);
            consultStatus.getTxtDescription1().addKeyListener(this);
            consultStatus.getTblConsult().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(machineStatus.getBtnConsult2())) {
                Production.getJdpEscritorio().add(consultStatus);
                consultStatus.setTitle("Consulta de Estatus de Maquina");
                loadTable();
                consultStatus.setVisible(true);
                machineStatus.dispose();
            }


            if (e.getSource().equals(machineStatus.getBtnAdd())) {
                machineStatus.getBtnSave().setEnabled(true);
            }

            if (e.getSource().equals(machineStatus.getBtnEdit())) {
                machineStatus.getTxtCodeGen().setEditable(false);
            }

            if (e.getSource().equals(machineStatus.getBtnSave())) {
                if (machineStatus.getTxtCodeGen().getText().isEmpty() || machineStatus.getTxtDescripGen().getText().isEmpty()) {
                    machineStatus.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (machineStatus.getTxtCodeGen().getText().equals(machineStatus.getTxtCode2().getText())) {
                    maStatus1.update(machineStatus.getTxtCodeGen().getText().trim(), machineStatus.getTxtDescripGen().getText().trim());
                    machineStatus.getLblValidate().setText("Cambio realizado.");
                } else if (!machineStatus.getTxtCodeGen().getText().isEmpty() & !machineStatus.getTxtDescripGen().getText().isEmpty()) {
                    maStatus1.create(machineStatus.getTxtCodeGen().getText().trim(), machineStatus.getTxtDescripGen().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        machineStatus.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        machineStatus.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    machineStatus.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(machineStatus.getBtnDelete())) {
                maStatus1.delete(machineStatus.getTxtCodeGen().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    machineStatus.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    machineStatus.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }

            }

            if (e.getSource().equals(machineStatus.getBtnCancel())) {
                machineStatus.getTxtCodeGen().setEditable(true);
            }

            if (e.getSource().equals(machineStatus.getBtnSearch2())) {
                ///busqueda

            }

            if (e.getSource().equals(consultStatus.getBtnExit())) {
                Production.getJdpEscritorio().add(machineStatus);
                machineStatus.setVisible(true);
                consultStatus.dispose();
            }

            if (e.getSource().equals(consultStatus.getBtnAccept())) {
                machineStatus.getTxtCodeGen().setEditable(true);
                Codigo = consultStatus.getTxtCode1().getText();
                Descripcion = consultStatus.getTxtDescription1().getText();
                Production.getJdpEscritorio().add(machineStatus);
                machineStatus.getTxtCode2().setText(Codigo);
                machineStatus.getTxtDescription2().setText(Descripcion);
                machineStatus.getTxtCodeGen().setText(Codigo);
                machineStatus.getTxtDescripGen().setText(Descripcion);
                machineStatus.getLblValidate().setText("");
                machineStatus.setVisible(true);
                consultStatus.dispose();

            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultStatus.getTxtCode1().getText();
            Descripcion = consultStatus.getTxtDescription1().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(machineStatus);
                machineStatus.getTxtCode2().setText(Codigo);
                machineStatus.getTxtDescription2().setText(Descripcion);
                machineStatus.getTxtCodeGen().setText(Codigo);
                machineStatus.getTxtDescripGen().setText(Descripcion);
                machineStatus.getLblValidate().setText("");
                machineStatus.setVisible(true);
                consultStatus.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultStatus.getTxtCode1().setText(consultStatus.getTblConsult().getValueAt(consultStatus.getTblConsult().getSelectedRow(), 0).toString());
            consultStatus.getTxtDescription1().setText(consultStatus.getTblConsult().getValueAt(consultStatus.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultStatus.getTxtDescription1().getText(), 1));
            consultStatus.getTblConsult().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(2);
            data = maStatus1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultStatus.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultStatus.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }

    public class productCertificate implements ActionListener, MouseListener, KeyListener {

        ProductCertificate productCertificate;
        ConsultProductCertificate consultProductCertificate;
        Mlib.mlibProductCertificate proCertificate1;
        Mlib.mlibCedTask cedTask1;
        Mlib.mlibCedArticles cedArticles1;
        Mlib.mlibCedMachineExpenses cedMaExpenses1;
        Mlib.mlibCedEmployeeProfile cedEmProfile1;

        public productCertificate() {
            productCertificate = new ProductCertificate();
            consultProductCertificate = new ConsultProductCertificate();
            proCertificate1 = mlib.new mlibProductCertificate();
            cedTask1 = mlib.new mlibCedTask();
            cedArticles1 = mlib.new mlibCedArticles();
            cedMaExpenses1 = mlib.new mlibCedMachineExpenses();
            cedEmProfile1 = mlib.new mlibCedEmployeeProfile();
        }

        public void Start() {
            productCertificate.setTitle("Cedula del Producto");
            Production.getJdpEscritorio().add(productCertificate);
            productCertificate.setVisible(true);
            productCertificate.getBtnAdd().addActionListener(this);
            productCertificate.getBtnCancel().addActionListener(this);
            productCertificate.getBtnConsult().addActionListener(this);
            productCertificate.getBtnDelete().addActionListener(this);
            productCertificate.getBtnEdit().addActionListener(this);
            productCertificate.getBtnSave().addActionListener(this);
            productCertificate.getBtnSearch().addActionListener(this);
            productCertificate.getBtnExit().addActionListener(this);
            productCertificate.getTxtCode().addActionListener(this);
            productCertificate.getTxtDescription().addActionListener(this);
            consultProductCertificate.getBtnAccept().addActionListener(this);
            consultProductCertificate.getBtnExit().addActionListener(this);
            consultProductCertificate.getBtnSearch1().addActionListener(this);
            consultProductCertificate.getTxtCode2().addActionListener(this);
            consultProductCertificate.getTxtDescription2().addActionListener(this);
            consultProductCertificate.getTblConsult5().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(productCertificate.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultProductCertificate);
                consultProductCertificate.setTitle("Consulta de Cedula del Producto");
                //tabla
                consultProductCertificate.setVisible(true);
                productCertificate.dispose();
            }
            if (e.getSource().equals(productCertificate.getBtnExit())) {
                productCertificate.dispose();
            }

            if (e.getSource().equals(productCertificate.getBtnAdd())) {
                productCertificate.getBtnSave().setEnabled(true);
            }

            if (e.getSource().equals(productCertificate.getBtnEdit())) {
            }

            if (e.getSource().equals(productCertificate.getBtnSave())) {
                System.out.println("Guardando . . .");
            }

            if (e.getSource().equals(productCertificate.getBtnDelete())) {
                System.out.println("Borrando . . .");
            }

            if (e.getSource().equals(productCertificate.getBtnCancel())) {
            }

            if (e.getSource().equals(consultProductCertificate.getBtnExit())) {
                Production.getJdpEscritorio().add(productCertificate);
                productCertificate.setVisible(true);
                consultProductCertificate.dispose();
            }

            if (e.getSource().equals(consultProductCertificate.getBtnAccept())) {
                Codigo = consultProductCertificate.getTxtCode2().getText();
                Descripcion = consultProductCertificate.getTxtDescription2().getText();
                Production.getJdpEscritorio().add(productCertificate);
                productCertificate.getTxtCode().setText(Codigo);
                productCertificate.getTxtDescription().setText(Descripcion);
                productCertificate.getjTextField1().setText(Codigo);
                productCertificate.getjTextField2().setText(Descripcion);
                productCertificate.setVisible(true);
                consultProductCertificate.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultProductCertificate.getTxtCode2().getText();
            Descripcion = consultProductCertificate.getTxtDescription2().getText();
            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(productCertificate);
                productCertificate.getTxtCode().setText(Codigo);
                productCertificate.getTxtDescription().setText(Descripcion);
                productCertificate.getjTextField1().setText(Codigo);
                productCertificate.getjTextField2().setText(Descripcion);
                productCertificate.setVisible(true);
                consultProductCertificate.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultProductCertificate.getTxtCode2().setText(consultProductCertificate.getTblConsult5().getValueAt(consultProductCertificate.getTblConsult5().getSelectedRow(), 0).toString());
            consultProductCertificate.getTxtDescription2().setText(consultProductCertificate.getTblConsult5().getValueAt(consultProductCertificate.getTblConsult5().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

    public class productOrder implements ActionListener, MouseListener, KeyListener {

        ProductOrder productOrder;
        ConsultProductOrder consultProductOrder;
        ConsultProductCertificate consultProductCertificate;
        Mlib.mlibProductOrder proOrder1;
        Mlib.mlibProductCertificate proCertificate1;
        String[] colum = {"Código", "Descripcion", "Unidad", "Cantidad"};
        String[] colum1 = {"Código", "Descripcion", "Producto", "Unidad", "Duracion", "Dias/Horas", "Cantidad", "Fecha"};

        public productOrder() {
            productOrder = new ProductOrder();
            consultProductOrder = new ConsultProductOrder();
            consultProductCertificate = new ConsultProductCertificate();
            proOrder1 = mlib.new mlibProductOrder();
            proCertificate1 = mlib.new mlibProductCertificate();
            model = new DefaultTableModel(colum, 0);
            model1 = new DefaultTableModel(colum1, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            productOrder.setTitle("Orden de Producto");
            Production.getJdpEscritorio().add(productOrder);
            productOrder.setVisible(true);
            productOrder.getBtnAdd().addActionListener(this);
            productOrder.getBtnConsult().addActionListener(this);
            productOrder.getBtnDelete().addActionListener(this);
            productOrder.getBtnEdit().addActionListener(this);
            productOrder.getBtnSave().addActionListener(this);
            productOrder.getBtnSearch().addActionListener(this);
            productOrder.getBtnExit().addActionListener(this);
            productOrder.getBtnConsult2().addActionListener(this);
            productOrder.getTxtCode().addActionListener(this);
            productOrder.getTxtDescription().addActionListener(this);
            consultProductOrder.getBtnAccept().addActionListener(this);
            consultProductOrder.getBtnExit().addActionListener(this);
            consultProductOrder.getBtnSearch1().addActionListener(this);
            consultProductCertificate.getBtnAccept().addActionListener(this);
            consultProductCertificate.getBtnExit().addActionListener(this);
            consultProductCertificate.getBtnSearch1().addActionListener(this);
            consultProductCertificate.getTxtCode2().addActionListener(this);
            consultProductCertificate.getTxtDescription2().addActionListener(this);
            consultProductCertificate.getTblConsult5().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(productOrder.getBtnConsult())) {

                Production.getJdpEscritorio().add(consultProductOrder);
                consultProductOrder.setTitle("Consulta de Orden del Producto");
                loadTable();
                consultProductOrder.setVisible(true);
                productOrder.dispose();

            }

            if (e.getSource().equals(productOrder.getBtnExit())) {
                productOrder.dispose();
            }

            if (e.getSource().equals(productOrder.getBtnConsult2())) {

                Production.getJdpEscritorio().add(consultProductCertificate);
                consultProductCertificate.setTitle("Consulta de Cedula del Producto");
                loadTable1();
                consultProductCertificate.setVisible(true);
                consultProductCertificate.toFront();
                productOrder.dispose();

            }

            if (e.getSource().equals(consultProductCertificate.getBtnExit())) {
                Production.getJdpEscritorio().add(productOrder);
                productOrder.setVisible(true);
                productOrder.toFront();
                consultProductCertificate.dispose();
            }

            if (e.getSource().equals(productOrder.getBtnAdd())) {

                productOrder.getBtnSave().setEnabled(true);

            }

            if (e.getSource().equals(productOrder.getBtnEdit())) {

            }

            if (e.getSource().equals(productOrder.getBtnSave())) {
                if (productOrder.getTxtCode().getText().isEmpty() || productOrder.getTxtDescription().getText().isEmpty()) {
                    productOrder.getLblValidate().setText("Los campos no pueden estar vacios.");
                } else if (productOrder.getTxtCode().getText().equals(productOrder.getTxtDescription().getText())) {
                    proOrder1.update(productOrder.getTxtCode().getText().trim(), productOrder.getTxtDescription().getText().trim());
                    productOrder.getLblValidate().setText("Cambio realizado");
                } else if (!productOrder.getTxtCode().getText().isEmpty() & !productOrder.getTxtCode().getText().isEmpty()) {
                    proOrder1.create(productOrder.getTxtCode().getText(), productOrder.getTxtDescription().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        productOrder.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        productOrder.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    productOrder.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(productOrder.getBtnDelete())) {
                proOrder1.delete(productOrder.getTxtCode().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    productOrder.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    productOrder.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }

            }

            if (e.getSource().equals(productOrder.getBtnCancel())) {

            }

            if (e.getSource().equals(consultProductOrder.getBtnExit())) {
                Production.getJdpEscritorio().add(productOrder);
                productOrder.setVisible(true);
                productOrder.toFront();
                consultProductOrder.dispose();
            }

            if (e.getSource().equals(consultProductOrder.getBtnAccept())) {

                Codigo = consultProductOrder.getTxtCode2().getText();
                Descripcion = consultProductOrder.getTxtDescription2().getText();
                //los demas campos
                Production.getJdpEscritorio().add(productOrder);
                productOrder.getTxtCode().setText(Codigo);
                productOrder.getTxtDescription().setText(Descripcion);

                productOrder.getLblValidate().setText("");
                productOrder.setVisible(true);
                consultProductOrder.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultProductOrder.getTxtCode2().getText();
            Descripcion = consultProductOrder.getTxtDescription2().getText();

            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(productOrder);
                productOrder.getTxtCode().setText(Codigo);
                productOrder.getTxtDescription().setText(Descripcion);
                productOrder.getLblValidate().setText("");
                productOrder.setVisible(true);
                consultProductOrder.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultProductOrder.getTxtCode2().setText(consultProductOrder.getTblConsult5().getValueAt(consultProductOrder.getTblConsult5().getSelectedRow(), 0).toString());
            consultProductOrder.getTxtDescription2().setText(consultProductOrder.getTblConsult5().getValueAt(consultProductOrder.getTblConsult5().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultProductOrder.getTxtDescription2().getText(), 1));
            consultProductOrder.getTblConsult5().setRowSorter(trs);
            //trs.setRowFilter(RowFilter.regexFilter(consultProductCertificate.getTxtDescription2().getText(), 1));
            //consultProductCertificate.getTblConsult5().setRowSorter(trs);
        }
///

        public void loadTable() {
            model.setColumnCount(4);
            data = proOrder1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultProductOrder.getTblConsult5().setModel(model);
        }
       
        public void loadTable1() {
            model1.setColumnCount(8);
            data = proCertificate1.read();
            data.forEach(obj -> {
                model1.addRow(obj);
            });
            consultProductCertificate.getTblConsult5().setModel(model1);
        }
        public void clearTable() {
            for (int i = 0; i < consultProductOrder.getTblConsult5().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
       
        public void clearTable1() {
            for (int i = 0; i < consultProductCertificate.getTblConsult5().getRowCount(); i++) {
                model1.removeRow(i);
                i = i - 1;
            }
        }
       
    }

    public class production implements ActionListener {

        Production production;
        articles articles;
        attributes attributes;
        employeeProfile employeeProfile;
        machineExpenses machineExpenses;
        machineFaults machineFaults;
        machineStatus machineStatus;
        machine machines;
        productCertificate productCertificate;
        productOrder productOrder;
        task task;
        Background background;

        public production() throws IOException, ClassNotFoundException {
            production = new Production();
            articles = new articles();
            attributes = new attributes();
            employeeProfile = new employeeProfile();
            machineExpenses = new machineExpenses();
            machineFaults = new machineFaults();
            machineStatus = new machineStatus();
            machines = new machine();
            productCertificate = new productCertificate();
            productOrder = new productOrder();
            task = new task();
            background = new Background();
        }

        public void Start() throws IOException {
            production.setTitle("Produccion MIT");
            production.getJmiArticulos().addActionListener(this);
            production.getJmiAtributos().addActionListener(this);
            production.getJmiPerfilEmpleado().addActionListener(this);
            production.getJmiGastosFabrica().addActionListener(this);
            production.getJmiFallosMaquina().addActionListener(this);
            production.getJmiEstatusMaquina().addActionListener(this);
            production.getJmiMaquinas().addActionListener(this);
            production.getJmiCedulaProducto().addActionListener(this);
            production.getJmiOrdenProducto().addActionListener(this);
            production.getJmiTareas().addActionListener(this);
            Production.getJdpEscritorio().setBorder(background);
            production.setResizable(true);
            production.setExtendedState(MAXIMIZED_BOTH);
            production.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(production.getJmiArticulos())) {
                articles.Start();
            }

            if (e.getSource().equals(production.getJmiAtributos())) {
                attributes.Start();
            }

            if (e.getSource().equals(production.getJmiPerfilEmpleado())) {
                employeeProfile.Start();
            }

            if (e.getSource().equals(production.getJmiGastosFabrica())) {
                machineExpenses.Start();
            }
            if (e.getSource().equals(production.getJmiFallosMaquina())) {
                machineFaults.Start();
            }

            if (e.getSource().equals(production.getJmiEstatusMaquina())) {
                machineStatus.Start();
            }

            if (e.getSource().equals(production.getJmiMaquinas())) {
                machines.Start();
            }

            if (e.getSource().equals(production.getJmiCedulaProducto())) {
                productCertificate.Start();
            }

            if (e.getSource().equals(production.getJmiOrdenProducto())) {
                productOrder.Start();
            }

            if (e.getSource().equals(production.getJmiTareas())) {
                task.Start();
            }
        }

    }

    public class task implements ActionListener, MouseListener, KeyListener {

        Task task;
        ConsultHomework consultHomework;
        Mlib.mlibTask task1;
        Mlib.mlibTaskAttributes taAtributtes1;
        Mlib.mlibTaskMachine taMachine1;
        String[] colum = {"Código", "Descripcion"};

        public task() {
            task = new Task();
            consultHomework = new ConsultHomework();
            task1 = mlib.new mlibTask();
            taAtributtes1 = mlib.new mlibTaskAttributes();
            taMachine1 = mlib.new mlibTaskMachine();
            model = new DefaultTableModel(colum, 0);
            trs = new TableRowSorter<>(model);
        }

        public void Start() {
            task.setTitle("Tarea");
            Production.getJdpEscritorio().add(task);
            task.setVisible(true);
            task.getBtnAdd().addActionListener(this);
            task.getBtnCancel().addActionListener(this);
            task.getBtnConsult().addActionListener(this);
            task.getBtnDelete().addActionListener(this);
            task.getBtnEdit().addActionListener(this);
            task.getBtnExit().addActionListener(this);
            task.getBtnSave().addActionListener(this);
            task.getBtnSave().addActionListener(this);
            task.getBtnSearch().addActionListener(this);
            task.getTxtCode().addActionListener(this);
            task.getTxtDescription().addActionListener(this);
            consultHomework.getBtnAccept().addActionListener(this);
            consultHomework.getBtnExit().addActionListener(this);
            consultHomework.getBtnSearch().addActionListener(this);
            consultHomework.getTblConsult().addMouseListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(task.getBtnConsult())) {
                Production.getJdpEscritorio().add(consultHomework);
                consultHomework.setTitle("Consulta de Tarea");
                loadTable();
                consultHomework.setVisible(true);
                task.dispose();
            }
            if (e.getSource().equals(task.getBtnExit())) {
                task.dispose();
            }

            if (e.getSource().equals(task.getBtnAdd())) {
                task.getBtnSave().setEnabled(true);

            }

            if (e.getSource().equals(task.getBtnEdit())) {
                task.getCodigo().setEditable(false);
            }

            if (e.getSource().equals(task.getBtnSave())) {
                if (task.getCodigo().getText().isEmpty() || task.getjTextField2().getText().isEmpty()) {
                    task.getLblValidate().setText(" Los campos no pueden estar vacios. ");
                } else if (task.getCodigo().getText().equals(task.getjTextField2().getText())) {
                    task1.update(task.getCodigo().getText().trim(), task.getjTextField2().getText().trim());
                    task.getLblValidate().setText("Cambio realizado.");
                } else if (!task.getCodigo().getText().isEmpty() & !task.getjTextField2().getText().isEmpty()) {
                    task1.create(task.getCodigo().getText().trim(), task.getjTextField2().getText().trim());
                    if ("Existe".equals(Mlib.Val_Data)) {
                        task.getLblValidate().setText("Registro existente.");
                        Mlib.Val_Data = "";
                    } else {
                        task.getLblValidate().setText("Registro exitoso.");
                    }
                } else {
                    task.getLblValidate().setText("No se pudo guardar el registro.");
                }
            }

            if (e.getSource().equals(task.getBtnDelete())) {
                task1.delete(task.getTxtCode().getText());
                if ("eliminar".equals(Mlib.Val_Data)) {
                    task.getLblValidate().setText("Eliminación exitosa.");
                    Mlib.Val_Data = "";
                } else {
                    task.getLblValidate().setText("El registro no puede ser eliminado ya que esta siendo utilizado.");
                }

            }

            if (e.getSource().equals(task.getBtnCancel())) {
                task.getCodigo().setEditable(true);
            }

            if (e.getSource().equals(consultHomework.getBtnExit())) {
                Production.getJdpEscritorio().add(task);
                task.setVisible(true);
                task.toFront();
                consultHomework.dispose();
            }

            if (e.getSource().equals(consultHomework.getBtnAccept())) {
                Codigo = consultHomework.getTxtCode().getText();
                Descripcion = consultHomework.getTxtDescription().getText();
                Production.getJdpEscritorio().add(task);
                task.getTxtCode().setText(Codigo);
                task.getTxtDescription().setText(Descripcion);
                task.getCodigo().setText(Codigo);
                task.getjTextField2().setText(Descripcion);
                task.getLblValidate().setText("");
                task.setVisible(true);
                consultHomework.dispose();
            }
        }
///

        @Override
        public void mouseClicked(MouseEvent e) {
            Codigo = consultHomework.getTxtCode().getText();
            Descripcion = consultHomework.getTxtDescription().getText();

            if (e.getClickCount() == 2) {
                Production.getJdpEscritorio().add(task);
                task.getTxtCode().setText(Codigo);
                task.getTxtDescription().setText(Descripcion);
                task.getCodigo().setText(Codigo);
                task.getjTextField2().setText(Descripcion);
                task.getLblValidate().setText("");
                task.setVisible(true);
                consultHomework.dispose();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            consultHomework.getTxtCode().setText(consultHomework.getTblConsult().getValueAt(consultHomework.getTblConsult().getSelectedRow(), 0).toString());
            consultHomework.getTxtDescription().setText(consultHomework.getTblConsult().getValueAt(consultHomework.getTblConsult().getSelectedRow(), 1).toString());
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
///

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            trs.setRowFilter(RowFilter.regexFilter(consultHomework.getTxtDescription().getText(), 0));
            consultHomework.getTblConsult().setRowSorter(trs);
        }
///
        public void loadTable() {
            model.setColumnCount(2);
            data = task1.read();
            data.forEach(obj -> {
                model.addRow(obj);
            });
            consultHomework.getTblConsult().setModel(model);
        }

        public void clearTable() {
            for (int i = 0; i < consultHomework.getTblConsult().getRowCount(); i++) {
                model.removeRow(i);
                i = i - 1;
            }
        }
    }
//pruebita
    public class inventory implements ActionListener, MouseListener, KeyListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
