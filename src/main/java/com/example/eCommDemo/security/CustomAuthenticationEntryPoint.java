package com.example.eCommDemo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.eCommDemo.response.InvalidLoginResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		InvalidLoginResponse loginRes = new InvalidLoginResponse();

		String jsonRes = new Gson().toJson(loginRes);

		response.setContentType("application/json");
		response.setStatus(401);
		response.getWriter().print(jsonRes);
		
	}

}
