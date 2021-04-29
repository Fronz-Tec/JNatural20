package ch.obvita.jnatural.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CharacterService {

    @Autowired
    private CharacterRepo repo;


}
