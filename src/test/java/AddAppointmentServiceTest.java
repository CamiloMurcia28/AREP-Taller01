package escuelaing.edu.co.arep;

import escuelaing.edu.co.arep.AddMedAppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddMedAppointmentServiceTest {

    private MedAppointmentService appointmentService;
    private AddMedAppointmentService addMedAppointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = new MedAppointmentService();
        addMedAppointmentService = new AddMedAppointmentService(exerciseService);
    }

    @Test
    void testResponse_InvalidInput1() {
        String request = "docName=Camilo&schDate=2023-05-15&type=invalid";
        String response = addMedAppointmentService.response(request);

        assertEquals("{\"error\":\"Invalid request\"}", response);
        assertEquals(0, appointmentService.getAppointments().size());
    }

    @Test
    void testResponse_InvalidInput2() {
        String request = "docName=&schDate=2023-06-15&type=invalid";
        String response = addMedAppointmentService.response(request);

        assertEquals("{\"error\":\"Invalid request\"}", response);
        assertEquals(0, appointmentService.getAppointments().size());
    }
}