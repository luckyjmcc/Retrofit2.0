package xb.com.retrofit.entity;

import java.util.List;

/**
 * Created by Administrator on 2015/12/16.
 */
public class LoginEntity extends BaseEntity {
    List<UserInfo> list;

    public List<UserInfo> getList() {
        return list;
    }

    public void setList(List<UserInfo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append("\n");
        int i = 0;
        for (UserInfo item : list) {
            builder.append("{").append("\n")
                    .append(item.toString())
                    .append("}").append("\n");
            i++;
        }
        builder.append("]");
        return super.toString() + "\n" + builder;
    }
}
