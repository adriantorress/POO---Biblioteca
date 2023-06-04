DROP SCHEMA biblioteca;
CREATE SCHEMA biblioteca;

USE biblioteca;

CREATE TABLE tb_usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  usuario VARCHAR(50) UNIQUE NOT NULL,
  senha VARCHAR(50) NOT NULL,
  cargo ENUM('MEMBRO', 'ADMINISTRADOR') DEFAULT 'MEMBRO',
  data_cadastro DATE NOT NULL DEFAULT (CURRENT_DATE),
  endereco VARCHAR(255) DEFAULT 'Não informado',
  email VARCHAR(50) UNIQUE,
  telefone VARCHAR(20) UNIQUE,
  status ENUM('ATIVO', 'INATIVO', 'SUSPENSO') DEFAULT 'ATIVO'
);

CREATE TABLE tb_livro (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(50),
  autor VARCHAR(50),
  isbn VARCHAR(20) UNIQUE,
  ano_publicacao INT,
  categoria VARCHAR(30),
  quantidade_disponivel INT DEFAULT 1,
  data_cadastro DATE NOT NULL DEFAULT (CURRENT_DATE),
  status ENUM('DISPONIVEL', 'INDISPONIVEL') DEFAULT 'DISPONIVEL'
);
SET SQL_SAFE_UPDATES = 0;

INSERT INTO tb_usuario (nome,usuario,senha,email,telefone,cargo)
VALUES ('Adrian','admin','administratorsky','admin@gmail.com','82 98888-8888','ADMINISTRADOR');



CREATE TABLE tb_emprestimo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_user VARCHAR(50),
  livro_isbn VARCHAR(50),
  data_emprestimo DATE NOT NULL DEFAULT (CURRENT_DATE),
  data_devolucao DATE NOT NULL DEFAULT (DATE_ADD(CURRENT_DATE(), INTERVAL 3 DAY)),
  FOREIGN KEY (livro_isbn) REFERENCES tb_livro (isbn),
  FOREIGN KEY (usuario_user) REFERENCES tb_usuario(usuario),
  status ENUM('EM ANDAMENTO', 'FINALIZADO', 'CANCELADO', 'ATRASADO') NOT NULL DEFAULT 'EM ANDAMENTO'
);