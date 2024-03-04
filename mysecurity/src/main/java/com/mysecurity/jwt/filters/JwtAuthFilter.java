package com.mysecurity.jwt.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mysecurity.controller.JwtService;
import com.mysecurity.model.UserInfoService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
  
// This class helps us to validate the generated jwt token 
@Component
public class JwtAuthFilter extends OncePerRequestFilter { 
  
    @Autowired
    private JwtService jwtService; 
  
    @Autowired
    private UserInfoService userDetailsService; 
  
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
      
    	
    	String authHeader = request.getHeader("Authorization"); 
    	
    	System.out.println("in doFilterInternal.................."+authHeader);
        String token = null; 
        String username = null; 
        if (authHeader != null && authHeader.startsWith("Bearer ")) { 
        	System.out.println("in doFilterInternal--Bearer if .................."+authHeader);
            token = authHeader.substring(7); 
            username = jwtService.extractUsername(token); 
        } 
  
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { 
        	System.out.println("in doFilterInternal security context is null.................");
        	
            UserDetails userDetails = userDetailsService.loadUserByUsername(username); 
            if (jwtService.validateToken(token, userDetails)) { 
            	System.out.println("in doFilterInternal in validate token .................");
            	UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
                SecurityContextHolder.getContext().setAuthentication(authToken); 
            } 
        } 
        
        filterChain.doFilter(request, response); 
    } 
} 