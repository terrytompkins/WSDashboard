package com.tdbank.greenhornet

class ExternalSystemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [externalSystemInstanceList: ExternalSystem.list(params), externalSystemInstanceTotal: ExternalSystem.count()]
    }

    def create = {
        def externalSystemInstance = new ExternalSystem()
        externalSystemInstance.properties = params
        return [externalSystemInstance: externalSystemInstance]
    }

    def save = {
        def externalSystemInstance = new ExternalSystem(params)
        if (externalSystemInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), externalSystemInstance.id])}"
            redirect(action: "show", id: externalSystemInstance.id)
        }
        else {
            render(view: "create", model: [externalSystemInstance: externalSystemInstance])
        }
    }

    def show = {
        def externalSystemInstance = ExternalSystem.get(params.id)
        if (!externalSystemInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), params.id])}"
            redirect(action: "list")
        }
        else {
            [externalSystemInstance: externalSystemInstance]
        }
    }

    def edit = {
        def externalSystemInstance = ExternalSystem.get(params.id)
        if (!externalSystemInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [externalSystemInstance: externalSystemInstance]
        }
    }

    def update = {
        def externalSystemInstance = ExternalSystem.get(params.id)
        if (externalSystemInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (externalSystemInstance.version > version) {
                    
                    externalSystemInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'externalSystem.label', default: 'ExternalSystem')] as Object[], "Another user has updated this ExternalSystem while you were editing")
                    render(view: "edit", model: [externalSystemInstance: externalSystemInstance])
                    return
                }
            }
            externalSystemInstance.properties = params
            if (!externalSystemInstance.hasErrors() && externalSystemInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), externalSystemInstance.id])}"
                redirect(action: "show", id: externalSystemInstance.id)
            }
            else {
                render(view: "edit", model: [externalSystemInstance: externalSystemInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def externalSystemInstance = ExternalSystem.get(params.id)
        if (externalSystemInstance) {
            try {
                externalSystemInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystem.label', default: 'ExternalSystem'), params.id])}"
            redirect(action: "list")
        }
    }
}
