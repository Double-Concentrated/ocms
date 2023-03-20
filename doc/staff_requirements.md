# staff

<br>

## 查看员工信息

select * from staff

<br>

## 查询某员工信息

输入staName

根据关键词搜索该元组信息

查询结构都根据

sta_id sta_name sta_dept sta_tele形式展示

搜索为空输出："您所查找的信息不存在。"

<br>

## 提交apply

员工可以填写申请信息

点击apply弹出以下列

staId conName conTime applyName applyNum

另外applyTime为提交apply当前时间

applyIsCheck默认为0

填写申请后点击提交后续操作在apply表实现->此处后续跳转apply表

<br>

## 查询审核情况

员工点击查询审核情况后显示apply表中信息

select apply_id, apply_name, apply_time, con_time, apply_num, apply_is_check, apply_result, apply_note

from apply