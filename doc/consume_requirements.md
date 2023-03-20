# consume

<br>

## 【触发器实现】耗材管理（自动申请补货）

**consume**表中**con_num**小于10时把**con_is_replenish**修改为1

（表示耗材需要补货）

**在插入前触发**

**在更新前触发**

<br>

**consume**表中**con_is_replenish**等于1时候触发

同时向apply表中插入字段

sta_id=1（代表仓库需要补货）

con_id等于触发了发器的的con_id

con_time等于now

apply_time等于now

apply_num等于50

apply_name等于触发了触发器的con_name

apply_is_check等于0

（表示仓库向apply提交申请）

**在插入后触发**

**在更新后触发**

<br>

<br>

（之后补货由admin审核实现补货）

```sql
CREATE TRIGGER before_update_auto_check_replenish
    BEFORE UPDATE
    ON consume
    FOR EACH ROW
BEGIN
    IF
        (new.con_num < 10) THEN

        SET new.con_is_replenish = 1;

    END IF;

END
    
    
CREATE TRIGGER before_insert_auto_check_replenish
    BEFORE INSERT
    ON consume
    FOR EACH ROW
BEGIN
    IF
    (new.con_num < 10)
    THEN

SET new.con_is_replenish = 1;

END IF;

END
```

```sql
CREATE TRIGGER after_update_auto_apply_replenish
    AFTER UPDATE
    ON consume
    FOR EACH ROW
BEGIN
    IF (new.con_is_replenish = 1) THEN
        INSERT INTO apply
        (sta_id, con_id, apply_time, con_time, apply_num, apply_name, apply_is_check)
        SELECT 1, new.con_id, NOW(), NOW(), 50, new.con_name, 0
        FROM staff,
             apply
        WHERE staff.sta_id = apply.sta_id
        LIMIT 1;
    END IF;

END
    
    
CREATE TRIGGER after_insert_auto_apply_replenish
    AFTER INSERT
    ON consume
    FOR EACH ROW
BEGIN
    IF
    (new.con_is_replenish = 1)
    THEN
INSERT INTO apply
(sta_id, con_id, apply_time, con_time, apply_num, apply_name, apply_is_check)
SELECT 1, new.con_id, NOW(), NOW(), 50, new.con_name, 0
FROM staff,
     apply
WHERE staff.sta_id = apply.sta_id
LIMIT 1;
END IF;

END
```

<br>