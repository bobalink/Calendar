package calendar

import org.springframework.dao.DataIntegrityViolationException
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils



class EventController {

    SpringSecurityService springSecurityService
    def scaffold = true
    //static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    //@Secured(['ROLE_ADMIN','ROLE_GUEST'])
    def index() {
       // redirect(action: "list", params: params)
    }
    //@Secured(['ROLE_ADMIN','ROLE_GUEST'])
    def list() { //Integer max
        //params.max = Math.min(max ?: 10, 100)
        [eventInstanceList: Event.list(params), eventInstanceTotal: Event.count()]
    }
    @Secured(['ROLE_ADMIN','ROLE_GUEST'])
    def create() {
        [eventInstance: new Event(params)]
    }
    @Secured(['ROLE_ADMIN'])
    def save() {
        def eventInstance = new Event(params)
        //println("current params = " + params)
        if (!eventInstance.save(flush: true)) {
            //println("rendering view")
            render(view: "create", model: [eventInstance: eventInstance])
            //println("event instance id inside the if =" +eventInstance.id)
            //return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'event.label', default: 'Event'), eventInstance.id])
        //println("flash message = " +flash.message)
        //println("event instance id =" +eventInstance.id)
        redirect(action: "show", id: eventInstance.id)

    }
   // @Secured(['ROLE_ADMIN'])
    def show(Long id) {

        def eventInstance = Event.get(id)
//        println("Current User is " + session.user.name)
//        println("owner is " + eventInstance.owner.name)
//        println("user is " + eventInstance.user.name)
//        println("eventInstance.user== session.owner results in " +(eventInstance.user== session.owner))
//        println("eventInstance.user== session.user results in " +(eventInstance.user== session.user))
//        println("session.owner == session.user results in " +(eventInstance.owner== session?.user))
        if (!eventInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), id])
            redirect(action: "list")
            return
        }
      //  if (eventInstance.privateEvent && session.user.name == eventInstance.owner.name) {
      //      println("user is the owner of the event")
            [eventInstance: eventInstance]
      //  }
    }
    @Secured(['ROLE_ADMIN'])
    def edit(Long id) {
        def eventInstance = Event.get(id)
        if (!eventInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), id])
            redirect(action: "list")
            return
        }

        [eventInstance: eventInstance]
    }
    @Secured(['ROLE_ADMIN'])
    def update(Long id, Long version) {
        def eventInstance = Event.get(id)
        if (!eventInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (eventInstance.version > version) {
                eventInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'event.label', default: 'Event')] as Object[],
                          "Another user has updated this Event while you were editing")
                render(view: "edit", model: [eventInstance: eventInstance])
                return
            }
        }

        eventInstance.properties = params

        if (!eventInstance.save(flush: true)) {
            render(view: "edit", model: [eventInstance: eventInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'event.label', default: 'Event'), eventInstance.id])
        redirect(action: "show", id: eventInstance.id)
    }
    @Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        def eventInstance = Event.get(id)
        if (!eventInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'event.label', default: 'Event'), id])
            redirect(action: "list")
            return
        }

        try {
            eventInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'event.label', default: 'Event'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'event.label', default: 'Event'), id])
            redirect(action: "show", id: id)
        }
    }
}
