CREATE TABLE tbl_board
(
    bno NUMBER(6,0),
    title VARCHAR2(1000) NOT NULL,
    writer VARCHAR2(1000) DEFAULT 'Any' NOT NULL,
    contents VARCHAR2(4000) DEFAULT 'No Content',
    regdate DATE NOT NULL,
    updatedate DATE DEFAULT SYSDATE,
    image VARCHAR2(2000),
    CONSTRAINT board_pk_bno PRIMARY KEY(bno)
);

INSERT INTO tbl_board ( bno, title, regdate) VALUES ( 1000, 'First Board', sysdate-7);
INSERT INTO tbl_board ( bno, title, regdate) VALUES ( 1001, 'Hello, Today is ...', sysdate -3);
INSERT INTO tbl_board ( bno, title, regdate) VALUES ( 1002, 'Welcome!!', sysdate-2);

COMMIT;

SELECT * FROM tbl_board;