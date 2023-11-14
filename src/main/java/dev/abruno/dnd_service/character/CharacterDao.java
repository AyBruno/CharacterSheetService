package dev.abruno.dnd_service.character;

import java.util.List;
public interface CharacterDao {
    List<CharacterModel> selectUserCharacters(int user_id);
    int insertCharacter(CharacterModel characterModel);
    int deleteCharacter(int characterId);
    int updateCharacter(CharacterModel updatedCharacterModel);
}
