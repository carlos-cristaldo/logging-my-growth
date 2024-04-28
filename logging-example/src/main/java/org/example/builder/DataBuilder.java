package org.example.builder;

import org.example.model.MonsterModel;
import org.example.utils.Constants;
import org.example.utils.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static org.example.utils.Utils.getRandomNumber;

public class DataBuilder {

    public static MonsterModel monsterBuilder(){
        int monsterId = getRandomNumber(1,5);
        return new MonsterModel.MonsterBuilder(
                monsterId,
                Utils.getRandomString(10),
                String.valueOf(getRandomNumber(1, 100)),
                String.valueOf(getRandomNumber(1, 100)),
                String.valueOf(getRandomNumber(1, 100)),
                String.valueOf(getRandomNumber(1, 100))
        ).build();
    }

    public static MonsterModel monsterBuilderParemeterized(){
        int monsterId = getRandomNumber(1,5);
        return new MonsterModel.MonsterBuilder(
                monsterId,
                Utils.getRandomString(10),
                String.valueOf(getRandomNumber(1, 100)),
                String.valueOf(getRandomNumber(1, 100)),
                String.valueOf(getRandomNumber(1, 100)),
                String.valueOf(getRandomNumber(1, 100))
        ).build();
    }

    public static Map<String, String> dataBuilder(@NotNull MonsterModel monster){
        Map<String, String> data = new HashMap<>();
        data.put(Constants.MONSTER_NAME_ATTR, monster.getName());
        data.put(Constants.MONSTER_HP_ATTR, monster.getHp());
        data.put(Constants.MONSTER_ATTACK_ATTR, monster.getAttack());
        data.put(Constants.MONSTER_DEFENSE_ATTR, monster.getDefense());
        data.put(Constants.MONSTER_SPEED_ATTR, monster.getSpeed());
        return data;
    }
}
