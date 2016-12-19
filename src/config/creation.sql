USE mdsp;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS Recipe;
DROP TABLE IF EXISTS DrugItem;
DROP TABLE IF EXISTS SingleDrugItem;

CREATE TABLE Recipe
(
    id INT AUTO_INCREMENT,
    rdate DATE NULL,
    name VARCHAR(40),
    gender INT NULL,
    age INT NULL,
    recordId VARCHAR(40) NULL,
    address VARCHAR(40) NULL,
    diagnosis VARCHAR(40) NULL,
    doctor VARCHAR(40) NULL,
    charge FLOAT(6, 2) NULL,
    checker VARCHAR(40) NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE DrugItem
(
    id INT AUTO_INCREMENT,
    recipeId INT,
    dosageUnit VARCHAR(40) NULL,
    dosageQuantity INT NULL,
    timePerDay INT NULL,
    note VARCHAR(40) NULL,
    PRIMARY KEY (id),
    CONSTRAINT recipe_id_reference FOREIGN KEY (recipeId) REFERENCES Recipe (id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE SingleDrugItem
(
    id INT AUTO_INCREMENT,
    drugItemId INT,
    name VARCHAR(40),
    purchaseUnit VARCHAR(40) NULL,
    purchaseQuantity FLOAT(6, 2) NULL,
    PRIMARY KEY (id),
    CONSTRAINT drug_item_reference FOREIGN KEY (drugItemId) REFERENCES DrugItem (id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

SET FOREIGN_KEY_CHECKS=1;

SHOW TABLE STATUS;