-- Tabla de tecnologías
CREATE TABLE IF NOT EXISTS TECNOLOGIAS (
                                           UniqueID     BIGINT PRIMARY KEY AUTO_INCREMENT,
                                           nombre       VARCHAR(50)  NOT NULL,
    descripcion  VARCHAR(90)  NOT NULL,
    CONSTRAINT uq_tecnologias_nombre UNIQUE (nombre)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de relación local (sin FK a otra DB)
CREATE TABLE IF NOT EXISTS CAPACIDAD_TECNOLOGIAS (
                                                     UniqueID      BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                     id_tecnologia BIGINT NOT NULL,
                                                     id_capacidad  BIGINT NOT NULL,
    -- Solo FK interna
                                                     CONSTRAINT fk_ct_tecnologia
                                                     FOREIGN KEY (id_tecnologia) REFERENCES TECNOLOGIAS (UniqueID)
    ON UPDATE CASCADE ON DELETE RESTRICT
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Índices
CREATE INDEX idx_ct_tecnologia ON CAPACIDAD_TECNOLOGIAS (id_tecnologia);
CREATE INDEX idx_ct_capacidad  ON CAPACIDAD_TECNOLOGIAS (id_capacidad);
