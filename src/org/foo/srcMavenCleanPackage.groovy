package org.foo

import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl
import org.jenkinsci.plugins.workflow.steps.StepContext
import org.jenkinsci.plugins.workflow.steps.SynchronousNonBlockingStepExecution

class srcMavenCleanPackage extends AbstractStepImpl {

    void run(StepContext context) {
        context.get(StepExecutionImpl).apply()
    }

    static class StepExecutionImpl extends SynchronousNonBlockingStepExecution<Void> {

        @Override
        protected Void run() throws Exception {
            sh 'mvn -B -DskipTests clean package'
            return null
        }

        @Override
        public org.jenkinsci.plugins.workflow.steps.StepExecution start() throws Exception {
            StepExecutionImpl execution = new StepExecutionImpl()
            execution.setResume(run())
            return execution
        }

        private static final long serialVersionUID = 1L
    }

}
