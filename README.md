# cprapp-pipeline
1. Introduction of cprapp
   Using RESTful API, I will create cpr club's homepage web application. /w Java Spring framework and React.js
2. Basic Structure of cprapp
   home, about symphony,  Medical board(CRUD), community board(CRUD), signup, signin
   /cprapp(R)
     "안녕하세요, 고려대학교 의과대학 심폐소생술 교육봉사동아리 심포니 입니다."-further animation /w .css
   /cprapp/aboutsymphony(R)(club history & founding philosophy, rules and activity purpose of the club, process being instructor, want to join?)
      ./history
         timeline image -additional animation /w .css
      ./about
         -founding philosophy and purpose of the club
         -basic rules for club members
         -goals of the club 
      ./how
         -how to be a instructor(basic lecture, deepened lecture)
         -how to join activity(check the schedules page and apply)
         
      ./tojoin
         provide google form link to join the club | compose a whole web page as a application form
   /cprapp/medicalboard(CRUD)*-bulletin board layout
   /cprapp/communityboard(CRUD)*-bulletin board layout
   /cprapp/schedules(CRUD)**
      calender and scedules->retrieve
      apply, change, cancel the schedule-> create, update, delete
   /cprapp/signup(S)
   /cprapp/signin(S)


      
     

### I want this function to be implemented!
header- if the cursor is on the header menu, mini pages are presented as thier name list
