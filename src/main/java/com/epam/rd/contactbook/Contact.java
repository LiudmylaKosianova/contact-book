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
            return contactName;
        }
    }

/*
Contact.Email - A ContactInfo implementation containing an email.
Implement as public static nested class. Use "Email" for the entry title.
*/

    public static class Email{
        String title = "Email";
        String value;
    }
/*
Contact.Social - A ContactInfo implementation containing a social media link/id.
Implement as public static nested class. Let the user of the class define the title.
*/

    public static Social{

    }

    public void rename(String newName) {
        //Implement this method
    }

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
