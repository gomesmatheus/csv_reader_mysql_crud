# csv-reader-mysql-crud

## Antes de rodar não se esqueça de:

### 1 - Alterar o arquivo `database.properties` com as credências de seu banco de dados:
```properties
url=jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC
username=root
password=
```

### 2 - Rode o script de criação de tabela abaixo:

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
