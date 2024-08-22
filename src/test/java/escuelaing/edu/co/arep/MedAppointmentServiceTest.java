package escuelaing.edu.co.arep;


import escuelaing.edu.co.arep.MedAppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MedAppointmentServiceTest {

    private MedAppointmentService medAppointmentService;

    @BeforeEach
    void setUp() {
        medAppointmentService = new MedAppointmentService();
    }

    @Test
    void testAddAppointment() {
        medAppointmentService.addMedAppointment("Laura", new Date(2023-04-11),"Prioritaria");
        ArrayList<MedAppointment> appointments = medAppointmentService.getAppointments();
        assertEquals(1, appointments.size());

        MedAppointment appointment = appointments.get(0);
        assertEquals("Laura", appointment.getName());
        assertEquals("Prioritaria", appointment.getType());
    }

    @Test
    void testGetAppointments_NonEmptyList() {
        medAppointmentService.addMedAppointment("Daniel", new Date(2023-05-11),"General");
        medAppointmentService.addMedAppointment("Valentino", new Date(2022-04-11),"Especialista");
        ArrayList<MedAppointment> appointments = medAppointmentService.getAppointments();
        assertEquals(2, appointments.size());
        assertEquals("Daniel", appointments.get(0).getName());
        assertEquals("General", appointments.get(0).getType());

        assertEquals("Valentino", appointments.get(1).getName());
        assertEquals("Especialista", appointments.get(1).getType());
    }

    @Test
    void testGetAppointment_EmptyList() {
        ArrayList<MedAppointment> appointments = medAppointmentService.getAppointments();
        assertTrue(appointments.isEmpty());
    }

}