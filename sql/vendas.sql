CREATE TABLE IF NOT EXISTS TBL_PRODUTO (
    prod_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prod_descricao VARCHAR(45),
    prod_saldo DECIMAL(12, 2),
    prod_unidade VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS TBL_CLIENTE (
    cli_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cli_nome VARCHAR(45),
    cli_cpf VARCHAR(14),
    cli_ultima_compra DATETIME
);

CREATE TABLE IF NOT EXISTS TBL_VENDEDOR (
    vend_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    vend_nome VARCHAR(45),
    vend_percentual_comissao DECIMAL(3, 2)
);

CREATE TABLE IF NOT EXISTS TBL_PEDIDO (
    ped_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ped_data DATETIME,
    ped_observacao VARCHAR(255),
    ped_cod_CLIENTE INT,
    ped_cod_VENDEDOR INT,

    CONSTRAINT FK_Cliente FOREIGN KEY (ped_cod_CLIENTE) REFERENCES TBL_CLIENTE(cli_codigo),
    CONSTRAINT FK_Vendedor FOREIGN KEY (ped_cod_VENDEDOR) REFERENCES TBL_VENDEDOR(vend_codigo)
);

CREATE TABLE IF NOT EXISTS TBL_PEDIDO_PRODUTO (
    pedp_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pedp_quantidade INT UNSIGNED,
    pedp_valor DECIMAL(18, 2),
    pedp_valor_total DECIMAL(18, 3),
    pedp_cod_PRODUTO INT,
    pedp_cod_PEDIDO INT,

    CONSTRAINT FK_Produto FOREIGN KEY (pedp_cod_PRODUTO) REFERENCES TBL_PRODUTO(prod_codigo),
    CONSTRAINT FK_Pedido FOREIGN KEY (pedp_cod_PEDIDO) REFERENCES TBL_PEDIDO(ped_codigo)
);

CREATE TABLE IF NOT EXISTS TBL_PRODUTO_MOVIMENTACAO (
    prodm_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prodm_data DATETIME,
    prodm_descricao VARCHAR(45),
    prodm_cod_PRODUTO INT,

    CONSTRAINT FK_Prod FOREIGN KEY (prodm_cod_PRODUTO) REFERENCES TBL_PRODUTO(prod_codigo)
);

CREATE TABLE IF NOT EXISTS TBL_VENDEDOR_COMISSAO (
    vnc_codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    vnc_comissao DECIMAL(3, 2),
    vnc_cod_VENDEDOR INT,
    vnc_cod_PEDIDO INT,

    CONSTRAINT FK_Vend FOREIGN KEY (vnc_cod_VENDEDOR) REFERENCES TBL_VENDEDOR(vend_codigo),
    CONSTRAINT FK_Ped FOREIGN KEY (vnc_cod_PEDIDO) REFERENCES TBL_PEDIDO(ped_codigo)
);
