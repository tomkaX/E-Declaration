package main.java.logic.model.dao;

import logic.model.dao.Declaration;
import logic.model.dao.Roles;
import logic.model.dao.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spayker on 2/24/2016.
 */

public class UserTest extends CommonEntityTest<User> {

    @Override
    protected User getFirstEntity() {
        List<Declaration> declarations = new ArrayList<Declaration>();

        return User.createUser(
                "Vasya",
                "Pupkin",
                "Vasek",
                "qwerty",
                Roles.USER
        );

    }

    @Override
    protected User getSecondEntity() {
        List<Declaration> declarations = new ArrayList<Declaration>();
        return User.createUser(
                "Viktor",
                "Santope",
                "Dark_vik",
                "qazxsw",
                Roles.USER
        );
    }
}


