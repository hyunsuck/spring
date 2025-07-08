-- CREATE �� 2��
CREATE TABLE book_tbl_06
(
   book_no NUMBER PRIMARY KEY,
   book_name VARCHAR2(50) NOT NULL,
   book_covering VARCHAR(20),
   book_date DATE,
   book_price NUMBER,
   book_publisher VARCHAR2(50),
   book_info VARCHAR2(2000)
);

CREATE TABLE rent_tbl_06
(
   rent_no NUMBER PRIMARY KEY,
   book_no NUMBER,
   rent_price NUMBER,
   rent_date DATE,
   rent_status CHAR(1) DEFAULT '0',
   FOREIGN KEY (book_no) REFERENCES book_tbl_06(book_no)
);

-- INSERT �� 16��
INSERT INTO book_tbl_06
(
    book_no
    ,book_name
    ,book_covering
    ,book_date
    ,book_price
    ,book_publisher
    ,book_info
    )
    VALUES
    (
    100
    ,'������'
    ,'100.jpg'
    ,'2015/09/02'
    ,24000
    ,'���轺'
    ,'�ü��
    , DB����
    , ��Ʈ��ũ����
    , ����ȯ�汸��'
    );
INSERT INTO book_tbl_06
(
    book_no
    ,book_name
    ,book_covering
    ,book_date
    ,book_price
    ,book_publisher
    ,book_info
    )
    VALUES(101
    ,'�ڹ�'
    ,'101.jpg'
    ,'2016/01/10'
    ,20000
    ,'���ڹ�'
    ,'���α׷��� ���'
    );
INSERT INTO book_tbl_06
(
    book_no
    ,book_name
    ,book_covering
    ,book_date
    ,book_price
    ,book_publisher
    ,book_info
    )
    VALUES(
    102,
    '�ڹ������α׷���'
    ,'102.jpg'
    ,'2016/10/30'
    ,25000
    ,'������'
    ,'����ȯ��/�������α׷�/��ġ���α׷�'
    );
INSERT INTO book_tbl_06
(
   book_no
  ,book_name
  ,book_covering
  ,book_date
  ,book_price
  ,book_publisher
  ,book_info
)
VALUES
  (
     103
    ,'���¼ҽ�Ȱ���ϱ�'
    ,'103.jpg'
    ,'2017/09/01'
    ,30000
    ,'�ڿ���'
    ,'�������, ����, ����'
  );
INSERT INTO book_tbl_06
(
   book_no
  ,book_name
  ,book_covering
  ,book_date
  ,book_price
  ,book_publisher
  ,book_info
)
VALUES
  (
     104
    ,'HTML'
    ,'104.jpg'
    ,'2018/04/04'
    ,10000
    ,'ȫ�浿'
    ,'HTML/CSS/JACASCRIPT/JQUERY'
  );
-- �����������
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10001
    ,100
    ,2400
    ,'2018/07/02'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10002
    ,101
    ,2000
    ,'2018/07/04'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10003
    ,100
    ,2400
    ,'2018/08/02'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10004
    ,100
    ,2400
    ,'2018/08/12'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10005
    ,102
    ,2500
    ,'2018/08/13'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10006
    ,103
    ,3000
    ,'2018/08/13'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10007
    ,103
    ,3000
    ,'2018/08/20'
    ,'0'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10008
    ,100
    ,2400
    ,'2018/09/03'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10009
    ,100
    ,2400
    ,'2018/09/08'
    ,'1'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10010
    ,100
    ,2400
    ,'2018/09/14'
    ,'0'
  );
INSERT INTO rent_tbl_06
(
   rent_no
  ,book_no
  ,rent_price
  ,rent_date
  ,rent_status
)
VALUES
  (
     10011
    ,102
    ,2500
    ,'2018/09/14'
    ,'0'
  );