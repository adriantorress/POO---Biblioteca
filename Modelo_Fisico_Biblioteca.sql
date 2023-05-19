CREATE SCHEMA biblioteca;

USE biblioteca;

CREATE TABLE tb_usuario (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50)
);

CREATE TABLE tb_bibliotecario (
  usuario_id INT PRIMARY KEY,
  cargo VARCHAR(20),
  FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id)
);

CREATE TABLE tb_membro (
  usuario_id INT PRIMARY KEY,
  endereco VARCHAR(255),
  email VARCHAR(50),
  telefone VARCHAR(14),
  data_inscricao DATE,
  status ENUM('ativo', 'inativo', 'suspenso'),
  FOREIGN KEY (usuario_id) REFERENCES tb_usuario (id),
  CONSTRAINT CHK_Telefone_Format CHECK (telefone REGEXP '^\\([0-9]{2}\\) (\\d{4}-\\d{4}|\\d{5}-\\d{4})$')
);

CREATE TABLE tb_historico_cadastro_membro (
  bibliotecario_id INT,
  membro_id INT,
  data_cadastro DATE,
  FOREIGN KEY (bibliotecario_id) REFERENCES tb_bibliotecario (usuario_id),
  FOREIGN KEY (membro_id) REFERENCES tb_membro (usuario_id)
);

CREATE TABLE tb_livro (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(50),
  autor VARCHAR(50),
  isbn VARCHAR(20),
  ano_publicacao INT,
  categoria VARCHAR(30),
  quantidade_disponivel INT,
  status ENUM('disponivel', 'indisponivel')
);

CREATE TABLE tb_historico_cadastro_livro (
  bibliotecario_id INT,
  livro_id INT,
  data_cadastro DATE,
  FOREIGN KEY (bibliotecario_id) REFERENCES tb_bibliotecario (usuario_id),
  FOREIGN KEY (livro_id) REFERENCES tb_livro (id)
);

CREATE TABLE tb_emprestimo (
  id INT AUTO_INCREMENT PRIMARY KEY,
  data_emprestimo DATE,
  data_devolucao DATE,
  status ENUM('Em andamento', 'Finalizado', 'Cancelado', 'Atrasado')
);

CREATE TABLE tb_historico_emprestimo (
	bibliotecario_id INT,
    membro_id INT,
    livro_id INT,
    emprestimo_id INT,
    FOREIGN KEY (bibliotecario_id) REFERENCES tb_bibliotecario (usuario_id),
    FOREIGN KEY (membro_id) REFERENCES tb_membro (usuario_id),
    FOREIGN KEY (emprestimo_id) REFERENCES tb_emprestimo (id),
    FOREIGN KEY (livro_id) REFERENCES tb_livro (id)
);

