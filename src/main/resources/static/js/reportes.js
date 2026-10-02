document.addEventListener('DOMContentLoaded', function () {

    if (typeof Chart === 'undefined') {
        return;
    }


    // ============================================================
    // DASHBOARD - ESTADO DE BUSES
    // ============================================================

    const canvasBuses =
        document.getElementById(
            'graficoEstadoBuses'
        );


    if (canvasBuses) {

        const activos =
            Number(
                canvasBuses.dataset.activos || 0
            );

        const mantenimiento =
            Number(
                canvasBuses.dataset.mantenimiento || 0
            );

        const inactivos =
            Number(
                canvasBuses.dataset.inactivos || 0
            );


        new Chart(
            canvasBuses,
            {

                type: 'bar',

                data: {

                    labels: [
                        'Activos',
                        'Mantenimiento',
                        'Inactivos'
                    ],

                    datasets: [
                        {
                            label: 'Buses',

                            data: [
                                activos,
                                mantenimiento,
                                inactivos
                            ],

                            backgroundColor: [
                                '#16A34A',
                                '#D4AF37',
                                '#8C8C8C'
                            ],

                            borderRadius: 7,

                            barThickness: 48
                        }
                    ]

                },

                options: {

                    responsive: true,

                    maintainAspectRatio: false,

                    plugins: {

                        legend: {
                            display: false
                        }

                    },

                    scales: {

                        y: {

                            beginAtZero: true,

                            ticks: {
                                stepSize: 1
                            },

                            grid: {
                                color: '#EDEBE6'
                            }

                        },

                        x: {

                            grid: {
                                display: false
                            }

                        }

                    }

                }

            }
        );

    }


    // ============================================================
    // DASHBOARD - ESTADO DE VIAJES
    // ============================================================

    const canvasViajes =
        document.getElementById(
            'graficoEstadoViajes'
        );


    if (canvasViajes) {

        const programados =
            Number(
                canvasViajes.dataset.programados ||
                0
            );

        const cancelados =
            Number(
                canvasViajes.dataset.cancelados ||
                0
            );


        new Chart(
            canvasViajes,
            {

                type: 'doughnut',

                data: {

                    labels: [
                        'Programados',
                        'Cancelados'
                    ],

                    datasets: [
                        {
                            data: [
                                programados,
                                cancelados
                            ],

                            backgroundColor: [
                                '#0D1B2A',
                                '#DC2626'
                            ],

                            borderColor:
                                '#FFFFFF',

                            borderWidth: 4
                        }
                    ]

                },

                options: {

                    responsive: true,

                    maintainAspectRatio: false,

                    cutout: '68%',

                    plugins: {

                        legend: {

                            position: 'bottom',

                            labels: {

                                usePointStyle: true,

                                padding: 18,

                                font: {
                                    family: 'Inter',
                                    weight: '600'
                                }

                            }

                        }

                    }

                }

            }
        );

    }


    // ============================================================
    // REPORTES - BUSES POR SERVICIO
    // ============================================================

    const canvasServicio =
        document.getElementById(
            'graficoTipoServicio'
        );


    if (canvasServicio) {

        const confort =
            Number(
                canvasServicio.dataset.confort ||
                0
            );

        const imperial =
            Number(
                canvasServicio.dataset.imperial ||
                0
            );


        new Chart(
            canvasServicio,
            {

                type: 'bar',

                data: {

                    labels: [
                        'Confort 160°',
                        'Imperial 180°'
                    ],

                    datasets: [
                        {
                            label: 'Buses',

                            data: [
                                confort,
                                imperial
                            ],

                            backgroundColor: [
                                '#0D1B2A',
                                '#D4AF37'
                            ],

                            borderRadius: 8,

                            barThickness: 52
                        }
                    ]

                },

                options: {

                    responsive: true,

                    maintainAspectRatio: false,

                    plugins: {

                        legend: {
                            display: false
                        }

                    },

                    scales: {

                        y: {

                            beginAtZero: true,

                            ticks: {
                                stepSize: 1
                            },

                            grid: {
                                color: '#EDEBE6'
                            }

                        },

                        x: {

                            grid: {
                                display: false
                            }

                        }

                    }

                }

            }
        );

    }


    // ============================================================
    // REPORTES - VIAJES POR DESTINO
    // ============================================================

    const canvasDestinos =
        document.getElementById(
            'graficoDestinos'
        );


    if (canvasDestinos) {

        const piura =
            Number(
                canvasDestinos.dataset.piura || 0
            );

        const chiclayo =
            Number(
                canvasDestinos.dataset.chiclayo ||
                0
            );

        const cajamarca =
            Number(
                canvasDestinos.dataset.cajamarca ||
                0
            );


        new Chart(
            canvasDestinos,
            {

                type: 'bar',

                data: {

                    labels: [
                        'Piura',
                        'Chiclayo',
                        'Cajamarca'
                    ],

                    datasets: [
                        {
                            label:
                                'Viajes registrados',

                            data: [
                                piura,
                                chiclayo,
                                cajamarca
                            ],

                            backgroundColor:
                                '#D4AF37',

                            borderRadius: 8,

                            barThickness: 40
                        }
                    ]

                },

                options: {

                    responsive: true,

                    maintainAspectRatio: false,

                    plugins: {

                        legend: {
                            display: false
                        }

                    },

                    scales: {

                        y: {

                            beginAtZero: true,

                            ticks: {
                                stepSize: 1
                            },

                            grid: {
                                color: '#EDEBE6'
                            }

                        },

                        x: {

                            grid: {
                                display: false
                            }

                        }

                    }

                }

            }
        );

    }


    // ============================================================
    // REPORTES - GRÁFICO LINEAL
    // ============================================================

    const canvasTendencia =
        document.getElementById(
            'graficoTendencia'
        );


    if (canvasTendencia) {

        new Chart(
            canvasTendencia,
            {

                type: 'line',

                data: {

                    labels: [
                        'Ene',
                        'Feb',
                        'Mar',
                        'Abr',
                        'May',
                        'Jun',
                        'Jul',
                        'Ago',
                        'Sep',
                        'Oct',
                        'Nov',
                        'Dic'
                    ],

                    datasets: [
                        {
                            label:
                                'Viajes programados',

                            data: [
                                12,
                                16,
                                15,
                                20,
                                24,
                                22,
                                28,
                                31,
                                30,
                                35,
                                38,
                                42
                            ],

                            borderColor:
                                '#D4AF37',

                            backgroundColor:
                                'rgba(212,175,55,0.12)',

                            fill: true,

                            tension: 0.35,

                            borderWidth: 3,

                            pointRadius: 5,

                            pointBackgroundColor:
                                '#0D1B2A',

                            pointBorderColor:
                                '#D4AF37',

                            pointBorderWidth: 2
                        }
                    ]

                },

                options: {

                    responsive: true,

                    maintainAspectRatio: false,

                    plugins: {

                        legend: {

                            labels: {

                                usePointStyle: true,

                                font: {
                                    family: 'Inter'
                                }

                            }

                        }

                    },

                    scales: {

                        y: {

                            beginAtZero: true,

                            grid: {
                                color: '#EDEBE6'
                            }

                        },

                        x: {

                            grid: {
                                display: false
                            }

                        }

                    }

                }

            }
        );

    }

});