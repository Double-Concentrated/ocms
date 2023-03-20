# admin

<br>

## 登陆

登陆后与admin中的中的admin_account与admin_passwd比较 一致则进入管理员界面

**传入Passwd后需要MD5加密再与数据库中的Passwd比较**

<br>

## 查看申请情况

select * from apply

<br>

## 查询某员工申请情况

输入staName

根据关键词搜索该元组信息

select * from apply

where sta_name = StaName

搜索为空输出："您所查找的信息不存在。"

<br>

## 查看员工列表

select * from staff

<br>

## 员工管理

**（管理员会先查看所有员工信息）**

#### 修改员工信息

输入staff表中 **staId staName staDept staTele** update相应信息

#### **增加员工**

输入staff表 **staName staDept staTele** （除了sta_id）之外所有字段insert相应信息

#### **删除员工**

输入**sta_id**

然后删除该条记录

<br>

## 查看所有耗材

select * from consume

<br>

## 审核

查看apply表信息

如果允许apply_result改为1拒绝改为0

审核后 把apply_is_check改为1

审核过程：

先判断apply_num是否大于con_num

根据apply表中的apply_num修改con_num

### 同意申请

如果apply_num小于con_num通过审核

**修改apply_result为1 apply_is_check为1 并且填写apply_notes**

### 拒绝申请

如果apply_num大于con_num拒绝申请（库存不足）

**修改apply_result为0 apply_is_check为1 并且填写apply_notes**

### 注意点

**staId为1代表 仓库申请 admin通过后给仓库补货  **

**！注意给仓库补完货后需要把修改con_is_replenish为false**

**staId不为1代表 员工申请 admin通过后仓库更新库存**

<br>

## 耗材管理（新增耗材 删除耗材）

**（管理员会先查看所有耗材信息）**

### 修改耗材数量

输入conName conNum

先查询con_name然后修改con_num=conNum

### 增加耗材

输入con_name con_num con_factory

con_indate时增加日期，con_is_replenish默认为0

### 删除耗材

输入con_name

先查询con_name

然后删除该条记录

<br>