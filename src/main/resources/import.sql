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

-- Inserir uma nova joia
INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
VALUES ('Pulseira de Diamante', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);

-- Inserir uma nova joia
INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
VALUES ('Pulseira de Ouro', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);

-- Inserir uma nova joia
INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
VALUES ('Anel de Ouro', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);

INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
VALUES ('Corrente de Ouro', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);

INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
VALUES ('Corrente de Prata', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);

-- Inserir uma nova pulseira
INSERT INTO Pulseira (joia_id, comprimento, imgPulseira, tipoFecho, tipoElo)
VALUES (1, 20.0, 'https://image.lexica.art/full_webp/064a23ad-12ec-424e-b99f-b1136fbe91c9', 1, 1);

INSERT INTO Pulseira (joia_id, comprimento, imgPulseira, tipoFecho, tipoElo)
VALUES (2, 20.0, 'https://image.lexica.art/full_webp/1736304c-68d6-47b2-b335-985ab8a5e0af', 1, 1);

-- Inserir novas correntes
INSERT INTO Corrente (joia_id, comprimento, imgCorrente, tipoFecho, tipoElo)
VALUES (4, 20.0, 'https://image.lexica.art/full_webp/29ce2f8c-f391-4e82-9269-6d3a9b7d7dcd', 1, 1); -- Certifique-se de que joia_id=1 existe

INSERT INTO Corrente (joia_id, comprimento, imgCorrente, tipoFecho, tipoElo)
VALUES (5, 20.0, 'https://image.lexica.art/full_webp/5693226b-9c22-4fb3-ba68-abeaacaa24ca', 1, 1); -- Certifique-se de que joia_id=2 existe

-- Inserir novos pingentes com referências corretas
INSERT INTO Pingente (nome, material, cor, pulseira_id, corrente_id)
VALUES ('Pingente 1', 1, 1, NULL, 4); -- Referenciando corrente_id=1

INSERT INTO Pingente (nome, material, cor, pulseira_id, corrente_id)
VALUES ('Pingente 3', 1, 1, NULL, 5); -- Referenciando corrente_id=2

INSERT INTO Pingente (nome, material, cor, pulseira_id, corrente_id)
VALUES ('Pingente 4', 1, 1, 1, NULL); -- Referenciando pulseira_id=1

INSERT INTO Pingente (nome, material, cor, pulseira_id, corrente_id)
VALUES ('Pingente 2', 1, 1, 2, NULL); -- Referenciando pulseira_id=2

-- Inserir um novo anel
INSERT INTO Anel (joia_id, tamanho, imgAnel)
VALUES (3, 20.0, 'https://image.lexica.art/full_webp/04889d2a-c53d-4369-8ff5-9f4de03817f0');

-- Inserir algumas pessoas
INSERT INTO Pessoa (nome, cpf, telefone, DataNascimento)
VALUES ('João Silva', '123.456.789-10', '123456789', '1990-01-01');

INSERT INTO Pessoa (nome, cpf, telefone, DataNascimento)
VALUES ('Maria Oliveira', '987.654.321-00', '987654321', '1995-05-15');

-- Inserir algumas coleções, associando-as a pessoas existentes
INSERT INTO Colecao (nome, descricao, pessoa_id)
VALUES ('Coleção de João', 'Uma coleção de João', 1);

INSERT INTO Colecao (nome, descricao, pessoa_id)
VALUES ('Coleção de Maria', 'Uma coleção de Maria', 2);

INSERT INTO Usuario (email, senha, perfil, pessoa_id)
VALUES ('joao@gmail.com', 'w9pDMz7dZ7REE5f8MukQDK59A9wX6hwL4TlUhqGQDTd2BcHc7VFQdmybnvJjhSljaLbL85+e8osqfvj9OQa2Hw==', 1, 1);

-- INSERT INTO Joia (nome, material, descricao, preco, estoque, cor, peso)
-- VALUES ('Anel de Diamante', 1, 'Anel de ouro com diamante central', 1500.00, 10, 1, 5.2);
--
-- -- Inserir uma nova pulseira sem pingente
-- INSERT INTO Pulseira (nome, material, descricao, preco, estoque, cor, peso, comprimento, imgPulseira, tipoFecho, tipoElo)
-- VALUES ('Pulseira de Ouro', 1, 'Pulseira de ouro', 500.00, 20, 1, 10.5, 20.0, 'img/pulseira1.jpg', 1, 1);
--
-- -- Inserir uma nova pulseira com pingente associado
-- INSERT INTO Pulseira (nome, material, descricao, preco, estoque, cor, peso, comprimento, imgPulseira, tipoFecho, tipoElo, pulseira_id)
-- VALUES ('Pulseira de Prata com Pingente', 1, 'Pulseira de prata com pingente de diamante', 350.00, 15, 2, 8.0, 18.5, 'img/pulseira2.jpg', 2, 2, 1);



-- -- Inserir uma nova pulseira com pingente associado (substitua pulseira_id pelo nome da coluna que representa a chave estrangeira para pingente na tabela Pulseira)
-- INSERT INTO Pulseira (nome, material, descricao, preco, estoque, cor, peso, comprimento, imgPulseira, tipoFecho, tipoElo, pulseira_id)
-- VALUES ('Pulseira de Prata com Pingente', 1, 'Pulseira de prata com pingente de diamante', 350.00, 15, 2, 8.0, 18.5, 'img/pulseira2.jpg', 2, 2, 1);
