insert into users
values (seq_users_no.nextval,
        'aaa',
        'aaa',
        'aaa',
        'male' );

commit;

select*from
users;

select no, name
from users
where id = 'test'
and password =  '1q2w3e4r';