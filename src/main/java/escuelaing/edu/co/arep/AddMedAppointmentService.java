package escuelaing.edu.co.arep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Camilo Murcia
 */
public class AddMedAppointmentService implements RESTService{
    
    private MedAppointmentService appointmentService;
    
    public AddMedAppointmentService(MedAppointmentService medAppointmentService){
        this.appointmentService = medAppointmentService;
    }

    @Override
    public String response(String request) {
        String[] params = request.split("\\?");
        if (params.length < 2) return "{\"error\":\"Invalid request\"}";

        String[] queryParams = params[1].split("&");
        String docName = null;
        String appointmentType = null;
        Date schDate = null;

        for (String param : queryParams) {
            String[] pair = param.split("=");
            if (pair.length == 3) {
                String key = pair[0];
                String value = pair[1];
                String value2 = pair[2];

                if (key.equals("docName")) {
                    docName = value;
                }else if (key.equals("schDate")) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        schDate = formato.parse(value);
                    } catch (ParseException ex) {
                        Logger.getLogger(AddMedAppointmentService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(key.equals("appointmentType")){
                    appointmentType = value;
                }
            }
        }
        
        if (docName == null || appointmentType == null || schDate == null) {
        return "{\"error\":\"Missing parameters\"}";
        }

        appointmentService.addMedAppointment(docName, schDate, appointmentType);
        return "{\"DoctorName\":\"" + docName + "\", \"date\":\"" + schDate + "\",\"type\":\"" + appointmentType + "\"}";
        }
    
}
