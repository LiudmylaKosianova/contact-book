package com.epam.rd.contactbook;

public class Contact {
    private String contactName;

    public Contact(String contactName) {
        //Implement this method
        this.contactName = contactName;
    }
/*
Contact.NameContactInfo - A ContactInfo implementation providing the name of the contact.
Implement as private non-static nested class. Use "Name" for the entry title.
It must not have its own fields. It must use fields of the bounded Contact instance instead.
*/
    private class NameContactInfo implements ContactInfo{
        public String getTitle(){
            return "Name";
        }
        public String getValue(){
            return contactName;//is this how I use the field of the bounded Contact instance?
        }
    }

/*
Contact.Email - A ContactInfo implementation containing an email.
Implement as public static nested class. Use "Email" for the entry title.
*/

    public static class Email implements ContactInfo{
         public String getTitle(){
             return "Email";
         }
         public String getValue(){
             return null;//I don't know what to return here!
         }


    }
/*
Contact.Social - A ContactInfo implementation containing a social media link/id.
Implement as public static nested class. Let the user of the class define the title.
*/

    public static Social{

    }
/*
Note that it is possible to rename contact with the rename method.
Make sure it is not possible to rename contact to have null or empty value as the name.
*/
    public void rename(String newName) {
        //Implement this method
        if(newName != null || !newName.isEmpty() ){
            this.contactName = newName;
        }

    }
/*
addEmail(String localPart, String domain)
Adds an email entry.
addEmail("someone", "somewhere.com").getValue() will result to someone@somewhere.com.
*/
    public Email addEmail(String localPart, String domain) {
        //Implement this method
    }


    public Email addEpamEmail(String firstname, String lastname) {
        //Implement this method
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        //Implement this method
    }

    public Social addTwitter(String twitterId) {
        //Implement this method
    }

    public Social addInstagram(String instagramId) {
        //Implement this method
    }

    public Social addSocialMedia(String title, String id) {
        //Implement this method
    }

    public ContactInfo[] getInfo() {
        //Implement this method
    }

}
