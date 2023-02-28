/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sdelgado
 */
public class Mvar {
     public static int Identify;
     public static int IdCompany;
     public static String Company;
     public static String DescriptionCompany;
     public static String CommPort;
     public static Boolean AuxCode;
     public static String AuxDescription;
     String Id;
     String Descripcion;
     Date Dates;
     String Units;
     String Product;
     Integer Duration;
     String DayHour;
     Integer Quantity;
     String Salary;
     String CreateDate;
     String InitialDate;
     String EndDate;
     Integer Status;
     String Code;
     Integer IdProd;
     Float Quantity1;

    public Mvar(){
        
    }
 //Modificacacion @hcorrea 04/10/2022  
    public Mvar(String id, String descripcion, Date Fecha, String Unidad, String Producto, Integer Duracion, String Duracion_HD, Integer Cantidad, String sueldo, Float Quantity1){
        this.Id = id;
        this.Descripcion = descripcion;
        this.Dates = Fecha;
        this.Units = Unidad;
        this.Product = Producto;
        this.Duration = Duracion;
        this.DayHour = Duracion_HD;
        this.Quantity = Cantidad;
        this.Salary = sueldo;
        this.Quantity1 = Quantity1;
    }

    public Float getQuantity1() {
        return Quantity1;
    }

    public void setQuantity1(Float Quantity1) {
        this.Quantity1 = Quantity1;
    }

    public static int getIdentify() {
        return Identify;
    }

    public static void setIdentify(int Identify) {
        Mvar.Identify = Identify;
    }

    public static String getDescriptionCompany() {
        return DescriptionCompany;
    }

    public static void setDescriptionCompany(String DescriptionCompany) {
        Mvar.DescriptionCompany = DescriptionCompany;
    }

    public static Boolean getAuxCode() {
        return AuxCode;
    }

    public static void setAuxCode(Boolean AuxCode) {
        Mvar.AuxCode = AuxCode;
    }

    public static String getAuxDescription() {
        return AuxDescription;
    }

    public static void setAuxDescription(String AuxDescription) {
        Mvar.AuxDescription = AuxDescription;
    }

    public Date getDates() {
        return Dates;
    }

    public void setDates(Date Dates) {
        this.Dates = Dates;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String Units) {
        this.Units = Units;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer Duration) {
        this.Duration = Duration;
    }

    public String getDayHour() {
        return DayHour;
    }

    public void setDayHour(String DayHour) {
        this.DayHour = DayHour;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getInitialDate() {
        return InitialDate;
    }

    public void setInitialDate(String InitialDate) {
        this.InitialDate = InitialDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer Status) {
        this.Status = Status;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public Integer getIdProd() {
        return IdProd;
    }

    public void setIdProd(Integer IdProd) {
        this.IdProd = IdProd;
    }

    public static int getID() {
        return Identify;
    }

    public static void setID(int ID) {
        Mvar.Identify = ID;
    }

    public static int getIdCompany() {
        return IdCompany;
    }

    public static void setIdCompany(int idCompany) {
        Mvar.IdCompany = idCompany;
    }

    public static String getCompany() {
        return Company;
    }

    public static void setCompany(String company) {
        Mvar.Company = company;
    }

    public static String getDesCompany() {
        return DescriptionCompany;
    }

    public static void setDesCompany(String desCompany) {
        Mvar.DescriptionCompany = desCompany;
    }

    public static String getCommPort() {
        return CommPort;
    }

    public static void setCommPort(String commPort) {
        Mvar.CommPort = commPort;
    }

    public static Boolean getAuxCod() {
        return AuxCode;
    }

    public static void setAuxCod(Boolean auxCod) {
        Mvar.AuxCode = auxCod;
    }

    public static String getAuxDesc() {
        return AuxDescription;
    }

    public static void setAuxDesc(String auxDesc) {
        Mvar.AuxDescription = auxDesc;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public Date getFecha() {
        return Dates;
    }

    public void setFecha(Date Fecha) {
        this.Dates = Fecha;
    }

    public String getUnidad() {
        return Units;
    }

    public void setUnidad(String Unidad) {
        this.Units = Unidad;
    }

    public String getProducto() {
        return Product;
    }

    public void setProducto(String Producto) {
        this.Product = Producto;
    }

    public Integer getDuracion() {
        return Duration;
    }

    public void setDuracion(Integer Duracion) {
        this.Duration = Duracion;
    }

    public String getDuracion_HD() {
        return DayHour;
    }

    public void setDuracion_HD(String Duracion_HD) {
        this.DayHour = Duracion_HD;
    }

    public Integer getCantidad() {
        return Quantity;
    }

    public void setCantidad(Integer Cantidad) {
        this.Quantity = Cantidad;
    }

    public String getSueldo() {
        return Salary;
    }

    public void setSueldo(String sueldo) {
        this.Salary = sueldo;
    }

    void Quantity1(float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
