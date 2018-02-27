package firstProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by somasekhar on 2/25/2018.
 */

@Entity
@Table(name="userlist")
@NamedQuery(name="userModel.findAll",query="Select s from userlist as s ")
public class userModel {

    @Id
    private String user_id;
    public userModel(){
        this.user_id = UUID.randomUUID()
                .toString();
  }
    private String last_name ;
    private String first_name;
    private String email_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
