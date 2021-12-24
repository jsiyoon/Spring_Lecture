USE test;

DESC Board;
DESC Member;

-- Board.writer가 Member.id참조
ALTER TABLE Board
ADD FOREIGN KEY (writer) REFERENCES Member(id);

-- 탈퇴한 아이디의 게시물 삭제(위의 코드 에러 났을 시 실행)
DELETE FROM Board WHERE id IN
(SELECT b.id
FROM Board b LEFT JOIN Member m ON b.id = m.id
WHERE m.id IS NULL);

-- Reply boardId가 Board id를 참조
ALTER TABLE Reply
ADD FOREIGN KEY (boardId) REFERENCES Board(id);

-- Reply memberId가 Member id를 참조
ALTER TABLE Reply
ADD FOREIGN KEY (memberId) REFERENCES Member(id);

DESC Reply;

-- 지워진 게시물에 달린 댓글 지우기
SELECT r.id, b.id FROM Reply r LEFT JOIN Board b ON r.boardId = b.id WHERE b.id IS NULL;

select * from Reply;
select * from Board ORDER BY id DESC;

delete from Reply;
select * from Member;
desc Member;

