package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void check_when_same_team() {
        Team team1 = new Team("test-team");
        Team team2 = team1;
        assertEquals(true, team1.equals(team2));
    }
    
    @Test
    public void check_when_different_type() {
        Team team1 = new Team("test-team");
        String notATeam = "not a team";
        assertEquals(false, team1.equals(notATeam));
    }

    @Test
    public void check_when_TT() {
        Team team1 = new Team("test-team");
        team1.setMembers(team.getMembers());
        Team team2 = new Team("test-team");
        team2.setMembers(team.getMembers());
        assertEquals(true, team1.equals(team2));
    }

    @Test
    public void check_when_FF() {
        Team team1 = new Team("test-team1");
        team1.setMembers(team.getMembers());
        Team team2 = new Team("test-team2");
        team2.addMember("member1");
        assertEquals(false, team1.equals(team2));
    }
    @Test
    public void check_when_TF() {
        Team team1 = new Team("test-team");
        team1.setMembers(team.getMembers());
        Team team2 = new Team("test-team");
        team2.addMember("member1");
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void check_when_FT() {
        Team team1 = new Team("test-team1");
        team1.setMembers(team.getMembers());
        Team team2 = new Team("test-team2");
        team2.setMembers(team.getMembers());
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void check_hashCode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void check_hashCode_when_different() {
        // instantiate t as a Team object
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}    
