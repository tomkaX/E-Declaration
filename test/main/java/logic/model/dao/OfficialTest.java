package main.java.logic.model.dao;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spayker on 2/24/2016.
 */
public class OfficialTest extends CommonEntityTest<User> {

    @Override
    protected User getFirstEntity() {
        List<Declaration> declarations = new ArrayList<Declaration>();

        return Official.createUser(
                "Vasya",
                "Pupkin",
                "Vasek",
                "qwerty",
                Roles.OFFICIAL
        );

    }

    @Override
    protected User getSecondEntity() {
        List<Declaration> declarations = new ArrayList<Declaration>();
        return Official.createUser(
                "Viktor",
                "Santope",
                "Dark_vik",
                "qazxsw",
                Roles.OFFICIAL
        );
    }
}