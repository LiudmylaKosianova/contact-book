package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private ContactInfo phoneNumber;
    private boolean numberSet = false;
    private Email[] emails = new Email[3];
    private Social[] socialM = new Social[5];


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
    public NameContactInfo getNameContactInfo(){
        return new NameContactInfo();
    }

/*
Contact.Email - A ContactInfo implementation containing an email.
Implement as public static nested class. Use "Email" for the entry title.
*/

    public static class Email implements ContactInfo{
        String email = "";
        public Email(String localPort, String domain){
            this.email = localPort +"@"+ domain;
        }
         public String getTitle(){
             return "Email";
         }
         public String getValue(){
             return email;
         }

    }
/*
Contact.Social - A ContactInfo implementation containing a social media link/id.
Implement as public static nested class. Let the user of the class define the title.
*/

    public static class Social implements ContactInfo{
        String id = "";
        String title = "";
        public Social(String title, String id){
            this.title = title;
            this.id = id;
        }
        public String getTitle(){
            return title;
        }
        public String getValue(){
            return id;
        }

    }
/*
Note that it is possible to rename contact with the rename method.
Make sure it is not possible to rename contact to have null or empty value as the name.
*/
    public void rename(String newName) {
        //Implement this method
        if(newName != null && newName.length()!=0){
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
        Email email = new Email(localPart,domain);
        for(int i = 0; i<3; i++){
            if(emails[i] == null){
                emails[i] = email;
                return email;
            }
        }
        return null;
    }

/*
* addEpamEmail(String firstname, String lastname)
Adds a special email entry with "epam.com" domain.
Please, implement this method using an anonymous extension of the Email class.
Use "Epam Email" for the entry title.
addEpamEmail("some", "one").getValue() will result to some_one@epam.com
*/
    public Email addEpamEmail(String firstname, String lastname) {
        //Implement this method
        String localPort = firstname+"_"+lastname;
        Email email = new Email(localPort, "epam.com"){
            public String getTitle(){
                return "Epam Email";
            }
        };
        for(int i = 0; i<3; i++){
            if(emails[i] == null){
                emails[i] = email;
                return email;
            }
        }
        return null;
    }
/*
addPhoneNumber(int code, String number)
Adds a contact info entry for the phone number.
Please, implement this method using an anonymous class.
Use "Tel" for the entry title.
addPhoneNumber(44, "444 444-44-44").getValue() will result to +44 444 444-44-44
*/

    public ContactInfo addPhoneNumber(int code, String number) {
        //Implement this method
        if(!numberSet){
            String phoneNumber = "+"+code+" "+number;
            ContactInfo phone = new ContactInfo(){
                public String getTitle(){
                    return "Tel";
                }
                public String getValue(){
                    return phoneNumber;
                }
            };
            this.phoneNumber = phone;
            numberSet = true;
            return phone;
        }
        return null;
    }

    public Social addTwitter(String twitterId) {
        //Implement this method
        Social newSocial = new Social("Twitter", twitterId){
        };
        for(int i = 0; i<5; i++){
            if(socialM[i]==null){
                socialM[i] = newSocial;
                return newSocial;
            }
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        //Implement this method
        Social newSocial = new Social("Instagram", instagramId){
        };
        for(int i = 0; i<5; i++){
            if(socialM[i]==null){
                socialM[i] = newSocial;
                return newSocial;
            }
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        //Implement this method
        Social newSocial = new Social (title, id);
        for(int i = 0; i<5; i++){
            if(socialM[i]==null){
                socialM[i] = newSocial;
                return newSocial;
            }
        }
        return null;
    }
/*
One more method that the Contact class have is the getInfo() method.
This method returns an array containing the ContactInfo entries in the following order:

name contact info
phone number contact info (if set)
email entries in order of addition (if any added)
social media entries in order of addition (if any added)
Resulting array must not contain any null values.
* */
    public ContactInfo[] getInfo() {
        //Implement this method
        int emailsNumber = 0;
        for(int i = 0; i<3; i++){
            if(emails[i]!=null){
                emailsNumber++;
            }
        }

        int socialsNumber = 0;
        for(int i = 0; i<5; i++){
            if(socialM[i]!=null){
                socialsNumber++;
            }
        }

        int infoLength = emailsNumber + socialsNumber + 1;
        if(phoneNumber!=null){
            infoLength++;
        }
        ContactInfo[] answer = new ContactInfo[infoLength];
        answer[0] = getNameContactInfo();

        if(phoneNumber!=null){
            answer[1] = phoneNumber;
            int socialsPosition = 2;
            if(emailsNumber>0){
                System.arraycopy(emails,0,answer,2,emailsNumber);
                socialsPosition+=emailsNumber;
            }
            if(socialsNumber>0){
                System.arraycopy(socialM,0,answer,socialsPosition,socialsNumber);
            }
        }else{
            int socialsPosition = 1;
            if(emailsNumber>0){
                System.arraycopy(emails,0,answer,1,emailsNumber);
                socialsPosition+=emailsNumber;
            }
            if(socialsNumber>0){
                System.arraycopy(socialM,0,answer,socialsPosition,socialsNumber);
            }
        }

        return answer;

    }

}
