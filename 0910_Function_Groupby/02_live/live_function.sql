use ssafydb;

-- ------------------- 숫자 관련 함수 ----------------------
-- 절대값 : 5  0  5
select abs(-5), abs(0), abs(+5);


-- 올림(정수) : 13  13  -12  -12
select ceil(12.2), ceiling(12.2), ceil(-12.2), ceiling(-12.2);


-- 버림(정수) : 12  -13
select floor(12.6),  floor(-12.2);


-- 반올림 : 1526  1526  1526.2  1526.16  1530  2000
select round(1526.159, 0), round(1526.159, 1), round(1526.159, 2)
, round(1526.159, -1), round(1526.159, -3)
union

-- 버림 : 1526  1526.1  1526.15  1520  1000
select truncate(1526.159, 0), truncate(1526.159, 1), truncate(1526.159, 2)
, truncate(1526.159, -1), truncate(1526.159, -3);


-- 제곱, 제곱근 : 8  8	4
select pow(2, 3), power(2, 3), sqrt(16);


-- 나머지 : 2  2
select 8 % 3, mod(8, 3);


-- 최대, 최소값 : 9  3
select greatest(6,2,3,4,9,1,7), least(6,2,3,4,9,1,7);


-- 난수
select rand(), floor(rand() * 45 + 1);


select lpad(1, 9, 0), 'a' as "String";


-- ------------------- 문자 관련 함수 ----------------------
-- 문자 :: > 아스키, 아스키 ::> 문자 : 48  65  97  '0'  'A'  'a'  'ABCD'
select ascii('0'), ascii('A'), ascii('a'), cast(char(48) as char), cast(char(65, 66, 67, 68) as char);


-- 문자열 결합 : 100번 사원의 이름 Steven King
select concat(employee_id, '번 사원의 이름 ', first_name, ' ', last_name)
from employees
where employee_id = 100;

-- select concat(concat(employee_id, '번 사원의 이름 '), first_name))
-- from employees
-- where employee_id = 100;

select employee_id || '번 사원의 이름 ' || first_name || ' ' || last_name
from employees
where employee_id = 100;


-- 구분자를 이용한 문자열 결합 : 2024-09-10
select concat_ws('.', 2024, '09', '10');


-- 문자열 대치(index) : hello ssafy !!!
select 'ssafyabc!!!', insert('ssafyabc!!!', 6, 3, ' ssafy ');


-- 문자열 대치(문자열) : hello ssafy !!!
select 'ssafyabc!!!', replace('ssafyabc!!!', 'abc', ' ssafy ');


-- 찾을 문자열의 index 반환 : 7
select instr('hello ssafy !!!', 'ssafy');

select '123-456', substr('123-456', 1, instr('123-456', '-') - 1), substr('123-456', instr('123-456', '-') + 1);


-- 문자열 추출 : ssafy
select 'hello ssafy !!!', mid('hello ssafy !!!', 7, 5), substr('hello ssafy !!!', 7, 5);


-- hello ssafy !!!
select reverse('!!! yfass olleh');


-- hello ssafy !!!  hello ssafy !!!
select lower('HelLo SsaFY'),  lcase('HelLo SsaFY');


-- HELLO SSAFY !!!  HELLO SSAFY !!!,
select upper('HelLo SsaFY'),  ucase('HelLo SsaFY');


-- hello  fy !!!
select 'hello ssafy !!!', concat(left('hello ssafy !!!', 5), '...'), right('hello ssafy !!!', 6);


-- 3자리마다 콤마(,) & 소수점 2자리까지
select format(12345678.987, 2);


-- 공백제거, 문자기준 trim
select rtrim('  aaaa  '), ltrim('  aaaa  '), trim('  a a a a  ');


-- 길이(byte), 비트수, 문자의 개수
select length('ssafy'), bit_length('ssafy'), char_length('ssafy'),
length('싸피'), bit_length('싸피'), char_length('싸피');


-- ------------------- 날짜 관련 함수 ----------------------
-- 현재 시간 2024-09-10 10:11:52  2024-09-10 10:11:52  2024-09-10 10:11:52
select now(), sysdate(), current_timestamp();


-- 현재시간 (실행시점) : 2024-09-10 10:11:52. 2024-09-10 10:11:57. 2024-09-10 10:11:52
select now(), sleep(5), sysdate(), sleep(5), current_timestamp();


-- 날짜 또는 시간만 반환 : 2024-09-10  2024-09-10  10:12:10  10:12:10
select curdate(), current_date(), curtime(), current_time();


-- X일(or 시간) 전, 후
select now(), adddate(now(), interval 5 minute), adddate(now(), interval 5 day), date_add(now(), interval -5 year),
	subdate(now(), interval 5 minute);

-- 날짜 세부 반환 함수 : 
select year(now()), month(now()), month('2024-10-11'), monthname('2024-10-11'), dayofmonth(now()), dayofweek(now());


-- 날짜 형식 지정 : 
-- 2024-09-03 14:04:44	
-- 2024 September 3 PM 2 04 44	
-- 24-09-03 14:04:44	
-- 24.09.03 Tuesday	
-- 14시04분44초
select date_format(now(), '%Y-%m-%d %H:%i:%s'),
	date_format(now(), '%y.%m.%d %p %h:%i:%s'),
    date_format(now(), '%H시%i분%s초');


-- 시간, 날짜 차



-- 달의 마지막 날



-- ------------------- 논리 관련 함수 ----------------------
-- 논리함수 : 크다  작다  3  b  a
select if(3>2, '크다','작다'), ifnull(null, 'a'), ifnull('b', 'a'), nullif('a','a'), nullif('a','b');

-- ------------------- 집계 함수 ----------------------
-- employees table에서 사원의 총수, 급여의 합, 급여의 평균, 최고급여, 최저급여
select count(employee_id) 사원수, sum(salary) 급여총합, avg(salary) 급여평균, max(salary) 최고급여, min(salary) 최저급여
from employees;

