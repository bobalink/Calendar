package calendar

class Event {

    String name
    Date date
    Integer cost
    String location
    String discription

    static belongsTo=[user:User]

    static constraints = {
        name nullable: false
        date nullable: false
        cost nullable:true
        location nullable: true
        discription nullable: true

    }
}
