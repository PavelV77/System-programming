package recordspackage;

import javax.persistence.*;

@Entity
@Table(name = "myrecords")
public class OneRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int id;
    @Column
    public String address;
    @Column
    public String port;
    @Column(name = "protocol")
    public String protocol;
    public OneRecord(){}
    public OneRecord(String add, String po, String prot){
        this.address = add;
        this.port = po;
        this.protocol = prot;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPort(String port) {this.port = port;}
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    public String getProtocol(){
        return protocol;
    }
    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "OneRecord{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", port='" + port + '\'' +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
