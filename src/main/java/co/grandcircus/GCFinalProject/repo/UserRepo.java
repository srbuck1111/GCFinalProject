package co.grandcircus.GCFinalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.GCFinalProject.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
