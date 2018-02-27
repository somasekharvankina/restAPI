package firstProject.repository;

import firstProject.model.userModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by somasekhar on 2/25/2018.
 */
public interface userRepository {

    public List<userModel> findAll();
}
