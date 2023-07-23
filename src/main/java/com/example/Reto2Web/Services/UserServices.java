package com.example.Reto2Web.Services;

import com.example.Reto2Web.Model.User;
import com.example.Reto2Web.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return
     */
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    /**
     *
     * @param zone
     * @return
     */
    public List<User> getUsersByZone(String zone){
        String zoneL = zone.toLowerCase();
        return userRepository.getUserByZone(zoneL);
    }

    /**
     *
     * @param type
     * @return
     */
    public List<User> getUsersByType(String type){
        String typeL = type.toLowerCase();
        return userRepository.getUserByType(typeL);
    }


    /**
     *
     * @param month
     * @return
     */


    /**
     *
     * @param id
     * @return
     */
    public Optional<User> getUserById(Integer id){
        return userRepository.getUserById(id);
    }

    /**
     *
     * @param email
     * @return
     */
    public Boolean getUserByEmail(String email) {
        if(Utilities.validateEmail(email))
            return userRepository.findUserByEmail(email).isPresent()? true: false;
        else
            // TODO add a nice exception
            return false;
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> validateUserLogin(String email, String password){
        if(Utilities.validateEmail(email)) {
            if (password.length() >= 6)
                return userRepository.validateLogin(email, password);
            else
                return null;
        }
        else
            return null;
    }

    /**
     *
     * @param user
     * @return
     */
    public User insertUser(User user){
        if(Utilities.validateEmail(user.getEmail())){
            Optional<User> temp = userRepository.findUserByEmail(user.getEmail());
            if(temp.isEmpty()) {
                user.setType( user.getType().toUpperCase() );
                user.setZone( user.getZone().toUpperCase() );

                return userRepository.save(user);
            }
            else
                // TODO use a better exception
                return user;
        }
        return user;
    }

    /**
     *
     * @param user
     * @return
     */
    public User updateUser(User user){
        Optional<User> tempUser = userRepository.getUserById(user.getId());
        if(tempUser.isPresent()){
            if(user.getName() != null)
                tempUser.get().setName(user.getName());
            if(user.getAddress() != null)
                tempUser.get().setAddress(user.getAddress());
            if(user.getCellPhone() != null)
                tempUser.get().setCellPhone(user.getCellPhone());
            if(user.getPassword() != null)
                tempUser.get().setPassword(user.getPassword());
            if(user.getZone() != null)
                tempUser.get().setZone(user.getZone());
            if(user.getType() != null)
                tempUser.get().setType(user.getType());
            return userRepository.save(tempUser.get());
        }
        else
            return user;
    }

    /**
     *
     * @param userId
     */
    public void deleteUser(Integer userId){
        // TODO check if it is better to use getUserById
        Optional<User> tempUser = userRepository.findById(userId);
        if(tempUser.isPresent())
            userRepository.delete(tempUser.get());
        // TODO add exception ResourceNotFoundException
    }
}
