package calendar

class User {
    String name
    String email


    static hasMany=[events:Event]


    static constraints = {
        name(nullable:false, blank:false)
    }
}
