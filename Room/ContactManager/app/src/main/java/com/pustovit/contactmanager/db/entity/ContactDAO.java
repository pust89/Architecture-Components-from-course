package com.pustovit.contactmanager.db.entity;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Pustovit Vladimir on 15.01.2020.
 * vovapust1989@gmail.com
 */

@Dao
public interface ContactDAO {

    @Insert
    long addContact(Contact contact);


    @Update
    void updateContact(Contact contact);


    @Delete
    void deleteContact(Contact contact);

    @Query("SELECT * FROM contacts;")
    List<Contact> getContacts();


    @Query("SELECT * FROM contacts WHERE contact_id ==:contactId;")
    Contact getContact(long contactId);

}
