document.addEventListener('DOMContentLoaded', function () {

    // ============================================================
    // FECHA MÍNIMA PARA EL BUSCADOR
    // ============================================================

    const fechaViaje =
        document.getElementById('fechaViaje');

    if (fechaViaje) {

        const hoy =
            new Date();

        const anio =
            hoy.getFullYear();

        const mes =
            String(hoy.getMonth() + 1)
                .padStart(2, '0');

        const dia =
            String(hoy.getDate())
                .padStart(2, '0');

        fechaViaje.min =
            `${anio}-${mes}-${dia}`;

        if (!fechaViaje.value) {

            fechaViaje.value =
                `${anio}-${mes}-${dia}`;

        }

    }


    // ============================================================
    // VALIDACIÓN DE BÚSQUEDA
    // ============================================================

    const formBusqueda =
        document.getElementById('formBusqueda');

    if (formBusqueda) {

        formBusqueda.addEventListener(
            'submit',
            function (evento) {

                const origen =
                    document.getElementById('origen');

                const destino =
                    document.getElementById('destino');

                if (
                    origen &&
                    destino &&
                    origen.value &&
                    destino.value &&
                    origen.value === destino.value
                ) {

                    evento.preventDefault();

                    window.alert(
                        'El origen y el destino deben ser diferentes.'
                    );

                }

            }
        );

    }


    // ============================================================
    // SELECCIÓN DE ASIENTOS
    // ============================================================

    const asientos =
        document.querySelectorAll(
            '.client-seat.available'
        );

    const textoAsiento =
        document.getElementById(
            'asientoSeleccionado'
        );

    const botonContinuar =
        document.getElementById(
            'btnContinuarAsiento'
        );


    if (
        asientos.length > 0 &&
        textoAsiento
    ) {

        let asientoActual = null;


        // Desactivar continuar hasta escoger asiento
        if (botonContinuar) {

            botonContinuar.style.pointerEvents =
                'none';

            botonContinuar.style.opacity =
                '0.50';

        }


        asientos.forEach(function (asiento) {

            asiento.addEventListener(
                'click',
                function () {

                    // Quitar selección anterior
                    asientos.forEach(
                        function (otro) {

                            otro.classList.remove(
                                'selected'
                            );

                        }
                    );


                    // Seleccionar actual
                    asiento.classList.add(
                        'selected'
                    );

                    asientoActual =
                        asiento.dataset.seat;


                    textoAsiento.textContent =
                        asientoActual;


                    if (botonContinuar) {

                        botonContinuar.style.pointerEvents =
                            'auto';

                        botonContinuar.style.opacity =
                            '1';

                        // Enviamos el asiento como parámetro visual
                        botonContinuar.href =
                            '/pasajeros?asiento=' +
                            encodeURIComponent(
                                asientoActual
                            );

                    }

                }
            );

        });

    }


    // ============================================================
    // MÉTODOS DE PAGO
    // ============================================================

    const opcionesPago =
        document.querySelectorAll(
            '.payment-option'
        );


    opcionesPago.forEach(
        function (opcion) {

            opcion.addEventListener(
                'click',
                function () {

                    opcionesPago.forEach(
                        function (otra) {

                            otra.classList.remove(
                                'active'
                            );

                        }
                    );


                    opcion.classList.add(
                        'active'
                    );


                    const radio =
                        opcion.querySelector(
                            'input[type="radio"]'
                        );

                    if (radio) {
                        radio.checked = true;
                    }

                }
            );

        }
    );

});