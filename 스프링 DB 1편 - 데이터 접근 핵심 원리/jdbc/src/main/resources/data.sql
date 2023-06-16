-- 수동 커밋 모드로 전환 => 트랜잭션 시작
set autocommit = true; -- 자동 커밋 모드 설정
insert into member(member_id, money) values ('data1',10000); -- 자동 커밋
insert into member(member_id, money) values ('data2',10000); -- 자동 커밋

set autocommit = false; -- 수동 커밋 모드 설정
insert into member(member_id, money) values ('data3',10000);
insert into member(member_id, money) values ('data4',10000);
commit; -- 수동 커밋


-- 조회시 락을 사용하고 싶다면 select for update 사용
set autocommit = false;
select * from member where member_id='memberA' for update;
-- 조회한 세션에서 커밋하기 전까지
-- 다른 세션에서 데이터 변경 불가(조회는 가능함)