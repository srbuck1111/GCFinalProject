package co.grandcircus.GCFinalProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.GCFinalProject.mappojos.Place;

public interface MapRepo extends JpaRepository<Place, Integer> {

}
