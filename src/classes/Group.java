package classes;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<String> groupUsers;
    private List<String> groupMessage = new ArrayList<>();

    public Group(String groupName, List<String> groupUsers) {
        this.groupName = groupName;
        this.groupUsers = groupUsers;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public List<String> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<String> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public List<String> getGroupMessage() {
        return groupMessage;
    }

    public void setGroupMessage(List<String> groupMessage) {
        this.groupMessage = groupMessage;
    }

    @Override
    public String toString() {
        return "Group Name :" + groupName +
                "Group users :" + groupUsers +
                "Group Message :" + groupMessage +
                "\n>>>>>>>>>>><<<<<<<<<<<";
    }
}
