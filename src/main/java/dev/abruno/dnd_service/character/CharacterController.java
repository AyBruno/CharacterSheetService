package dev.abruno.dnd_service.character;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/characters")
public class CharacterController {

    @GetMapping("{user_id}")
    public List<CharacterModel> getCharactersForUser(@PathVariable("user_id") int user_id){
        List<CharacterModel> characterList = new ArrayList<>();
        characterList.add(new CharacterModel.CharacterBuilder(user_id, "Brumbo").build());
        return characterList;
    }

    @GetMapping("/random")
    public CharacterModel getRandomCharacter(){
        return new CharacterModel.CharacterBuilder(0, "Random Name")
                .randomizeRace()
                .randomizeCharacterClass()
                .randomizeStats()
                .build();
    }

}
