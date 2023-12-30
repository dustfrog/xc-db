package com.rkennedy.running.persistance.respository;

import com.rkennedy.running.persistance.entities.Athlete;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, String> {

  /**
   * Returns a list of athletes whose last name is lastName.
   *
   * Note: This function was created for writing Test class for Repository.
   *
   * @param lastName String value
   * @return List of Athletes
   */
  @Query("select athlete from Athlete athlete where athlete.lastName = :lastName")
  List<Athlete> findAthleteWithLastName(@Param("lastName") String lastName);
}
