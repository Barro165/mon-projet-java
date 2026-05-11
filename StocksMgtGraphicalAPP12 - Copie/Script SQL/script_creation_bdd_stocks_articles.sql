CREATE TABLE supplier(
id NUMBER,
name VARCHAR2(50) NOT NULL,
address VARCHAR2(500),
email VARCHAR2(100),
CONSTRAINT pf_supplier PRIMARY KEY(id)
);
CREATE TABLE article(
reference VARCHAR2(15),
designation VARCHAR2(50) NOT NULL,
upet NUMBER(10) CONSTRAINT CK_upet CHECK (upet BETWEEN 1 AND 1000),
qtystock NUMBER(10),
idsupplier NUMBER,
CONSTRAINT pk_article PRIMARY KEY(reference),
CONSTRAINT fk_idsupplier FOREIGN KEY(idsupplier) REFERENCES supplier(id)
);


