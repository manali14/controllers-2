package bootcamp.demo.co

import grails.validation.Validateable

@Validateable
class UserCO {
    String email
    String name

    static constraints = {
        email(email: true, nullable: false)
        name(nullable: false)
    }
}
