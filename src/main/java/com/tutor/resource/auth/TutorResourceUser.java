package com.tutor.resource.auth;

import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.model.Tutor;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Represents the users (tutor/privileged) for endpoint security
public class TutorResourceUser implements Principal {

    private final String name;
    private final String salt;
    private final String hash;
    private final Set<String> roles = new HashSet<>();

    public TutorResourceUser(PrivilegedUser user) {
        this.name = user.getEmail();
        this.salt = user.getSalt();
        this.hash = user.getPassword_hash();
        this.roles.add(user.getRole());
    }

    public TutorResourceUser(Tutor user) {
        this.name = user.getEmail();
        this.salt = user.getSalt();
        this.hash = user.getPassword_hash();
        this.roles.add("TUTOR");
    }

    // Represents the email
    @Override
    public String getName() {
        return name;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public String getSalt() {
        return salt;
    }

    public String getHash() {
        return hash;
    }
}
