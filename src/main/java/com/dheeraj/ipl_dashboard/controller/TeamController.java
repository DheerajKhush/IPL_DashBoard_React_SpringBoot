package com.dheeraj.ipl_dashboard.controller;

import com.dheeraj.ipl_dashboard.model.Team;
import com.dheeraj.ipl_dashboard.repository.MatchRepository;
import com.dheeraj.ipl_dashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
        this.teamRepository=teamRepository;
        this.matchRepository=matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
         Team team= this.teamRepository.findByTeamName(teamName);
         team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));
         return team;
    }

    
}
