document.addEventListener('DOMContentLoaded', function () {

    // ============================================================
    // BUSCADOR DEL MANIFIESTO
    // ============================================================

    const buscador =
        document.getElementById(
            'buscarPasajero'
        );

    const filas =
        document.querySelectorAll(
            '.fila-pasajero'
        );


    if (buscador && filas.length > 0) {

        buscador.addEventListener(
            'input',
            function () {

                const texto =
                    buscador.value
                        .trim()
                        .toLowerCase();


                filas.forEach(
                    function (fila) {

                        const contenido =
                            fila.textContent
                                .toLowerCase();

                        fila.style.display =
                            contenido.includes(texto)
                                ? ''
                                : 'none';

                    }
                );

            }
        );

    }


    // ============================================================
    // MARCAR PASAJERO COMO ABORDADO
    // ============================================================

    const botonesAbordaje =
        document.querySelectorAll(
            '.btn-abordaje'
        );


    botonesAbordaje.forEach(
        function (boton) {

            boton.addEventListener(
                'click',
                function () {

                    if (boton.disabled) {
                        return;
                    }


                    const fila =
                        boton.closest(
                            '.fila-pasajero'
                        );


                    if (!fila) {
                        return;
                    }


                    const badge =
                        fila.querySelector(
                            '.estado-embarque'
                        );


                    if (badge) {

                        badge.textContent =
                            'Abordó';

                        badge.className =
                            'boarding-badge boarding-boarded estado-embarque';

                    }


                    boton.innerHTML =
                        '<i class="bi bi-check-lg"></i> Abordó';

                    boton.disabled =
                        true;

                }
            );

        }
    );


    // ============================================================
    // INTERACCIÓN VISUAL DEL PLANO DE ASIENTOS
    // ============================================================

    const asientosSupervisor =
        document.querySelectorAll(
            '.supervisor-seat:not(.free)'
        );


    asientosSupervisor.forEach(
        function (asiento) {

            asiento.addEventListener(
                'click',
                function () {

                    const estadoActual =
                        asiento.classList.contains(
                            'boarded'
                        )
                            ? 'Abordó'
                            : asiento.classList.contains(
                                'pending'
                            )
                                ? 'Pendiente'
                                : 'Ausente';


                    window.alert(
                        'Asiento ' +
                        asiento.textContent.trim() +
                        '\nEstado: ' +
                        estadoActual
                    );

                }
            );

        }
    );

});