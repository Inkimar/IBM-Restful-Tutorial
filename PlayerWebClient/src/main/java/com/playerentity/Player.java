package com.playerentity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ingimar
 */
@Entity
@Table(name = "PLAYER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByLastname", query = "SELECT p FROM Player p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Player.findByFirstname", query = "SELECT p FROM Player p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Player.findByJerseynumber", query = "SELECT p FROM Player p WHERE p.jerseynumber = :jerseynumber"),
    @NamedQuery(name = "Player.findByLastspokenwords", query = "SELECT p FROM Player p WHERE p.lastspokenwords = :lastspokenwords")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    private Integer id;

    @Column(name = "LAST_NAME")
    private String lastname;

    @Column(name = "FIRST_NAME")
    private String firstname;

    @Column(name = "JERSEY_NUMBER")
    private Integer jerseynumber;

    @Column(name = "LAST_SPOKEN_WORDS")
    private String lastspokenwords;
    
    @Id
    @Basic(optional = false)
    @Column(name = "TESTING_UUID")
    private String testingUUID;

    public Player() {
        this.testingUUID = UUID.randomUUID().toString();
    }

    public String getTestingUUID() {
        return testingUUID;
    }

    public void setTestingUUID(String testingUUID) {
        this.testingUUID = testingUUID;
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getJerseynumber() {
        return jerseynumber;
    }

    public void setJerseynumber(Integer jerseynumber) {
        this.jerseynumber = jerseynumber;
    }

    public String getLastspokenwords() {
        return lastspokenwords;
    }

    public void setLastspokenwords(String lastspokenwords) {
        this.lastspokenwords = lastspokenwords;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.playerentity.Player[ id=" + id + " ]";
    }
}
