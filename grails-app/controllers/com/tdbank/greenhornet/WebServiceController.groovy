package com.tdbank.greenhornet

class WebServiceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [webServiceInstanceList: WebService.list(params), webServiceInstanceTotal: WebService.count()]
    }

    def create = {
        def webServiceInstance = new WebService()
        webServiceInstance.properties = params
        return [webServiceInstance: webServiceInstance]
    }

    def save = {
        def webServiceInstance = new WebService(params)
        if (webServiceInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'webService.label', default: 'WebService'), webServiceInstance.id])}"
            redirect(action: "show", id: webServiceInstance.id)
        }
        else {
            render(view: "create", model: [webServiceInstance: webServiceInstance])
        }
    }

    def show = {
        def webServiceInstance = WebService.get(params.id)
        if (!webServiceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'webService.label', default: 'WebService'), params.id])}"
            redirect(action: "list")
        }
        else {
            [webServiceInstance: webServiceInstance]
        }
    }

    def edit = {
        def webServiceInstance = WebService.get(params.id)
        if (!webServiceInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'webService.label', default: 'WebService'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [webServiceInstance: webServiceInstance]
        }
    }

    def update = {
        def webServiceInstance = WebService.get(params.id)
        if (webServiceInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (webServiceInstance.version > version) {
                    
                    webServiceInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'webService.label', default: 'WebService')] as Object[], "Another user has updated this WebService while you were editing")
                    render(view: "edit", model: [webServiceInstance: webServiceInstance])
                    return
                }
            }
            webServiceInstance.properties = params
            if (!webServiceInstance.hasErrors() && webServiceInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'webService.label', default: 'WebService'), webServiceInstance.id])}"
                redirect(action: "show", id: webServiceInstance.id)
            }
            else {
                render(view: "edit", model: [webServiceInstance: webServiceInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'webService.label', default: 'WebService'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def webServiceInstance = WebService.get(params.id)
        if (webServiceInstance) {
            try {
                webServiceInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'webService.label', default: 'WebService'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'webService.label', default: 'WebService'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'webService.label', default: 'WebService'), params.id])}"
            redirect(action: "list")
        }
    }
}
