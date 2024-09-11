use ssafydb;

-- 테이블 생성
create table ssafy_members (
	idx			int 		not null auto_increment,
	userid		varchar(16)	not null,
	username	varchar(20),
	userpwd		varchar(16),
	emailid		varchar(20),
	emaildomain	varchar(50),
	joindate	timestamp	not null default current_timestamp,
	primary key (idx)
) ENGINE=InnoDB default CHARSET=utf8;

-- 회원 정보 등록
-- 'kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com' 등록시간


-- '김싸피', 'kimssafy', '1234'


-- '이싸피', 'leessafy', '1234'
-- '박싸피', 'parkssafy', '9876'


-- 회원 정보 변경
-- userid가 kimssafy인 회원의 비번을 9876, 이메일 도메인을 ssafy.co.kr으로 변경.


-- 회원 정보 삭제
-- userid가 kimssafy 회원 탈퇴
