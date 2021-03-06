package com.kausik.ipldashboard.repository;

import com.kausik.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository <Match, Long> {
    List<Match> getMatchesByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);
    default List<Match> getLatestMatchesByTeam(String teamName, int count){
        return getMatchesByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0,count));
    }
}
