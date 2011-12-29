package com.tdbank.greenhornet

class ServerClusterController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [serverClusterInstanceList: ServerCluster.list(params), serverClusterInstanceTotal: ServerCluster.count()]
    }

    def create = {
        def serverClusterInstance = new ServerCluster()
        serverClusterInstance.properties = params
        return [serverClusterInstance: serverClusterInstance]
    }

    def save = {
        def serverClusterInstance = new ServerCluster(params)
        if (serverClusterInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), serverClusterInstance.id])}"
            redirect(action: "show", id: serverClusterInstance.id)
        }
        else {
            render(view: "create", model: [serverClusterInstance: serverClusterInstance])
        }
    }

    def show = {
        def serverClusterInstance = ServerCluster.get(params.id)
        if (!serverClusterInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), params.id])}"
            redirect(action: "list")
        }
        else {
            [serverClusterInstance: serverClusterInstance]
        }
    }

    def edit = {
        def serverClusterInstance = ServerCluster.get(params.id)
        if (!serverClusterInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [serverClusterInstance: serverClusterInstance]
        }
    }

    def update = {
        def serverClusterInstance = ServerCluster.get(params.id)
        if (serverClusterInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (serverClusterInstance.version > version) {
                    
                    serverClusterInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'serverCluster.label', default: 'ServerCluster')] as Object[], "Another user has updated this ServerCluster while you were editing")
                    render(view: "edit", model: [serverClusterInstance: serverClusterInstance])
                    return
                }
            }
            serverClusterInstance.properties = params
            if (!serverClusterInstance.hasErrors() && serverClusterInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), serverClusterInstance.id])}"
                redirect(action: "show", id: serverClusterInstance.id)
            }
            else {
                render(view: "edit", model: [serverClusterInstance: serverClusterInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def serverClusterInstance = ServerCluster.get(params.id)
        if (serverClusterInstance) {
            try {
                serverClusterInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'serverCluster.label', default: 'ServerCluster'), params.id])}"
            redirect(action: "list")
        }
    }
}
