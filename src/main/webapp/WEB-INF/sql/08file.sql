USE test;

CREATE TABLE File(
	id INT PRIMARY KEY AUTO_INCREMENT,
    boardId INT NOT NULL,
    fileName VARCHAR(255) NOT NULL,
    FOREIGN KEY (boardId) REFERENCES Board(id)
);

DESC File;

SELECT * FROM File ORDER BY boardId DESC, id ASC;

-- '542'이미지들 '543'이미지 공간에 복사
INSERT INTO File(boardId, fileName)
SELECT '542' as boardId, fileName FROM File WHERE boardId = 543;