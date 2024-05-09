package sk.vinconafta.vpasem.Models;


import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Meno" )
    private String meno;
    @Column(name = "Priezvisko")
    private String priezvisko;
    @Column(name = "Titul")
    private String titul;
    @Column(name = "email", nullable = false, length = 64, unique = true)
    public String email;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "password")
    private String password;
    public String getMeno() {
        return meno;
    }


    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getTitul() {
        return titul;
    }

    public void setTitul(String titul) {
        this.titul = titul;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
