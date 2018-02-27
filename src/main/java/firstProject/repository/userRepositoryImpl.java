package firstProject.repository;

import firstProject.model.userModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by somasekhar on 2/25/2018.
 */
@Repository

public class userRepositoryImpl implements userRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<userModel> findAll() {
        TypedQuery<userModel> query = em.createNamedQuery("userModel.findAll",userModel.class);
        List<userModel> users = query.getResultList();
        return users;
    }
}
