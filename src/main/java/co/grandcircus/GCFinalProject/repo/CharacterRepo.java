package co.grandcircus.GCFinalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.GCFinalProject.dndpojos.PlayerCharacter;

public interface CharacterRepo extends JpaRepository<PlayerCharacter, Integer> {

}
