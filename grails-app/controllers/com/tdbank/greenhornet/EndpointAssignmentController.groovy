package com.tdbank.greenhornet

class EndpointAssignmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [endpointAssignmentInstanceList: EndpointAssignment.list(params), endpointAssignmentInstanceTotal: EndpointAssignment.count()]
    }

    def create = {
        def endpointAssignmentInstance = new EndpointAssignment()
        endpointAssignmentInstance.properties = params
        return [endpointAssignmentInstance: endpointAssignmentInstance]
    }

    def save = {
        def endpointAssignmentInstance = new EndpointAssignment(params)
        if (endpointAssignmentInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), endpointAssignmentInstance.id])}"
            redirect(action: "show", id: endpointAssignmentInstance.id)
        }
        else {
            render(view: "create", model: [endpointAssignmentInstance: endpointAssignmentInstance])
        }
    }

    def show = {
        def endpointAssignmentInstance = EndpointAssignment.get(params.id)
        if (!endpointAssignmentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), params.id])}"
            redirect(action: "list")
        }
        else {
            [endpointAssignmentInstance: endpointAssignmentInstance]
        }
    }

    def edit = {
        def endpointAssignmentInstance = EndpointAssignment.get(params.id)
        if (!endpointAssignmentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [endpointAssignmentInstance: endpointAssignmentInstance]
        }
    }

    def update = {
        def endpointAssignmentInstance = EndpointAssignment.get(params.id)
        if (endpointAssignmentInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (endpointAssignmentInstance.version > version) {
                    
                    endpointAssignmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'endpointAssignment.label', default: 'EndpointAssignment')] as Object[], "Another user has updated this EndpointAssignment while you were editing")
                    render(view: "edit", model: [endpointAssignmentInstance: endpointAssignmentInstance])
                    return
                }
            }
            endpointAssignmentInstance.properties = params
            if (!endpointAssignmentInstance.hasErrors() && endpointAssignmentInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), endpointAssignmentInstance.id])}"
                redirect(action: "show", id: endpointAssignmentInstance.id)
            }
            else {
                render(view: "edit", model: [endpointAssignmentInstance: endpointAssignmentInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def endpointAssignmentInstance = EndpointAssignment.get(params.id)
        if (endpointAssignmentInstance) {
            try {
                endpointAssignmentInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'endpointAssignment.label', default: 'EndpointAssignment'), params.id])}"
            redirect(action: "list")
        }
    }
}
