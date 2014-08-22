import calendar.*

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        User user = new User(name:'Waverly', email:'bobalink13@gmail.com')
        User otherUser = new User(name:'jim', email:'jimsEmail@gmail.com')
        if (!user.save()){
            log.error "Could not save user!!"
            log.error "${user.errors}"
        }
        if (!otherUser.save()){
            log.error "Could not save otherUser!!"
        }
        String oldstring = "2014-08-22 00:00:00.0";
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
        Event event1 = new Event(name:"Friday", date:date, user:user)

        if (!event1.save()){
            log.error "Could not save Event!"
            log.error "${event1.errors}"
        }
    }
    def destroy = {
    }
}
