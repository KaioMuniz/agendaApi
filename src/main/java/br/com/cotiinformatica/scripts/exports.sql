INSERT INTO tb_categoria(id, nome)
	VALUES
		(gen_random_uuid(), 'Família'),
		(gen_random_uuid(), 'Trabalho'),
		(gen_random_uuid(), 'Amigos'),
		(gen_random_uuid(), 'Estudo'),
		(gen_random_uuid(), 'Lazer'),
		(gen_random_uuid(), 'Outros');
		
SELECT * FROM tb_categoria
ORDER BY nome;)