package com.rkennedy.running.persistance.respository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.rkennedy.running.persistance.entities.Athlete;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class AthleteRepositoryTest {

    @Autowired
    private AthleteRepository athleteRepository;

    @Before
    public void setUp() throws Exception {

        Athlete athlete1 =
                Athlete.builder()
                        .athleteId("id1")
                        .firstName("Arjun")
                        .lastName("Kumar")
                        .build();

        Athlete athlete2 =
                Athlete.builder()
                        .athleteId("id2")
                        .firstName("Vishu")
                        .lastName("Prem")
                        .build();

        athleteRepository.save(athlete1);
        athleteRepository.save(athlete2);
    }

    @Test
    public void testFindAthleteWithLastName() {
        String lastName = "Kumar";
        List<Athlete> athleteList = athleteRepository.findAthleteWithLastName(lastName);

        assertEquals(1, athleteList.size());
        boolean allLastNamesMatched = athleteList.stream().allMatch(athlete -> athlete.getLastName().equals(lastName));
        assertTrue(allLastNamesMatched);
    }
}
