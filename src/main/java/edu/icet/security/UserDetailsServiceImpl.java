package edu.icet.security;

import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toSet());

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
