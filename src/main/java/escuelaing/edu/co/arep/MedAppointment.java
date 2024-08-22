package escuelaing.edu.co.arep;

import java.util.Date;

/**
 * @author Camilo Murcia
 */
public class MedAppointment {
    private String docName;
    private Date schDate;
    private String appointmentType;
    
    public MedAppointment(String docName, Date schDate, String appointmentType){
        this.docName = docName;
        this.schDate = schDate;
        this.appointmentType = appointmentType;
    }
    
    public String getName(){
        return this.docName;
    }
    
    public Date getDate(){
        return this.schDate;
    }
    
    public String getType(){
        return this.appointmentType;
    }
    
}
