document.getElementById('citaForm').addEventListener('submit', loadPostMsg);

function loadPostMsg(event) {
    event.preventDefault();

    const doctor = document.getElementById('doctor').value;
    const fecha = document.getElementById('fecha').value;
    const tipo = document.getElementById('tipo').value;

    let url = `/app/addMedAppointment?docName=${encodeURIComponent(doctor)}&schDate=${encodeURIComponent(fecha)}&type=${encodeURIComponent(tipo)}`;

    fetch(url, { method: 'POST' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            document.getElementById('message').innerText = `Nombre doctoooor: ${data.docName} añadido correctamente`;
            fetchAppointments();
        })
        .catch(error => {
            console.error("Error al programar cita:", error);
            document.getElementById('message').innerText = 'Error al programar cita';
        }); 
}


function fetchAppointments() {
    fetch('/app/medAppointment')
        .then(response => {
            return response.json();
        })
        .then(data => {
            console.log("Data received:", data);
            let appointmentsItems = document.getElementById('appointmentsItems');
            appointmentsItems.innerHTML = '';
            data.appointments.forEach(appointments => {
                let li = document.createElement('li');
                li.textContent = `Nombre Doctor: ${appointments.docName}, Fecha: ${appointments.schDate}`;
                appointmentsItems.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error al programar citaaaaaaaaaa:', error);
            document.getElementById('message').innerText = 'Error al programar citaaa.';
        });
}

window.onload = fetchAppointments();