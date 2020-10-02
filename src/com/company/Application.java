package com.company;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Vasile","Negru","vasilenegru@gmail.com",20,
                Timestamp.valueOf(LocalDateTime.now().minusDays(2)),Status.INACTIVE ));
        userList.add(new User("Ion","Rosca","ionrosca@gmail.com",20,
                Timestamp.valueOf(LocalDateTime.now().minusDays(4)),Status.NEW ));
        userList.add(new User("Andrei","Brown","andrewbrown@gmail.com",22,
                Timestamp.valueOf(LocalDateTime.now()),Status.NEW ));
        userList.add(new User("Nikita","Lexus","lexus@gmail.com",20,
                Timestamp.valueOf(LocalDateTime.now().minusMonths(2)),Status.INACTIVE ));
        userList.add(new User("Alex","Ester","Ester@gmail.com",20,
                Timestamp.valueOf(LocalDateTime.now()),Status.ACTIVE ));
        userList.forEach((user ->{

            if (user.status==Status.NEW && user.getTimestamp().before(User.yesterday())){
                user.setStatus(Status.ACTIVE);
            }
            if (user.status==Status.INACTIVE && user.getTimestamp().before(User.month())){
                user.setStatus(Status.BLOCKED);
            }

        }));
        userList.forEach(user -> {
            System.out.println(user.toString());
        });

    }

}
