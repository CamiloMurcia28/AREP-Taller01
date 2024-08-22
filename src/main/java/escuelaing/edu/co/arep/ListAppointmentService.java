package escuelaing.edu.co.arep;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Camilo Murcia
 */
public class ListAppointmentService implements RESTService{

    private MedAppointmentService medAppointmentService;
    
    public ListAppointmentService(MedAppointmentService medAppointmentService){
        this.medAppointmentService = medAppointmentService;
    }
    
    @Override
    public String response(String request) {
        ArrayList<MedAppointment> appointments = medAppointmentService.getAppointments();
        return "{\"appointments\":[" + 
            appointments.stream()
            .map((MedAppointment medAppointment) -> String.format("{\"docname\":\"%s\", \"date\":%d\", \"type\":%s}", medAppointment.getName(), medAppointment.getDate(), medAppointment.getType()))
            .collect(Collectors.joining(",")) + 
        "]}";
    }
    
}