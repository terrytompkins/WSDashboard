package com.tdbank.greenhornet

class JvmController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [jvmInstanceList: Jvm.list(params), jvmInstanceTotal: Jvm.count()]
    }

    def create = {
        def jvmInstance = new Jvm()
        jvmInstance.properties = params
        return [jvmInstance: jvmInstance]
    }

    def save = {
        def jvmInstance = new Jvm(params)
        if (jvmInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'jvm.label', default: 'Jvm'), jvmInstance.id])}"
            redirect(action: "show", id: jvmInstance.id)
        }
        else {
            render(view: "create", model: [jvmInstance: jvmInstance])
        }
    }

    def show = {
        def jvmInstance = Jvm.get(params.id)
        if (!jvmInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jvm.label', default: 'Jvm'), params.id])}"
            redirect(action: "list")
        }
        else {
            [jvmInstance: jvmInstance]
        }
    }

	def search = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[jvmInstanceList: Jvm.list(params), jvmInstanceTotal: Jvm.count()]
	}

    def edit = {
        def jvmInstance = Jvm.get(params.id)
        if (!jvmInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jvm.label', default: 'Jvm'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [jvmInstance: jvmInstance]
        }
    }

    def update = {
        def jvmInstance = Jvm.get(params.id)
        if (jvmInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (jvmInstance.version > version) {
                    
                    jvmInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'jvm.label', default: 'Jvm')] as Object[], "Another user has updated this Jvm while you were editing")
                    render(view: "edit", model: [jvmInstance: jvmInstance])
                    return
                }
            }
            jvmInstance.properties = params
            if (!jvmInstance.hasErrors() && jvmInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'jvm.label', default: 'Jvm'), jvmInstance.id])}"
                redirect(action: "show", id: jvmInstance.id)
            }
            else {
                render(view: "edit", model: [jvmInstance: jvmInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jvm.label', default: 'Jvm'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def jvmInstance = Jvm.get(params.id)
        if (jvmInstance) {
            try {
                jvmInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'jvm.label', default: 'Jvm'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'jvm.label', default: 'Jvm'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'jvm.label', default: 'Jvm'), params.id])}"
            redirect(action: "list")
        }
    }
}
