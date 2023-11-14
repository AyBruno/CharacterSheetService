package dev.abruno.dnd_service.character;

import dev.abruno.dnd_service.character.util.RandomNameGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/characters")
public class CharacterController {
    private final CharacterDataAccessService characterDao;
    CharacterController(CharacterDataAccessService characterDao){
        this.characterDao = characterDao;
    }

    @GetMapping("/")
    public List<CharacterModel> getCharactersForUser(@RequestParam(required=true) int userId){
        List<CharacterModel> characterList = characterDao.selectUserCharacters(userId);
        return characterList;
    }

    @GetMapping("/random")
    public CharacterModel getRandomCharacter(@RequestParam(required = false) Integer userId){
        return new CharacterModel.CharacterBuilder((userId == null) ? 0 : userId, RandomNameGenerator.getRandomName())
                .randomizeRace()
                .randomizeCharacterClass()
                .randomizeStats()
                .build();
    }

    @PostMapping("/random")
    public int addRandomCharacter(@RequestParam Integer userId){
        CharacterModel randomCharacter = getRandomCharacter(userId);
        return characterDao.insertCharacter(randomCharacter);
    }

    @DeleteMapping("/{character-id}")
    public int deleteCharacter(@PathVariable("character-id") int characterId){
        return characterDao.deleteCharacter(characterId);
    }

}
