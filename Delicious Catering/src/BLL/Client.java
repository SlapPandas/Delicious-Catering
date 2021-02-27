package BLL;

public class Client {

    private String username;
    private String password;
    private String firstname;
    private String surname;
    private int contactnr;
    private String email;
    private String address;
    private Boolean adminRights;


    public Client(String uname, String passw, String fname, String sname, int nr, String em, String adrs, Boolean admn){
        this.username = uname;
        this.password = passw;
        this.firstname = fname;
        this.surname = sname;
        this.contactnr = nr;
        this.email = em;
        this.address = adrs;
        this.adminRights = admn;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public int getContactnr() {
        return contactnr;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public Boolean getAdminRights() {
        return adminRights;
    }



}