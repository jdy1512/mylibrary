select emp.employee_id, emp.employee_name, emp.email, emp.job_position, emp.salary, emp.hire_date, emp.department_id,
	dept.department_name, dept.location
from employee emp, department dept
where emp.department_id=dept.department_id

select dept.department_id, dept.department_name, dept.location,
	emp.employee_id, emp.employee_name, emp.email, emp.job_position, emp.salary, emp.hire_date
from department dept, employee emp
where dept.department_id=300 and dept.department_id=emp.department_id

update employee
set department_id=300
where employee_id=500

create sequence dept_id_seq;

select dept_id_seq.nextval from dual;