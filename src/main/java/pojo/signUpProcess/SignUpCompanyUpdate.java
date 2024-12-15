package pojo.signUpProcess;

import java.util.List;

public class SignUpCompanyUpdate {
    private String companyName;
    private String companySize;
    private String location;
    private List<SignUpCompanyUpdateWorkspace> workspaces;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<SignUpCompanyUpdateWorkspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<SignUpCompanyUpdateWorkspace> workspaces) {
        this.workspaces = workspaces;
    }
}
