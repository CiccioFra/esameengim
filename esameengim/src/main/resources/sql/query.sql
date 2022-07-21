-- Tabella Articoli
DROP TABLE IF EXISTS articolo;
CREATE TABLE IF NOT EXISTS articolo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codice VARCHAR(20) NOT NULL,
    descrizione VARCHAR(50),
    peso DOUBLE NOT NULL)
    ENGINE = InnoDB;

INSERT INTO articolo (`codice`, `descrizione`, `peso`)
    VALUE ('PNDRV8', 'Pen driver USB 8G no brand', 0.15),
         ('DCP-J715E', 'Stampante Brother DCP J715 W', 5.3),
         ('LNVCX1', 'Notebook Lenovo Carbon X1', 1.9),
         ('ALCPPC3', 'Smartphone Alcatel POP C3', 0.53),
         ('BSHT1R', 'Ampli Combo valvolare BlackStar HT 1-R', 6);

SELECT * FROM articolo;

-- Tabella Ordine
DROP TABLE IF EXISTS ordine;
CREATE TABLE IF NOT EXISTS ordine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    data VARCHAR(10))
    ENGINE = InnoDB;

INSERT INTO ordine (`numero`, `data`)
    VALUE (7, '21/07/2022'),
          (3, '15/07/2022'),
          (3, '09/12/2021'),
          (12, '08/06/2022'),
          (5, '01/01/2022'),
          (6, '05/02/2022'),
          (7, '03/03/2022'),
          (11, '09/05/2022'),
          (9, '30/04/2022');

SELECT * FROM articolo;

-- Tabella tariffa_coriere
DROP TABLE IF EXISTS tariffa_corriere;
CREATE TABLE IF NOT EXISTS tariffa_corriere (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_corriere VARCHAR(10),
    nome_tariffa VARCHAR(50),
    peso_massimo DOUBLE NOT NULL,
    costo DOUBLE NOT NULL)
    ENGINE = InnoDB;

INSERT INTO tariffa_corriere (`nome_corriere`, `nome_tariffa`, `peso_massimo`, `costo`)
    VALUE ('SDA', 'Economy',      1,      5.90),
          ('SDA', 'Veloce',       5,      7.90),
          ('SDA', 'Bigbox',       30,     12.90),
          ('DHL', 'Veloce',       1.5,    6.50),
          ('DHL', 'Assicurata',   7.5,    9.90),
          ('DHL', 'XXL',          40,     13.90),
          ('UPS', 'Economy',      0.7,    5.20),
          ('UPS', 'Standard',     3,      6.90),
          ('UPS', 'Jumbo',        25,     11.50);

SELECT * FROM tariffa_corriere;

-- Tabella Voce
DROP TABLE IF EXISTS voce;
CREATE TABLE IF NOT EXISTS voce (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_ordine INT NOT NULL,
    id_articolo INT NOT NULL,
    quantita_articolo INT NOT NULL)
    ENGINE = InnoDB;

INSERT INTO voce (`id_ordine`, `id_articolo`, `quantita_articolo`)
    VALUE (1, 3, 2),
          (2, 2, 1),
          (2, 3, 1),
          (3, 3, 1),
          (3, 4, 1),
          (4, 1, 2),
          (4, 4, 1),
          (5, 4, 2),
          (5, 1, 1),
          (6, 1, 3),
          (7, 2, 7),
          (8, 5, 1),
          (8, 3, 1),
          (9, 5, 6);

SELECT * FROM voce;

