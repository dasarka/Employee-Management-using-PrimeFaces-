###### EmployeeManagement-UsingPrimefaces
It's a simple self-designed application. 

***********ACCESS DEFINATION***********
Here resources has different access like 'Admin', 'HR', 'Developer','Client','Manager','Tester', 'Performance-Tester', 'Lead','Onsite-Manager' and 'No-Access'. 
By default everyone has 'No-Access'.
ACCESS Hierarchy(from bottom to top):
1.  'No-Access'
2.  'Admin','HR'
3.  'Developer','Performance-Tester','Tester'
4.  'Lead'
5.  'Manager'
6.  'Onsite Manager'
7.  'Client'


***********HR AND ADMIN IMPORTANCE***********
'HR' can only hire any resource and 'Admin' can only provide access to any resource.
'MasterAdmin' and 'MasterHR'are two deafult admin and hr respectively which are inbuilt in system to start the process.


***********PROJECT INTRO***********
'Internal Project' is only created by any HR and assigned to all admin and HRs. 'Bench Project' also created by HR only and assign to those resources who are not allocate to any project currently.
'Client' can only order project. After that HR can allocate resource to any project. Client can view project progress from project timeline.


***********LEAD/MANAGER/ONSITE MANAGER JOBS***********
Only LEAD/MANAGER/ONSITE MANAGER can view and edit project timeline. But LEAD can only able to create any task. Through all can release their juniors(in access) from team at any time. If they request for any resource then the request goes to HR. Based on current availibility HR can re-allocate any resource.


***********TECHNOLOGY***********
Frontend           :  JSF,Primefaces,Ajax
Backend            :  Core Java
Project Structure  :  MVC
DataBase           :  MY SQL
DB Structure       :  INNO DB
Bootstrap          :  YES
Use of JS/JQUERY   :  NO
PAGE-PATTERN       :  *.xhtml       
Seesion Handling   :  Faces Servlet

NOTE:- DB code(with both structure and test data) provide within DB folder.

*************************************************************************************************************************************
                                        CopyWrite@2018 : EmployeeManagement|ARKA DAS
*************************************************************************************************************************************                                        
