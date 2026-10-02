INSERT IGNORE INTO roles (
    nombre_rol,
    descripcion
) VALUES
    ('ROLE_ADMIN', 'Administrador del sistema'),
    ('ROLE_SUPERVISOR', 'Supervisor de terminal'),
    ('ROLE_CLIENTE', 'Cliente registrado');


INSERT IGNORE INTO tipo_documento (
    nombre_documento,
    longitud_exacta
) VALUES
    ('DNI', 8),
    ('CE', 9),
    ('Pasaporte', 12);


INSERT IGNORE INTO servicio (
    nombre,
    descripcion
) VALUES
    (
        'Económico',
        'Asientos estándar reclinables 140°'
    ),
    (
        'Confort',
        'Asientos semi-cama 160°, WiFi'
    ),
    (
        'Imperial',
        'Asientos cama 180°, pantallas individuales, WiFi'
    );


INSERT IGNORE INTO metodos_pago (
    nombre_metodo,
    activo
) VALUES
    ('Yape', 1),
    ('Plin', 1),
    ('Tarjeta', 1);


INSERT IGNORE INTO tipo_comprobante (
    nombre_tipo,
    codigo_sunat
) VALUES
    ('Boleta', '03'),
    ('Factura', '01');


INSERT IGNORE INTO empresa_emisor (
    ruc,
    razon_social,
    nombre_comercial,
    direccion_fiscal,
    telefono
) VALUES (
    '20123456789',
    'Transportes Los Chaskis S.A.C.',
    'Los Chaskis',
    'Av. Javier Prado Este 1234, Lima',
    '01-555-1234'
);