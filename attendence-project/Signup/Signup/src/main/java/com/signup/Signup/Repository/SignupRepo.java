package com.signup.Signup.Repository;

import com.signup.Signup.Model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepo extends JpaRepository<Signup,Short>{

    Signup findByEid(String eid);

    Signup findByEmail(String email);
}
