package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Table(name = "`log`")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint")
    private long id;
    @Column(columnDefinition = "varchar(50)")
    private String account_id;
    @Column(columnDefinition = "datetime")
    private Timestamp login_time;
    @Column(columnDefinition = "datetime")
    private Timestamp logout_time;
    @Column(columnDefinition = "varchar(250)")
    private String notes;

    public Log() {
    }

    public Log(String acccount_id, Timestamp login_time, Timestamp logout_time, String notes) {
        this.account_id = acccount_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcccount_id() {
        return account_id;
    }

    public void setAcccount_id(String acccount_id) {
        this.account_id = acccount_id;
    }

    public Timestamp getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Timestamp login_time) {
        this.login_time = login_time;
    }

    public Timestamp getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Timestamp logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Log(long id, String acccount_id, Timestamp login_time, Timestamp logout_time, String notes) {
        this.id = id;
        this.account_id = acccount_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", acccount_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
