package com.kausik.ipldashboard.repository;

import com.kausik.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository <Team, Long> {

    Team findByTeamName(String teamName);
}
