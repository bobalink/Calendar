import calendar.*

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->

        def adminRole = new SecRole(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new SecRole(authority: 'ROLE_USER').save(flush: true)
        User adminUser = new User(name:'admin', email:'admin@gmail.com',username: "admin", password: "admin")
        User user = new User(name:'Waverly', email:'bobalink13@gmail.com', username: "bobalink", password: "password")
        User otherUser = new User(name:'jim', email:'jimsEmail@gmail.com',username: "jimslogin", password: "jimspassword")

        if (!adminUser.save()){
            log.error "Could not save user!!"
            log.error "${adminUser.errors}"
        }

        if (!user.save()){
            log.error "Could not save user!!"
            log.error "${user.errors}"
        }
        if (!otherUser.save()){
            log.error "Could not save otherUser!!"
        }

        SecUserSecRole.create(user, adminRole, true)
        SecUserSecRole.create(user, userRole, true)
        SecUserSecRole.create(adminUser, userRole, true)
        SecUserSecRole.create(adminUser, adminRole, true)



        String oldstring = "2014-08-22 00:00:00.0";
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        Event event1 = new Event(name:"Friday", date:date, user:user, privateEvent: true)
        Event event2 = new Event(name:"Today!", date:date, user:otherUser, privateEvent: true)
        Event event3 = new Event(name:"Public", date:date, user:user, privateEvent: false)


        if (!event1.save()){
            log.error "Could not save Event!"
            log.error "${event1.errors}"

        }
        if (!event2.save()){
            log.error "Could not save Event!"
            log.error "${event2.errors}"
        }

        if (!event3.save()){
            log.error "Could not save Event!"
            log.error "${event3.errors}"
        }


    }
    def destroy = {
    }
}
