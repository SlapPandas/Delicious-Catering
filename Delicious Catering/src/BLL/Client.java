public class Client {

    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String contactnr;
    private String email;
    private String address;
    private Boolean adminRights;


    public Client(String uname, String passw, String fname, String sname, String nr, String em, String adrs, Boolean admn){
        this.username = uname;
        this.password = passw;
        this.firstname = fname;
        this.surname = sname;
        this.contactnr = nr;
        this.email = em;
        this.address = adrs;
        this.adminRights = admn;
    }



}