-- TABELA USUARIO
select * from tb_usuario;

INSERT INTO tb_usuario (nome,usuario,senha,endereco,email,telefone)
VALUES (?,?,?,?,?,?);
 
UPDATE tb_usuario
SET nome = ?, usuario = ?, senha = ?, cargo = ?, endereco = ?, email = ?, telefone = ?, status = ?
WHERE id = ?;

DELETE FROM tb_usuario
WHERE id = ?;

-- Criar administrador

INSERT INTO tb_usuario (nome,usuario,senha,email,telefone,cargo)
VALUES ('Adrian','admin','administratorsky','admin@gmail.com','82 98888-8888','ADMINISTRADOR');



-- TABELA LIVRO
select * from tb_livro;

INSERT INTO tb_livro (titulo,autor,isbn,ano_publicacao,categoria,quantidade_disponivel,status) 
VALUES (?,?,?,?,?,?);

UPDATE tb_livro
SET titulo = ?, autor = ?, isbn = ?, ano_publicacao = ?, categoria = ?, quantidade_disponivel = ?, status = ?
WHERE id = ?;

DELETE FROM tb_livro
WHERE id = ?;





-- TABELA EMPRESTIMO
select * from tb_emprestimo;

INSERT INTO tb_emprestimo (usuario_id,livro_id,data_devolucao) 
VALUES (?,?,?);

UPDATE tb_emprestimo
SET usuario_id = ?, livro_id = ?, data_devolucao = ? , status = ?
WHERE id = ?;

DELETE FROM tb_emprestimo
WHERE id = ?;

