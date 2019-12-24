import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Member {
    private int id;
    private boolean isActive = true;

    public Member(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        String sysTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        return sysTime + " member" + getId() + ": ";
    }
}
