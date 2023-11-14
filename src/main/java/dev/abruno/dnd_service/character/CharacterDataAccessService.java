package dev.abruno.dnd_service.character;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterDataAccessService implements CharacterDao{

    private NamedParameterJdbcTemplate jdbcTemplate;

    CharacterDataAccessService(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<CharacterModel> selectUserCharacters(int userId) {
        String sql = """
                SELECT * FROM Character_Sheet WHERE user_id = :userId
                """;
        return jdbcTemplate.query(sql, new MapSqlParameterSource().addValue("userId",userId), new CharacterRowMapper());
    }

    @Override
    public int insertCharacter(CharacterModel characterModel) {
        String sql = """
                INSERT INTO Character_Sheet(user_id, name, background, 
                                            description, character_class, race, 
                                            death_successes, death_failures, max_hit_points, 
                                            current_hit_points, experience_points, gold)
                                            VALUES(:userId, :name, :background, 
                                                   :description, :characterClass, :race, 
                                                   :deathSuccesses, :deathFailures, :maxHitPoints, 
                                                   :currentHitPoints, :experiencePoints, :gold); 
                """;
        return jdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("userId", characterModel.getUserId())
                .addValue("name", characterModel.getName())
                .addValue("background", characterModel.getBackground())
                .addValue("description", characterModel.getDescription())
                .addValue("characterClass", characterModel.getCharacterClass().name())
                .addValue("race", characterModel.getRace().name())
                .addValue("deathSuccesses", characterModel.getDeathSaves().getSuccesses())
                .addValue("deathFailures", characterModel.getDeathSaves().getFailures())
                .addValue("maxHitPoints", characterModel.getMaxHitPoints())
                .addValue("currentHitPoints", characterModel.getCurrentHitPoints())
                .addValue("experiencePoints", characterModel.getExperiencePoints())
                .addValue("gold", characterModel.getGold())
        );
    }

    @Override
    public int deleteCharacter(int characterId) {
        String sql = """
                DELETE FROM Character_Sheet WHERE id = :characterId;
                """;
        return jdbcTemplate.update(sql, new MapSqlParameterSource().addValue("characterId", characterId));
    }

    @Override
    public int updateCharacter(CharacterModel updatedCharacterModel) {
        return 0;
    }
}
