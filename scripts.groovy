def checkCausedByGenericWebhookTrigger() {
    def causeList = currentBuild.getBuildCauses()
    for (cause in causeList) {
        if (cause.class.name == 'org.jenkinsci.plugins.gwt.GenericCause') {
            return true
        }
    }
    return false
}

rerturn this
