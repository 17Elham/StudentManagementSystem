USE studentmanagementdb;

-- التقرير الأول: يربط كل طالب بالمادة اللّي سجل فيها ودرجته (INNER JOIN)
SELECT s.name AS 'Student Name', c.course_name AS 'Course Name', e.grade AS 'Final Grade'
FROM enrollments e
INNER JOIN students s ON e.student_id = s.student_id
INNER JOIN courses c ON e.course_code = c.course_code;


-- التقرير الثاني: يربط كل مدرس بالقسم اللّي يقرّي فيه (INNER JOIN)
SELECT t.name AS 'Teacher Name', d.department_name AS 'Department'
FROM teachers t
INNER JOIN departments d ON t.department_id = d.department_id;