package main.java.logic.model.dao;

import logic.model.dao.Declaration;
import logic.model.dao.Official;
import logic.model.dao.Roles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spayker on 2/24/2016.
 */
public class OfficialTest extends CommonEntityTest<Official> {

    @Override
    protected Official getFirstEntity() {
        List<Declaration> declarations = new ArrayList<Declaration>();

        return Official.createOfficial(
                "Vasya",
                "Pupkin",
                "Vasek",
                "qwerty",
                Roles.OFFICIAL
        );

    }

    @Override
    protected Official getSecondEntity() {
        List<Declaration> declarations = new ArrayList<Declaration>();
        return Official.createOfficial(
                "Viktor",
                "Santope",
                "Dark_vik",
                "qazxsw",
                Roles.OFFICIAL
        );
    }
}