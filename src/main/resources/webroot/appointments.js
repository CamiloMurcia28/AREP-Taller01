document.getElementById('citaForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    var doctor = document.getElementById('doctor').value;
    var fecha = document.getElementById('fecha').value;
    var tipo = document.getElementById('tipo').value;
    
    // Enviar datos al servidor
    fetch('/app/addMedAppointment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            doctor: doctor,
            fecha: fecha,
            tipo: tipo
        })
    })
    .then(response => response.json())
    .then(data => {
        var resultado = document.getElementById('resultado');
        resultado.innerHTML = `
            <h2>Cita Programada:</h2>
            <p><strong>Doctor:</strong> ${data.doctor}</p>
            <p><strong>Fecha:</strong> ${data.fecha}</p>
            <p><strong>Tipo de Cita:</strong> ${data.tipo}</p>
        `;
    })
    .catch((error) => {
        console.error('Error:', error);
        var resultado = document.getElementById('resultado');
        resultado.innerHTML = '<p>Error al programar la cita. Por favor, intente de nuevo.</p>';
    });
});