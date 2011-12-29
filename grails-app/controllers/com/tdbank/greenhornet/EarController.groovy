package com.tdbank.greenhornet

class EarController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [earInstanceList: Ear.list(params), earInstanceTotal: Ear.count()]
    }

    def create = {
        def earInstance = new Ear()
        earInstance.properties = params
        return [earInstance: earInstance]
    }

    def save = {
        def earInstance = new Ear(params)
        if (earInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'ear.label', default: 'Ear'), earInstance.id])}"
            redirect(action: "show", id: earInstance.id)
        }
        else {
            render(view: "create", model: [earInstance: earInstance])
        }
    }

    def show = {
        def earInstance = Ear.get(params.id)
        if (!earInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ear.label', default: 'Ear'), params.id])}"
            redirect(action: "list")
        }
        else {
            [earInstance: earInstance]
        }
    }

    def edit = {
        def earInstance = Ear.get(params.id)
        if (!earInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ear.label', default: 'Ear'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [earInstance: earInstance]
        }
    }

    def update = {
        def earInstance = Ear.get(params.id)
        if (earInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (earInstance.version > version) {
                    
                    earInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'ear.label', default: 'Ear')] as Object[], "Another user has updated this Ear while you were editing")
                    render(view: "edit", model: [earInstance: earInstance])
                    return
                }
            }
            earInstance.properties = params
            if (!earInstance.hasErrors() && earInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'ear.label', default: 'Ear'), earInstance.id])}"
                redirect(action: "show", id: earInstance.id)
            }
            else {
                render(view: "edit", model: [earInstance: earInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ear.label', default: 'Ear'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def earInstance = Ear.get(params.id)
        if (earInstance) {
            try {
                earInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'ear.label', default: 'Ear'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'ear.label', default: 'Ear'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ear.label', default: 'Ear'), params.id])}"
            redirect(action: "list")
        }
    }
}
