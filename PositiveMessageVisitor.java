/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

/**
 *
 * @author nathangoshay
 */
public class PositiveMessageVisitor implements Visitor {

    @Override
    public int visitUser(User user) {
        int count = 0;

        if (user.getClass() == SingleUser.class) {
            count += visitSingleUser(user);
        } else if (user.getClass() == UserGroup.class) {
            count += visitUserGroup(user);
        }

        return count;
    }

    @Override
    public int visitSingleUser(User user) {
        return ((SingleUser) user).getPositiveTweetCount();
    }

    @Override
    public int visitUserGroup(User user) {
        int count = 0;

        for (User u : ((UserGroup) user).getUserGroups().values()) {
            count += visitUser(u);
        }

        return count;
    }

}
