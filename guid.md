
1. maven project 생성(war)

2. web.xml 추가

3. targeted runtime 설정 

4. pom.xml 설정 

5. web.xml 설정 

	5.1 /WEB-INF/applicationContext.xml (Root Application Context)
	5.2 /WEB-INF/spring-servlet.xml (Web Application Context)


6. package 및 source code 추가 


	com.douzone.emaillist.controller
			|--EmaillistController
	com.douzone.emaillist.repository
			|--EmaillistRepository
	com.douzone.emaillist.vo
			|--EmaillistVo

* jdbc, jstl 라이브러리 추가 	
