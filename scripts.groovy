def checkCausedByGenericWebhookTrigger() {
    def causeList = currentBuild.getBuildCauses()
    for (cause in causeList) {
        if (cause._class == 'org.jenkinsci.plugins.gwt.GenericCause') {
            return true
        }
    }
    return false
}

return this
