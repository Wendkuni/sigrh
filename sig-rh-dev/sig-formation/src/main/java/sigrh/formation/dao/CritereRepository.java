package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Critere;

@Repository
public interface CritereRepository extends JpaRepository<Critere, Integer>{

}
