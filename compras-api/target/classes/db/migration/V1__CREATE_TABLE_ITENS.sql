CREATE TABLE IF NOT EXISTS `tb_itens` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `codigo_produto` VARCHAR(255) NOT NULL,
    `quantidade` INT NOT NULL,
    `preco` DECIMAL(10, 2) NOT NULL
);
