```mysql
drop procedure if exists calStaffConsumeNum;
CREATE
    DEFINER = `root`@`localhost` PROCEDURE `calStaffConsumeNum`(IN `staId` int, OUT `num` int)
BEGIN
    -- 		创建接收游标数据的变量  
    declare iu int;
    --     declare n varchar(20);  
-- 		创建总数变量  
    declare total int default 0;
-- 		创建结束标志变量  
    declare done int default false;
-- 		创建游标  
    declare cur cursor for select apply.sta_id
                           from apply
                           where apply.sta_id = staId and apply.apply_is_check = 1 and apply.apply_result = 1;
-- 		指定游标循环结束时的返回值  
    declare continue HANDLER for not found set done = true;
-- 		设置初始值  
    set `num` = 0;
-- 		打开游标  
    open cur;
-- 		开始循环游标里的数据  
    read_loop:
    loop
        -- 		根据游标当前指向的一条数据  
        fetch cur into iu;
-- 		判断游标的循环是否结束  
        if done then
            leave read_loop;
-- 				跳出游标循环  
        end if;
-- 		获取一条数据时，将count值进行累加操作，这里可以做任意你想做的操作，  
        set `num` = `num` + iu;
-- 		结束游标循环  
    end loop;
-- 		关闭游标  
    close cur;
-- 		输出结果  
    select `num`;

END;

-- 		调用存储过程
set @id = 1;
set @num = 0;
call calStaffConsumeNum(@id, @num);
```

