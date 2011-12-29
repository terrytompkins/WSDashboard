package com.tdbank.greenhornet

class EndpointTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [endpointTypeInstanceList: EndpointType.list(params), endpointTypeInstanceTotal: EndpointType.count()]
    }

    def create = {
        def endpointTypeInstance = new EndpointType()
        endpointTypeInstance.properties = params
        return [endpointTypeInstance: endpointTypeInstance]
    }

    def save = {
        def endpointTypeInstance = new EndpointType(params)
        if (endpointTypeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), endpointTypeInstance.id])}"
            redirect(action: "show", id: endpointTypeInstance.id)
        }
        else {
            render(view: "create", model: [endpointTypeInstance: endpointTypeInstance])
        }
    }

    def show = {
        def endpointTypeInstance = EndpointType.get(params.id)
        if (!endpointTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), params.id])}"
            redirect(action: "list")
        }
        else {
            [endpointTypeInstance: endpointTypeInstance]
        }
    }

    def edit = {
        def endpointTypeInstance = EndpointType.get(params.id)
        if (!endpointTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [endpointTypeInstance: endpointTypeInstance]
        }
    }

    def update = {
        def endpointTypeInstance = EndpointType.get(params.id)
        if (endpointTypeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (endpointTypeInstance.version > version) {
                    
                    endpointTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'endpointType.label', default: 'EndpointType')] as Object[], "Another user has updated this EndpointType while you were editing")
                    render(view: "edit", model: [endpointTypeInstance: endpointTypeInstance])
                    return
                }
            }
            endpointTypeInstance.properties = params
            if (!endpointTypeInstance.hasErrors() && endpointTypeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), endpointTypeInstance.id])}"
                redirect(action: "show", id: endpointTypeInstance.id)
            }
            else {
                render(view: "edit", model: [endpointTypeInstance: endpointTypeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def endpointTypeInstance = EndpointType.get(params.id)
        if (endpointTypeInstance) {
            try {
                endpointTypeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointType.label', default: 'EndpointType'), params.id])}"
            redirect(action: "list")
        }
    }
}
