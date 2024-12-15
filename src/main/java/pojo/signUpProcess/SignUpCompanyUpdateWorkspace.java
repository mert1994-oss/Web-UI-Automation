package pojo.signUpProcess;

import java.util.List;

public class SignUpCompanyUpdateWorkspace {
    private String id;
    private String name;
    private List<SignUpCompanyUpdateUser> users;
    private long createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SignUpCompanyUpdateUser> getUsers() {
        return users;
    }

    public void setUsers(List<SignUpCompanyUpdateUser> users) {
        this.users = users;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
}
