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
  email VARCHAR(50) UNIQUE DEFAULT 'Não informado',
  telefone VARCHAR(14) UNIQUE DEFAULT "00000000000",
  status ENUM('ATIVO', 'INATIVO', 'SUSPENSO') DEFAULT 'ATIVO',
  CONSTRAINT CHK_Telefone_Format CHECK (telefone REGEXP '^\\([0-9]{2}\\) (\\d{4}-\\d{4}|\\d{5}-\\d{4})$')
);

CREATE TABLE tb_livro (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(50),
  autor VARCHAR(50),
  isbn VARCHAR(20) UNIQUE,
  ano_publicacao INT,
  categoria VARCHAR(30),
  quantidade_disponivel INT,
  data_cadastro DATE NOT NULL DEFAULT (CURRENT_DATE),
  status ENUM('DISPONIVEL', 'INDISPONIVEL') DEFAULT 'DISPONIVEL'
);

CREATE TABLE tb_emprestimo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  livro_id INT,
  data_emprestimo DATE NOT NULL DEFAULT (CURRENT_DATE),
  data_devolucao DATE NOT NULL,
  FOREIGN KEY (livro_id) REFERENCES tb_livro (id),
  status ENUM('EM ANDAMENTO', 'FINALIZADO', 'CANCELADO', 'ATRASADO') NOT NULL DEFAULT 'EM ANDAMENTO'
);