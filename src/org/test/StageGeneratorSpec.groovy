package org.test

import org.foo.StageGenerator
import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

class StageGeneratorSpec extends JenkinsPipelineSpecification {

      def "Get instance"() {
        given:
        def factory = new StageGenerator()

        expect:
        factory != null
    }

        def "Get stage"() {
        given:
        def factory = StageGenerator.instance

        when:
        def stage = factory.getStage("BuildJava")

        then:
        stage != null
    }

}