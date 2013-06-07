package br.com.controle.facade;
 
import br.com.controle.dao.UserDAO;
import br.com.controle.model.User;
 
public class UserFacade {
    private UserDAO userDAO = new UserDAO();
 
    public User isValidLogin(String email, String password) {
        userDAO.beginTransaction();
        User user = userDAO.findUserByEmail(email);
 
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
 
        return user;
    }
}