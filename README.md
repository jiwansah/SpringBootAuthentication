# SpringBootAuthentication
# Getting Started

1) If you want stateless authentication then 
uncomment the below line from WebSecurityConfig.java file

//		http.csrf().disable()
//		.cors().disable()
//		.authorizeRequests()
//		.antMatchers("/token").permitAll()
//		.antMatchers(HttpMethod.POST, "/employees").permitAll()
//		.anyRequest().authenticated()
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


2) For State full authentication 
uncomment the below line from WebSecurityConfig.java file
	http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/employees").permitAll()
		.antMatchers("/token").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and().cors().disable()
		.csrf().disable();


3) This application contain JWT Authentication, Form Authentication, QAuth2 Authentication.

4) give the correct value for below in application.properties


spring.datasource.url=jdbc:hsqldb:hsql://localhost:9001/
spring.datasource.username=sa
spring.datasource.password=
