package com.kausik.ipldashboard.controller;

import com.kausik.ipldashboard.model.Match;
import com.kausik.ipldashboard.model.Team;
import com.kausik.ipldashboard.repository.MatchRepository;
import com.kausik.ipldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/teams/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team =  teamRepository.findByTeamName(teamName);
        List<Match> matches = matchRepository.getLatestMatchesByTeam(teamName, 4);
        team.setMatches(matches);
        return team;
    }
}
