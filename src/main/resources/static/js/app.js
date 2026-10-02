document.addEventListener('DOMContentLoaded', function () {

    // ============================================================
    // CONFIRMACIÓN DE ELIMINACIÓN
    // ============================================================

    const formulariosEliminar =
        document.querySelectorAll('.form-eliminar');

    formulariosEliminar.forEach(function (formulario) {

        formulario.addEventListener('submit', function (evento) {

            const confirmar = window.confirm(
                '¿Está seguro de eliminar este registro? Esta acción no se puede deshacer.'
            );

            if (!confirmar) {
                evento.preventDefault();
            }

        });

    });


    // ============================================================
    // TOOLTIPS BOOTSTRAP
    // ============================================================

    if (typeof bootstrap !== 'undefined') {

        const elementosTooltip =
            document.querySelectorAll(
                '[data-bs-toggle="tooltip"]'
            );

        elementosTooltip.forEach(function (elemento) {

            new bootstrap.Tooltip(elemento);

        });

    }


    // ============================================================
    // OCULTAR ALERTAS AUTOMÁTICAMENTE
    // ============================================================

    const alertas =
        document.querySelectorAll(
            '.alert.alert-success'
        );

    alertas.forEach(function (alerta) {

        setTimeout(function () {

            alerta.classList.remove('show');

            setTimeout(function () {

                alerta.remove();

            }, 250);

        }, 4500);

    });


    // ============================================================
    // CERRAR SIDEBAR MÓVIL AL HACER CLIC EN UNA OPCIÓN
    // ============================================================

    const sidebar =
        document.getElementById('appSidebar');

    if (sidebar) {

        const enlaces =
            sidebar.querySelectorAll(
                '.sidebar-nav-link'
            );

        enlaces.forEach(function (enlace) {

            enlace.addEventListener('click', function () {

                if (window.innerWidth < 992) {

                    sidebar.classList.remove('show');

                }

            });

        });

    }

});