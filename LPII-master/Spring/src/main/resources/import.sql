DROP TABLE PRODUTOS;

CREATE TABLE PRODUTOS (CODIGO INTEGER AUTO_INCREMENT, NOME VARCHAR(30), VALOR DOUBLE, PRIMARY KEY(CODIGO));

INSERT INTO PRODUTOS(NOME,VALOR) VALUES ('TESTANDO',3.50)