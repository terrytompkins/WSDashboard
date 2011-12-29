package com.tdbank.greenhornet

class ChannelController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [channelInstanceList: Channel.list(params), channelInstanceTotal: Channel.count()]
    }

    def create = {
        def channelInstance = new Channel()
        channelInstance.properties = params
        return [channelInstance: channelInstance]
    }

    def save = {
        def channelInstance = new Channel(params)
        if (channelInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'channel.label', default: 'Channel'), channelInstance.id])}"
            redirect(action: "show", id: channelInstance.id)
        }
        else {
            render(view: "create", model: [channelInstance: channelInstance])
        }
    }

    def show = {
        def channelInstance = Channel.get(params.id)
        if (!channelInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'channel.label', default: 'Channel'), params.id])}"
            redirect(action: "list")
        }
        else {
            [channelInstance: channelInstance]
        }
    }

    def edit = {
        def channelInstance = Channel.get(params.id)
        if (!channelInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'channel.label', default: 'Channel'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [channelInstance: channelInstance]
        }
    }

    def update = {
        def channelInstance = Channel.get(params.id)
        if (channelInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (channelInstance.version > version) {
                    
                    channelInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'channel.label', default: 'Channel')] as Object[], "Another user has updated this Channel while you were editing")
                    render(view: "edit", model: [channelInstance: channelInstance])
                    return
                }
            }
            channelInstance.properties = params
            if (!channelInstance.hasErrors() && channelInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'channel.label', default: 'Channel'), channelInstance.id])}"
                redirect(action: "show", id: channelInstance.id)
            }
            else {
                render(view: "edit", model: [channelInstance: channelInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'channel.label', default: 'Channel'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def channelInstance = Channel.get(params.id)
        if (channelInstance) {
            try {
                channelInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'channel.label', default: 'Channel'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'channel.label', default: 'Channel'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'channel.label', default: 'Channel'), params.id])}"
            redirect(action: "list")
        }
    }
}
