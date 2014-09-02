package calendar

class Event {

    String name
    Date date
    Integer cost
    String location
    String discription
   // User owner
    Boolean privateEvent
    Attendance attendance

    static belongsTo=[user:User]


    static constraints = {
        name nullable: false
        date nullable: false
        cost nullable:true
        location nullable: true
        discription nullable: true
      //  owner nullable: false
        privateEvent nullable:false
        attendance nullable:true

    }
}
