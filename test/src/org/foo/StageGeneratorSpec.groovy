package org.foo

import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

class StageGeneratorSpec extends JenkinsPipelineSpecification {

    def "Get instance"() {
        given:
        def factory = StageGenerator.instace

        expect:
        factory != null
    }

    def "Get stage"() {
        given:
        def factory = StageFactory.instance

        when:
        def stage = factory.getStage("Maven", "Build")

        then:
        stage != null
    }

    def "Get stage - Maven"() {
        given:
        def factory = StageFactory.instance

        when:
        def stage = factory.getStage("Java", "Test")

        then:
        stage != null
    }

    def "Get stage - Docker"() {
        given:
        def factory = StageFactory.instance

        when:
        def stage = factory.getStage("Docker", "Build")

        then:
        stage != null
    }
}
