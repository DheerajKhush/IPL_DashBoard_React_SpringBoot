package com.dheeraj.ipl_dashboard.repository;

import com.dheeraj.ipl_dashboard.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>{
    
    Team findByTeamName(String TeamName);
}
