package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users1")


public class User implements UserDetails {
    public static final Object ROLE_USER = "";
    public static final Object ROLE_ADMIN ="" ;
    @Id
    private String userId;
    private String username;
    private String password;
    private String email;
    private Date registrationDate=new Date();
    private Set<String> roles=new HashSet<>();
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;








    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void getRegistrationDate(Date date) {
    }

    public class ROLE_ADMIN {
    }
}
