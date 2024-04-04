--INSERT ESTADOS
INSERT INTO estado (nome, sigla)
VALUES ('Acre', 'AC'),
       ('Alagoas', 'AL'),
       ('Amapá', 'AP'),
       ('Amazonas', 'AM'),
       ('Bahia', 'BA'),
       ('Ceará', 'CE'),
       ('Distrito Federal', 'DF'),
       ('Espírito Santo', 'ES'),
       ('Goiás', 'GO'),
       ('Maranhão', 'MA'),
       ('Mato Grosso', 'MT'),
       ('Mato Grosso do Sul', 'MS'),
       ('Minas Gerais', 'MG'),
       ('Pará', 'PA'),
       ('Paraíba', 'PB'),
       ('Paraná', 'PR'),
       ('Pernambuco', 'PE'),
       ('Piauí', 'PI'),
       ('Rio de Janeiro', 'RJ'),
       ('Rio Grande do Norte', 'RN'),
       ('Rio Grande do Sul', 'RS'),
       ('Rondônia', 'RO'),
       ('Roraima', 'RR'),
       ('Santa Catarina', 'SC'),
       ('São Paulo', 'SP'),
       ('Sergipe', 'SE'),
       ('Tocantins', 'TO');

-- INSERT CIDADES
INSERT INTO cidade (nome, id_estado)
VALUES ('Rio Branco', 1),
       ('Macapá', 2),
       ('Maceió', 3),
       ('Manaus', 4),
       ('Salvador', 5),
       ('Fortaleza', 6),
       ('Brasília', 7),
       ('Vitória', 8),
       ('Goiânia', 9),
       ('São Luís', 10),
       ('Cuiabá', 11),
       ('Campo Grande', 12),
       ('Belo Horizonte', 13),
       ('Belém', 14),
       ('João Pessoa', 15),
       ('Curitiba', 16),
       ('Recife', 17),
       ('Teresina', 18),
       ('Rio de Janeiro', 19),
       ('Natal', 20),
       ('Porto Alegre', 21),
       ('Porto Velho', 22),
       ('Boa Vista', 23),
       ('Florianópolis', 24),
       ('São Paulo', 25),
       ('Aracaju', 26),
       ('Palmas', 27);

-- INSERT ENDERECOS
INSERT INTO endereco (id_cidade, cep, numero, bairro, logradouro, complemento)
VALUES (1, '12345-678', 10, 'Centro', 'Rua Principal', 'Apto 101'),
       (2, '23456-789', 20, 'Bairro A', 'Rua Secundária', ''),
       (3, '34567-890', 30, 'Bairro B', 'Avenida Central', 'Casa 2'),
       (4, '45678-901', 40, 'Bairro C', 'Travessa da Praça', ''),
       (5, '56789-012', 50, 'Bairro D', 'Rua da Esquina', 'Sala 3'),
       (6, '67890-123', 60, 'Bairro E', 'Avenida dos Lagos', ''),
       (7, '78901-234', 70, 'Bairro F', 'Rua das Flores', ''),
       (8, '89012-345', 80, 'Bairro G', 'Avenida da Praia', ''),
       (9, '90123-456', 90, 'Bairro H', 'Rua das Palmeiras', 'Loja 5'),
       (10, '01234-567', 100, 'Bairro I', 'Avenida Central', '');

-- INSERT PedraPreciosa
INSERT INTO PedraPreciosa (pedra, peso, quantidade, cor)
VALUES (1, '10 quilates', 5, 1);
INSERT INTO PedraPreciosa (pedra, peso, quantidade, cor)
VALUES (2, '8 quilates', 3, 1);

-- INSERT PINGENTE
INSERT INTO Pingente (material, cor)
VALUES (1, 1);

INSERT INTO Pingente (material, cor)
VALUES (2, 2);

-- Inserir algumas pessoas
INSERT INTO Pessoa (nome, senha, cpf, telefone, email, DataNascimento, perfil)
VALUES ('João Silva', 'senha123', '123.456.789-10', '123456789', 'joao@example.com', '1990-01-01', '1');

INSERT INTO Pessoa (nome, senha, cpf, telefone, email, DataNascimento, perfil)
VALUES ('Maria Oliveira', 'senha456', '987.654.321-00', '987654321', 'maria@example.com', '1995-05-15', '2');

-- Inserir algumas coleções, associando-as a pessoas existentes
INSERT INTO Colecao (nome, descricao, pessoa_id)
VALUES ('Coleção de João', 'Uma coleção de João', 1);

INSERT INTO Colecao (nome, descricao, pessoa_id)
VALUES ('Coleção de Maria', 'Uma coleção de Maria', 2);


INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
VALUES ('Anel de Diamante', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);
