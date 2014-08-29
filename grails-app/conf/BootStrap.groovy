import calendar.*

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->

        def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)
        User user = new User(name:'Waverly', email:'bobalink13@gmail.com', username: "bobalink", password: "password")
        User otherUser = new User(name:'jim', email:'jimsEmail@gmail.com',username: "jimslogin", password: "jimspassword")
        if (!user.save()){
            log.error "Could not save user!!"
            log.error "${user.errors}"
        }
        if (!otherUser.save()){
            log.error "Could not save otherUser!!"
        }

        SecUserSecRole.create(user, adminRole, true)
        SecUserSecRole.create(user, userRole, true)

        String oldstring = "2014-08-22 00:00:00.0";
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        Event event1 = new Event(name:"Friday", date:date, user:user, owner:user, privateEvent: true)


        if (!event1.save()){
            log.error "Could not save Event!"
            log.error "${event1.errors}"
        }
    }
    def destroy = {
    }
}
