CREATE TABLE TIPOIMOVEL(
	IDTIPOIMOVEL INT PRIMARY KEY NOT NULL,
	DESCRICAO VARCHAR(200) NOT NULL
);

INSERT INTO TipoImovel (descricao) VALUES ('Casa');
INSERT INTO TipoImovel (descricao) VALUES ('Apartamento');

CREATE TABLE LOCADOR(
	IDLOCADOR INT PRIMARY KEY NOT NULL,
	NOME VARCHAR(200) NOT NULL,
	CPFCNPJ VARCHAR(14) NOT NULL
);


INSERT INTO Locador (nome, cpfCnpj) VALUES ('João Silva', '123.456.789-00');
INSERT INTO Locador (nome, cpfCnpj) VALUES ('Maria Souza', '987.654.321-00');

CREATE TABLE IMOVEL(
	IDIMOVEL INT PRIMARY KEY NOT NULL,
	DESCRICAO VARCHAR(200) NOT NULL,
	RUA VARCHAR(200) NOT NULL,
	NUMERO VARCHAR(20) NOT NULL,
	BAIRRO VARCHAR(200) NOT NULL,
	VALORALUGUEL NUMERIC NOT NULL,
	TAXAADMINISTRACAO NUMERIC NOT NULL,
	
	IDTIPOIMOVEL INT NOT NULL,
	IDLOCADOR INT NOT NULL,
	CONSTRAINT FK_IMOVEL FOREIGN KEY (IDTIPOIMOVEL) REFERENCES TIPOIMOVEL(IDTIPOIMOVEL),
	CONSTRAINT FK_LOCADOR FOREIGN KEY (IDLOCADOR) REFERENCES LOCADOR(IDLOCADOR)
);

INSERT INTO Imovel (descricao, rua, numero, bairro, valorAluguel, taxaAdministracao, idTipoImovel, idLocador) VALUES ('Casa na Praia', 'Rua da Praia', '123', 'Beira Mar', 1500.00, 100.00, 1, 1);
INSERT INTO Imovel (descricao, rua, numero, bairro, valorAluguel, taxaAdministracao, idTipoImovel, idLocador) VALUES ('Apartamento no Centro', 'Rua Principal', '456', 'Centro', 1200.00, 80.00, 2, 2);


CREATE TABLE LOCATARIO(
	IDLOCATARIO INT PRIMARY KEY NOT NULL,
	NOME VARCHAR(200) NOT NULL,
	CPFCNPJ VARCHAR(14) NOT NULL
);

INSERT INTO Locatario (nome, cpfCnpj) VALUES ('Pedro Santos', '111.222.333-44');
INSERT INTO Locatario (nome, cpfCnpj) VALUES ('Ana Oliveira', '555.666.777-88');

CREATE TABLE TIPODESCONTO(
	IDTIPODESCONTO INT PRIMARY KEY NOT NULL,
	DESCRICAO VARCHAR(200) NOT NULL
);

INSERT INTO ContratoLocacao (dataContrato, dataInicio, dataFinal, mesesContrato, diaRecebimento, diaPagamento, valorTotalContratado, valorRecebido, valorDescontos, valorPago, valorJurosMultaRecebido, valorJurosMultaPago, saldoContratado, idLocador, idImovel, idLocatario) VALUES ('2023-09-11', '2023-10-01', '2024-09-30', 12, 5, 5, 18000.00, 0.00, 0.00, 0.00, 0.00, 0.00, 18000.00, 1, 1, 1);
INSERT INTO ContratoLocacao (dataContrato, dataInicio, dataFinal, mesesContrato, diaRecebimento, diaPagamento, valorTotalContratado, valorRecebido, valorDescontos, valorPago, valorJurosMultaRecebido, valorJurosMultaPago, saldoContratado, idLocador, idImovel, idLocatario) VALUES ('2023-09-15', '2023-10-01', '2024-09-30', 12, 5, 5, 15000.00, 0.00, 0.00, 0.00, 0.00, 0.00, 15000.00, 2, 2, 2);

CREATE TABLE PARCELADESCONTO(
	IDPARCELADESCONTO INT PRIMARY KEY NOT NULL,
	NROPARCELA INT NOT NULL,
	DATALANCAMENTO DATE NOT NULL,
	VALORDESCONTO NUMERIC NOT NULL,
	DESCRICAO VARCHAR(200) NOT NULL,
	
	IDTIPODESCONTO INT NOT NULL,
	CONSTRAINT FK_IDTIPODESCONTO FOREIGN KEY (IDTIPODESCONTO) REFERENCES TIPODESCONTO(IDTIPODESCONTO)
);

INSERT INTO ParcelaReceber (dataVencimento, dataRecebimento, valorParcela, valorRecebido, valorJurosMulta, situacao, idContrato) VALUES ('2023-10-01', NULL, 1500.00, NULL, NULL, 'Pendente', 1);
INSERT INTO ParcelaReceber (dataVencimento, dataRecebimento, valorParcela, valorRecebido, valorJurosMulta, situacao, idContrato) VALUES ('2023-10-01', NULL, 1250.00, NULL, NULL, 'Pendente', 2);


CREATE TABLE PARCELAPAGAR(
	IDPARCELAPAGAR INT PRIMARY KEY NOT NULL,
	DATAVENCIMENTO DATE NOT NULL,
	DATAPAGAMENTO DATE NOT NULL,
	VALORDESCONTOS NUMERIC NOT NULL,
	VALORPAGAR NUMERIC NOT NULL,
	VALORPAGO NUMERIC NOT NULL,
	VALORJUROSMULTA NUMERIC NOT NULL,
	SITUACAO VARCHAR NOT NULL
);

INSERT INTO ParcelaPagar (dataVencimento, dataPagamento, valorDescontos, valorPagar, valorPago, valorJurosMulta, situacao, idContrato) VALUES ('2023-10-01', NULL, NULL, 1500.00, NULL, NULL, 'Pendente', 1);
INSERT INTO ParcelaPagar (dataVencimento, dataPagamento, valorDescontos, valorPagar, valorPago, valorJurosMulta, situacao, idContrato) VALUES ('2023-10-01', NULL, NULL, 1250.00, NULL, NULL, 'Pendente', 2);


CREATE TABLE PARCELARECEBER(
	NROPARCELA INT PRIMARY KEY NOT NULL,
	DATAVENCIMENTO DATE NOT NULL,
	DATARECEBIMENTO DATE NOT NULL,
	VALORPARCELA NUMERIC NOT NULL,
	VALORRECEBIDO NUMERIC NOT NULL,
	VALORJUOUSMULTA NUMERIC NOT NULL,
	SITUACAO VARCHAR(200) NOT NULL
);

INSERT INTO TipoDesconto (descricao) VALUES ('Desconto por antecipação');
INSERT INTO TipoDesconto (descricao) VALUES ('Desconto por fidelidade');

CREATE TABLE CONTRATOLOCACAO(
	IDCONTRATO INT PRIMARY KEY NOT NULL,
	
	DATACONTRATO DATE NOT NULL,
	DATAINICIO DATE NOT NULL,
	DATAFINAL DATE NOT NULL,
	
	MESESCONTRATO INT NOT NULL,
	DIARECEBIMENTO INT NOT NULL,
	DIAPAGAMENTO INT NOT NULL,
	
	VALORTOTALCONTRATO NUMERIC NOT NULL,
	VALORRECIBO NUMERIC NOT NULL,
	VALORDESCONTOS NUMERIC NOT NULL,
	VALORPAGO NUMERIC NOT NULL,
	VALORJUROSMULTARECEBIdO NUMERIC NOT NULL,
	VALORJUROSMULTAPAGO NUMERIC NOT NULL,
	
	SALDOCONTRATO NUMERIC NOT NULL,
	
	IDIMOVEL INT NOT NULL,
	IDLOCADOR INT NOT NULL,
	IDLOCATARIO INT NOT NULL,
	NROPARCELA INT NOT NULL,
	IDPARCELAPAGAR INT NOT NULL,
	IDPARCELADESCONTO INT NOT NULL,
	CONSTRAINT FK_IMOVEL FOREIGN KEY (IDIMOVEL) REFERENCES IMOVEL(IDIMOVEL),
	CONSTRAINT FK_IDLOCADOR FOREIGN KEY (IDLOCADOR) REFERENCES LOCADOR(IDLOCADOR),
	CONSTRAINT FK_IDLOCATARIO FOREIGN KEY (IDLOCATARIO) REFERENCES LOCATARIO(IDLOCATARIO),
	CONSTRAINT FK_NROPARCELA FOREIGN KEY (NROPARCELA) REFERENCES PARCELARECEBER(NROPARCELA),
	CONSTRAINT FK_IDPARCELAPAGAR FOREIGN KEY (IDPARCELAPAGAR) REFERENCES PARCELAPAGAR(IDPARCELAPAGAR),
	CONSTRAINT FK_IDPARCELADESCONTO FOREIGN KEY (IDPARCELADESCONTO) REFERENCES PARCELADESCONTO(IDPARCELADESCONTO)
);

INSERT INTO ParcelaDesconto (nroParcela, dataLancamento, valorDesconto, descricao, idContrato, idTipoDesconto) VALUES (1, '2023-09-15', 50.00, 'Desconto por antecipação', 1, 1);
INSERT INTO ParcelaDesconto (nroParcela, dataLancamento, valorDesconto, descricao, idContrato, idTipoDesconto) VALUES (1, '2023-09-15', 40.00, 'Desconto por antecipação', 2, 1);
