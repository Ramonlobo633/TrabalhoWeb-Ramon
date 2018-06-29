package com.trabalhoweb.trabalhoweb.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.trabalhoweb.trabalhoweb.models.Cliente;
import com.trabalhoweb.trabalhoweb.repository.ClienteRepository;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private ClienteRepository cr;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Cliente cliente = cr.findByLogin(login);
		
		if(cliente == null) {
			throw new UsernameNotFoundException(" não existente");
		}
		return new User(cliente.getUsername(), cliente.getPassword(), true, true, true, true, cliente.getAuthorities());
	}

}
