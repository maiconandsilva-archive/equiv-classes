INSERT INTO course (id, code, name) VALUES
(1, 'ADS', 'Análise e Desenvolvimento de Sistemas'),
(2, 'BD', 'Banco de Dados'),
(3, 'DSM', 'Desenvolvimento de Software Multiplataforma'),
(4, 'GPI', 'Gestão da Produção Industrial'),
(5, 'LOG', 'Logística'),
(6, 'MA', 'Manufatura Avançada'),
(7, 'MNT', 'Manutenção de Aeronaves'),
(8, 'PEA', 'Projetos de Estruturas Aeronáuticas')
;

INSERT INTO equivalent_class (id) VALUES
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10),
(11), (12), (13), (14), (15), (16), (17), (18), (19),
(20), (21), (22), (23), (24), (25), (26), (27), (28),
(29), (30), (31), (32)
;

INSERT INTO academic_class
(id, name, code, semester, workload, course_id, equivalent_class_id) VALUES
-- ADS
(1, 'Administração Geral', 'AAG001', 1, 80, 1, 1),
(2, 'Arquitetura e Organização de Computadores', 'IAC001', 1, 80, 1, 2),
(3, 'Algoritmos e Lógica de Programação', 'IAL002', 1, 80, 1, 3),
(4, 'Laboratório de Hardware', 'IHW100', 1, 40, 1, null),
(5, 'Programação em Microinformática', 'ILM001', 1, 80, 1, null),
(6, 'Inglês I', 'LIN100', 1, 40, 1, 4),
(7, 'Matemática Discreta', 'MMD001', 1, 80, 1, 5),
(8, 'Contabilidade', 'CCG001', 2, 40, 1, 6),
(9, 'Engenharia de Software I', 'IES100', 2, 80, 1, 7),
(10, 'Linguagem de Programação', 'ILP010', 2, 80, 1, 8),
(11, 'Sistemas de Informação', 'ISI002', 2, 80, 1, null),
(12, 'Inglês II', 'LIN200', 2, 40, 1, 9),
(13, 'Comunicação e Expressão', 'LPO001', 2, 80, 1, 10),
(14, 'Cálculo', 'MCA002', 2, 80, 1, 11),
(15, 'Economia e Finanças', 'CEF100', 3, 40, 1, 12),
(16, 'Sociedade e Tecnologia', 'HST002', 3, 40, 1, null),
(17, 'Estruturas de Dados', 'IED001', 3, 80, 1, 13),
(18, 'Engenharia de Software II', 'IES200', 3, 80, 1, null),
(19, 'Interação Humano Computador', 'IHC001', 3, 40, 1, null),
(20, 'Programação Orientada a Objetos', 'ILP007', 3, 80, 1, 14),
(21, 'Sistemas Operacionais I', 'ISO100', 3, 80, 1, 15),
(22, 'Inglês III', 'LIN300', 3, 40, 1, 16),
(23, 'Estatística Aplicada', 'MET100', 3, 80, 1, 17),
(24, 'Banco de Dados', 'IBD002', 4, 40, 1, 21),
(25, 'Engenharia de Software III', 'IES300', 4, 80, 1, 22),
(26, 'Eletiva - Testes de Software', 'IQS500', 4, 80, 1, null),
(27, 'Sistemas Operacionais II', 'ISO200', 4, 80, 1, null),
(28, 'Inglês IV', 'LIN400', 4, 40, 1, 18),
(29, 'Metodologia da Pesquisa Científico Tecnológica', 'TTG001', 4, 40, 1, 24),
(30, 'Laboratório de Engenharia de Software', 'IES301', 5, 80, 1, 25),
(31, 'Laboratório de Banco de Dados', 'IBD100', 5, 80, 1, 26),
(32, 'Programação para Dispositivos Móveis', 'ILP506', 5, 80, 1, null),
(33, 'Redes de Computadores', 'IRC008', 5, 80, 1, null),
(34, 'Segurança da Informação', 'ISG003', 5, 40, 1, null),
(35, 'Inglês V', 'LIN500', 5, 40, 1, 19),
(36, 'Programação Linear e Aplicações', 'MPL001', 5, 80, 1, null),
(37, 'Trabalho de Graduação I', 'TTG003', 5, 80, 1, 27),
(38, 'Gestão de Projetos', 'AGO005', 6, 80, 1, null),
(39, 'Gestão de Equipes', 'AGR101', 6, 40, 1, 29),
(40, 'Empreendedorismo', 'CEE002', 6, 40, 1, 30),
(41, 'Ética e Responsabilidade Profissional', 'HSO003', 6, 40, 1, 31),
(42, 'Inteligência Artificial', 'IIA002', 6, 80, 1, 23),
(43, 'Tópicos Especiais em Informática (Escolha 2)', 'ITE002', 6, 80, 1, 32),
(44, 'Gestão e Governança de Tecnologia da Informação', 'ITI004', 6, 80, 1, null),
(45, 'Inglês VI', 'LIN600', 6, 40, 1, 20),
(46, 'Trabalho de Graduação II', 'LIN600', 6, 80, 1, 28),
-- BD
(47, 'Arquitetura e Organização de Computadores', 'IAC001', null, 80, 2, 2),
(48, 'Algoritmos', 'IAL001', null, 80, 2, 3),
(49, 'Inglês I', 'LIN100', null, 80, 2, 4),
(50, 'Matemática Discreta', 'MMD001', null, 80, 2, 5),
(51, 'Engenharia de Software', 'IES001', null, 80, 2, 7),
(52, 'Linguagem de Programação I', 'ILP008', null, 80, 2, 8),
(53, 'Inglês II', 'LIN200', null, 40, 2, 9),
(54, 'Comunicação e Expressão', 'LPO001', null, 80, 2, 10),
(55, 'Estruturas de Dados', 'IED001', null, 80, 2, 13),
(56, 'Linguagem de Programação II', 'ILP102', null, 80, 2, 14),
(57, 'Sistemas Operacionais Centralizados e Distribuídos', 'ISO005', null, 80, 2, 15),
(58, 'Inglês III', 'LIN300', null, 40, 2, 16),
(59, 'Arquitetura e Modelagem de Banco de Dados', 'IMB003', null, 40, 2, 21),
(60, 'Padrões de Projetos de Sistemas', 'IPP002', null, 80, 2, 22),
(61, 'Laboratório de Desenvolvimento em Banco de Dados VI', 'IBD186', null, 80, 2, 23),
(62, 'Inglês IV', 'LIN400', null, 40, 2, 18),
(63, 'Metodologia da Pesquisa Científico Tecnológica', 'TTG001', null, 40, 2, 24),
(64, 'Laboratório de Desenvolvimento em Banco de Dados IV', 'IBD184', null, 80, 2, 25),
(65, 'Projeto de Banco de Dados Não Estruturados', 'TBI004', null, 80, 2, 26),
(66, 'Inglês V', 'LIN500', null, 80, 2, 19),
(67, 'Gestão de Processos de Desenvolvimento de Software', 'AGO106', null, 40, 2, 29),
(68, 'Laboratório de Desenvolvimento em Banco de Dados V', 'IBD185', null, 80, 2, 32),
(69, 'Inglês VI', 'LIN600', null, 80, 2, 20),
(70, 'Projeto Trabalho de Graduação em Banco de Dados I', 'TTG021', null, 80, 2, 27),
(71, 'Projeto Trabalho de Graduação em Banco de Dados II', 'TTG022', null, 80, 2, 28),
-- GPI
(72, 'Administração Geral', 'AAG001', null, 80, 4, 1),
(73, 'Inglês I', 'ING001', null, 40, 4, 4),
(74, 'Introdução à Contabilidade', 'CON001', null, 40, 4, 6),
(75, 'Inglês II', 'ING002', null, 40, 4, 9),
(76, 'Cálculo', 'CAL102', null, 80, 4, 11),
(77, 'Economia e Finanças', 'ECN002', null, 40, 4, 12),
(78, 'Inglês III', 'ING003', null, 40, 4, 16),
(79, 'Estatística', 'EST001', null, 80, 4, 17),
(80, 'Inglês IV', 'ING004', null, 40, 4, 18),
(81, 'Metodologia da Pesquisa Científico Tecnológica', 'MPT006', null, 40, 4, 24),
(82, 'Inglês V', 'ING005', null, 40, 4, 19),
(83, 'Liderança e Empreendedorismo', 'TLE002', null, 40, 4, 30),
(84, 'Ética e Ética e Direito Empresarial', 'DDE003', null, 40, 4, 31),
(85, 'Inglês VI', 'ING006', null, 40, 4, 20),
(86, 'Administração Geral', 'AAG001', null, 80, 5, 1),
(87, 'Inglês I', 'LIN100', 1, 40, 5, 4),
-- LOG
(88, 'Contabilidade', 'CCG001', null, 40, 5, 6),
(89, 'Inglês II', 'LIN200', null, 40, 5, 9),
(90, 'Comunicação e Expressão', 'LPO001', null, 80, 5, 10),
(91, 'Cálculo I', 'MCA025', null, 80, 5, 11),
(92, 'Economia e Finanças Empresariais', 'CEF003', null, 40, 5, 12),
(93, 'Inglês III', 'LIN300', null, 40, 5, 16),
(94, 'Estatística Aplicada à Gestão', 'MET102', null, 80, 5, 17),
(95, 'Inglês IV', 'LIN400', null, 40, 5, 18),
(96, 'Métodos para a Produção do Conhecimento', 'TTG100', null, 40, 5, 24),
(97, 'Inglês V', 'LIN500', null, 40, 5, 19),
(98, 'Inovação e Empreendedorismo', 'CEE001', null, 40, 5, 30),
(99, 'Inglês VI', 'LIN600', null, 40, 5, 20),
-- MA
(100, 'Inglês I', 'HSC103', null, 40, 6, 4),
(101, 'Inglês II', 'HSC202', null, 40, 6, 9),
(102, 'Inglês III', 'HSC302', null, 40, 6, 16),
(103, 'Inglês IV', 'HSC402', null, 40, 6, 18),
(104, 'Inglês V', 'HSC502', null, 40, 6, 19),
(105, 'Inglês VI', 'HSC602', null, 40, 6, 20),
-- MNT
(106, 'Inglês I', 'ING001', null, 40, 7, 4),
(107, 'Inglês II', 'ING002', null, 40, 7, 9),
(108, 'Inglês III', 'ING003', null, 40, 7, 16),
(109, 'Inglês IV', 'ING004', null, 40, 7, 18),
(110, 'Inglês V', 'ING005', null, 40, 7, 19),
(111, 'Inglês VI', 'ING006', null, 40, 7, 20),
(112, 'Cálculo Aplicado à Aeronáutica', 'CAL101', null, 80, 7, 11),
(113, 'Metodologia da Pesquisa Científico Tecnológica', 'MPT001', null, 40, 7, 24),
-- PEA
(114, 'Inglês I', 'LIN100', null, 40, 8, 4),
(115, 'Inglês II', 'LIN200', null, 40, 8, 9),
(116, 'Inglês III', 'LIN300', null, 40, 8, 16),
(117, 'Inglês IV', 'LIN400', null, 40, 8, 18),
(118, 'Inglês V', 'LIN500', null, 40, 8, 19),
(119, 'Inglês VI', 'LIN600', null, 40, 8, 20),
(120, 'Cálculo I', 'MCA003', null, 80, 8, 11),
(121, 'Liderança e Empreendedorismo', 'TLE002', null, 40, 8, 30)
;

INSERT INTO authority (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER')
;

INSERT INTO academic_user (id,active,username, "password",course_id) VALUES
('acdaedd5-e318-4672-a514-30f2125a2f0d'::uuid,true, 'admin',
 '$2a$10$1bZt86uJkwrn6cjgNe2G5.LbRSGSPfFcucoJmye1KSpXmI6E8oZmi',1);
-- password: testing

INSERT INTO academic_user (id,active,username, "password",course_id) VALUES
('acdaedd5-e318-4672-a514-30f2125a2f01'::uuid,true, 'user',
 '$2a$10$1bZt86uJkwrn6cjgNe2G5.LbRSGSPfFcucoJmye1KSpXmI6E8oZmi',1);
-- password: testing

INSERT INTO academic_user_authorities (academic_user_id,authorities_id) VALUES
('acdaedd5-e318-4672-a514-30f2125a2f0d'::uuid, 2);

INSERT INTO academic_user_authorities (academic_user_id,authorities_id) VALUES
('acdaedd5-e318-4672-a514-30f2125a2f01'::uuid, 1);
