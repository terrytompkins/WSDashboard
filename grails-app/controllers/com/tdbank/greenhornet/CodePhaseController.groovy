package com.tdbank.greenhornet

class CodePhaseController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [codePhaseInstanceList: CodePhase.list(params), codePhaseInstanceTotal: CodePhase.count()]
    }

    def create = {
        def codePhaseInstance = new CodePhase()
        codePhaseInstance.properties = params
        return [codePhaseInstance: codePhaseInstance]
    }

    def save = {
        def codePhaseInstance = new CodePhase(params)
        if (codePhaseInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), codePhaseInstance.id])}"
            redirect(action: "show", id: codePhaseInstance.id)
        }
        else {
            render(view: "create", model: [codePhaseInstance: codePhaseInstance])
        }
    }

    def show = {
        def codePhaseInstance = CodePhase.get(params.id)
        if (!codePhaseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), params.id])}"
            redirect(action: "list")
        }
        else {
            [codePhaseInstance: codePhaseInstance]
        }
    }

    def edit = {
        def codePhaseInstance = CodePhase.get(params.id)
        if (!codePhaseInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [codePhaseInstance: codePhaseInstance]
        }
    }

    def update = {
        def codePhaseInstance = CodePhase.get(params.id)
        if (codePhaseInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (codePhaseInstance.version > version) {
                    
                    codePhaseInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'codePhase.label', default: 'CodePhase')] as Object[], "Another user has updated this CodePhase while you were editing")
                    render(view: "edit", model: [codePhaseInstance: codePhaseInstance])
                    return
                }
            }
            codePhaseInstance.properties = params
            if (!codePhaseInstance.hasErrors() && codePhaseInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), codePhaseInstance.id])}"
                redirect(action: "show", id: codePhaseInstance.id)
            }
            else {
                render(view: "edit", model: [codePhaseInstance: codePhaseInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def codePhaseInstance = CodePhase.get(params.id)
        if (codePhaseInstance) {
            try {
                codePhaseInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'codePhase.label', default: 'CodePhase'), params.id])}"
            redirect(action: "list")
        }
    }
}
