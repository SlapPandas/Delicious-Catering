package BLL;
import java.util.*;
import DAL.*;

public class Client {

    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String contactnr;
    private String email;
    private String address;
    private Boolean adminRights;

    public Client(){}

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

    public String getContactnr() {
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

    public Boolean SuccessfulLogin(String username, String password)
    {
        ClientData myClient = new ClientData();
        List<Client> myClientList = myClient.ReadClientList();
        boolean logedIn = false;
        for(int i=0;i<myClientList.size();i++){
            if(myClientList.get(i).username == username && myClientList.get(i).password == password){logedIn=true;break;}
        }
        return logedIn;
    }

    public Boolean IsAdmin()
    {
        ClientData myClient = new ClientData();
        List<Client> myClientList = myClient.ReadClientList();
        boolean admin = false;
        for(int i=0;i<myClientList.size();i++){
            if(myClientList.get(i).username == username && myClientList.get(i).adminRights == true){admin=true;break;}
        }
        return admin;
    }

    public List<Client> DisplayClientList()
    {
        ClientData myClient = new ClientData();
        return myClient.ReadClientList();
    }

    public void RegisterClient(String username, String password, String fname, String surname, String contactnr, String email, String address, boolean adminRights)
    {
        ClientData cd = new ClientData();

        cd.WriteNewClient(username, password, fname, surname, contactnr, email, address, adminRights);

    }

}