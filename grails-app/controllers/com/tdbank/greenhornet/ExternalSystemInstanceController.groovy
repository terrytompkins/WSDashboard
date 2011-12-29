package com.tdbank.greenhornet

class ExternalSystemInstanceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [externalSystemInstanceInstanceList: ExternalSystemInstance.list(params), externalSystemInstanceInstanceTotal: ExternalSystemInstance.count()]
    }

    def create = {
        def externalSystemInstanceInstance = new ExternalSystemInstance()
        externalSystemInstanceInstance.properties = params
        return [externalSystemInstanceInstance: externalSystemInstanceInstance]
    }

    def save = {
        def externalSystemInstanceInstance = new ExternalSystemInstance(params)
        if (externalSystemInstanceInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), externalSystemInstanceInstance.id])}"
            redirect(action: "show", id: externalSystemInstanceInstance.id)
        }
        else {
            render(view: "create", model: [externalSystemInstanceInstance: externalSystemInstanceInstance])
        }
    }

    def show = {
        def externalSystemInstanceInstance = ExternalSystemInstance.get(params.id)
        if (!externalSystemInstanceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), params.id])}"
            redirect(action: "list")
        }
        else {
            [externalSystemInstanceInstance: externalSystemInstanceInstance]
        }
    }

    def edit = {
        def externalSystemInstanceInstance = ExternalSystemInstance.get(params.id)
        if (!externalSystemInstanceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [externalSystemInstanceInstance: externalSystemInstanceInstance]
        }
    }

    def update = {
        def externalSystemInstanceInstance = ExternalSystemInstance.get(params.id)
        if (externalSystemInstanceInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (externalSystemInstanceInstance.version > version) {
                    
                    externalSystemInstanceInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance')] as Object[], "Another user has updated this ExternalSystemInstance while you were editing")
                    render(view: "edit", model: [externalSystemInstanceInstance: externalSystemInstanceInstance])
                    return
                }
            }
            externalSystemInstanceInstance.properties = params
            if (!externalSystemInstanceInstance.hasErrors() && externalSystemInstanceInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), externalSystemInstanceInstance.id])}"
                redirect(action: "show", id: externalSystemInstanceInstance.id)
            }
            else {
                render(view: "edit", model: [externalSystemInstanceInstance: externalSystemInstanceInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def externalSystemInstanceInstance = ExternalSystemInstance.get(params.id)
        if (externalSystemInstanceInstance) {
            try {
                externalSystemInstanceInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'externalSystemInstance.label', default: 'ExternalSystemInstance'), params.id])}"
            redirect(action: "list")
        }
    }
}
