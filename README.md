# csv-reader-mysql-crud

Rode o script de criação de tabela abaixo:

```mysql
CREATE TABLE jogador (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(255) NOT NULL,
    idade INTEGER(2),
    main VARCHAR(255),
    elo VARCHAR(255),
    
    PRIMARY KEY (id)
);
```
