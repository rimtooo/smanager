--�л�����(�л���ȣ, �̸�, ����ó, �ּ�, �������)
--tbl_student ���̺��.
create table student(
    std_no varchar2(10) primary key,
    std_name varchar2(100) not null,
    std_phone varchar2(20), -- 010-1111-2222
    address varchar2(100),
    birth_date date,
    creation_date date default sysdate
);

-- sample data.
insert into student (std_no, std_name, std_phone)
values('S2024-01', 'ȫ�浿', '010-1234-5678');
insert into student (std_no, std_name, std_phone, address)
values('S2024-02', '��浿', '010-3333-4444', '���� 100����');

select *
from student;

update student
set address = '���� 100'
where std_no = 's2024-01';

delete from student
where std_no = 'S2024-01';


--����, �ּ� ����
update student
set birth_date = to_date('19940621', 'yyyy-mm-dd')
    ,std_no = 'S2024-03',
    -- address = address
where address = '���� 100';

--update student
--set std_name = '���氪'
--    ,std_phone = '���氪'
--where std_no = 'S2024-02';


rollback;


insert into student (std_no, std_name, std_phone)
values('S2024-04', '��α�', '010-2222-5678');

commit;

-- std_no,