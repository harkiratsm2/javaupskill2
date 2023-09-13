package com.hcl.surabirestaurant.to;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private com.hcl.surabirestaurant.entity.UserDetails user;
	
	public CustomUserDetails(com.hcl.surabirestaurant.entity.UserDetails user)
	{
		this.user = user;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		System.out.println("I am inside getAuthorities");
		
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		
		set.add(new SimpleGrantedAuthority(this.user.getRole()));
		
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
