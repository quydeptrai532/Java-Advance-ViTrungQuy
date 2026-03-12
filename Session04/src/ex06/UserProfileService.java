package ex06;

import java.time.LocalDate;
import java.util.List;

public class UserProfileService {

    public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers){

        // check ngày sinh tương lai
        if(newProfile.getBirthDate().isAfter(LocalDate.now())){
            return null;
        }

        String newEmail = newProfile.getEmail();

        // check email trùng
        for(User u : allUsers){
            if(u != existingUser && u.getEmail().equals(newEmail)){
                return null;
            }
        }

        // cập nhật
        existingUser.setEmail(newEmail);
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}