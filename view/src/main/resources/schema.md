## Table employee

Contains information about employees in database:

id  - employee identifier, required field,

firstname - employee firstname, required field,

lastname - employee lastname, required field,

fathername - employee fathername,

position - employee position in team,

account - employee account, unique,

email - employee email,

status - employee status (ACTIVE, DELETED),

password character varying(50) NOT NULL,

is_temporary_pwd - boolean value, required for authorisation sequrity, required field.

## Table task

Contains information about task in database:

id - task identifier, required field,

name  - task name, required field, required field,

description - task description, required field,

employee\_id - idetifier of the employee that do this task,

project\_id - identifier of the project this task belongs to,

labour\_hours - required time for this work (in hours), required field,

deadline - deadline date, required field,

status - task status, requred field (NEW, IN_PROGRESS, COMPLETED, CLOSED),

author\_id - author identifier, required field,

author - author name, required field,

creation\_date - creation date, required field,

update\_date  - update date, required field.

## Table project

Contains information about employee in database:

id - project identifier, required field,

team_id - team identifier that works in this project,

name - project name, required field,

description - project description,

status - project status, required field (DRAFT, DEVELOPING, TESTING, COMPILED).

## Table team

Contains information about employee in project:

team\_id - command identifier, required field,

employee\_id - employee identifier, required field,

role - employee role, required field (PROJECT_MANAGER, ANALYST, PROGRAMMER, TESTER).

## Table employee_in_team

Contains information about team in database:

id - command identifier, required field,

name - team name, required field.