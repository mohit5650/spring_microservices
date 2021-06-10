package com.brainmentors.apps.isademo.jointableeg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
@Entity
@Table(name = "largedata")
public class LargeObjects {
@Lob	
private Character[] charData;
@Lob
private byte[] docBytes;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@NaturalId
// PanNo, AdharNo, Driving LicNo
private String cardNo;

private String name;

public Character[] getCharData() {
	return charData;
}

public void setCharData(Character[] charData) {
	this.charData = charData;
}

public byte[] getDocBytes() {
	return docBytes;
}

public void setDocBytes(byte[] docBytes) {
	this.docBytes = docBytes;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



}
