package dev.abruno.dnd_service.character;

import dev.abruno.dnd_service.character.util.CharacterClass;
import dev.abruno.dnd_service.character.util.Race;
import dev.abruno.dnd_service.character.util.StatHelper;
import dev.abruno.dnd_service.util.RandomEnumGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/characters")
public class CharacterController {
    private static RandomEnumGenerator randomClassGenerator = new RandomEnumGenerator(CharacterClass.class);
    private static RandomEnumGenerator randomRaceGenerator = new RandomEnumGenerator(Race.class);
    private static RandomEnumGenerator randomAbilityGenerator = new RandomEnumGenerator(StatHelper.Ability.class);
    private static RandomEnumGenerator randomSkillGenerator = new RandomEnumGenerator(StatHelper.Skill.class);

    @GetMapping("{user_id}")
    public List<CharacterModel> getCharactersForUser(@PathVariable("user_id") int user_id){
        List<CharacterModel> characterList = new ArrayList<>();
        characterList.add(new CharacterModel.CharacterBuilder(1, "Brumbo").build());
        return characterList;
    }

    @GetMapping("/random")
    public CharacterModel getRandomCharacter(){
        return new CharacterModel.CharacterBuilder(0, "Random Name")
                .setCharacterClass((CharacterClass)randomClassGenerator.getRandomValue())
                .setRace((Race)randomRaceGenerator.getRandomValue())
                .randomizeStats()
                .build();
    }

}
