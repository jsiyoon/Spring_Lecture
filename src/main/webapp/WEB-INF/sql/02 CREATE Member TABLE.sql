USE test;

CREATE TABLE Member(
	id VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL
);

ALTER TABLE Member ADD COLUMN inserted DATETIME NOT NULL DEFAULT NOW();

SELECT * FROM Member ORDER BY inserted DESC;

ALTER TABLE Member ADD COLUMN nickName VARCHAR(30); -- 컬럼추가

UPDATE Member SET nickName = id; -- id 컬럼을 nickName컬럼으로 추가

ALTER TABLE Member MODIFY COLUMN nickName VARCHAR(30) UNIQUE NOT NULL; -- 제약 사항 추가 unique, not null

-- Board테이블의 작성자 열을 Member테이블 id값으로 수정
UPDATE Board SET writer = (SELECT id FROM Member ORDER BY inserted LIMIT 1);

-- Member 조회 with 작성한 게시글 수
SELECT m.id, m.password, m.email, m.address, m.inserted, m.nickName, COUNT(b.id)
FROM Member m JOIN Board b ON m.id = b.writer
GROUP BY m.id
ORDER BY m.inserted DESC;