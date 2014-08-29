package calendar

class User extends SecUser {
    String name
    String email
//    String login
//    String password


    static hasMany=[events:Event]


    static constraints = {
        name(nullable:false, blank:false)
//        login(blank:false, size:5..15,matches:/[\S]+/,unique:true)
//        password(blank:false,size:5..15,matches:/[\S]+/)
        email (unique:true)
    }
}
