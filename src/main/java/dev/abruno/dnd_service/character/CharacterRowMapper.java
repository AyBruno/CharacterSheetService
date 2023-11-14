package dev.abruno.dnd_service.character;

import dev.abruno.dnd_service.character.util.CharacterClass;
import dev.abruno.dnd_service.character.util.Race;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
public class CharacterRowMapper implements RowMapper<CharacterModel>{
    @Override
    public CharacterModel mapRow(ResultSet resultSet, int i) throws SQLException {

        String dbCharacterClass = resultSet.getString("character_class");
        String dbRace = resultSet.getString("race");

        return new CharacterModel.CharacterBuilder(resultSet.getInt("user_id"), resultSet.getString("name"))
                .setBackground(resultSet.getString("background"))
                .setDescription(resultSet.getString("description"))
                .setCharacterClass(Arrays.stream(CharacterClass.values())
                        .filter(characterClass -> characterClass.name().equals(dbCharacterClass)).findFirst().orElseThrow(() -> new IllegalStateException("Unsupported CharacterClass type in DB")))
                .setRace(Arrays.stream(Race.values())
                        .filter(race -> race.name().equals(dbRace)).findFirst().orElseThrow(() -> new IllegalStateException("Unsupported Race type in DB")))
                .setDeathSaves(resultSet.getInt("death_successes"), resultSet.getInt("death_failures"))
                .setMaxHitPoints(resultSet.getInt("max_hit_points"))
                .setCurrentHitPoints(resultSet.getInt("current_hit_points"))
                .setExperiencePoints(resultSet.getInt("experience_points"))
                .setGold(resultSet.getInt("gold"))
                .build();
    }
}
