package fonket.pendindong.models.models;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by felip on 27-02-2017.
 */

public class Pending extends SugarRecord implements Serializable {

    private String name, description;
    private boolean done;

    public Pending() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
