package uz.pdp.ssss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ssss.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUserName(String userName);

}
