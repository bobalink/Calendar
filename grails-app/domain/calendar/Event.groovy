package calendar

class Event {

    String name
    Date date
    Integer cost
    String location
    String discription
   // User owner
    Boolean privateEvent
    GuestList guestList


    static belongsTo=[user:User]


    String toString(){
        return name
    }

    static constraints = {
        name nullable: false
        date nullable: false
        cost nullable:true
        location nullable: true
        discription nullable: true
      //  owner nullable: false
        privateEvent nullable:false
        guestList nullable:true

    }
}
