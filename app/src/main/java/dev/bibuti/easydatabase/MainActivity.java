package dev.bibuti.easydatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import dev.bibuti.easydatabase.models.User;
import dev.bibuti.easydb.EasyDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User("Bibuti Koley", "Male", "Full Time");

        //Save to Database..
        EasyDB.put(EasyDBConstants.USERKEY, user);

        //Read from Database..
        User u = (User) EasyDB.getObject(EasyDBConstants.USERKEY, User.class);
        System.out.println(u.getName());
        System.out.println(u.getGender());
        System.out.println(u.getWorkField());

        //Save Multiple Users..
        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userArrayList.add(new User("UserName - " + i, "Gender - " + i, "WorkField - " + i));
        }
        EasyDB.put(EasyDBConstants.USERLISTKEY, userArrayList);

        //Read from Database..
        ArrayList<User> savedUsers = EasyDB.getArrayList(EasyDBConstants.USERLISTKEY, User.class);
        //Print the values..
        for (User singleUser : savedUsers) {
            System.out.println("User -> " + singleUser.getName() + "," + singleUser.getGender() + "," + singleUser.getWorkField());
        }

    }
}
